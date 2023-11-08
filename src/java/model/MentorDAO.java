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
 * @author Admin
 */
public class MentorDAO extends MyDAO {

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

    public List<Mentor> getAllMentor() throws SQLException {
        List<Mentor> list = new ArrayList<>();
        String sql = "Select *from dbo.Mentor";
        ps = con.prepareStatement(sql);

        rs = ps.executeQuery();
        while (rs.next()) {
            Mentor r = new Mentor();
            r.setID(rs.getInt("ID"));
            r.setIntro(rs.getString("Intro"));

            r.setExperience(rs.getString("Ex"));

            list.add(r);

        }
        return list;
    }
    public String checkExistMentor(int ID){
         xSql = "select Intro from Mentor where id = " + ID;
         
         try{         
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
            String intro = rs.getString("intro");
            return intro;
        }
            rs.close();
            ps.close();
         }catch(Exception e){
             e.printStackTrace();
         }
        // return true;
        return null;
    }
    public Mentor getMentorByID(int ID){
      Mentor m = new Mentor();
         xSql = "select * from Mentor where id = " + ID;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
            m.setID(rs.getInt("ID"));  
            m.setIntro(rs.getString("Intro"));
            m.setExperience(rs.getString("Ex"));        
            m.setRate(rs.getFloat("Rate"));    
        }
            rs.close();
            ps.close();
         }catch(Exception e){
             e.printStackTrace();
         }
         if(m.getExperience()==null) m.setExperience("Input Experience here");
         if(m.getIntro()==null)m.setIntro("Input Introduction here");
         return m;
    }
     public void updateMentor(int ID,String intro,String ex) {       
        xSql = "update Mentor set Intro=N'"+intro+"', "+"Ex=N'"+ex+"' where ID = "+ID;
                
        try {
            ps = con.prepareStatement(xSql);
           
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void insertMentor(int ID,String intro,String ex){
         
           xSql = "insert into Mentor(ID,Intro,Ex) values (?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, ID);
            ps.setString(2, intro);
            ps.setString(3, ex);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    public List<Mentor> SearchMentorByName(String Fullname) throws SQLException {
        List<Mentor> list = new ArrayList<>();
        String sql = "Select c.Avatar, c.Fullname, m.ID, m.Ex from Mentor m join Profile c\n"
                + "on m.ID = c.ID\n"
                + "\n"
                + "where  c.Fullname like ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, "%" + Fullname + "%");

        rs = ps.executeQuery();
        while (rs.next()) {
            Mentor r = new Mentor();
            Profile c = new Profile();
            c.setAvatar(rs.getString("Avatar"));
            c.setFullname(rs.getString("Fullname"));
            r.setID(rs.getInt("ID"));
            r.setExperience(rs.getString("Ex"));

            list.add(r);

        }
        return list;

    }

    public static void main(String[] args) throws SQLException {
        MentorDAO dao = new MentorDAO();
        System.out.println(dao.checkExistMentor(3));
    }
}
