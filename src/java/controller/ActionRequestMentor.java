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
public class ActionRequestMentor extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDAO rDAO = new RequestDAO();
        NoficationDAO nDAO = new NoficationDAO();
        Request r = rDAO.getRequestByID(Integer.parseInt(request.getParameter("ID")));
        String action = request.getParameter("action");
        if (request.getParameter("action").equals("reject")){
            request.setAttribute("msgE", "Reject request successfully!");
            new RequestDAO().updateStatusRequest("Rejected", r.getID());
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
        request.getSession().removeAttribute("idrequest");
        request.getSession().setAttribute("idrequest", String.valueOf(r.getID()));
        request.getRequestDispatcher("detailrequestmentor").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

}
