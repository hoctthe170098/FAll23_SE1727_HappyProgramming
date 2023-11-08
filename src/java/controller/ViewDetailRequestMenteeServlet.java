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
public class ViewDetailRequestMenteeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idRequest = Integer.parseInt(request.getParameter("idrequest"));
        RequestDAO rDAO = new RequestDAO();
        rDAO.updateRequestByDate();
        Account acc = (Account) request.getSession().getAttribute("acc");
        Request r = rDAO.getRequestByIDMentee(idRequest, acc.getID());
        if (r == null) {
            response.sendRedirect("home");
        } else {
            SkillDAO sDAO = new SkillDAO();
            Skill s = sDAO.getSkillByID(r.getIDSkill());
            request.getSession().removeAttribute("idmentor");
            request.getSession().setAttribute("idmentor", r.getIDMentor());
            ProfileDAO pDAO = new ProfileDAO();
            Profile mentor = pDAO.getProfileByID(r.getIDMentor());
            request.setAttribute("r", r);
            request.setAttribute("s", s);
            request.setAttribute("mentor", mentor);
            request.getRequestDispatcher("ViewDetailRequestMentee.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }
}
