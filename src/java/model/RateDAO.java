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
            rate = rs.getInt("rate");
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
    public void insertRate(Rate r){
        
    }
}
