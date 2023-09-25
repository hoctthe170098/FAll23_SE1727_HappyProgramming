package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import model.*;

@MultipartConfig
public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int ID = Integer.parseInt(request.getParameter("ID"));
        ProfileDAO proDAO = new ProfileDAO();
        Profile p = proDAO.getProfileByID(ID);
        request.setAttribute("p", p);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
//        String s="rds rfdsf rfsd";
//        String[] str = s.split(" ");
//        for (int i=0;i<str.length-1;i++){
//            String firstname=str[i]+" ";
//        }
//        String lastname = str[str.length-1];
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String fullname = firstname + " " + lastname;
            String Phone = request.getParameter("phone");
            Date birth = Date.valueOf(request.getParameter("birth"));
            boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
            String address = request.getParameter("address");
            String faceLink = request.getParameter("facebooklink");
            String intaLink = request.getParameter("instragramlink");
            Part part = request.getPart("avatar");
            String realPath = request.getServletContext().getRealPath("/imagesAcc");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            Account acc = (Account) request.getSession().getAttribute("acc");
            int ID = acc.getID();
            
            String ss="fdf.df";
            out.println(ss.contains("."));
            String[] s = ss.split(".");
            out.println(s.length);
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectory(Paths.get(realPath));
            }
            //String imgName=realPath+"/"+"acc"+ID+"."+str[str.length-1];
            //String imgName = realPath + "/" + fileName;
            //part.write(imgName);
            
//            out.print("<img src='imagesAcc/"+fileName+"'>");

//            
//            Profile p = new Profile(ID, gender, fileName, Phone, birth, fullname, address, faceLink, intaLink);        
//            ProfileDAO dao = new ProfileDAO();
//          dao.InsertProfile(p);
//          out.print(p.toString());
//          request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (Exception e) {

        }
    }
}