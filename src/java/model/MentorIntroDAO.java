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
public class MentorIntroDAO extends MyDAO {

    public List<MentorIntro> getTop3MentorIntro() {
        List<MentorIntro> listTop3Mentor = new ArrayList<>();
        xSql = "select top 3 Mentor.ID,Avatar,Fullname,Rate,Intro,FacebookLink,InstagramLink "
                + "from Mentor join Profile on Mentor.ID=Profile.ID "
                + "order by Rate desc ";
        try {

            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            MentorIntro m;
            int id;
            String avatar;
            String fullname;
            float rate;
            String intro;
            String facebook;
            String inta;
            while (rs.next()) {
                id = rs.getInt("ID");
                avatar = rs.getString("Avatar");
                fullname = rs.getString("Fullname");
                rate = rs.getFloat("Rate");
                intro = rs.getString("Intro");
                facebook = rs.getString("FacebookLink");
                inta = rs.getString("InstagramLink");
                m = new MentorIntro(id, avatar, fullname, rate, intro, facebook, inta);
                listTop3Mentor.add(m);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTop3Mentor;
    }

    public MentorIntro getMentorByID(int ID) {
        MentorIntro mentor = null;
        String xSql = "SELECT Mentor.ID, Avatar, Fullname, Rate, Intro, FacebookLink, InstagramLink "
                + "FROM Mentor JOIN Profile ON Mentor.ID = Profile.ID WHERE ID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Lấy thông tin từ cơ sở dữ liệu
                int id = rs.getInt("ID");
                String avatar = rs.getString("Avatar");
                String fullname = rs.getString("Fullname");
                float rate = rs.getFloat("Rate");
                String intro = rs.getString("Intro");
                String facebook = rs.getString("FacebookLink");
                String inta = rs.getString("InstagramLink");

                // Tạo đối tượng Mentor
                mentor = new MentorIntro(id, avatar, fullname, rate, intro, facebook, inta);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mentor;
    }

    public void delete(int ID) {
        String mentorDeleteSql = "DELETE FROM Mentor WHERE ID = ?";
        String skillMentorDeleteSql = "DELETE FROM SkillMentor WHERE IDMentor = ?";

        try {

            ps = con.prepareStatement(skillMentorDeleteSql);
            ps.setInt(1, ID);
            ps.executeUpdate();
            ps.close();

            ps = con.prepareStatement(mentorDeleteSql);
            ps.setInt(1, ID);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MentorIntro> getMentorByName(String mentorName) {
        List<MentorIntro> listMentorName = new ArrayList<>();
        xSql = "select  Mentor.ID,Avatar,Fullname,Rate,Intro,FacebookLink,InstagramLink "
                + "from Mentor join Profile on Mentor.ID=Profile.ID  where Fullname like '%" + mentorName + "%'";

        try {

            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            MentorIntro m;
            int id;
            String avatar;
            String fullname;
            float rate;
            String intro;
            String facebook;
            String inta;
            while (rs.next()) {
                id = rs.getInt("ID");
                avatar = rs.getString("Avatar");
                fullname = rs.getString("Fullname");
                rate = rs.getFloat("Rate");
                intro = rs.getString("Intro");
                facebook = rs.getString("FacebookLink");
                inta = rs.getString("InstagramLink");
                m = new MentorIntro(id, avatar, fullname, rate, intro, facebook, inta);
                listMentorName.add(m);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (listMentorName);
    }

    public List<MentorIntro> getAllMentorIntro() {
        List<MentorIntro> listAllMentor = new ArrayList<>();
        xSql = "select  Mentor.ID,Avatar,Fullname,Rate,Intro,FacebookLink,InstagramLink "
                + "from Mentor join Profile on Mentor.ID=Profile.ID ";

        try {

            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            MentorIntro m;
            int id;
            String avatar;
            String fullname;
            float rate;
            String intro;
            String facebook;
            String inta;
            while (rs.next()) {
                id = rs.getInt("ID");
                avatar = rs.getString("Avatar");
                fullname = rs.getString("Fullname");
                rate = rs.getFloat("Rate");
                intro = rs.getString("Intro");
                facebook = rs.getString("FacebookLink");
                inta = rs.getString("InstagramLink");
                m = new MentorIntro(id, avatar, fullname, rate, intro, facebook, inta);
                listAllMentor.add(m);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAllMentor;
    }

    public List<MentorIntro> getTop3MentorIntroByIDSkill(int ID) {
        List<MentorIntro> listTop3Mentor = new ArrayList<>();
        xSql = "select top 3 Mentor.ID,Avatar,Fullname,Rate,Intro,FacebookLink,InstagramLink "
                + "from Mentor join Profile on Mentor.ID=Profile.ID "
                + "join SkillMentor on Mentor.ID=SkillMentor.IDMentor and IDSkill=" + ID
                + " order by Rate desc ";
        try {

            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            MentorIntro m;
            int id;
            String avatar;
            String fullname;
            float rate;
            String intro;
            String facebook;
            String inta;
            while (rs.next()) {
                id = rs.getInt("ID");
                avatar = rs.getString("Avatar");
                fullname = rs.getString("Fullname");
                rate = rs.getFloat("Rate");
                intro = rs.getString("Intro");
                facebook = rs.getString("FacebookLink");
                inta = rs.getString("InstagramLink");
                m = new MentorIntro(id, avatar, fullname, rate, intro, facebook, inta);
                listTop3Mentor.add(m);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTop3Mentor;
    }

   public List<MentorIntro> getMentorBySkill(int skillID) {
    List<MentorIntro> listMentor = new ArrayList<>();
    String sql = "SELECT m.ID, Avatar, Fullname, Rate, Intro, FacebookLink, InstagramLink FROM Mentor m " +
                 "JOIN Profile p ON m.ID = p.ID " +
                 "JOIN SkillMentor sm ON m.ID = sm.IDMentor " +
                 "JOIN Skills s ON s.ID = sm.IDSkill " +
                 "WHERE s.ID = ?";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, skillID);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String avatar = rs.getString("Avatar");
                String fullname = rs.getString("Fullname");
                float rate = rs.getFloat("Rate");
                String intro = rs.getString("Intro");
                String facebook = rs.getString("FacebookLink");
                String inta = rs.getString("InstagramLink");
                
                MentorIntro mentor = new MentorIntro(id, avatar, fullname, rate, intro, facebook, inta);
                listMentor.add(mentor);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listMentor;
}

    public int TotalMentor() {

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

    public static void main(String[] args) {
        MentorIntroDAO dao = new MentorIntroDAO();
        List<MentorIntro> l = dao.getTop3MentorIntroByIDSkill(3);
        for (MentorIntro m : l) {
            System.out.println(m);
        }
    }
}
