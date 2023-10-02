/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class MentorProfile {
    private String avatar;
    private String fullname;
    private String Ex;
    private String Intro;

    public MentorProfile() {
    }

    public MentorProfile(String avatar, String fullname, String Ex,String Intro) {
        this.avatar = avatar;
        this.fullname = fullname;
        this.Ex = Ex;
        this.Intro = Intro;
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

    public String getEx() {
        return Ex;
    }

    public void setEx(String Ex) {
        this.Ex = Ex;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String Intro) {
        this.Intro = Intro;
    }

    
    
}
