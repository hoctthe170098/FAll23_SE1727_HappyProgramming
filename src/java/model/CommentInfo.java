/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class CommentInfo {
    int IDMentee;
    String FullName;
    String Avatar;
    String Comment;
    int minute;

    public CommentInfo() {
    }

    public CommentInfo(int IDMentee, String FullName, String Avatar, String Comment, int minute) {
        this.IDMentee = IDMentee;
        this.FullName = FullName;
        this.Avatar = Avatar;
        this.Comment = Comment;
        this.minute = minute;
    }

    public int getIDMentee() {
        return IDMentee;
    }

    public void setIDMentee(int IDMentee) {
        this.IDMentee = IDMentee;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "CommentInfo{" + "IDMentee=" + IDMentee + ", FullName=" + FullName + ", Avatar=" + Avatar + ", Comment=" + Comment + ", minute=" + minute + '}';
    }
    
}
