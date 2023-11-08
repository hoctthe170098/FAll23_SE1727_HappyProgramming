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
import model.*;

/**
 *
 * @author Admin
 */
public class CreateRequestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idMentor = Integer.parseInt(request.getParameter("idmentor"));
        RequestDAO rDAO = new RequestDAO();
        rDAO.updateRequestByDate();
        request.getSession().removeAttribute("idmentor");
        request.getSession().setAttribute("idmentor", idMentor);
        request.getRequestDispatcher("CreateRequest.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        long millis = System.currentTimeMillis();
        java.sql.Date now = new java.sql.Date(millis);
        String title = request.getParameter("title");
        java.sql.Date date = java.sql.Date.valueOf(request.getParameter("date"));
        float from = Float.parseFloat(request.getParameter("from"));
        float to = Float.parseFloat(request.getParameter("to"));
        String sIDSkill = request.getParameter("idskill");
        String detail = request.getParameter("detail");
        String address = request.getParameter("address");
        float money = Float.parseFloat(request.getParameter("money"));
        if (title.trim().equals("") || detail.trim().equals("") || address.trim().equals("")) {
            request.setAttribute("msgE", "Must enter all boxs");
        } else if (date.before(now)) {
            request.setAttribute("msgD", "The date must after today");
        } else if (to - from < 2) {
            request.setAttribute("msgD", "The lesson must last at least 2 hours");
        } else if (sIDSkill == null) {
            request.setAttribute("msgS", "You must choose one skill ");
        } else {
            RequestDAO rDAO = new RequestDAO();
            NoficationDAO nDAO = new NoficationDAO();
            Account acc = (Account) request.getSession().getAttribute("acc");
            int IDMentee = acc.getID();
            int IDMentor = (int) request.getSession().getAttribute("idmentor");
            int IDSkill = Integer.parseInt(sIDSkill);
            if (rDAO.IsDuplicateRequestMentee(IDMentee, from, to, date)) {
                request.setAttribute("msgE", "You had another appointment during this time");
            } else if (rDAO.IsDuplicateRequestMentor(IDMentor, from, to, date)) {
                request.setAttribute("msgE", "This mentor had another appointment during this time");
            } else {
                rDAO.InsertRequest(IDMentor, IDMentee, IDSkill, title.trim(), date, from, to, detail.trim(), address.trim(), money);
                String content = "I have sent a request to you, check your request please";
                nDAO.insertNoficationDAO(IDMentee, IDMentor, content, 3);
            }
        }
        request.getRequestDispatcher("CreateRequest.jsp").forward(request, response);
    }
}
