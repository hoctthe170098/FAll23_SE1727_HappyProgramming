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
import model.*;
/**
 *
 * @author Nhat Anh
 */
public class CommentServlet extends HttpServlet {
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String rate = request.getParameter("rating");
        String comment = request.getParameter("comment");
        int idMentor = (int)request.getSession().getAttribute("idmentor");
        Account acc = (Account)request.getSession().getAttribute("acc");
        if(rate!=null){
            RateDAO rDAO = new RateDAO();
            if(rDAO.checkIsExistRate(acc.getID(),idMentor )){
                
            }
        }
    }
}
