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
 * @author Admin
 */
public class MentorDAO extends MyDAO {
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
       public List<Mentor> getAllMentor() throws SQLException {
        List<Mentor> list = new ArrayList<>();
        String sql = "Select *from dbo.Mentor";
        ps = con.prepareStatement(sql);

        rs = ps.executeQuery();
        while (rs.next()) {
            Mentor r = new Mentor();
            r.setID(rs.getInt("ID"));
            r.setIntro(rs.getString("Intro"));
           
            r.setExperience(rs.getString("Ex"));
            
            list.add(r);

        }
        return list;
    }
       public static void main(String[] args) {
        MentorDAO dao =  new MentorDAO();
      
}
}
