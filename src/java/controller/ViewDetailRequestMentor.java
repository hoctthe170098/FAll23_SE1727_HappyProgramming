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
public class ViewDetailRequestMentor extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sRequest = request.getParameter("idrequest");
        Account acc = (Account) request.getSession().getAttribute("acc");
        if (sRequest == null) {
            sRequest = (String) request.getSession().getAttribute("idrequest");
        }
        int idRequest = Integer.parseInt(sRequest);
        String msgE = request.getParameter("msgE");
        RequestDAO rDAO = new RequestDAO();
        rDAO.updateRequestByDate();
        Request r = rDAO.getRequestByIDMentor(idRequest, acc.getID());
        if (r == null) {
            response.sendRedirect("home");
        } else {
            SkillDAO sDAO = new SkillDAO();
            Skill s = sDAO.getSkillByID(r.getIDSkill());
            request.getSession().removeAttribute("idmentor");
            request.getSession().setAttribute("idmentor", r.getIDMentor());
            ProfileDAO pDAO = new ProfileDAO();
            Profile mentee = pDAO.getProfileByID(r.getIDMentee());
            request.setAttribute("r", r);
            request.setAttribute("s", s);
            request.setAttribute("mentee", mentee);
            if (msgE != null) {
                request.setAttribute("msgE", msgE);
            }
            request.getRequestDispatcher("ViewDetailRequestMentor.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }
}
