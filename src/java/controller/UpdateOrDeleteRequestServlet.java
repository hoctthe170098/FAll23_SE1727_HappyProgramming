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
import model.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class UpdateOrDeleteRequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Account acc = (Account) request.getSession().getAttribute("acc");
        String action = request.getParameter("action");
        String ID = request.getParameter("idrequest");
        RequestDAO rDAO = new RequestDAO();
        rDAO.updateRequestByDate();
        if(action==null||ID==null){
            response.sendRedirect("home");
        }
        else if (!action.equals("delete") && !action.equals("update")) {
            response.sendRedirect("home");
        } else if ((rDAO.getRequestByIDMentee(ID, acc.getID()) == null)) {
            response.sendRedirect("home");
        } else if (action.equals("delete")) {
            rDAO.deleteRequest(ID);
            request.setAttribute("msgE", "Delete Request successfully");
            response.sendRedirect("home");
        } else if (action.equals("update")) {
            Request r = rDAO.getRequestCanUpdateByIDMentee(ID, acc.getID());
            if (r == null) {
                response.sendRedirect("home");
            } else {
                long millis = System.currentTimeMillis();
                java.sql.Date now = new java.sql.Date(millis);
                if (r.getStatus().equals("Accepted") && r.getDate().toString().equals(now.toString())) {
                    request.setAttribute("msgE", "Can't update request because The meeting took place today!");
                    request.getRequestDispatcher("CreateRequest.jsp").forward(request, response);
                } else {
                    request.getSession().removeAttribute("request");
                    request.getSession().setAttribute("request", r);
                    request.getRequestDispatcher("UpdateRequest.jsp").forward(request, response);
                }
            }
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Request r = (Request) request.getSession().getAttribute("request");
        if (r == null) {
            response.sendRedirect("home");
        } else {
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
                request.getRequestDispatcher("UpdateRequest.jsp").forward(request, response);
            } else if (date.before(now)) {
                request.setAttribute("msgD", "The date must after today");
                request.getRequestDispatcher("UpdateRequest.jsp").forward(request, response);
            } else if (to - from < 2) {
                request.setAttribute("msgD", "The lesson must last at least 2 hours");
                request.getRequestDispatcher("UpdateRequest.jsp").forward(request, response);
            } else if (sIDSkill == null) {
                request.setAttribute("msgS", "You must choose one skill ");
                request.getRequestDispatcher("UpdateRequest.jsp").forward(request, response);
            } else {
                RequestDAO rDAO = new RequestDAO();
                NoficationDAO nDAO = new NoficationDAO();
                Account acc = (Account) request.getSession().getAttribute("acc");
                int IDMentee = acc.getID();
                int IDMentor = (int) request.getSession().getAttribute("idmentor");
                int IDSkill = Integer.parseInt(sIDSkill);
                if (!date.equals(r.getDate()) && rDAO.IsDuplicateRequestMentee(IDMentee, from, to, date)) {
                    request.setAttribute("msgE", "You had another appointment during this time");
                    request.getRequestDispatcher("UpdateRequest.jsp").forward(request, response);
                } else if (!date.equals(r.getDate()) && rDAO.IsDuplicateRequestMentor(IDMentor, from, to, date)) {
                    request.setAttribute("msgE", "This mentor had another appointment during this time");
                    request.getRequestDispatcher("UpdateRequest.jsp").forward(request, response);
                } else {
                    Request rUpdate = new Request(r.getID(), IDMentor,
                            IDMentee, IDSkill, title.trim(), date, from, to, detail.trim(), r.getStatus(), address.trim(), money);
                    rDAO.updateRequest(rUpdate);
                    if (r.getStatus().equals("Accepted")) {
                        String content = "I have changed a request you have accepted from me, check your request part Accepted please";
                        nDAO.insertNoficationDAO(IDMentee, IDMentor, content, 3);
                    }
                    request.getRequestDispatcher("CreateRequest.jsp").forward(request, response);
                }
            }
        }
    }

}
