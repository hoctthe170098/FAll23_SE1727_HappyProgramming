/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
}
