/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ProfileDAO extends MyDAO{
     public List<Profile> getAllProfile() throws SQLException {
        List<Profile> list = new ArrayList<>();
        String sql = "Select *from dbo.Profile";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Profile c = new Profile();
            c.setId(rs.getInt("ID"));
            c.setGender(rs.getBoolean("Gender"));
            c.setAvatar(rs.getString("Avatar"));
            c.setPhone(rs.getString("Phone"));
            c.setBirth(rs.getDate("Birth"));
            c.setFullname(rs.getString("Fullname"));
            c.setAddress(rs.getString("Address"));
            
            list.add(c);
        }
        return list;
    }
     public Profile getProfileByID(int ID){
         Profile p = new Profile();
         xSql = "select * from Profile where id = ?" ;
         try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
            p.setId(rs.getInt("ID"));
            p.setGender(rs.getBoolean("Gender"));
            p.setAvatar(rs.getString("Avatar"));
            p.setPhone(rs.getString("Phone"));
            p.setBirth(rs.getDate("Birth"));
            p.setFullname(rs.getString("Fullname"));
            p.setAddress(rs.getString("Address"));
            p.setFacebookLink(rs.getString("facebookLink"));
            p.setInstagramLink(rs.getString("InstagramLink"));
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         if(p.getId()>0) return p;
         else{
             p.setId(0);
             p.setGender(true);
             p.setAvatar("imagesAcc/acc0.jpg");
             p.setPhone("0123456789");
             p.setAddress("");
             p.setFullname("FirstName LastName");
             long millis=System.currentTimeMillis();
             java.sql.Date date=new java.sql.Date(millis); 
             p.setBirth(date);
             p.setFacebookLink("https://www.facebook.com/");
             p.setInstagramLink("https://www.instagram.com/");
             return p;
         }
     }
     public void InsertProfile(Profile p){
           xSql = "insert into Profile values (?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getFullname());
            ps.setString(3, p.getAddress());
            ps.setDate(4, p.getBirth());
            ps.setString(5, p.getPhone());
            if(p.isGender()==true){
            ps.setByte(6,Byte.parseByte("1") );}else ps.setByte(6,Byte.parseByte("0"));
            ps.setString(7, p.getAvatar());
            ps.setString(8, p.getFacebookLink());
            ps.setString(9, p.getInstagramLink());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     public void deleteProfile(int ID){
         xSql = "delete from Profile where id = " + ID;
         try{
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
         }catch(Exception e){
             e.printStackTrace();
         }
     }
     public boolean IsExistProfile(int ID){
         xSql = "select FullName from Profile where ID = "+ID;
         String name =null;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
            name = rs.getString("FullName");         
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         if(name!=null)return true; else return false;
    }
      public boolean IsExistPhone(String p){
         xSql = "select Phone from Profile where Phone = '"+p+"'";
         String name =null;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
            name = rs.getString("Phone");         
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         if(name!=null)return true; else return false;
    }
     public static void main(String[] args) throws SQLException  {
        ProfileDAO cdao =  new ProfileDAO();
         System.out.println(cdao.getProfileByID(2));
    }
}
