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
import java.util.List;
import model.*;

public class ListRequestMentor extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDAO rDAO = new RequestDAO();
        rDAO.updateRequestByDate();
        String status = request.getParameter("status");
        if (status==null||(!status.equals("Processing")&&
                !status.equals("Accepted")&&!status.equals("Closed")&&!status.equals("Rejected"))) {
            response.sendRedirect("home");
        } else {
            Account acc = (Account) request.getSession().getAttribute("acc");
            String indexPage = request.getParameter("index");
            if(indexPage!=null&&!check(indexPage)){
                response.sendRedirect("home");
            }
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            List<Request> listRequest = rDAO.getRequestMentorByStatus(index, acc.getID(), status);
            int total = rDAO.getTotalRequestmentorByStatus(acc.getID(), status);
            int page = total / 4;
            if (total % 4 != 0) {
                page++;
            }
            request.setAttribute("index", indexPage);
            request.setAttribute("page", page);
            request.setAttribute("status", status);
            request.setAttribute("listReq", listRequest);
            request.getRequestDispatcher("ViewRequestMentor.jsp").forward(request, response);
        }
    }
    private boolean check(String s) {
        boolean check = true;
        try {
            int n = Integer.parseInt(s);
            if (n <= 0) {
                check = false;
            }
        } catch (Exception e) {
            check = false;
        }
        return check;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }
}
