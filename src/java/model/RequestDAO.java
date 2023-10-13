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
public class RequestDAO extends MyDAO {
    public void InsertRequest(int IDMentor,int IDMentee,int IDSkill,String title,Date date,float from,float to,String Detail){
               xSql = "insert into Request values (?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentor);
            ps.setInt(2, IDMentee);
            ps.setInt(3, IDSkill);
            ps.setString(7, title);
            ps.setDate(9, date);
            ps.setFloat(4, from);
            ps.setFloat(5,to );
            ps.setString(8, Detail);
            ps.setString(6, "Processing");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Request getRequestProcessing(int IDMentor,int IDMentee){
         xSql = "select * "
                 + "from Request "
                 + "where IDMentor = ? and IDMentee = ? and Status in ('Processing','Accepted')";
         int ID,iDMentor,iDMentee,IDSkill;
         float from,to;
         String title,status,detail;
         Date date;
         Request r ;
         try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentor);
            ps.setInt(2, IDMentee);
            rs = ps.executeQuery();
            while (rs.next()) {
            ID = rs.getInt("ID");
            iDMentor = rs.getInt("IDMentor");
            iDMentee = rs.getInt("IDMentee");
            IDSkill = rs.getInt("IDSkill");
            from  = rs.getFloat("From");
            to = rs.getFloat("to");
            status = rs.getString("status"); 
            title = rs.getString("Title");
            detail = rs.getString("Details");
            date = rs.getDate("Date");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status);
            return r;
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         return null;
    }
    public boolean IsDuplicateRequestMentee(int IDMentee,float hFrom,float hTo,Date Date){
        List<Request> listRequest = new ArrayList<>();
            xSql = "select * "
                 + "from Request "
                 + "where IDMentee = ? and (? < [To] and ? > [From]) and Date = ? and Status = 'Accepted'";
         int ID,iDMentor,iDMentee,IDSkill;
         float from,to;
         String title,status,detail;
         Date date;
         Request r ;
         try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentee);
            ps.setFloat(2, hFrom);
            ps.setFloat(3, hTo);
            ps.setDate(4, Date);
            rs = ps.executeQuery();
            while (rs.next()) {
            ID = rs.getInt("ID");
            iDMentor = rs.getInt("IDMentor");
            iDMentee = rs.getInt("IDMentee");
            IDSkill = rs.getInt("IDSkill");
            from  = rs.getFloat("From");
            to = rs.getFloat("to");
            status = rs.getString("status"); 
            title = rs.getString("Title");
            detail = rs.getString("Details");
            date = rs.getDate("Date");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status);
            listRequest.add(r);
        }
         }catch(Exception e){
             e.printStackTrace();
         }
        if(listRequest.size()>0)return true;
        else return false;
    }
     public boolean IsDuplicateRequestMentor(int IDMentor,float hFrom,float hTo,Date Date){
        List<Request> listRequest = new ArrayList<>();
            xSql = "select * "
                 + "from Request "
                 + "where IDMentor = ? and (? < [To] and ? > [From]) and Date = ? and Status = 'Accepted'";
         int ID,iDMentor,iDMentee,IDSkill;
         float from,to;
         String title,status,detail;
         Date date;
         Request r ;
         try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentor);
            ps.setFloat(2, hFrom);
            ps.setFloat(3, hTo);
            ps.setDate(4, Date);
            rs = ps.executeQuery();
            while (rs.next()) {
            ID = rs.getInt("ID");
            iDMentor = rs.getInt("IDMentor");
            iDMentee = rs.getInt("IDMentee");
            IDSkill = rs.getInt("IDSkill");
            from  = rs.getFloat("From");
            to = rs.getFloat("to");
            status = rs.getString("status"); 
            title = rs.getString("Title");
            detail = rs.getString("Details");
            date = rs.getDate("Date");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status);
            listRequest.add(r);
        }
         }catch(Exception e){
             e.printStackTrace();
         }
        if(listRequest.size()>0)return true;
        else return false;
    }
    public static void main(String[] args) {
        RequestDAO dao = new RequestDAO();
        
    }
}
