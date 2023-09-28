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

    // b?t swj kien insert -> acc -> mentee
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
           
            Account acc = (Account) request.getSession().getAttribute("acc");
            int ID = acc.getID();
            ProfileDAO dao = new ProfileDAO();
            Profile pro = dao.getProfileByID(ID);
            if (pro.getId()==0){
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            String realPath = request.getServletContext().getRealPath("/imagesAcc");
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectory(Paths.get(realPath));
            }
            int index=-1;
            for (int i=0;i<=fileName.length();i++){
                if (fileName.charAt(i)=='.'){
                    index=i;break;
                }
            }
            String s=fileName.substring(index);
            String img="acc"+ID+"."+s;
            String imgName = realPath + "/" + img;
            part.write(imgName);    
            Profile p = new Profile(ID, gender,"imagesAcc/"+img, Phone, birth, fullname, address, faceLink, intaLink);  
            dao.InsertProfile(p);
             response.sendRedirect("profile.jsp");
            }
            else{
                if (part==null){
                    
                    Profile p = new Profile(ID, gender,pro.getAvatar(), Phone, birth, fullname, address, faceLink, intaLink);
                    out.println(p.toString());
//                    dao.deleteProfile(ID);
//                    dao.InsertProfile(p);             
                }
            }                 
        } catch (Exception e) {

        }
         
    }
}
