/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class MentorIntro {
    int ID;
    String avatar;
    String fullname;
    float rate;
    String intro;
    String facebook;
    String inta;

    public MentorIntro() {
    }

    public MentorIntro(int ID, String avatar, String fullname, float rate, String intro, String facebook, String inta) {
        this.ID = ID;
        this.avatar = avatar;
        this.fullname = fullname;
        this.rate = rate;
        this.intro = intro;
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

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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
        return "MentorIntro{" + "ID=" + ID + ", avatar=" + avatar + ", fullname=" + fullname + ", rate=" + rate + ", intro=" + intro + ", facebook=" + facebook + ", inta=" + inta + '}';
    }

}
