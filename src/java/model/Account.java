/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Account {
    int ID;
    String email;
    String Username;
    String Password;
    Byte isMentee;
    Byte isMentor;
    Byte isAdmin;

    public Account() {
    }

    public Account(int ID, String email, String Username, String Password, Byte isMentee, Byte isMentor, Byte isAdmin) {
        this.ID = ID;
        this.email = email;
        this.Username = Username;
        this.Password = Password;
        this.isMentee = isMentee;
        this.isMentor = isMentor;
        this.isAdmin = isAdmin;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = Password;
    }

    public Byte getIsMentee() {
        return isMentee;
    }

    public void setIsMentee(Byte isMentee) {
        this.isMentee = isMentee;
    }

    public Byte getIsMentor() {
        return isMentor;
    }

    public void setIsMentor(Byte isMentor) {
        this.isMentor = isMentor;
    }

    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "ID=" + ID + ", email=" + email + ", Username=" + Username + ", Password=" + Password + ", isMentee=" + isMentee + ", isMentor=" + isMentor + ", isAdmin=" + isAdmin + '}';
    }
    
}
