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
public class MenteeDAO extends MyDAO {
    public int TotalMentee(){
           
        xSql = "select count(*)as Count from Mentee";
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
    public void delete(int ID){
         xSql = "delete from Mentee where id = " + ID;
         try{
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
         }catch(Exception e){
             e.printStackTrace();
         }
     }
    public static void main(String[] args) {
        MenteeDAO dao =  new MenteeDAO();
        System.out.println(dao.TotalMentee());
    }
}
