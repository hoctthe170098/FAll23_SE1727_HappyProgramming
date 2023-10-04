/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MentorIntroDAO extends MyDAO {
      public List<MentorIntro> getTop3MentorIntro(){
         List<MentorIntro>listTop3Mentor = new ArrayList<>();
         xSql = "select top 3 Mentor.ID,Avatar,Fullname,Rate,Intro,FacebookLink,InstagramLink "
                 + "from Mentor join Profile on Mentor.ID=Profile.ID "
                 + "order by Rate desc " ;
         try{ 
           
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            MentorIntro m ;
            int id;
            String avatar;
            String fullname;
            float rate;
            String intro;
            String facebook;
            String inta;
            while (rs.next()) {
            id=rs.getInt("ID");  
            avatar = rs.getString("Avatar");
            fullname=rs.getString("Fullname");
            rate=rs.getFloat("Rate"); 
            intro=rs.getString("Intro");
            facebook=rs.getString("FacebookLink");        
            inta=rs.getString("InstagramLink");
            m=new MentorIntro(id, avatar, fullname, rate, intro, facebook, inta);
            listTop3Mentor.add(m);
        }
            rs.close();
            ps.close();
         }catch(Exception e){
             e.printStackTrace();
         }
        return listTop3Mentor;
    }
         public List<MentorIntro> getTop3MentorIntroByIDSkill(int ID){
         List<MentorIntro>listTop3Mentor = new ArrayList<>();
         xSql = "select top 3 Mentor.ID,Avatar,Fullname,Rate,Intro,FacebookLink,InstagramLink "
                 + "from Mentor join Profile on Mentor.ID=Profile.ID "
                 + "join SkillMentor on Mentor.ID=SkillMentor.IDMentor and IDSkill="+ID
                 + " order by Rate desc " ;
         try{ 
           
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            MentorIntro m ;
            int id;
            String avatar;
            String fullname;
            float rate;
            String intro;
            String facebook;
            String inta;
            while (rs.next()) {
            id=rs.getInt("ID");  
            avatar = rs.getString("Avatar");
            fullname=rs.getString("Fullname");
            rate=rs.getFloat("Rate"); 
            intro=rs.getString("Intro");
            facebook=rs.getString("FacebookLink");        
            inta=rs.getString("InstagramLink");
            m=new MentorIntro(id, avatar, fullname, rate, intro, facebook, inta);
            listTop3Mentor.add(m);
        }
            rs.close();
            ps.close();
         }catch(Exception e){
             e.printStackTrace();
         }
        return listTop3Mentor;
    }
      public static void main(String[] args) {
        MentorIntroDAO dao =new MentorIntroDAO();
        List<MentorIntro> l = dao.getTop3MentorIntroByIDSkill(3);
        for(MentorIntro m:l){
            System.out.println(m);
        }
    }
}
