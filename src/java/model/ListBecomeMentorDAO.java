/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
         
        String sql = "SELECT * FROM BecomeMentor";
         
        
         
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String Intro = resultSet.getString("Intro");
            String Ex = resultSet.getString("Ex");
            String Skill = resultSet.getString("Skill");
             
            BecomeMentor becomementor = new BecomeMentor(id, Intro, Ex, Skill);
            listAllBecomeMentor().add(becomementor);
        }
         
        resultSet.close();
        statement.close();
         
        
         
        return listAllBecomeMentor();
    }
       
}
