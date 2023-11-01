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
<%@page import=  "java.util.Map.Entry"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Skills</title>
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
            <main id="main" data-aos="fade-in">

                <!-- ======= Breadcrumbs ======= -->
                <div class="breadcrumbs">
                    <div class="container">
                        <h2>Skills</h2>
                    <%  
                          List<Skill> listSkill = (List<Skill>)request.getAttribute("listSkillByName");
                          if(listSkill==null){
                          SkillDAO SkillDAO = new SkillDAO();
                          listSkill = SkillDAO.getListSkill();
                        }
                    %>   
                    <p>We have <%=listSkill.size()%> skills which are the most used nowaday such as: C/C++, java, HTML/CSS</p>
                </div>
            </div><!-- End Breadcrumbs -->

            <!-- ======= Courses Section ======= -->
            <section id="courses" class="courses">
                <%
               int count=listSkill.size()/2;
               int remain=listSkill.size()-count*2;
                %>
                <%for (int i=1;i<=count;i++){%>
                <div class="container" data-aos="fade-up">
                    <div class="row" data-aos="zoom-in" data-aos-delay="100">
                        <%for(int j=(i-1)*2+1;j<=i*2;j++){%>
                        <div class="col-lg-6 col-md-6 d-flex align-items-stretch">
                            <div class="course-item">
                                <img style="width: 315px; height: 210px" src=<%=listSkill.get(j-1).getImage()%> class="img-fluid" alt="...">
                                <div class="course-content">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4><%=listSkill.get(j-1).getName()%></h4>
<!--                                        <p class="price">$169</p>-->
                                    </div>

                                    <h3><a href="MentorBySkill.jsp?ID=<%=listSkill.get(j-1).getID()%>">Mentors of this skill</a></h3>
                                    <p><%=listSkill.get(j-1).getDescription()%></p>
                                </div>
                            </div>
                        </div> <!-- End Course Item-->
                        <%}%>
                    </div>

                </div>
                <%}%>
              <%if(remain!=0){%>
               <div class="container" data-aos="fade-up">
                    <div class="row" data-aos="zoom-in" data-aos-delay="100">               
                        <div class="col-lg-6 col-md-6 d-flex align-items-stretch">
                            <div class="course-item">
                                <img src=<%=listSkill.get(listSkill.size()-1).getImage()%> class="img-fluid" alt="...">
                                <div class="course-content">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4><%=listSkill.get(listSkill.size()-1).getName()%></h4>
<!--                                        <p class="price">$169</p>-->
                                    </div>

                                    <h3><a href="">Mentors of this skill</a></h3>
                                    <p><%=listSkill.get(listSkill.size()-1).getDescription()%></p>
                                </div>
                            </div>
                        </div> <!-- End Course Item-->                    
                    </div>

                </div>
              <%}%>
            </section><!-- End Courses Section -->
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
