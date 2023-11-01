/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class MentorProfileDAO extends MyDAO {
     public List<MentorProfile> SearchMentorByName(String mentorName) throws SQLException {
        List<MentorProfile> listmc = new ArrayList<>();
         String sql = "SELECT Profile.Avatar, Profile.Fullname, Mentor.Intro FROM Profile " +
                 "INNER JOIN Mentor ON Profile.ID = Mentor.ID " +
                 "WHERE Fullname LIKE ?";
    ps = con.prepareStatement(sql);
    ps.setString(1, "%" + mentorName + "%");

        rs = ps.executeQuery();
        while (rs.next()) {
            MentorProfile v = new MentorProfile();
           v.setAvatar(rs.getString("Avatar"));
           v.setFullname(rs.getString("Fullname"));
           v.setIntro(rs.getString("Intro"));
           
            listmc.add(v);

        }
        return listmc;
     }
            
public static void main(String[] args) throws SQLException {
        MentorProfileDAO dao = new MentorProfileDAO();
         List<MentorProfile> mentorList = dao.SearchMentorByName("a");
    
    for (MentorProfile mentorProfile : mentorList) {
        System.out.println("Avatar: " + mentorProfile.getAvatar());
        System.out.println("Fullname: " + mentorProfile.getFullname());
        System.out.println("Intro: " + mentorProfile.getIntro());

    }
}

    public int TotalMentor(){
           
        xSql = "select count(*)as Count from Mentor";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int count;         
            while (rs.next()) {
                count = rs.getInt("Count");
               return count;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
            

           
    


