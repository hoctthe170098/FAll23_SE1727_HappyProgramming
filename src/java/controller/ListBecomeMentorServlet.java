/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import model.BecomeMentor;
import model.ListBecomeMentorDAO;

/**
 *
 * @author admin
 */
public class ListBecomeMentorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Frameset//EN\" \"http://www.w3.org/TR/REC-html40/frameset.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListBecomeMentorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListBecomeMentorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         String action = request.getServletPath();
 
        try {
            switch (action) {
            
           
            case "/delete":
                deleteRequest(request, response);
                break;
          
            
            default:
                listAllRequest(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
     private void  listAllRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
         ListBecomeMentorDAO lmd = new ListBecomeMentorDAO();
        List<BecomeMentor> listMentor = lmd.listAllBecomeMentor();
        request.setAttribute("ListBecomeMentor", listMentor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListBecomeMentor.jsp");
        dispatcher.forward(request, response);
    }
     private void deleteRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        BecomeMentor bm = new BecomeMentor(id);
       ListBecomeMentorDAO bmd = new ListBecomeMentorDAO();
       bmd.deleteRequest(bm);
        response.sendRedirect("list");
 
    }
}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   



