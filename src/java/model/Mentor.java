/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Mentor {
   int ID;
   float rate;
   String experience;

    public Mentor() {
    }

    public Mentor(int ID, float rate, String experience) {
        this.ID = ID;
        this.rate = rate;
        this.experience = experience;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Mentor{" + "ID=" + ID + ", rate=" + rate + ", experience=" + experience + '}';
    }
   
    
   
}
