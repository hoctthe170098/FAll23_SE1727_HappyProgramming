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
public class MentorSkillDAO extends MyDAO{
    public MentorSkill getSkillByName(int ID){
          MentorSkill ms = new MentorSkill();
          List<Integer> listIDSkill = new ArrayList<>();
          ms.setIDMentor(ID);
        xSql = "select IDMentor,IDSkill from SkillMentor join Skills on SkillMentor.IDSkill=Skills.ID "
                + "where IDMentor = "+ID;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
               listIDSkill.add(rs.getInt("IDSkill"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ms.setListSkillID(listIDSkill);
        return ms;
      }
      public void deleteMentorSkill(int ID){
         xSql = "delete from SkillMentor where IDMentor = " + ID;
         try{
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
         }catch(Exception e){
             e.printStackTrace();
         }
     }
      public void insertMentorSkill(int IDMentor,int IDSkill){
                xSql = "insert into SkillMentor values (?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDSkill);
            ps.setInt(2, IDMentor);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
      public boolean isExistSkill(int ID,List<Integer>listIDSkill){
          for(int i:listIDSkill){
              if (ID==i)return true;
          }
          return false;
      }
    public static void main(String[] args) {
        MentorSkillDAO dao = new MentorSkillDAO();
        dao.insertMentorSkill(4, 2);
       // dao.insertMentorSkill(2, 4);
    }
}
