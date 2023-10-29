<%-- 
    Document   : home.jsp
    Created on : Sep 17, 2023, 4:18:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">

    <head>
      <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>List Mentor</title>
        <meta content="" name="description">
        <meta content="" name="keywords">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="author" content="colorlib.com">
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />
        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">

        <!-- =======================================================
        * Template Name: Mentor
        * Updated: Aug 30 2023 with Bootstrap v5.3.1
        * Template URL: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
        <style>
              .custom-icon {
    color: blue;
}
.custom-instagram-icon {
    background: linear-gradient(135deg, #405DE6, #5851DB, #833AB4, #C13584, #E1306C, #FD1D1D);
    -webkit-background-clip: text;
    color: transparent;
}
        </style>
    </head>

    <body>

        <!-- ======= Header ======= -->
        <jsp:include page="header.jsp"></jsp:include>
            <main id="main">

                <section id="counts" class="counts section-bg">
                    <main id="main" data-aos="fade-in">

                        <!-- ======= Breadcrumbs ======= -->
                        <div class="breadcrumbs">
                            <div class="container">

                            <%  
                                
                            MentorIntroDAO MentorIntroDAO = new MentorIntroDAO();
                           String skill = request.getParameter("skill");
                           List<MentorIntro> listAllMentor = MentorIntroDAO.getMentorBySkill(skill);
                          
                            %>   
                            <p>We have <%=listAllMentor.size()%> mentors for you to choose </p>
                        </div>
                    </div><!-- End Breadcrumbs -->

                    <!-- ======= Courses Section ======= -->



                    <section id="trainers" class="trainers">
                        <div class="container" data-aos="fade-up">
                            <div class="section-title">
                                <h1>List of Mentors</h1>
                            </div>
                            <%
                            int itemsPerPage = 3; // Số phần tử trên mỗi trang
                            int totalItems = listAllMentor.size(); // Tổng số phần tử trong danh sách mentor
                            int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage); // Tính tổng số trang

                            // Lấy số trang hiện tại từ tham số truyền vào (hoặc từ session hoặc cookie)
                            int currentPage = 1;
                            if (request.getParameter("page") != null) {
                                currentPage = Integer.parseInt(request.getParameter("page"));
                            }

                            int startIndex = (currentPage - 1) * itemsPerPage; // Vị trí bắt đầu của trang hiện tại
                            int endIndex = Math.min(startIndex + itemsPerPage, totalItems); // Vị trí kết thúc của trang hiện tại
                            %>


                            <div class="row" data-aos="zoom-in" data-aos-delay="100">

                                <% for (int i = startIndex; i < endIndex; i++) { %>
                                <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                                    <div class="member">
                                        <img style="height: 215px; width: 335px" src="<%= listAllMentor.get(i).getAvatar() %>" class="img-fluid" alt="">
                                        <div class="member-content">
                                            <h4><%= listAllMentor.get(i).getFullname() %> (<a href="detailmentor?idmentor=<%=listAllMentor.get(i).getID()%>">Details</a>)</h4>
                                            <span>Rate: <%= listAllMentor.get(i).getRate() %></span>
                                            <p><%= listAllMentor.get(i).getIntro() %></p>
                                            <div class="social">
                                                <a href="<%= listAllMentor.get(i).getFacebook() %>"><i class="bi bi-facebook custom-icon"></i></a>
                                                <a href="<%= listAllMentor.get(i).getInta() %>"><i class="bi bi-instagram custom-instagram-icon"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <% } %>


                            </div> 




                            <style>
                                .paging {
                                    text-align: right; /* Đẩy sang bên phải */

                                    padding: 10px; /* Khoảng cách nội dung và viền */
                                    margin-top: 10px; /* Khoảng cách giữa phân trang và nội dung khác */
                                }

                                .paging a {
                                    padding: 5px 10px; /* Khoảng cách bên trong mỗi liên kết */
                                    border: 1px solid #ccc; /* Viền cho từng liên kết */
                                    margin-right: 5px; /* Khoảng cách giữa các liên kết */
                                    text-decoration: none; /* Loại bỏ gạch chân mặc định */
                                    color: #333; /* Màu chữ */
                                }

                                .paging a:hover {
                                    background-color: #f5f5f5; /* Màu nền khi di chuột qua */
                                }
                            </style>

                            <%-- Hiển thị danh sách các trang --%>
                            <div class="paging">
                                <% for (int pageNumber = 1; pageNumber <= totalPages; pageNumber++) { %>
                                <a href="header?page=<%= pageNumber %>&&id=1"><%= pageNumber %></a>
                                <% } %>
                            </div>  






                            </main><!-- End #main -->

                            <!-- ======= Footer ======= -->
                            <jsp:include page="Footer.jsp"></jsp:include>

                            <div id="preloader"></div>
                            <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

                            <!-- Vendor JS Files -->
                            <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
                            <script src="assets/vendor/aos/aos.js"></script>
                            <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
                            <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
                            <script src="assets/vendor/php-email-form/validate.js"></script>

                            <!-- Template Main JS File -->
                            <script src="assets/js/main.js"></script>

                            </body>

                            </html>
