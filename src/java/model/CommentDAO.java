/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
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
public class CommentDAO extends MyDAO{
    public List<Comment> getCommentBy2ID(int IDMentee,int IDMentor){
         List<Comment> list = new ArrayList<>();
        xSql = "select * from Comment where IDMentor = "+IDMentor + " and IDMentee = "+IDMentee;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id,idMentee,idMentor;
            Date time;
            String Comment;
            Comment c;
            while (rs.next()) {
                id = rs.getInt("ID");
                idMentee = rs.getInt("IDMentee");
                idMentor = rs.getInt("IDMentor");
                time = rs.getDate("Time");
                Comment = rs.getString("comment");
                c = new Comment(id,time, Comment, idMentor, idMentee);
                list.add(c);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void insertComment(int IDMentor,int IDMentee,String comment){
              xSql = "insert into Comment values (getdate(),?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentor);
            ps.setInt(2, IDMentee);
            ps.setString(3, comment);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteComment(int ID){
             xSql = "delete from Comment where ID = "+ID;
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public static void main(String[] args) {
        CommentDAO dao = new CommentDAO();
        for(Comment c : dao.getCommentBy2ID(3, 2)){
            System.out.println(c);
        }
        System.out.println(dao.getCommentBy2ID(3, 2).size()>0);
    }
    }

