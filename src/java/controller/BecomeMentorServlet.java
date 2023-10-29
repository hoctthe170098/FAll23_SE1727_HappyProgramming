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
public class BecomeMentorServlet extends HttpServlet {
   
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Account acc = (Account)request.getSession().getAttribute("acc");
        int ID = acc.getID();
        String button = request.getParameter("button");
        BecomeMentorDao bmDao = new BecomeMentorDao();
        if(button==null){
        ProfileDAO pDao = new ProfileDAO();
        boolean isExist = pDao.IsExistProfile(ID);   
        BecomeMentor bm = bmDao.getBecomeMentorByID(ID);
        request.setAttribute("isExistProfile",isExist);
        if(bm.getID()>0){
        request.setAttribute("BecomeMentor", bm);}
        request.getRequestDispatcher("BecomeMentor.jsp").forward(request, response);
        }
        else{
            String intro = request.getParameter("intro");
        String[] listNameSkill = request.getParameterValues("skill");
        String ex = request.getParameter("ex");
        String reason = request.getParameter("reason");
        BecomeMentor bm = new BecomeMentor(acc.getID(), intro, ex, listNameSkill,reason);      
        bmDao.InsertBecomeMentor(bm);
        NoficationDAO nDAO = new NoficationDAO();
        String content = "I want to become a mentor, please check request for me";
        nDAO.insertNoficationDAO(acc.getID(), 1, content, 3);
        request.setAttribute("isExistProfile",true);
        request.setAttribute("BecomeMentor", bm);
        request.getRequestDispatcher("BecomeMentor.jsp").forward(request, response); 
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Account acc = (Account)request.getSession().getAttribute("acc");
        BecomeMentorDao bmDao = new BecomeMentorDao();
        bmDao.deleteBecomeMentor(acc.getID());
        request.setAttribute("isExistProfile",true);
        request.getRequestDispatcher("BecomeMentor.jsp").forward(request, response);
    }

}
