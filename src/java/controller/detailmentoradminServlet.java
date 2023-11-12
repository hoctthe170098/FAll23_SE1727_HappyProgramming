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
        String idMentor = request.getParameter("ID");    
        ProfileDAO pDAO = new ProfileDAO();
        MentorDAO mDAO = new MentorDAO();
        if(idMentor==null||mDAO.checkExistMentor(idMentor)==null){
            response.sendRedirect("home");
        }
        MentorSkillDAO msDAO = new MentorSkillDAO();
        AccountDAO accDAO = new AccountDAO();
        CommentInfoDAO ciDAO = new CommentInfoDAO();
        Profile p = pDAO.getProfileByID(Integer.parseInt(idMentor));
        Mentor m = mDAO.getMentorByID(Integer.parseInt(idMentor));
        MentorSkill ms = msDAO.getSkillByName(Integer.parseInt(idMentor));
        String email = accDAO.getEmailByID(Integer.parseInt(idMentor));
        String date = String.valueOf(p.getBirth());
        List<Integer> ListSkillMentor = ms.getListSkillID();
        List<CommentInfo> listComment = ciDAO.getAllCommentInfo(Integer.parseInt(idMentor));
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
    }
}
