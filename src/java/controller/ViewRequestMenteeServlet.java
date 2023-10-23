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

public class ViewRequestMenteeServlet extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDAO rDAO = new RequestDAO();
        rDAO.updateRequestByDate();
        Account acc = (Account)request.getSession().getAttribute("acc");
        String indexPage= request.getParameter("index");
        if (indexPage==null ) {indexPage="1";}
        int index = Integer.parseInt(indexPage);
        List<Request> listRequest = rDAO.getRequestPagging(index, acc.getID());
        int total = rDAO.getTotalRequestByID(acc.getID());
        int page = total/4;
                  if (total%4!=0){
                      page++;
                    }
        request.setAttribute("index", indexPage);
        request.setAttribute("page", page);
        request.setAttribute("listReq", listRequest);
        request.getRequestDispatcher("ViewRequestMentee.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }
}
