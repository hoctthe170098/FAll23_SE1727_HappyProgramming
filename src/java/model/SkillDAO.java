/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            int ID;
            String name;
            String Description;
            String image;
            Skill x;
            while (rs.next()) {
                ID = rs.getInt("ID");
                name = rs.getString("Name");
                Description = rs.getString("Description");
                image = rs.getString("image");
                x = new Skill(ID, name, Description, image);
                listSkill.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (listSkill);
    }

    public Skill getSkillByID(int ID) {
        Skill skill = null;
         xSql = "select * from Skills where ID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, ID);
             rs = ps.executeQuery();

            if (rs.next()) {
                // Lấy thông tin từ cơ sở dữ liệu
                int skillID = rs.getInt("ID");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                String image = rs.getString("Image");

                // Tạo đối tượng Skill
                skill = new Skill(skillID, name, description, image);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skill;
    }

    public void delete(int ID) {
        xSql = "DELETE FROM Skills WHERE ID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, ID);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public List<Skill> getSkillByName(String nameSkill)  {
        List<Skill> listSkill = new ArrayList<>();
        xSql = "select * from Skills where Name like '%" + nameSkill + "%'";
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
        for(Skill s:dao.getListSkill()){
            System.out.println(s);
        }
    }

   
        
}
