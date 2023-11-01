/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class MenteeProfile {
    int ID;
    String avatar;
    String fullname;
    String address;
    Date Birth;
    String Phone;
    String facebook;
    String inta;

    public MenteeProfile() {
    }

    

    public MenteeProfile(int ID, String avatar, String fullname, String address, Date birth, String phone, String facebook, String inta) {
        this.ID = ID;
        this.avatar = avatar;
        this.fullname = fullname;
        this.address = address;
        this.Birth = birth;
        this.Phone = phone;
        this.facebook = facebook;
        this.inta = inta;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return Birth;
    }

    public void setBirth(Date Birth) {
        this.Birth = Birth;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInta() {
        return inta;
    }

    public void setInta(String inta) {
        this.inta = inta;
    }

    @Override
    public String toString() {
        return "MenteeProfile{" + "ID=" + ID + ", avatar=" + avatar + ", fullname=" + fullname + ", address=" + address + ", Birth=" + Birth + ", Phone=" + Phone + ", facebook=" + facebook + ", inta=" + inta + '}';
    }
    
}

   
