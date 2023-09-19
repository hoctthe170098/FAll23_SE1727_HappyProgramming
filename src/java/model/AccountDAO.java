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
public class AccountDAO extends DBContext {

    public void insertAccount(Account account) {

        try {
            String query = "INSERT INTO Account (name, email, password,gender,username,mobile) VALUES (?, ?, ?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(2, account.getEmail());
            statement.setString(3, account.getPassword());

            statement.setString(5, account.getUsername());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public Account getAccountBy(String username, String password) {
    try {
        String sql = "SELECT [Username], [Password] FROM [dbo].[Account] WHERE Username = ? AND Password = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, username);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            // Tạo một đối tượng Account và đổ dữ liệu từ ResultSet vào đó
            Account account = new Account();
            account.setUsername(rs.getString("Username"));
            account.setPassword(rs.getString("Password"));
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


    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        Account a = dao.getAccountBy("hoctthe170098", "123456");
        System.out.println(a.toString());
    }
}