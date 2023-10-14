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
public class ShowNoficationServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Account acc = (Account)request.getSession().getAttribute("acc");
        String sCount = request.getParameter("count");
        if(sCount==null) sCount="5";
        int count = Integer.parseInt(sCount);
        NoficationDAO nDAO = new NoficationDAO();
        List<Notification> list = nDAO.getListNoficationByID(acc.getID(), count);
        request.setAttribute("list", list);
        request.getRequestDispatcher("Notification.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

}
