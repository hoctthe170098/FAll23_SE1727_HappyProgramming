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
import jakarta.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author DELL
 */
public class RegisterServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("RegisterAccount.jsp").forward(request, response);
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
        AccountDAO accDao = new AccountDAO();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String repass = request.getParameter("repass");
        if (name == "" || email == "" || password == "" || repass == "") {
            request.setAttribute("msg", "Please fill out the form completely");
        } else if ((name.contains(" ") || name.length() > 50) || (password.contains(" ") || password.length() > 50)) {
            request.setAttribute("msg", "Username or password can't contain space or has length >50 ");
        } else if (password.length() < 8 || !password.contains("[A-Z]") || !password.contains("[a-z]") || !password.contains("[0-9]")) {
            request.setAttribute("msg", "Password must has at least 8 characters long,one lowercase letter, one uppercase letter and one number ");
        } else {
            if (accDao.IsExistUsername(name)) {
                request.setAttribute("msg", "Username is exist");
            } else if (accDao.IsExistEmail(email)) {
                request.setAttribute("msg", "Email is exist");
            } else if (!password.equals(repass)) {
                request.setAttribute("msg", "Password must be the same as Repassword");
            } else {
                Account acc = new Account(0, email, name, password, Byte.valueOf("1"), Byte.valueOf("0"), Byte.valueOf("0"));
                accDao.insertAccount(acc);
                request.setAttribute("msg", "Sign up successfully, please return Sign in page to login");
            }
        }
         request.getRequestDispatcher("RegisterAccount.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "long description";
    }// </editor-fold>

}
