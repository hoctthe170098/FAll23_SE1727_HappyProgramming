package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.List;
import model.*;

public class SearchSkillByNameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        SkillDAO dao = new SkillDAO();
        String skill = request.getParameter("nameskill");
        List<Skill> listSkillbyName = dao.getSkillByName(skill);
        request.setAttribute("id2", "2");
        request.setAttribute("listSkillByName", listSkillbyName);
        request.getRequestDispatcher("Skill.jsp").forward(request, response);
    }
}



