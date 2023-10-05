/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class MentorSkill {
    int IDMentor;
    List<Integer> listSkillID;

    public MentorSkill() {
    }

    public MentorSkill(int IDMentor, List<Integer> listSkillID) {
        this.IDMentor = IDMentor;
        this.listSkillID = listSkillID;
    }

    public int getIDMentor() {
        return IDMentor;
    }

    public void setIDMentor(int IDMentor) {
        this.IDMentor = IDMentor;
    }

    public List<Integer> getListSkillID() {
        return listSkillID;
    }

    public void setListSkillID(List<Integer> listSkillID) {
        this.listSkillID = listSkillID;
    }

    @Override
    public String toString() {
        return "MentorSkill{" + "IDMentor=" + IDMentor + ", listSkillID=" + listSkillID + '}';
    }
    
}
