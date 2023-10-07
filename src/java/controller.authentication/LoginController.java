/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javax.mail.Session;
import model.Account;

/**
 *
 * @author sonnt
 */
public class LoginController extends HttpServlet {

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
        //query data from databases;

        request.getRequestDispatcher("Signin.html").forward(request, response);

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
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        String remember = request.getParameter("remember");

        AccountDAO db = new AccountDAO();
        Account account = db.getAccountBy(username, password);

        if (account == null) {
            String msg = "";
            HttpSession session = request.getSession();
            session.setAttribute("account", null);
            response.sendRedirect("login?error=1");
            msg = "Unable to loggin";
            request.setAttribute("mess", msg);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", account);
            if (remember != null) {
                String loginData = username + ":" + password;
                Cookie rememberLogin = new Cookie("loginRemember", loginData);
                rememberLogin.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(rememberLogin);
            }
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Long description";
    }// </editor-fold>

}
