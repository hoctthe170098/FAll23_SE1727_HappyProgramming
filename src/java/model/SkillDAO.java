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
public class SkillDAO extends MyDAO {

    public List<Skill> getListSkill() {
        List<Skill> listSkill = new ArrayList<>();
        xSql = "select * from Skills";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String name;
            String Description;
            String img;
            Skill x;
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                Description = rs.getString("Description");
                img = rs.getString("image");
                x = new Skill(id, name, Description, img);
                listSkill.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (listSkill);
    }

    public List<Skill> getListTop3Skill() {
        List<Skill> listSkill = new ArrayList<>();
        xSql = "select top 3 * from Skills order by ID";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String name;
            String Description;
            String img;
            Skill x;
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                Description = rs.getString("Description");
                img = rs.getString("image");
                x = new Skill(id, name, Description, img);
                listSkill.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (listSkill);
    }

    public int TotalSkill() {

        xSql = "select count(*)as Count from Skills";
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


    public static void main(String[] args) {
        SkillDAO dao = new SkillDAO();
        List<Skill> list = dao.getListSkill();
        for (Skill s : list) {
            System.out.println(s.toString());
        }
    }
}
