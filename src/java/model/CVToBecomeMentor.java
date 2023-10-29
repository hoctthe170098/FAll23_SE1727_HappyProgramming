/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nhat Anh
 */
public class CVToBecomeMentor {
    int ID;
    String Intro;
    String Ex;
    String skill;
    String Reason;
    Profile p;
    
    public CVToBecomeMentor() {
    }

    public CVToBecomeMentor(int ID, String Intro, String Ex, String skill, String Reason, Profile p) {
        this.ID = ID;
        this.Intro = Intro;
        this.Ex = Ex;
        this.skill = skill;
        this.Reason = Reason;
        this.p = p;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String Intro) {
        this.Intro = Intro;
    }

    public String getEx() {
        return Ex;
    }

    public void setEx(String Ex) {
        this.Ex = Ex;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public Profile getP() {
        return p;
    }

    public void setP(Profile p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "CVToBecomeMentor{" + "ID=" + ID + ", Intro=" + Intro + ", Ex=" + Ex + ", skill=" + skill + ", Reason=" + Reason + ", p=" + p + '}';
    }

    
    
}
