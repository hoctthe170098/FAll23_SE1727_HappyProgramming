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
        
        <<<<<<< HEAD
        <title>Home</title>
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
        =======
        <title>Mentor</title>
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
                                <h2>Skills</h2>
                            <%  
                                  SkillDAO SkillDAO = new SkillDAO();
                                  List<Skill> listSkill = SkillDAO.getListSkill();
                                  MentorDAO MentorDAO = new MentorDAO();
                                  List<Mentor> listMentor = MentorDAO.getAllMentor();
                                  ProfileDAO ProfileDAO = new ProfileDAO();
                                  List<Profile> listPr = ProfileDAO.getAllProfile();
                          
                            %>   
                            <p>We have <%=listMentor.size()%> mentors for you to choose </p>
                        </div>
                    </div><!-- End Breadcrumbs -->

                    <!-- ======= Courses Section ======= -->
                    <section id="courses" class="courses">
                       <%
int count = listMentor.size() / 3; // Chia danh sách thành các phần 3
int remain = listMentor.size() % 3;
%>
<% for (int i = 0; i < count; i++) { %>
    <div class="container" data-aos="fade-up">
        <h1>List of Mentors</h1>
        <%
        int itemsPerPage = 3; // Số phần tử trên mỗi trang
        int totalItems = listMentor.size(); // Tổng số phần tử trong danh sách mentor
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
            <% for (int j = startIndex; j < endIndex; j++) { %>
                <div class="col-lg-4 col-md-4 d-flex align-items-stretch">
                    <div style = " background-color: #f8f8f8;border: 2px solid black;padding: 20px;text-align: center;margin-bottom: 20px; " class="course-item">
                        <div style="text-align: center;">
                            <img src="<%= listPr.get(j).getAvatar() %>" class="img-fluid" alt="...">
                        </div>
                        <div style="text-align: center;" class="course-content">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h2 ><%=listPr.get(j).getFullname()%></h2>
                            </div>

                            <h2 style="border-bottom: 3px solid;border-bottom-color: #86db9f" ><a href="request.jsp"> About this mentor </a></h2>
                            <h3>Mentor's Experiences</h3>
                            <p style ="color: #666; font-size: 30px;"><%=listMentor.get(j).getIntro()%></p>
                            <h3 style="border: 2px solid black; background-color: #f8f8f8; padding: 10px; text-align: center";><a href="request.jsp">Request</a></h3>
                        </div>
                    </div>
                </div>
            <% } %>
        </div>

        <!-- Hiển thị các liên kết phân trang -->
        <div class="pagination">
            <% if (currentPage > 1) { %>
                
                <a href="?page=<%= currentPage - 1 %>&&id=1">Previous</a>
            <% } %>
            <% if (currentPage < totalPages) { %>
                <a href="?page=<%= currentPage + 1 %>&&id=1">Next</a>
            <% } %>
        </div>
    </div>
       
        </div>
    </div>
<% } %>

                    </section>
                    <section id="popular-courses" class="courses">
                        <div class="container" data-aos="fade-up">

                            <div class="section-title">
                                <h2>Skill</h2>
                                <p>Popular Skills</p>
                            </div>

                            <div class="row" data-aos="zoom-in" data-aos-delay="100">
                                <%
                                List<Skill> listTop3Skills = SkillDAO.getListTop3Skill();
                                %>
                                <%for(Skill s : listTop3Skills){%>
                                <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                                    <div class="course-item">
                                        <img src=<%=s.getImage()%> class="img-fluid" alt=<%=s.getName()%>>
                                        <div class="course-content">
                                            <div class="d-flex justify-content-between align-items-center mb-3">
                                                <h4><%=s.getName()%></h4>
                                                <!--                  <p class="price">$169</p>-->
                                            </div>
                                            <h3><a href="">Mentors of this skill</a></h3>
                                            <p><%=s.getDescription()%></p>
                                        </div>
                                    </div>
                                </div> <!-- End Course Item-->
                                <%}%>
                            </div>
                        </div>
                    </section>

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
