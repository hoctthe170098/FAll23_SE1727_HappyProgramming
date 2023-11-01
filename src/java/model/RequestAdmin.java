/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class RequestAdmin {
 
  int ID;
  float from;
  float to;
  String status;
  String title;
  String details;
  Date date;
  String address;
  float money;
  String mentorName;
  String menteeName;
  String skill;

    public RequestAdmin() {
    }

    public RequestAdmin(int ID, float from, float to, String status, String title, String details, Date date, String address, float money, String mentorName, String menteeName, String skill) {
        this.ID = ID;
        this.from = from;
        this.to = to;
        this.status = status;
        this.title = title;
        this.details = details;
        this.date = date;
        this.address = address;
        this.money = money;
        this.mentorName = mentorName;
        this.menteeName = menteeName;
        this.skill = skill;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMenteeName() {
        return menteeName;
    }

    public void setMenteeName(String menteeName) {
        this.menteeName = menteeName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "RequestAdmin{" + "ID=" + ID + ", from=" + from + ", to=" + to + ", status=" + status + ", title=" + title + ", details=" + details + ", date=" + date + ", address=" + address + ", money=" + money + ", mentorName=" + mentorName + ", menteeName=" + menteeName + ", skill=" + skill + '}';
    }

   

   

}
