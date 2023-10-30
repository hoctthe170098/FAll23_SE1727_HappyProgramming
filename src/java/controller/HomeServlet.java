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
import java.sql.Date;
import java.util.List;
import model.*;

public class HomeServlet extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MenteeDAO MenteeDAO = new MenteeDAO();
        SkillDAO SkillDAO = new SkillDAO();
        MentorDAO MentorDAO = new MentorDAO();
        MentorIntroDAO mentorIntro = new MentorIntroDAO();
        List<Skill> listTop3Skills = SkillDAO.getListTop3Skill();
        List<MentorIntro> listTop3MentorIntro = mentorIntro.getTop3MentorIntro();
        int totalMentee = MenteeDAO.TotalMentee();
        int totalMentor = MentorDAO.TotalMentor();
        int totalSkill = SkillDAO.TotalSkill();
        request.setAttribute("totalMentee",totalMentee );
        request.setAttribute("totalMentor",totalMentor );
        request.setAttribute("totalSkill",totalSkill);
        request.setAttribute("listTop3Skills",listTop3Skills);
        request.setAttribute("listTop3MentorIntro",listTop3MentorIntro);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }
}
