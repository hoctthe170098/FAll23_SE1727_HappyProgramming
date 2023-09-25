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
public class Profile {
    int id;
    boolean gender;
    String Avatar;
    String Phone;
    Date Birth;
    String Fullname;
    String Address;
    String FacebookLink;
    String InstagramLink;
    public Profile() {
    }

    public Profile(int id, boolean gender, String Avatar, String Phone, Date Birth, String Fullname, String Address, String FacebookLink, String InstagramLink) {
        this.id = id;
        this.gender = gender;
        this.Avatar = Avatar;
        this.Phone = Phone;
        this.Birth = Birth;
        this.Fullname = Fullname;
        this.Address = Address;
        this.FacebookLink = FacebookLink;
        this.InstagramLink = InstagramLink;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Date getBirth() {
        return Birth;
    }

    public void setBirth(Date Birth) {
        this.Birth = Birth;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getFacebookLink() {
        return FacebookLink;
    }

    public void setFacebookLink(String FacebookLink) {
        this.FacebookLink = FacebookLink;
    }

    public String getInstagramLink() {
        return InstagramLink;
    }

    public void setInstagramLink(String InstagramLink) {
        this.InstagramLink = InstagramLink;
    }

    @Override
    public String toString() {
        return "Profile{" + "id=" + id + ", gender=" + gender + ", Avatar=" + Avatar + ", Phone=" + Phone + ", Birth=" + Birth + ", Fullname=" + Fullname + ", Address=" + Address + ", FacebookLink=" + FacebookLink + ", InstagramLink=" + InstagramLink + '}';
    }

    
      
     
    
    
    
}
