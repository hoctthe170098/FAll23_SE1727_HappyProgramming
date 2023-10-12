/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ListBecomeMentorDAO extends MyDAO{
      public List<BecomeMentor> listAllBecomeMentor() throws SQLException {
        List<BecomeMentor> listMentor = new ArrayList<>();
        BecomeMentor bm = new BecomeMentor(); 
        String sql = "SELECT * FROM BecomeMentor";
         
        
         
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String Intro = resultSet.getString("Intro");
            String Ex = resultSet.getString("Ex");
            String skill = rs.getString("Skill");
             String[]skills = skill.split(",");
            bm.setSkill(skills);
             
            BecomeMentor becomementor = new BecomeMentor(id, Intro, Ex, skills);
            listAllBecomeMentor().add(becomementor);
        }
         
        resultSet.close();
        statement.close();
         
        
         
        return listAllBecomeMentor();
    }
       public boolean deleteRequest(BecomeMentor bm) throws SQLException {
        String sql = "DELETE FROM book where book_id = ?";
         
        
         
         PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, bm.getID());
        
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        return rowDeleted;     
    }
}
