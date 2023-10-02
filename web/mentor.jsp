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
>>>>>>> 595401a21149daca8f99a050e91779e5905dff4e

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
                       int count=listMentor.size()/2;
                       int remain=listMentor.size()-count*2;
                        %>
                        <%for (int i=1;i<=count;i++){%>
                        <div class="container" data-aos="fade-up">
                            <div class="row" data-aos="zoom-in" data-aos-delay="100">
                                <%for(int j=(i-1)*2+1;j<=i*2;j++){%>
                                <div class="col-lg-6 col-md-6 d-flex align-items-stretch">
                                    <div class="course-item">
                                        <div style="text-align: center;">
                                            <img src="<%= listPr.get(j-1).getAvatar() %>" class="img-fluid" alt="...">
                                        </div>
                                        <div style="text-align: center;" class="course-content">
                                            <div class="d-flex justify-content-between align-items-center mb-3">
                                                <h2 ><%=listPr.get(j-1).getFullname()%></h2>
                                                <!--                                        <p class="price">$169</p>-->
                                            </div>

                                            <h2 style="border-bottom: 3px solid;border-bottom-color: #86db9f" ><a href="request.jsp"> About this mentor </a></h2>
                                            <h3>Mentor's Experiences</h3>
                                            <p><%=listMentor.get(j-1).getIntro()%></p>
                                            <h3 style="border: 2px solid black; background-color: #f8f8f8; padding: 10px; text-align: center";><a href="request.jsp">Request</a></h3>
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
                                         <div style="text-align: center;">
                                        <img src=<%=listPr.get(listPr.size()-1).getAvatar()%> class="img-fluid" alt="...">
                                         </div>
                                        <div class="course-content">
                                            <div class="d-flex justify-content-between align-items-center mb-3">
                                                <h2 style="text-align: center;" ><%=listPr.get(listPr.size()-1).getFullname()%></h2>
                                                <!--                                        <p class="price">$169</p>-->
                                            </div>

                                            <h2 style="text-decoration: underline; text-decoration-color: #86db9f;  "><a href="request.jsp"> About this mentor </a></h2>
                                            <h3>Mentor's Experiences</h3>
                                            <p><%=listMentor.get(listMentor.size()-1).getIntro()%></p>

                                            <h3 style="border: 2px solid black; background-color: #f8f8f8; padding: 10px; text-align: center";><a href="request.jsp">Request</a></h3>
                                        </div>
                                    </div>
                                </div>
                            </div> <!-- End Course Item-->                    
                        </div>

                        </div>
                        <%}%>
                    </section><!-- End Why Us Section -->

                    <!-- ======= Features Section ======= -->
                    <!--    <section id="features" class="features">
                          <div class="container" data-aos="fade-up">
                    
                            <div class="row" data-aos="zoom-in" data-aos-delay="100">
                              <div class="col-lg-3 col-md-4">
                                <div class="icon-box">
                                  <i class="ri-store-line" style="color: #ffbb2c;"></i>
                                  <h3><a href="">Lorem Ipsum</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4 mt-md-0">
                                <div class="icon-box">
                                  <i class="ri-bar-chart-box-line" style="color: #5578ff;"></i>
                                  <h3><a href="">Dolor Sitema</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4 mt-md-0">
                                <div class="icon-box">
                                  <i class="ri-calendar-todo-line" style="color: #e80368;"></i>
                                  <h3><a href="">Sed perspiciatis</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4 mt-lg-0">
                                <div class="icon-box">
                                  <i class="ri-paint-brush-line" style="color: #e361ff;"></i>
                                  <h3><a href="">Magni Dolores</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4">
                                <div class="icon-box">
                                  <i class="ri-database-2-line" style="color: #47aeff;"></i>
                                  <h3><a href="">Nemo Enim</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4">
                                <div class="icon-box">
                                  <i class="ri-gradienter-line" style="color: #ffa76e;"></i>
                                  <h3><a href="">Eiusmod Tempor</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4">
                                <div class="icon-box">
                                  <i class="ri-file-list-3-line" style="color: #11dbcf;"></i>
                                  <h3><a href="">Midela Teren</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4">
                                <div class="icon-box">
                                  <i class="ri-price-tag-2-line" style="color: #4233ff;"></i>
                                  <h3><a href="">Pira Neve</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4">
                                <div class="icon-box">
                                  <i class="ri-anchor-line" style="color: #b2904f;"></i>
                                  <h3><a href="">Dirada Pack</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4">
                                <div class="icon-box">
                                  <i class="ri-disc-line" style="color: #b20969;"></i>
                                  <h3><a href="">Moton Ideal</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4">
                                <div class="icon-box">
                                  <i class="ri-base-station-line" style="color: #ff5828;"></i>
                                  <h3><a href="">Verdo Park</a></h3>
                                </div>
                              </div>
                              <div class="col-lg-3 col-md-4 mt-4">
                                <div class="icon-box">
                                  <i class="ri-fingerprint-line" style="color: #29cc61;"></i>
                                  <h3><a href="">Flavor Nivelanda</a></h3>
                                </div>
                              </div>
                            </div>
                    
                          </div>
                        </section> End Features Section -->

                    <!-- ======= Popular Courses Section ======= -->
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
                    </section><!-- End Popular Courses Section -->
                    <!-- ======= Trainers Section ======= -->
                    <!--    <section id="trainers" class="trainers">
                          <div class="container" data-aos="fade-up">
                          <div class="section-title">
                              <h2>Mentor</h2>
                              <p>Popular Mentor</p>
                            </div>
                            <div class="row" data-aos="zoom-in" data-aos-delay="100">
                              <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                                <div class="member">
                                  <img src="assets/img/trainers/trainer-1.jpg" class="img-fluid" alt="">
                                  <div class="member-content">
                                    <h4>Walter White</h4>
                                    <span>Web Development</span>
                                    <p>
                                      Magni qui quod omnis unde et eos fuga et exercitationem. Odio veritatis perspiciatis quaerat qui aut aut aut
                                    </p>
                                    <div class="social">
                                      <a href=""><i class="bi bi-twitter"></i></a>
                                      <a href=""><i class="bi bi-facebook"></i></a>
                                      <a href=""><i class="bi bi-instagram"></i></a>
                                      <a href=""><i class="bi bi-linkedin"></i></a>
                                    </div>
                                  </div>
                                </div>
                              </div>
                    
                              <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                                <div class="member">
                                  <img src="assets/img/trainers/trainer-2.jpg" class="img-fluid" alt="">
                                  <div class="member-content">
                                    <h4>Sarah Jhinson</h4>
                                    <span>Marketing</span>
                                    <p>
                                      Repellat fugiat adipisci nemo illum nesciunt voluptas repellendus. In architecto rerum rerum temporibus
                                    </p>
                                    <div class="social">
                                      <a href=""><i class="bi bi-twitter"></i></a>
                                      <a href=""><i class="bi bi-facebook"></i></a>
                                      <a href=""><i class="bi bi-instagram"></i></a>
                                      <a href=""><i class="bi bi-linkedin"></i></a>
                                    </div>
                                  </div>
                                </div>
                              </div>
                    
                              <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                                <div class="member">
                                  <img src="assets/img/trainers/trainer-3.jpg" class="img-fluid" alt="">
                                  <div class="member-content">
                                    <h4>William Anderson</h4>
                                    <span>Content</span>
                                    <p>
                                      Voluptas necessitatibus occaecati quia. Earum totam consequuntur qui porro et laborum toro des clara
                                    </p>
                                    <div class="social">
                                      <a href=""><i class="bi bi-twitter"></i></a>
                                      <a href=""><i class="bi bi-facebook"></i></a>
                                      <a href=""><i class="bi bi-instagram"></i></a>
                                      <a href=""><i class="bi bi-linkedin"></i></a>
                                    </div>
                                  </div>
                                </div>
                              </div>
                    
                            </div>
                    
                          </div>
                        </section> End Trainers Section -->

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
