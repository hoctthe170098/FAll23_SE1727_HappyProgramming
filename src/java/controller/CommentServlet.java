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
        CommentDAO cDAO = new CommentDAO();
        RequestDAO rDAO = new RequestDAO();
        RateDAO raDAO = new RateDAO();
        String IDC = request.getParameter("IDC");
        Account acc = (Account) request.getSession().getAttribute("acc");
        if (IDC != null) {
            int ID = Integer.parseInt(IDC);
            cDAO.deleteComment(ID);
        }
        int idMentor = 0;
        String idmentor = request.getParameter("idmentor");
        if (idmentor == null) {
            response.sendRedirect("home");
        }
        if (!rDAO.CheckRequestClosed(idmentor, acc.getID())) {
            request.setAttribute("closed", false);
        } else {
            if (idmentor != null) {
                idMentor = Integer.parseInt(idmentor);
                request.getSession().removeAttribute("idmentor");
                request.getSession().setAttribute("idmentor", idMentor);
            } else {
                idMentor = (int) request.getSession().getAttribute("idmentor");
            }
            if (!raDAO.checkIsExistRate(acc.getID(), idMentor)) {
                raDAO.insertRate(idMentor, acc.getID());
            }
            List<Comment> listC = cDAO.getCommentBy2ID(acc.getID(), idMentor);
            request.setAttribute("listC", listC);
        }
        request.getRequestDispatcher("DisplayComment.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sRate = request.getParameter("rating");
        String comment = request.getParameter("comment");
        int idMentor = (int) request.getSession().getAttribute("idmentor");
        Account acc = (Account) request.getSession().getAttribute("acc");
        CommentDAO cDAO = new CommentDAO();
        if (sRate != null) {
            RateDAO rDAO = new RateDAO();
            int rate = Integer.parseInt(sRate);
            Rate r = new Rate(idMentor, acc.getID(), rate);
            rDAO.updateRate(r);
        }
        if (comment != "") {
            cDAO.insertComment(idMentor, acc.getID(), comment);
        }
        List<Comment> list = cDAO.getCommentBy2ID(acc.getID(), idMentor);
        request.setAttribute("listC", list);
        request.getRequestDispatcher("DisplayComment.jsp").forward(request, response);
    }
}
