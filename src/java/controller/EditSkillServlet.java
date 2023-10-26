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

import model.Skill;
import model.SkillDAO;


/**
 *
 * @author ADMIN
 */

public class EditSkillServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int id = Integer.parseInt(request.getParameter("ID"));
        SkillDAO u = new SkillDAO();
        Skill x = u.getSkillByID(id);
        request.setAttribute("skill", x);
        request.getRequestDispatcher("editskill.jsp").forward(request, response);

        

        // Tạo câu lệnh SQL để lấy thông tin kỹ năng dựa trên ID
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}

