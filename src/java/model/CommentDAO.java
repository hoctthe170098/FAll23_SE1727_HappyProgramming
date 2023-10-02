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

/**
 *
 * @author admin
 */
public class CommentDAO {
    
    public static void insertComment(Connection conn, Comment cmt) throws SQLException{
        PreparedStatement ptmt = null;
        String sql = "insert into comment(content,Username) values(?,?)";
        try{
            ptmt = conn.prepareStatement(sql);
            String Content = cmt.getContent();
            String Username = cmt.getUsername();
            
            ptmt.setString(1,Content);
            ptmt.setString(2,Username );
            ptmt.executeUpdate();
            
           ptmt.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //HIEN THI DU LIEU TU SQL
    public static List<Comment> DisplayComment(Connection conn) throws SQLException{
        List<Comment> list = new ArrayList<Comment>();
        String sql = "Select c.Comment,a.Username From Comment c\n"
                +" join Mentee m1 on m1.ID = c.IDMentee\n"
                +" join Mentor m2 on m2.ID = c.IDMentor\n"
                +" join Account a on c.ID = a.ID";
        try{
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()){
                Comment cmt = new Comment();
                String Content = rs.getString("Content");
                String Username = rs.getString("Username");
                
                cmt.setContent(Content);
                cmt.setUsername(Username);
                
                list.add(cmt);
            }
        }catch(SQLException e){
            e.printStackTrace();
    } 
    return list;
    }
}
