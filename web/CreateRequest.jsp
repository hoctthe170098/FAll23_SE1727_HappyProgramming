<%-- 
    Document   : CreateRequest
    Created on : Oct 11, 2023, 10:29:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
          <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Create Request</title>
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
    </head>
    <body>
       <!-- ======= Header ======= -->
        <jsp:include page="header.jsp"></jsp:include>
          <section id="contact" class="contact">
<!--      <div data-aos="fade-up">
        <iframe style="border:0; width: 100%; height: 350px;" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12097.433213460943!2d-74.0062269!3d40.7101282!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb89d1fe6bc499443!2sDowntown+Conference+Center!5e0!3m2!1smk!2sbg!4v1539943755621" frameborder="0" allowfullscreen></iframe>
      </div>-->

      <div class="container" data-aos="fade-up">

        <div class="row mt-5">
<!--
          <div class="col-lg-4">
            <div class="info">
              <div class="address">
                <i class="bi bi-geo-alt"></i>
                <h4>Location:</h4>
                <p>A108 Adam Street, New York, NY 535022</p>
              </div>

              <div class="email">
                <i class="bi bi-envelope"></i>
                <h4>Email:</h4>
                <p>info@example.com</p>
              </div>

              <div class="phone">
                <i class="bi bi-phone"></i>
                <h4>Call:</h4>
                <p>+1 5589 55488 55s</p>
              </div>

            </div>

          </div>-->

          <div class="col-lg-12 mt-5 mt-lg-0">

            <form action="createrequest" method="post" class="php-email-form">
              <div class="row">
                <div class="col-md-12 form-group">
                    <h6>Title * </h6>
                  <input type="text" name="title" class="form-control" id="name" placeholder="Title" required>
                </div>               
              </div>
                <div class="row">
                  <div class="col-md-6 form-group mt-3 mt-md-0">
                   <h6>Date * </h6>   
                  <input type="date" class="form-control" name="date" id="date" placeholder="Date" required>
                </div>
                  <div class="col-md-3 form-group mt-3 mt-md-0">
                   <h6>From * </h6>
                  <input type="number" class="form-control" name="from" id="from" placeholder="From" min="8" max="20" step="0.5" value="8" required>
                </div>
                  <div class="col-md-3 form-group mt-3 mt-md-0">
                   <h6>To * </h6>   
                  <input type="number" class="form-control" name="to" id="to" placeholder="To" min="10" max="22" step="0.5" value="10" required>
                </div>  
                </div>
              <div class="form-group mt-3">
                  <h6>Skill * </h6> 
                  <%
                      HashMap hSkill = (HashMap)request.getAttribute("hSkill");
                      Set<Integer> listKey = hSkill.keySet();
                  %>
                  <%for(int id: listKey){%>
                  <input type="radio" name="skill" value=<%=id%>/><span><%=hSkill.get(id)%></span>
                  <%}%>          
              </div>
              <div class="form-group mt-3">
                 <h6>Detail * </h6> 
                <textarea class="form-control" name="detail" rows="5" placeholder="Detail" required></textarea>
              </div>
              <div class="my-3">
                <div class="loading">Loading</div>
                <div class="error-message"></div>
                <div class="sent-message">Your message has been sent. Thank you!</div>
              </div>
              <div class="text-center"><button type="submit">Send Request</button></div>
            </form>

          </div>

        </div>

      </div>
    </section><!-- End Contact Section -->

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
