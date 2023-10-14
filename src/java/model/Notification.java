/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Notification {
    int ID;
    String avatarSender;
    String nameSender;
    int roleSender;
    String content;
    int minute;

    public Notification() {
    }

    public Notification(int ID, String avatarSender, String nameSender, int roleSender, String content, int minute) {
        this.ID = ID;
        this.avatarSender = avatarSender;
        this.nameSender = nameSender;
        this.roleSender = roleSender;
        this.content = content;
        this.minute = minute;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAvatarSender() {
        return avatarSender;
    }

    public void setAvatarSender(String avatarSender) {
        this.avatarSender = avatarSender;
    }

    public String getNameSender() {
        return nameSender;
    }

    public void setNameSender(String nameSender) {
        this.nameSender = nameSender;
    }

    public int getRoleSender() {
        return roleSender;
    }

    public void setRoleSender(int roleSender) {
        this.roleSender = roleSender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Notification{" + "ID=" + ID + ", avatarSender=" + avatarSender + ", nameSender=" + nameSender + ", roleSender=" + roleSender + ", content=" + content + ", minute=" + minute + '}';
    }
    
}
