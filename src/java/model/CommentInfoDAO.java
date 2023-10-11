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
public class CommentInfoDAO extends MyDAO {
       public List<CommentInfo> getAllCommentInfo(int idmentor) {
        List<CommentInfo> list = new ArrayList<>();
        xSql = "select Comment.IDMentee,FullName,Avatar,Comment,Minute = DATEDIFF(minute,Comment.Time,GETDATE())  "
                + "from Comment join Profile on Comment.IDMentee=Profile.ID "
                + "and Comment.IDMentor = " + idmentor
                + " order by Minute ";
 
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int IDMentee;
            String fullName,avatar,Comment;
            int minute;
            CommentInfo x;
            while (rs.next()) {
                IDMentee = rs.getInt("IDMentee");
                fullName = rs.getString("FullName");
                avatar = rs.getString("avatar");
                Comment = rs.getString("Comment");
                minute = rs.getInt("Minute");
                x = new CommentInfo(IDMentee, fullName, avatar, Comment, minute);
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
        public int TotalCommentInfo( int idmentor) {
       
        xSql = "select total = Count(*)  "
                + "from Comment "
                + "where IDMentor = " + idmentor;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int total;
           
            while (rs.next()) {
                total = rs.getInt("total");
              return total;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
       public static void main(String[] args) {
        CommentInfoDAO dao = new CommentInfoDAO();
        for(CommentInfo c:dao.getAllCommentInfo(4)){
            System.out.println(c);
        }
    }
}
