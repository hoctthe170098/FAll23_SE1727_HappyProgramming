/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import model.*;

/**
 *
 * @author Admin
 */
public class detailmentoradminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idMentor = Integer.parseInt(request.getParameter("ID"));
        ProfileDAO pDAO = new ProfileDAO();
        MentorDAO mDAO = new MentorDAO();
        MentorSkillDAO msDAO = new MentorSkillDAO();
        AccountDAO accDAO = new AccountDAO();
        CommentInfoDAO ciDAO = new CommentInfoDAO();
        Profile p = pDAO.getProfileByID(idMentor);
        Mentor m = mDAO.getMentorByID(idMentor);
        MentorSkill ms = msDAO.getSkillByName(idMentor);
        String email = accDAO.getEmailByID(idMentor);
        String date = String.valueOf(p.getBirth());
        List<Integer> ListSkillMentor = ms.getListSkillID();
        List<CommentInfo> listComment = ciDAO.getAllCommentInfo(idMentor);
        request.setAttribute("listComment", listComment);
        request.setAttribute("p", p);
        request.setAttribute("m", m);
        request.setAttribute("ListSkillMentor", ListSkillMentor);
        request.setAttribute("email", email);
        request.setAttribute("date", date);
        request.setAttribute("idmentor", idMentor);
        request.getRequestDispatcher("viewdetailmentoradmin.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idMentor = Integer.parseInt(request.getParameter("idmentor"));
        String button = request.getParameter("button");
        if (button.equals("request")) {
            RequestDAO rDAO = new RequestDAO();
            rDAO.updateRequestByDate();
            request.getSession().removeAttribute("idmentor");
            request.getSession().setAttribute("idmentor", idMentor);
            request.getRequestDispatcher("CreateRequest.jsp").forward(request, response);
        } else {
            Account acc = (Account) request.getSession().getAttribute("acc");
            if (acc == null) {
                request.setAttribute("account", false);
            } else {
                RequestDAO rDAO = new RequestDAO();
                if (!rDAO.CheckRequestClosed(idMentor, acc.getID())) {
                    request.setAttribute("closed", false);
                } else {
                    request.getSession().removeAttribute("idmentor");
                    request.getSession().setAttribute("idmentor", idMentor);
                    CommentDAO cDAO = new CommentDAO();
                    RateDAO raDAO = new RateDAO();
                    if (!raDAO.checkIsExistRate(acc.getID(), idMentor)) {
                        raDAO.insertRate(idMentor, acc.getID());
                    }
                    List<Comment> listC = cDAO.getCommentBy2ID( acc.getID(),idMentor);
                    request.setAttribute("listC", listC);
                }
            }
            request.getRequestDispatcher("DisplayComment.jsp").forward(request, response);
        }
    }
}
