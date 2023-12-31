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

    public List<Skill> getSkillByName(String nameSkill) {
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

    public void updateSkillByID(int ID, String name, String description, String image) {
        String sql = "UPDATE Skills SET Name = ?, Description = ?, Image = ? WHERE ID = ?";

        try ( PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, image);
            preparedStatement.setInt(4, ID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Skill> getListTop3Skill() {
        List<Integer>listID = new ArrayList<>();;
        List<Skill> listSkill = new ArrayList<>();
        xSql = "select top 3 Skills.ID"
                + " From Skills join Request on Skills.ID=Request.IDSkill"
                + " group by Request.IDSkill,Skills.ID"
                + " order by count(Request.ID) desc";
        try {
            int id = 0;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                listID.add(id);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i:listID){
            Skill x = getSkillByID(i);
            listSkill.add(x);
        }
        return listSkill;
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

}
