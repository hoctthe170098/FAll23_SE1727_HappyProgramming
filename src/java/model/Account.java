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
    String username;
    String password;
    Byte isMentee;
    Byte isMentor;
    Byte isAdmin;

    public Account() {
    }

    public Account(int ID, String email, String username, String password, Byte isMentee, Byte isMentor, Byte isAdmin) {
        this.ID = ID;
        this.email = email;
        this.username = username;
        this.password = password;
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
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Account{" + "ID=" + ID + ", email=" + email + ", username=" + username + ", password=" + password + ", isMentee=" + isMentee + ", isMentor=" + isMentor + ", isAdmin=" + isAdmin + '}';
    }
    
}
