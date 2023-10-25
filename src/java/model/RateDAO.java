/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Nhat Anh
 */
public class RateDAO extends MyDAO{
    public boolean checkIsExistRate(int IDMentee,int IDMentor){
        xSql = "select * "
                 + "from Rate "
                 + "where IDMentor = ? and IDMentee = ?";
         int iDMentor,iDMentee,rate;
         Rate r ;
         try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentor);
            ps.setInt(2, IDMentee);
            rs = ps.executeQuery();
            while (rs.next()) {
            rate = rs.getInt("Rate");
            iDMentor = rs.getInt("IDMentor");
            iDMentee = rs.getInt("IDMentee");
            r = new Rate(iDMentor, iDMentee, rate);
            if(r!=null)return true;
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         return false;
    }
    public void insertRate(int IDMentor,int IDMentee){
              xSql = "insert into Rate(IDMentor,IDMentee) values (?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, IDMentor);
            ps.setInt(2, IDMentee);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateRate(Rate r){
              xSql = "Update Rate set Rate = ? where IDMentor = ? and IDMentee = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, r.getRate());
            ps.setInt(2, r.getIDMentor());
            ps.setInt(3, r.getIDMentee());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        RateDAO dao = new RateDAO();
        System.out.println(dao.checkIsExistRate(3, 2));
        if(!dao.checkIsExistRate(3, 2))
        dao.insertRate(2, 3);
        System.out.println(dao.checkIsExistRate(3, 2));
    }
}
