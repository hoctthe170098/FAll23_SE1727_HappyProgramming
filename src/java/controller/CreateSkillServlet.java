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
import java.sql.SQLException;
import java.util.UUID;
import model.DBContext;


/**
 *
 * @author ADMIN
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)
public class CreateSkillServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateSkillServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateSkillServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("CreateSkill.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ biểu mẫu
        String skillName = request.getParameter("skillName");
        String skillDescription = request.getParameter("skillDescription");
        // Lấy hình ảnh từ biểu mẫu (chú ý: bạn cần lưu trữ hình ảnh trong cơ sở dữ liệu hoặc hệ thống tệp riêng biệt)
        Part Filepart = request.getPart("skillImage");
        String relativePath = request.getServletContext().getRealPath("/assets/img");

        String avatar = Filepart.getSubmittedFileName();
        String ava = "assets/img/" + avatar;
        String filePath = relativePath + File.separator + avatar;

        Filepart.write(filePath);
        // Lưu dữ liệu từ InputStream vào tệp hình ảnh trên máy chủ

        // Sử dụng lớp DBContext để lấy kết nối đến cơ sở dữ liệu
        DBContext dbContext = new DBContext();
        Connection connection = dbContext.getConnection();

        try {
            // Tạo câu lệnh SQL để chèn dữ liệu vào bảng "Skill"
            String sql = "INSERT INTO Skills (Name, Description, image) VALUES (?, ?, ?)";

            // Tạo PreparedStatement và thiết lập các tham số
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, skillName);
            preparedStatement.setString(2, skillDescription);
            preparedStatement.setString(3, ava);
            // Thực thi câu lệnh SQL
            int rowsAffected = preparedStatement.executeUpdate();

            // Đóng kết nối và xử lý kết quả (nếu cần)
            preparedStatement.close();
            connection.close();

            // Chuyển hướng hoặc hiển thị trang kết quả
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi (ví dụ: in lỗi hoặc chuyển hướng đến trang lỗi)
        }
        request.setAttribute("mess", "Add successfully!");
        request.getRequestDispatcher("CreateSkill.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
