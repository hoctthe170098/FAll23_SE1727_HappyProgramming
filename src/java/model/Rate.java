/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nhat Anh
 */
public class Rate {
    int IDMentor;
    int IDMentee;
    int Rate;

    public Rate() {
    }

    public Rate(int IDMentor, int IDMentee, int Rate) {
        this.IDMentor = IDMentor;
        this.IDMentee = IDMentee;
        this.Rate = Rate;
    }

    public int getIDMentor() {
        return IDMentor;
    }

    public void setIDMentor(int IDMentor) {
        this.IDMentor = IDMentor;
    }

    public int getIDMentee() {
        return IDMentee;
    }

    public void setIDMentee(int IDMentee) {
        this.IDMentee = IDMentee;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int Rate) {
        this.Rate = Rate;
    }

    @Override
    public String toString() {
        return "Rate{" + "IDMentor=" + IDMentor + ", IDMentee=" + IDMentee + ", Rate=" + Rate + '}';
    }
    
}
