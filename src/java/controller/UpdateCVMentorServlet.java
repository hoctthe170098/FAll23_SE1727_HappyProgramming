package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.*;

@MultipartConfig
public class UpdateCVMentorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Account acc = (Account)request.getSession().getAttribute("acc");       
        ProfileDAO proDAO = new ProfileDAO();
        Profile p = proDAO.getProfileByID(acc.getID());
        MentorDAO mDAO = new MentorDAO();
        Mentor m = mDAO.getMentorByID(acc.getID());
        MentorSkillDAO msDAO = new MentorSkillDAO();
        MentorSkill ms = msDAO.getSkillByName(acc.getID());
        List<Integer> ListSkillMentor = ms.getListSkillID();
        request.setAttribute("p", p);
        request.setAttribute("m", m);
        request.setAttribute("ListSkillMentor", ListSkillMentor);
        request.getRequestDispatcher("UpdateCVMentor.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ProfileDAO dao = new ProfileDAO();
            MentorDAO mDao = new MentorDAO();
            MentorSkillDAO msDAO = new MentorSkillDAO();
            Account acc = (Account) request.getSession().getAttribute("acc");
            int ID = acc.getID();
            String button = request.getParameter("button");
            if (button.equals("update")) {
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String fullname = firstname + " " + lastname;
                String Phone = request.getParameter("phone");
                Date birth = Date.valueOf(request.getParameter("birth"));
                boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
                String address = request.getParameter("address");
                String intro = request.getParameter("intro");
                String ex = request.getParameter("ex");
                String faceLink = request.getParameter("facebooklink");
                String intaLink = request.getParameter("instragramlink");
                Part part = request.getPart("avatar");
                String[] listSSkill = request.getParameterValues("skill");
                List<Integer>listIDSkill = new ArrayList<>();
                if(listSSkill!=null){            
                for(int i=0;i<listSSkill.length;i++)
                    listIDSkill.add(Integer.parseInt(listSSkill[i]));
                }
                Profile p;    
                    Profile pro = dao.getProfileByID(ID);
                    Mentor m = mDao.getMentorByID(ID);
                if (pro.getId() == 0) {
                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    if (!fileName.equals("")) {
                        String realPath = request.getServletContext().getRealPath("/imagesAcc");
                        if (!Files.exists(Paths.get(realPath))) {
                            Files.createDirectory(Paths.get(realPath));
                        }
                        int index = -1;
                        for (int i = 0; i <= fileName.length(); i++) {
                            if (fileName.charAt(i) == '.') {
                                index = i;
                                break;
                            }
                        }
                        String s = fileName.substring(index);
                        String img = "acc" + ID + s;
                        String imgName = realPath + "/" + img;
                        part.write(imgName);
                        p = new Profile(ID, gender, "imagesAcc/" + img, Phone, birth, fullname, address, faceLink, intaLink);
                    } else {
                        p = new Profile(ID, gender, "imagesAcc/acc0.jpg", Phone, birth, fullname, address, faceLink, intaLink);   
                    }
                    m.setExperience(ex);
                    m.setIntro(intro);
                    if(dao.IsExistPhone(Phone)){
                          request.setAttribute("msgP", "This PhoneNumber is Exist");  
                        }else if(Phone.length()!=10){
                          request.setAttribute("msgP", "PhoneNumber must contain 10 digit");  
                        }else if(listIDSkill.size()==0){
                          request.setAttribute("msgS", "You must choose at least 1 skill");    
                        }
                    else{
                        mDao.updateMentor(ID, intro, ex);
                        dao.InsertProfile(p);
                        msDAO.deleteMentorSkill(ID);
                        for(int i: listIDSkill){
                            msDAO.insertMentorSkill(ID,i);
                        }
                        request.setAttribute("msgE", "Update CV successfully"); 
                    }
                    request.setAttribute("m", m);
                    request.setAttribute("p", p);
                    request.setAttribute("ListSkillMentor", listIDSkill);
                       
                } else {
                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    if (!fileName.equals("")) {
                        String realPath = request.getServletContext().getRealPath("/imagesAcc");
                        if (!Files.exists(Paths.get(realPath))) {
                            Files.createDirectory(Paths.get(realPath));
                        }
                        int index = -1;
                        for (int i = 0; i <= fileName.length(); i++) {
                            if (fileName.charAt(i) == '.') {
                                index = i;
                                break;
                            }
                        }
                        String s = fileName.substring(index);
                        String img = "acc" + ID + s;
                        String imgName = realPath + "/" + img;
                        part.write(imgName);
                        p = new Profile(ID, gender, "imagesAcc/" + img, Phone, birth, fullname, address, faceLink, intaLink);                     
                    } else {
                        p = new Profile(ID, gender, pro.getAvatar(), Phone, birth, fullname, address, faceLink, intaLink);                    
                    }
                    m.setExperience(ex);
                    m.setIntro(intro);
                    if(!Phone.equals(pro.getPhone())&&dao.IsExistPhone(Phone)){
                         request.setAttribute("msgP", "This PhoneNumber is Exist");  
                    }else if(Phone.length()!=10){
                        request.setAttribute("msgP", "PhoneNumber must contain 10 digit");  
                    }else if(listIDSkill.size()==0){
                          request.setAttribute("msgS", "You must choose at least 1 skill");    
                        }          
                    else{
                        dao.deleteProfile(ID);
                        dao.InsertProfile(p);
                        mDao.updateMentor(ID, intro, ex);
                        msDAO.deleteMentorSkill(ID);
                        for(int i: listIDSkill){
                            msDAO.insertMentorSkill(ID,i);
                        }
                         request.setAttribute("msgE", "Update CV successfully");
                    }
                    request.setAttribute("m", m);
                    request.setAttribute("p", p);
                    request.setAttribute("ListSkillMentor", listIDSkill);
                }
            }
        } catch (Exception e) {

        }
        request.getRequestDispatcher("UpdateCVMentor.jsp").forward(request, response);
    }
}
