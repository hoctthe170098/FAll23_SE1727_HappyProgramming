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
public class ViewCVMentee extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ListBecomeMentorDAO lDAO = new ListBecomeMentorDAO();
        String idMentee = request.getParameter("idmentee");
        if (idMentee == null) {
            response.sendRedirect("home");
        } else {
            CVToBecomeMentor CV = lDAO.getCVBecomeMentorByID(idMentee);
            if (CV != null) {
                String date = String.valueOf(CV.getP().getBirth());
                boolean g = CV.getP().isGender();
                if (g) {
                    request.setAttribute("gender", "Male");
                } else {
                    request.setAttribute("gender", "Female");
                }
                AccountDAO aDAO = new AccountDAO();
                String email = aDAO.getEmailByID(CV.getID());
                request.setAttribute("email", email);
                request.setAttribute("birth", date);
                request.setAttribute("CV", CV);
                request.getRequestDispatcher("ViewCVMentee.jsp").forward(request, response);
            } else {
                response.sendRedirect("home");
            }

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

}
