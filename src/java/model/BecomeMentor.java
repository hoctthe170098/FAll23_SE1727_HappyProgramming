/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class BecomeMentor {
    int ID;
    String intro;
    String ex;
    String[]skill;
    String Reason;
    public BecomeMentor() {
    }

    public BecomeMentor(int ID, String intro, String ex, String[] skill, String Reason) {
        this.ID = ID;
        this.intro = intro;
        this.ex = ex;
        this.skill = skill;
        this.Reason = Reason;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String[] getSkill() {
        return skill;
    }

    public void setSkill(String[] skill) {
        this.skill = skill;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    @Override
    public String toString() {
        return "BecomeMentor{" + "ID=" + ID + ", intro=" + intro + ", ex=" + ex + ", skill=" + skill + ", Reason=" + Reason + '}';
    }

    
    
}
