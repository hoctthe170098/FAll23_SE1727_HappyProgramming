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
            int idMentee,idMentor;
            Date time;
            String Comment;
            Comment c;
            while (rs.next()) {
                idMentee = rs.getInt("IDMentee");
                idMentor = rs.getInt("IDMentor");
                time = rs.getDate("Time");
                Comment = rs.getString("comment");
                c = new Comment(time, Comment, idMentor, idMentee);
                list.add(c);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        CommentDAO dao = new CommentDAO();
        for(Comment c : dao.getCommentBy2ID(3, 4)){
            System.out.println(c);
        }
    }
    }

