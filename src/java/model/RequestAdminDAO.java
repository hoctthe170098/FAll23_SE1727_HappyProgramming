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
public class RequestAdminDAO extends MyDAO {
    public List<RequestAdmin> getAllRequests() {
    List<RequestAdmin> requests = new ArrayList<>();
    xSql = "SELECT r.ID,pr.FullName AS MentorName, pr_e.FullName AS MenteeName, s.Name AS Skill, r.Title, r.Date, r.[From], r.[To], r.Details, r.Status, r.Address, r.money " +
           "FROM Request r " +
           "JOIN Profile pr ON r.IDMentor = pr.ID " +
           "JOIN Profile pr_e ON r.IDMentee = pr_e.ID " +
           "JOIN Skills s ON r.IDSkill = s.ID";

    try {
        ps = con.prepareStatement(xSql);
        rs = ps.executeQuery();
        while (rs.next()) {
            
            int ID = rs.getInt("ID");
            float from = rs.getFloat("From");
            float to = rs.getFloat("to");
            String status = rs.getString("status"); 
            String title = rs.getString("Title");
            String details = rs.getString("Details");
            Date date = rs.getDate("Date");
            String address = rs.getString("Address");
            float money = rs.getFloat("money");
            String mentorName = rs.getString("MentorName");
            String menteeName = rs.getString("MenteeName");
            String skill = rs.getString("Skill");
            RequestAdmin r = new RequestAdmin(ID,from, to, status, title, details, date, address, money, mentorName, menteeName, skill);

            requests.add(r);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return requests;
}
    public int TotalRequest() {
        xSql = "select count(*)as Count from Request";
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
