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
    public void InsertRequest(int IDMentor,int IDMentee,int IDSkill,String title,Date date,float from,float to,String Detail,String address,float money){
               xSql = "insert into Request values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentor);
            ps.setInt(2, IDMentee);
            ps.setInt(3, IDSkill);
            ps.setString(4, title);
            ps.setDate(5, date);
            ps.setFloat(6, from);
            ps.setFloat(7,to );
            ps.setString(8, Detail);
            ps.setString(9, "Processing");
            ps.setString(10, address);
            ps.setFloat(11, money);
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
         float from,to,money;
         String title,status,detail,address;
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
            address = rs.getString("Address");
            money = rs.getFloat("money");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status,address,money);
            return r;
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         return null;
    }
    
     public boolean CheckRequestClosed(int IDMentor,int IDMentee){
         xSql = "select * "
                 + "from Request "
                 + "where IDMentor = ? and IDMentee = ? and Status = 'Closed'";
         int ID,iDMentor,iDMentee,IDSkill;
         float from,to,money;
         String title,status,detail,address;
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
            address = rs.getString("Address");
            money = rs.getFloat("money");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status,address,money);
            if(r!=null)return true;
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         return false;
    }
      public boolean IsExistRequestAccepted(int IDMentee){
         xSql = "select * "
                 + "from Request "
                 + "where IDMentee = ? and Status = 'Accepted'";
         int ID,iDMentor,iDMentee,IDSkill;
         float from,to,money;
         String title,status,detail,address;
         Date date;
         Request r ;
         try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentee);
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
            address = rs.getString("Address");
            money = rs.getFloat("money");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status,address,money);
            if(r!=null)return true;
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         return false;
    }
     public Request getRequestByID(int id){
         xSql = "select * "
                 + "from Request "
                 + "where ID = "+id;
         int ID,iDMentor,iDMentee,IDSkill;
         float from,to,money;
         String title,status,detail,address;
         Date date;
         Request r ;
         try{
            ps = con.prepareStatement(xSql);
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
            address = rs.getString("Address");
            money = rs.getFloat("money");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status,address,money);
            return r;
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         return null;
    }
     public void deleteRequestByIDMentee(int IDMentee){
         xSql = "DELETE FROM Request WHERE IDMentee=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentee);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
      public void delete(int ID) {
        xSql = "DELETE FROM Request WHERE ID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, ID);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean IsDuplicateRequestMentee(int IDMentee,float hFrom,float hTo,Date Date){
        List<Request> listRequest = new ArrayList<>();
            xSql = "select * "
                 + "from Request "
                 + "where IDMentee = ? and (? < [To] and ? > [From]) and Date = ? and Status = 'Accepted'";
         int ID,iDMentor,iDMentee,IDSkill;
         float from,to,money;
         String title,status,detail,address;
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
            address = rs.getString("Address");
            money = rs.getFloat("money");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status,address,money);
            listRequest.add(r);
        }
            rs.close();
            ps.close();
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
         float from,to,money;
         String title,status,detail,address;
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
            address = rs.getString("Address");
            money = rs.getFloat("money");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status,address,money);
            listRequest.add(r);
        }
         }catch(Exception e){
             e.printStackTrace();
         }
        if(listRequest.size()>0)return true;
        else return false;
    }
    public void updateRequestByDate(){
         xSql = "exec updateRequest" ;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    public void deleteRequest(int id){
         xSql = "delete from Request where id = "+id ;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    public void updateRequest(Request r){
                    xSql = "Update Request "
                            + "set IDMentor = ? ,IDMentee = ?, IDSkill = ?, [From] = ?, [To] = ?, Status = ?,"
                            + "Title = ?, Details = ?, Date = ?, Address = ?, Money = ? "
                            + "where ID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, r.getIDMentor());
            ps.setInt(2, r.getIDMentee());
            ps.setInt(3, r.getIDSkill());
            ps.setString(7, r.getTitle());
            ps.setDate(9, r.getDate());
            ps.setFloat(4, r.getFrom());
            ps.setFloat(5,r.getTo());
            ps.setString(8, r.getDetails());
            ps.setString(6, r.getStatus());
            ps.setString(10, r.getAddress());
            ps.setFloat(11, r.getMoney());
            ps.setInt(12, r.getID());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getTotalRequestByID(int IDMentee){
         int x;
        xSql = "select count=count(*)from Request where IDMentee= " + IDMentee;
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
    public int getTotalRequestmentorByStatus(int IDMentor,String status){
         int x;
        xSql = "select count=count(*)from Request where IDMentor= " + IDMentor+" and status = '"+status+"'";
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
    public List<Request> getRequestPagging(int index,int IDMentee){
         int i = (index - 1) * 4;
        List<Request> listRequest = new ArrayList<>();
        xSql = "select * from Request where IDMentee= " + IDMentee
                + "order by Date desc "
                + "offset ? rows fetch next 4 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
              int ID,iDMentor,iDMentee,IDSkill;
         float from,to,money;
         String title,status,detail,address;
         Date date;
         Request r ;
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
            address = rs.getString("Address");
            money = rs.getFloat("money");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status,address,money);
            listRequest.add(r);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRequest;
    }
        public List<Request>getRequestMentorByStatus(int index,int idMentor,String sta){
            int i = (index - 1) * 4;
        List<Request> list = new ArrayList<>();
        xSql = "select * "
                 + "from Request "
                 + "where IDMentor = ? and Status = ?"
                 +" order by Date desc"
                 +" offset ? rows fetch next 4 rows only";
         int ID,iDMentor,iDMentee,IDSkill;
         float from,to,money;
         String title,status,detail,address;
         Date date;
         Request r ;
         try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, idMentor);
            ps.setString(2, sta);
            ps.setInt(3, i);
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
            address = rs.getString("Address");
            money = rs.getFloat("money");
            r = new Request(ID, iDMentor, iDMentee, IDSkill, title, date, from, to, detail, status,address,money);
            list.add(r);
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         return list;
    }
    public static void main(String[] args) {
        RequestDAO dao = new RequestDAO();
//        long millis=System.currentTimeMillis();   
//            java.sql.Date now=new java.sql.Date(millis);
//            System.out.println(now);
//           System.out.println(dao.getRequestByID(42).getDate());
//      for(Request r:dao.getRequestPagging(2, 3)){
//          System.out.println(r);
//      }
        for(Request r:dao.getRequestPagging(1, 10)){
            System.out.println(r);
        }
    }
}
