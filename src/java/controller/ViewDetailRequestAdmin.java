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
public class ViewDetailRequestAdmin extends HttpServlet {
   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String IDRequest = request.getParameter("requestID");
        if(IDRequest==null||!check(IDRequest)){
            response.sendRedirect("home");
        }
        int idRequest = Integer.parseInt(request.getParameter("requestID"));      
        RequestDAO rDAO = new RequestDAO();
        rDAO.updateRequestByDate();
        Request r = rDAO.getRequestByID(idRequest);
        SkillDAO sDAO = new SkillDAO();
        Skill s = sDAO.getSkillByID(r.getIDSkill());
        request.getSession().removeAttribute("idmentor");
        request.getSession().setAttribute("idmentor", r.getIDMentor());
        ProfileDAO pDAO = new ProfileDAO();
        Profile mentor = pDAO.getProfileByID(r.getIDMentor());
        Profile mentee = pDAO.getProfileByID(r.getIDMentee());
        request.setAttribute("r", r);
        request.setAttribute("s", s);
        request.setAttribute("mentor",mentor);
        request.setAttribute("mentee", mentee);
        request.getRequestDispatcher("DetailRequestAdmin.jsp").forward(request, response);   
    }
    private boolean check(String s){
        boolean check=true;
        try{
            int a = Integer.parseInt(s);
            if(a<=0)check=false;
        }catch(Exception e){
            check=false;
        }
        return check;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }
}
