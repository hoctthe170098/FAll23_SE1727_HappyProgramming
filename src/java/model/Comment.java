/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Comment {
    int ID;
     Date time;
     String Comment;
     int IDMentor;
     int IDMentee;
     
     

    public Comment() {
    }

    public Comment(int ID, Date time, String Comment, int IDMentor, int IDMentee) {
        this.ID = ID;
        this.time = time;
        this.Comment = Comment;
        this.IDMentor = IDMentor;
        this.IDMentee = IDMentee;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
   
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public int getIDMentor() {
        return IDMentor;
    }

    public void setIDMentor(int IDMentor) {
        this.IDMentor = IDMentor;
    }

    public int getIDMentee() {
        return IDMentee;
    }

    public void setIDMentee(int IDMentee) {
        this.IDMentee = IDMentee;
    }  

    @Override
    public String toString() {
        return "Comment{" + "ID=" + ID + ", time=" + time + ", Comment=" + Comment + ", IDMentor=" + IDMentor + ", IDMentee=" + IDMentee + '}';
    }
    
}
