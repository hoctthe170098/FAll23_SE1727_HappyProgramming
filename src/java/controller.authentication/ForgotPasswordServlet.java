/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import controller.SendMail.*;
import controller.sendMail.EmailConfig;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import model.Account;
import model.AccountDAO;

/**
 *
 * @author admin
 */
@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/ForgotPassword"})
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mailCurrent = request.getParameter("email");
        request.setAttribute("email", mailCurrent);
        request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // create object
        String mailCurrent;
        Boolean status = false;
        AccountDAO dao = new AccountDAO();
        EmailConfig emailConfig = new EmailConfig();
        ForgotPasswordServlet forgot = new ForgotPasswordServlet();
        // create variable
        String getAction = request.getParameter("resetPassword");
        final ServletContext servletContext = getServletContext();
        mailCurrent = request.getParameter("email");
        Account u = dao.searchAccountByEmail(mailCurrent);
        String codeRandom = randomCode();

        if (getAction.equalsIgnoreCase("reset password")) {
            String ForgotPassword = codeRandom;
            request.setAttribute("acc", u);
            if (u == null) {
                String mess = "Email does not exist!";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
            } else {
                try {
                    emailConfig.SendEmail(mailCurrent, "Reset Password", "Code reset password: " + codeRandom);
                } catch (MessagingException ex) {
                    Logger.getLogger(ForgotPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.getWriter().print(ex.getMessage());

                }
                servletContext.setAttribute("myVariable", codeRandom);
                // Lập lịch xóa biến sau 1 phút
                TimerTask removeVariableTask = new TimerTask() {
                    @Override
                    public void run() {
                        servletContext.removeAttribute("myVariable");
                    }
                };
                ///////////////////////////////////////////////////
                Timer timer = new Timer();
                timer.schedule(removeVariableTask, 90 * 1000); // 1 phút = 60 giây * 1000 mili giây
                //====================================================================
                request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
            }
            if (servletContext.getAttribute("myVariable") == null) {
                request.setAttribute("mess", "The code has expired!");
                u = null;
                request.setAttribute("acc", u);
                request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
            }
            if (getAction.equalsIgnoreCase("change password")) {

                // Lấy giá trị biến
                if (servletContext.getAttribute("myVariable") != null) {
                    String myVariable = (String) servletContext.getAttribute("myVariable");
                    mailCurrent = request.getParameter("email");
                    String password = request.getParameter("oldPassword");
                    if (!password.equalsIgnoreCase(myVariable)) {
                        String mess2 = "Code not correct!";
                        request.setAttribute("mess2", mess2);
                        request.setAttribute("acc", u);
                        request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
                    } else {
                        String newPassword = request.getParameter("password1");
                        dao.updatePassword(mailCurrent, newPassword);
                        response.sendRedirect("Signin.html");
                    }
                } else {
                    request.setAttribute("mess", "The code has expired!");
                    u = null;
                    request.setAttribute("acc", u);
                    request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
                }

            }
        }
    }

    public String randomCode() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Generates a random number between 100000 and 999999
        return randomNumber + "";
    }
}
