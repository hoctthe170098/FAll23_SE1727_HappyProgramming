/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NoficationDAO extends MyDAO {
    public void insertNoficationDAO(int IDsender,int IDreceiver,String content,int RoleSender){
                xSql = "insert into Notification values (?,?,?,?,getdate())";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDsender);
            ps.setInt(2, IDreceiver);
            ps.setString(3, content);
            ps.setInt(4, RoleSender);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Notification> getListNoficationByID(int id,int count){
        List<Notification> listN = new ArrayList<>();
             xSql = "select top " + count
                     + " Notification.ID,Avatar,FullName,RoleSender,content,"
                     + "Minute = DATEDIFF(minute,Notification.Time,GETDATE()) "
                 + "from Notification join Profile "
                 + "on Notification.IDsender = Profile.ID and IDreceiver = "+id
                     + " order by Minute";        
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int ID,roleSender,minute;
             String avatar,name,content;
             Notification n ;
            while (rs.next()) {
            ID = rs.getInt("ID");
            avatar = rs.getString("Avatar"); 
            name = rs.getString("FullName");
            content = rs.getString("Content");
            roleSender = rs.getInt("RoleSender");
            minute = rs.getInt("Minute");
            n = new Notification(ID, avatar, name, roleSender, content, minute);
            listN.add(n);
        }
            rs.close();
            ps.close();
         }catch(Exception e){
             e.printStackTrace();
         }
         return listN;
    }
    public static void main(String[] args) {
        NoficationDAO dao  = new NoficationDAO();
        List<Notification> list = dao.getListNoficationByID(12, 5);
        for(Notification n : list){
            System.out.println(n);
        }
    }
}
