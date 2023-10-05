/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class BecomeMentorDao extends MyDAO{
    public void deleteBecomeMentor(int ID){
         xSql = "delete from BecomeMentor where id = " + ID;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
         }catch(Exception e){
             e.printStackTrace();
         }
     } 
       public void InsertBecomeMentor(BecomeMentor bm){
           xSql = "insert into BecomeMentor values (?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, bm.getID());
            ps.setString(2, bm.getIntro());
            ps.setString(3, bm.getEx());
            String skill=bm.getSkill()[0];
            for(int i=1;i<bm.getSkill().length;i++){
                skill+=", "+bm.getSkill()[i];
            }
            ps.setString(4, skill);          
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
       public BecomeMentor getBecomeMentorByID(int ID){
         BecomeMentor bm = new BecomeMentor();
         xSql = "select * from BecomeMentor where id = " + ID;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
            bm.setID(rs.getInt("ID"));
            bm.setEx(rs.getString("Ex"));
            bm.setIntro(rs.getString("Intro"));
            String skill = rs.getString("Skill");
            String[]skills = skill.split(",");
            bm.setSkill(skills);
        }
         }catch(Exception e){
             e.printStackTrace();
         }
        return bm;
     }
        public boolean IsExistBecomeMentor(int ID){
         xSql = "select Intro from BecomeMentor where ID = "+ID;
         String intro =null;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
            intro = rs.getString("Intro");         
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         if(intro!=null)return true; else return false;
    }
       public static void main(String[] args) {
        BecomeMentorDao dao = new BecomeMentorDao();
           System.out.println(dao.getBecomeMentorByID(3));
    }
}
