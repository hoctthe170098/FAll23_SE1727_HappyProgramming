/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBContext;

/**
 *
 * @author DELL
 */
public class AccountDAO extends MyDAO {

    public void insertAccount(Account account) {

           xSql = "insert into Account values (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getUsername());
            ps.setString(3, account.getPassword());
            ps.setByte(4, account.getIsMentee());
            ps.setByte(5, account.getIsMentor());
            ps.setByte(6, account.getIsAdmin());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean IsExistUsername(String username){
         xSql = "select Username from Account where Username = '" + username+"'";
         String user =null;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
           user = rs.getString("Username");         
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         if(user!=null)return true; else return false;
    }
    public boolean IsExistEmail(String ema){
         xSql = "select Email from Account where Email = '" + ema+"'";
         String email =null;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
           email = rs.getString("Email");         
        }
         }catch(Exception e){
             e.printStackTrace();
         }
         if(email!=null)return true; else return false;
    }
    public Account getAccountBy(String Username, String Password) {
        try {
            String sql = "SELECT * FROM [dbo].[Account] WHERE Username = ? AND Password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, Username);
            stm.setString(2, Password);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                // Tạo một đối tượng Account và đổ dữ liệu từ ResultSet vào đó
                Account account = new Account();
                account.setID(rs.getInt("ID"));
                account.setEmail(rs.getString("Email"));
                account.setUsername(rs.getString("Username"));
                account.setPassword(rs.getString("Password"));
                account.setIsMentee(rs.getByte("isMentee"));
                account.setIsMentor(rs.getByte("isMentor"));
                account.setIsAdmin(rs.getByte("isAdmin"));
                // Điền thêm các trường khác nếu cần

                return account;
            } else {
                // Không tìm thấy tài khoản, có thể trả về null hoặc xử lý một cách tùy ý
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Trả về null nếu có lỗi xảy ra
        return null;
    }
    public String getEmailByID(int ID){
         xSql = "select Email from Account where id = " + ID;
         try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
            String email  = rs.getString("Email");
            return email;
        }
         }catch(Exception e){
             e.printStackTrace();
         }
       return null;
    }
    public Account searchAccountByEmail(String email) {
        Account account = null;

        try {
            String query = "SELECT * FROM Account WHERE Email = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                account = new Account();
                account.setUsername(resultSet.getString("Username"));
                account.setEmail(resultSet.getString("Email"));
                account.setPassword(resultSet.getString("Password"));
                account.setID(resultSet.getInt("ID"));
                account.setIsAdmin(resultSet.getByte("isAdmin"));
                account.setIsMentee(resultSet.getByte("isMentee"));
                account.setIsMentor(resultSet.getByte("isMentor"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return account;
    }

    public boolean updatePassword(String email, String newPassword) {
        try {
            String query = "UPDATE Account SET Password = ? WHERE Email = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, newPassword);
            statement.setString(2, email);

            int rowsAffected = statement.executeUpdate();

            statement.close();

            // Check if the update was successful (1 row affected means success)
            return rowsAffected == 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Handle the error as needed
        }
    }
    public void updateRole(int idMentee){
        
           xSql = "update Account set isMentee = 0,isMentor = 1 where ID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, idMentee);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
//        dao.updatePassword("hoctthe170098@fpt.edu.vn", "1234213123");
        System.out.println(dao.IsExistUsername("hoct"));
    }
}
