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
import java.util.*;
import java.sql.Date;
import model.*;

/**
 *
 * @author Admin
 */
public class ActionRequestMentor extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Account acc = (Account) request.getSession().getAttribute("acc");
        RequestDAO rDAO = new RequestDAO();
        NoficationDAO nDAO = new NoficationDAO();
        int idRequest = Integer.parseInt(request.getParameter("ID"));
        Request r ;
        String action = request.getParameter("action");
        if (!action.equals("update") && !action.equals("reject") && !action.equals("accept")) {
            response.sendRedirect("home");
        } else {
            request.getSession().removeAttribute("idrequest");
            request.getSession().setAttribute("idrequest", String.valueOf(idRequest));
            if (action.equals("update")) {
                r = rDAO.getRequestAcceptByIDMentor(idRequest, acc.getID());
                out.print(acc.getID());
                if (r == null) {
                    response.sendRedirect("home");
                } 
                    request.setAttribute("r", r);
                    request.getRequestDispatcher("UpdateRequestForMentor.jsp").forward(request, response);             
            } else {
                r = rDAO.getRequestProcessingByIDMentor(idRequest, acc.getID());
                if (r == null) {
                    response.sendRedirect("home");
                } else {
                    if (action.equals("reject")) {
                        request.setAttribute("msgE", "Reject request successfully!");
                        rDAO.updateStatusRequest("Rejected", r.getID());
                        nDAO.insertNoficationDAO(r.getIDMentor(), r.getIDMentee(), "Sorry, because some reasons,"
                                + " I can't meet you now. You can continue sending request, I hope we can meet another time", 2);
                    } else {
                        if (rDAO.IsDuplicateRequestMentee(r.getIDMentee(), r.getFrom(), r.getTo(), r.getDate())
                                || rDAO.IsDuplicateRequestMentor(r.getIDMentor(), r.getFrom(), r.getTo(), r.getDate())) {
                            request.setAttribute("msgE", "Can't accept this request because you or this mentee is having a meeting in this time");
                        } else {
                            nDAO.insertNoficationDAO(r.getIDMentor(), r.getIDMentee(), "I have accepted your request, "
                                    + "please check your schedule and be on time for your next meeting", 2);
                            request.setAttribute("msgE", "Accept request successfully!");
                            new RequestDAO().updateStatusRequest("Accepted", r.getID());
                        }
                    }
                    request.getRequestDispatcher("detailrequestmentor").forward(request, response);
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idRequest = Integer.parseInt((String) request.getSession().getAttribute("idrequest"));
        RequestDAO rDAO = new RequestDAO();
        Request r = rDAO.getRequestByID(idRequest);
        long millis = System.currentTimeMillis();
        java.sql.Date now = new java.sql.Date(millis);
        Date date = Date.valueOf(request.getParameter("date"));
        float from = Float.parseFloat(request.getParameter("from"));
        float to = Float.parseFloat(request.getParameter("to"));
        String sIDSkill = request.getParameter("idskill");
        String detail = request.getParameter("detail");
        String address = request.getParameter("address");
        request.setAttribute("idrequest", r.getID());
        boolean update = false;
        if (date.before(now)) {
            request.setAttribute("msgD", "The date must after today");
        } else if (to - from < 2) {
            request.setAttribute("msgD", "The lesson must last at least 2 hours");
        } else {
            NoficationDAO nDAO = new NoficationDAO();
            if (!date.equals(r.getDate()) && rDAO.IsDuplicateRequestMentee(r.getIDMentee(), from, to, date)) {
                request.setAttribute("msgE", "The mentee had another appointment during this time");
            } else if (!date.equals(r.getDate()) && rDAO.IsDuplicateRequestMentor(r.getIDMentor(), from, to, date)) {
                request.setAttribute("msgE", "You had another appointment during this time");
            } else {
                Request rUpdate = new Request(r.getID(), r.getIDMentor(),
                        r.getIDMentee(), Integer.parseInt(sIDSkill), r.getTitle(), date, from, to, detail, r.getStatus(), address, r.getMoney());
                rDAO.updateRequest(rUpdate);
                String content = "I have changed a request I have accepted from you, please check your request part Accepted ";
                nDAO.insertNoficationDAO(r.getIDMentor(), r.getIDMentee(), content, 2);
                request.setAttribute("r", rUpdate);
                update = true;
                request.setAttribute("msgE", "Update request successfully!");
            }
        }
        if (!update) {
            request.setAttribute("r", r);
        }
        request.getRequestDispatcher("UpdateRequestForMentor.jsp").forward(request, response);
    }
}
