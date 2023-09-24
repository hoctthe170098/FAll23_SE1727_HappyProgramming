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
public class ProfileDAO extends MyDAO{
     public List<Profile> getAllCV() throws SQLException {
        List<Profile> list = new ArrayList<>();
        String sql = "Select *from dbo.CV";
        ps = con.prepareStatement(sql);

        rs = ps.executeQuery();
        while (rs.next()) {
            Profile c = new Profile();
            c.setId(rs.getInt("ID"));
            c.setGender(rs.getBoolean("Gender"));
            c.setAvatar(rs.getString("Avatar"));
            c.setPhone(rs.getString("Phone"));
            c.setBirth(rs.getDate("Birth"));
            c.setFullname(rs.getString("Fullname"));
            c.setAddress(rs.getString("Address"));
            
            list.add(c);

        }
        return list;
    }
     public static void main(String[] args)  {
        ProfileDAO cdao =  new ProfileDAO();
        
    }
}
