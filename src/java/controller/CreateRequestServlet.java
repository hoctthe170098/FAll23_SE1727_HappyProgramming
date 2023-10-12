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

/**
 *
 * @author Admin
 */
public class CreateRequestServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idMentor = Integer.parseInt(request.getParameter("idmentor"));
        Date date = Date.valueOf(request.getParameter("date"));
        long millis=System.currentTimeMillis();   
        java.sql.Date now=new java.sql.Date(millis);
        if(date.equals(now)){
            request.setAttribute("idMentor", idMentor);
            request.getRequestDispatcher("CreateRequest.jsp").forward(request, response);
        }else{
            out.print("dcm ");
        }
    }
}
