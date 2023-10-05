/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author admin
 */
public class CommentDAO {
    Connection conn ;        // keets noois sql
    PreparedStatement ps;  // nems cau lenh query
    ResultSet rs ;    // keet qua tra ve
    public List<Comment> getAllComment() throws SQLException{
        List<Comment> list = new ArrayList<>();
        String sql = "Select * from dbo.Comment";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            Comment c = new Comment();
            c.setTime(rs.getDate("time"));
            c.setComment(rs.getString("comment"));
             c.setIDMentor(rs.getInt("IDMentor"));
            c.setIDMentee(rs.getInt("IDMentee"));
            
            list.add(c);
        }
        return list;
    }
    public void insertComment(Comment c){
        
        String Query = "insert into comment(Comment,IDMentor,IdMentee) values(?,?,?)";
        try{
          ps = conn.prepareStatement(Query);
          ps.setString(1, c.getComment());
          ps.setInt(2, c.getIDMentor());
          ps.setInt(3,c.getIDMentee() );
          ps.executeUpdate();
          ps.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
   
    public static void main(String[] args) throws SQLException  {
        Comment cdao =  new Comment();
         
//         long millis=System.currentTimeMillis();
//             java.sql.Date date=new java.sql.Date(millis); 
//             Profile p  = new Profile(7, true, "imagesAcc/acc7.jpg", "0987654321",date, "FirstName", "NamĐinh", "https://www.facebook.com/", "khongco");
//             cdao.InsertProfile(p);
//             System.out.println(cdao.getProfileByID(7));
    }


    }

