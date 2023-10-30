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

                <!-- ======= About Section ======= -->
                <section id="about" class="about">
                    <div class="container" data-aos="fade-up">

                        <div class="row">
                            <div class="col-lg-6 order-1 order-lg-2" data-aos="fade-left" data-aos-delay="100">
                                <img src="assets/img/about.jpg" class="img-fluid" alt="">
                            </div>
                            <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content">
                                <h3>Do you want to become a mentor?</h3>
                                <p class="fst-italic">
                                    To become a mentor, you need:
                                </p>
                                <ul>
                                    <li><i class="bi bi-check-circle"></i> Strong knowledge. Certainly, the necessary condition to become a mentor is that you must master the knowledge you want to teach.</li>
                                    <li><i class="bi bi-check-circle"></i> Practice communication skills</li>
                                    <li><i class="bi bi-check-circle"></i> Learn how to create lesson plans</li>
                                </ul>
                                <p>
                                    If you have a account,Click "Become Mentor" to join with us
                                </p>


                            </div>
                        </div>

                    </div>
                </section><!-- End About Section -->

                <!-- ======= Counts Section ======= -->
                <section id="counts" class="counts section-bg">
                    <div class="container">

                        <div class="row counters">
                        <%
                            MenteeDAO MenteeDAO = new MenteeDAO();
                        %>
                        <div class="col-lg-4 col-6 text-center">
                            <span data-purecounter-start="0" data-purecounter-end=<%=MenteeDAO.TotalMentee()%> data-purecounter-duration="1" class="purecounter"></span>
                            <p>Students</p>
                        </div>
                        <%
                              SkillDAO SkillDAO = new SkillDAO();
                        %>
                        <div class="col-lg-4 col-6 text-center">
                            <span data-purecounter-start="0" data-purecounter-end=<%=SkillDAO.TotalSkill()%> data-purecounter-duration="1" class="purecounter"></span>
                            <p>Skills</p>
                        </div>
                        <%
                         MentorDAO MentorDAO = new MentorDAO();
                        %>
                        <div class="col-lg-4 col-6 text-center">
                            <span data-purecounter-start="0" data-purecounter-end=<%=MentorDAO.TotalMentor()%> data-purecounter-duration="1" class="purecounter"></span>
                            <p>Mentor</p>
                        </div>
                    </div>
                </div>
            </section><!-- End Counts Section -->

            <!-- ======= Why Us Section ======= -->
            <section id="why-us" class="why-us">
                <div class="container" data-aos="fade-up">

                    <div class="row">
                        <div class="col-lg-4 d-flex align-items-stretch">
                            <div class="content">
                                <h3>Why Choose HappyProgramming?</h3>
                                <p>
                                    HappyProgramming will help you find mentor to learn about skills,language programming easily and page 
                                    ensure:
                                </p>
                                <!--              <div class="text-center">
                                                <a href="about.html" class="more-btn">Learn More <i class="bx bx-chevron-right"></i></a>
                                              </div>-->
                            </div>
                        </div>
                        <div class="col-lg-8 d-flex align-items-stretch" data-aos="zoom-in" data-aos-delay="100">
                            <div class="icon-boxes d-flex flex-column justify-content-center">
                                <div class="row">
                                    <div class="col-xl-4 d-flex align-items-stretch">
                                        <div class="icon-box mt-4 mt-xl-0">
                                            <i class="bx bx-receipt"></i>
                                            <h4>Quality mentors, always on time</h4>
                                            <p>The mentors are selective and have very high expertise</p>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 d-flex align-items-stretch">
                                        <div class="icon-box mt-4 mt-xl-0">
                                            <i class="bx bx-cube-alt"></i>
                                            <h4>Support team</h4>
                                            <p>Support team always helps you when something goes wrong, and will answer any questions related to the mentors and skills</p>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 d-flex align-items-stretch">
                                        <div class="icon-box mt-4 mt-xl-0">
                                            <i class="bx bx-images"></i>
                                            <h4>Good textbooks and materials</h4>
                                            <p>The materials have been compiled by mentors and ensure 100% knowledge</p>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- End .content-->
                        </div>
                    </div>

                </div>
            </section><!-- End Why Us Section -->
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
                                <img style="width: 315px; height: 210px" src=<%=s.getImage()%> class="img-fluid" alt=<%=s.getName()%>>
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
                <section id="trainers" class="trainers">
                  <div class="container" data-aos="fade-up">
                  <div class="section-title">
                      <h2>Mentor</h2>
                      <p>Popular Mentor</p>
                    </div>
                    <div class="row" data-aos="zoom-in" data-aos-delay="100">
                        <%
                            MentorIntroDAO mentorIntro = new MentorIntroDAO();
                            List<MentorIntro> listMentorIntro = mentorIntro.getTop3MentorIntro();
                        %>
                        <%for (MentorIntro mi: listMentorIntro){%>
                      <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                        <div class="member">
                            <img style="width: 315px; height: 210px" src=<%=mi.getAvatar()%> class="img-fluid" alt="">
                          <div class="member-content">
                              <h4><%=mi.getFullname()%>(<a href="detailmentor?idmentor=<%=mi.getID()%>">Details</a>)</h4>
                            <span>Rate: <%=mi.getRate()%></span>
                            <p>
                             <%=mi.getIntro()%>
                            </p>
                            <div class="social">
                              
                                <a href=<%=mi.getFacebook()%>><i class="bi bi-facebook custom-icon"></i></a>
                                <a href=<%=mi.getInta()%>><i class="bi bi-instagram custom-instagram-icon"></i></a>
                           
                            </div>
                          </div>
                        </div>
                      </div>
                        <%}%>
        
                    <div>
            
                  </div>
                </section>
<!--            End Trainers Section -->

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
