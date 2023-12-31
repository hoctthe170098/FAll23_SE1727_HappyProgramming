package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HeaderServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        if (id != null) {
            if (id.equals("1")) {
                request.setAttribute("id1", id);
                request.getRequestDispatcher("mentor.jsp").forward(request, response);
            }
            if (id.equals("2")) {
                request.setAttribute("id2", id);
                request.getRequestDispatcher("Skill.jsp").forward(request, response);
            } else {
                response.sendRedirect("home");
            }            
        } else {
            response.sendRedirect("home");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
    }
}
