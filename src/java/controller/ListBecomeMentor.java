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
public class ListBecomeMentor extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ListBecomeMentorDAO lDAO = new ListBecomeMentorDAO();
        String indexPage = request.getParameter("index");
        if(indexPage!=null&&!check(indexPage)){
            response.sendRedirect("home");
        }
        String msgE = request.getParameter("msgE");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        List<CVToBecomeMentor> listCV = lDAO.getListBecomeMentor(index);
        int total = lDAO.getTotal();
        int page = total / 4;
        if (total % 4 != 0) {
            page++;
        }
        request.setAttribute("index", indexPage);
        request.setAttribute("page", page);
        request.setAttribute("listCV", listCV);
        if (msgE != null) {
            request.setAttribute("msgE", msgE);
        }
        request.getRequestDispatcher("ListBecomeMentor.jsp").forward(request, response);
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
