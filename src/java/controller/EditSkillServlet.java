/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import model.DBContext;


/**
 *
 * @author ADMIN
 */

public class EditSkillServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    int skillID = Integer.parseInt(request.getParameter("editSkillID")); // Lấy ID kỹ năng cần cập nhật

    // Sử dụng lớp DBContext để lấy kết nối đến cơ sở dữ liệu
    DBContext dbContext = new DBContext();
    Connection connection = dbContext.getConnection();

    // Tạo câu lệnh SQL để lấy thông tin kỹ năng dựa trên ID
    String selectSql = "SELECT * FROM Skills WHERE ID = ?";
    try {
        PreparedStatement selectStatement = connection.prepareStatement(selectSql);
        selectStatement.setInt(1, skillID);
        ResultSet resultSet = selectStatement.executeQuery();

        if (resultSet.next()) {
            
            String skillName = resultSet.getString("Name");
            String skillDescription = resultSet.getString("Description");
            String skillImage = resultSet.getString("Image");

            
            request.setAttribute("skillID", skillID);
            request.setAttribute("skillName", skillName);
            request.setAttribute("skillDescription", skillDescription);
            request.setAttribute("skillImage", skillImage);

            
            request.getRequestDispatcher("editskill.jsp").forward(request, response);
        } else {
            
        }

        resultSet.close();
        selectStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
        // Xử lý lỗi (ví dụ: in lỗi hoặc chuyển hướng đến trang lỗi)
    }
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int skillID = Integer.parseInt(request.getParameter("editSkillID"));
        
        String skillName = request.getParameter("skillName");
        String skillDescription = request.getParameter("skillDescription");

        // Lấy hình ảnh từ biểu mẫu (nếu cần)
        Part Filepart = request.getPart("skillImage");
        String relativePath = request.getServletContext().getRealPath("/assets/img");

        String avatar = Filepart.getSubmittedFileName();
        String ava = "assets/img/" + avatar;
        String filePath = relativePath + File.separator + avatar;

        Filepart.write(filePath);

        // Sử dụng lớp DBContext để lấy kết nối đến cơ sở dữ liệu
        DBContext dbContext = new DBContext();
        Connection connection = dbContext.getConnection();

        try {
            // Tạo câu lệnh SQL để cập nhật kỹ năng
            String updateSql = "UPDATE Skills SET Name = ?, Description = ?, Image = ? WHERE ID = ?";

            // Tạo PreparedStatement và thiết lập các tham số
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);

            preparedStatement.setString(1, skillName);
            preparedStatement.setString(2, skillDescription);
            preparedStatement.setString(3, ava);
            preparedStatement.setInt(4, skillID);

            // Thực thi câu lệnh SQL UPDATE
            int rowsUpdated = preparedStatement.executeUpdate();

            // Đóng kết nối và xử lý kết quả (nếu cần)
            preparedStatement.close();
            connection.close();

            // Chuyển hướng hoặc hiển thị trang kết quả
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi (ví dụ: in lỗi hoặc chuyển hướng đến trang lỗi)
        }
        response.sendRedirect("editskill"); // Chuyển hướng đến trang danh sách kỹ năng sau khi cập nhật
    }
}

