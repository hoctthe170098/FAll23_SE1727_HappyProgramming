/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ListBecomeMentorDAO extends MyDAO {

    public List<CVToBecomeMentor> getListBecomeMentor(int index) {
        int i = (index - 1) * 4;
        List<CVToBecomeMentor> list = new ArrayList<>();
        xSql = "select * "
                + "from BecomeMentor order by ID "
                + "offset ? rows fetch next 4 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            int ID;
            String intro, ex, skill,reason;
            CVToBecomeMentor cv;
            while (rs.next()) {
                ID = rs.getInt("ID");
                intro = rs.getString("intro");
                ex = rs.getString("ex");
                skill = rs.getString("skill");
                reason = rs.getString("reason");
                ProfileDAO pDAO = new ProfileDAO();
                Profile p = pDAO.getProfileByID(ID);
                cv = new CVToBecomeMentor(ID, intro, ex, skill,reason, p);
                list.add(cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public CVToBecomeMentor getCVBecomeMentorByID(int IDMentee) {
        xSql = "select * "
                + "from BecomeMentor where ID = " + IDMentee;
        int ID;
        String intro, ex, skill,reason;
        CVToBecomeMentor cv;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt("ID");
                intro = rs.getString("intro");
                ex = rs.getString("ex");
                skill = rs.getString("skill");
                reason = rs.getString("reason");
                ProfileDAO pDAO = new ProfileDAO();
                Profile p = pDAO.getProfileByID(ID);
                cv = new CVToBecomeMentor(ID, intro, ex, skill,reason, p);
                return cv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getTotal() {
        int x;
        xSql = "select count=count(*)from BecomeMentor";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            while (rs.next()) {
                x = rs.getInt("count");
                return x;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
   public void delete(int ID){
         xSql = "delete from BecomeMentor where id = " + ID;
         try{
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
         }catch(Exception e){
             e.printStackTrace();
         }
     }
    public static void main(String[] args) {
        ListBecomeMentorDAO dao = new ListBecomeMentorDAO();
        System.out.println(dao.getCVBecomeMentorByID(3));
    }
}
