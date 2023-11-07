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
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import model.*;

/**
 *
 * @author Admin
 */
public class ViewDetailOfMentorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idMentor = Integer.parseInt(request.getParameter("idmentor"));
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
        request.getRequestDispatcher("ViewDetailMentor.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();      
    }
}
