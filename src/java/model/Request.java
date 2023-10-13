/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Request {
  int ID;
  int IDMentor;
  int IDMentee;
  int IDSkill;
  String title;
  Date date;
  float from;
  float to;
  String details;
  String status;
  String address;
  float money;
    public Request() {
    }

    public Request(int ID, int IDMentor, int IDMentee, int IDSkill, String title, Date date, float from, float to, String details, String status, String address, float money) {
        this.ID = ID;
        this.IDMentor = IDMentor;
        this.IDMentee = IDMentee;
        this.IDSkill = IDSkill;
        this.title = title;
        this.date = date;
        this.from = from;
        this.to = to;
        this.details = details;
        this.status = status;
        this.address = address;
        this.money = money;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getIDSkill() {
        return IDSkill;
    }

    public void setIDSkill(int IDSkill) {
        this.IDSkill = IDSkill;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getFrom() {
        return from;
    }

    public void setFrom(float from) {
        this.from = from;
    }

    public float getTo() {
        return to;
    }

    public void setTo(float to) {
        this.to = to;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Request{" + "ID=" + ID + ", IDMentor=" + IDMentor + ", IDMentee=" + IDMentee + ", IDSkill=" + IDSkill + ", title=" + title + ", date=" + date + ", from=" + from + ", to=" + to + ", details=" + details + ", status=" + status + ", address=" + address + ", money=" + money + '}';
    }

   
  
}
