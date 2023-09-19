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
public class CVDAO extends MyDAO{
     public List<CV> getAllCV() throws SQLException {
        List<CV> list = new ArrayList<>();
        String sql = "Select *from dbo.CV";
        ps = con.prepareStatement(sql);

        rs = ps.executeQuery();
        while (rs.next()) {
            CV c = new CV();
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
        CVDAO cdao =  new CVDAO();
        
    }
}
