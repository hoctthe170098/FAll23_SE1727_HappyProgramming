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
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author Admin
 */
public class ActionAdminRegisterBecomeMentor extends HttpServlet {
   
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ListBecomeMentorDAO lDAO = new ListBecomeMentorDAO();
        NoficationDAO nDAO = new NoficationDAO();
        MentorDAO mDAO = new MentorDAO();
        AccountDAO aDAO = new AccountDAO();
        MenteeDAO meDAO = new MenteeDAO();
        MentorSkillDAO msDAO = new MentorSkillDAO();
        String action = request.getParameter("action");
        Account acc = (Account)request.getSession().getAttribute("acc");
        int idMentee = Integer.parseInt(request.getParameter("ID"));
        if(action.equals("reject")){
          lDAO.delete(idMentee);
          String content = "If you failed to apply becoming a mentor, you can try again when your CV is better";
          nDAO.insertNoficationDAO(acc.getID(),idMentee , content, 1);
          request.getRequestDispatcher("ListBecomeMentor.jsp").forward(request, response);
        }else{
            SkillDAO sDAO = new SkillDAO();
            List<Skill> listSkill = sDAO.getListSkill();
            CVToBecomeMentor cv = lDAO.getCVBecomeMentorByID(idMentee);
            String[] skillMentor = cv.getSkill().split(", ");
            List<Integer>listIDSkill = new ArrayList<>();
            for(String name:skillMentor){
               for(Skill s:listSkill){
                   if(s.getName().equals(name)){
                       listIDSkill.add(s.getID());
                   }
               } 
            }
         aDAO.updateRole(idMentee);
         meDAO.delete(idMentee);
         mDAO.insertMentor(idMentee, cv.getIntro(), cv.getEx());
         for(int i: listIDSkill){
           msDAO.insertMentorSkill(idMentee, i);
         }
         lDAO.delete(idMentee);
         String content = "Congratulations on becoming a mentor, I hope you will try your best to help as much as possible mentees";
         nDAO.insertNoficationDAO(acc.getID(), idMentee, content, 1);
         request.getRequestDispatcher("ListBecomeMentor.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
    }

}