/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp DAO để truy vấn thông tin Mentee.
 */
public class MenteeProfileDAO extends MyDAO {
    public List<MenteeProfile> getAllMenteeIntro() {
        List<MenteeProfile> listAllMentee = new ArrayList<>();
        xSql = "SELECT p.ID, p.Avatar, p.Fullname, p.Address, p.Birth, p.Phone, p.FacebookLink, p.InstagramLink " +
               "FROM Profile p " +
               "JOIN Mentee e " +
               "ON p.ID = e.ID";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                String avatar = rs.getString("Avatar");
                String fullname = rs.getString("Fullname");
                String address = rs.getString("Address");
                Date birth = rs.getDate("Birth");
                String phone = rs.getString("Phone");
                String facebook = rs.getString("FacebookLink");
                String instagram = rs.getString("InstagramLink");
                MenteeProfile mentee = new MenteeProfile(id, avatar, fullname, address, birth, phone, facebook, instagram);
                listAllMentee.add(mentee);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAllMentee;
    }
    public int TotalMentee() {
    xSql = "SELECT COUNT(*) AS Count FROM Mentee";
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

