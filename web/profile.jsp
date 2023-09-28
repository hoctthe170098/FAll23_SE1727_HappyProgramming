<%-- 
    Document   : Profile1
    Created on : Sep 20, 2023, 9:18:07 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<%
    Account acc = (Account)request.getSession().getAttribute("acc");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
         <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
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
<style type="text/css">
.profile{margin-top:20px;
color: #9b9ca1;
}
.profile .bg-secondary-soft {
    background-color: rgba(208, 212, 217, 0.1) !important;
}
.profile .rounded {
    border-radius: 5px !important;
}
.profile .py-5 {
    padding-top: 3rem !important;
    padding-bottom: 3rem !important;
}
.profile .px-4 {
    padding-right: 1.5rem !important;
    padding-left: 1.5rem !important;
}
.profile .file-upload .square {
    height: 250px;
    width: 250px;
    margin: auto;
    vertical-align: middle;
    border: 1px solid #e5dfe4;
    background-color: #fff;
    border-radius: 5px;
}
.profile .text-secondary {
    --bs-text-opacity: 1;
    color: rgba(208, 212, 217, 0.5) !important;
}
.profile .btn-success-soft {
    color: #28a745;
    background-color: rgba(40, 167, 69, 0.1);
}
.profile .btn-danger-soft {
    color: #dc3545;
    background-color: rgba(220, 53, 69, 0.1);
}
.profile .form-control {
    display: block;
    width: 100%;
    padding: 0.5rem 1rem;
    font-size: 0.9375rem;
    font-weight: 400;
    line-height: 1.6;
    color: #29292e;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #e5dfe4;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    border-radius: 5px;
    -webkit-transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
    transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
}
    </style>
  <!-- =======================================================
  * Template Name: Mentor
  * Updated: Aug 30 2023 with Bootstrap v5.3.1
  * Template URL: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script >
      function chooseFile(fileInput){
          if(fileInput.files && fileInput.files[0]){
              var reader = new FileReader();
              reader.onload = function(e){
                  $('#image').attr('src',e.target.result);
              }
              reader.readAsDataURL(fileInput.files[0]);
          }
      }
  </script>
    </head>
    <body>
       <!-- ======= Header ======= -->
  <jsp:include page="header.jsp"></jsp:include>
  <div class="profile">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
<div class="container">
<div class="row">
<div class="col-12">

<div class="my-5">
<h3>My Profile</h3>
<hr>
</div>
<%
    ProfileDAO proDAO = new ProfileDAO();
   Profile p = proDAO.getProfileByID(acc.getID());
%>
<%
String[] str = p.getFullname().split(" ");
String firstname="";
        for (int i=0;i<str.length-1;i++){
             firstname=firstname+str[i];
        }
        firstname=firstname;
        String lastname = str[str.length-1];
        String gender;
 if(p.isGender()==true) gender="male";
 else gender="female";
%>
<form class="file-upload" action="profile" method="post" enctype="multipart/form-data">
<div class="row mb-5 gx-5">

<div class="col-xxl-8 mb-5 mb-xxl-0">
<div class="bg-secondary-soft px-4 py-5 rounded">
<div class="row g-3">
<h4 class="mb-4 mt-0">Contact detail</h4>

<div class="col-md-6">
<label class="form-label">First Name *</label>
<input type="text" name="firstname" class="form-control" placeholder aria-label="First name" value=<%=firstname%>>
</div>

<div class="col-md-6">
<label class="form-label">Last Name *</label>
<input type="text" name="lastname" class="form-control" placeholder aria-label="Last name" value=<%=lastname%>>
</div>

<div class="col-md-6">
<label class="form-label">Phone number *</label>
<input type="text" name="phone" class="form-control" placeholder aria-label="Phone number" value=<%=p.getPhone()%>>
</div>

<div class="col-md-6">
<label class="form-label">Birth *</label>
<input type="date" name="birth" class="form-control" placeholder aria-label="Enter your birth here" value=<%=p.getBirth()%>>
</div>
 <div class="col-md-6">
<label class="form-label">Address *</label>
<input type="text" name="address" class="form-control" placeholder aria-label="Address" value=<%=p.getAddress()%>>
</div>


<div class="col-md-6">
<label class="form-label">Gender *</label>
<!--<input type="text" class="form-control" placeholder aria-label="Phone number" value="Scaralet D">-->
<select name="gender" class="form-control" value=<%=gender%>>
  <option value="true">Male</option>
  <option value="false">Female</option>  
</select>    
</div>
 <div class="col-md-6">
<label for="inputEmail4" class="form-label">Email *</label>
<div><%=acc.getEmail()%></div>
</div>
</div> 
</div>
</div>

<div class="col-xxl-4">
<div class="bg-secondary-soft px-4 py-5 rounded">
<div class="row g-3">
<h4 class="mb-4 mt-0">Upload your profile photo</h4>
<div class="text-center">

<div class="square position-relative display-2 mb-3">
    <%if(p.getAvatar()!=""){%> 
    <img class="square position-relative display-2 mb-3" src=<%=p.getAvatar()%> id="image" alt=""/>
    <%}%>
    <%if(p.getAvatar()==""){%>
    <img class="square position-relative display-2 mb-3" src="imagesAcc\htmlcssjs.png" id="image" alt="gvb"/>
    <%}%>
<!--    <i class="fas fa-fw fa-user position-absolute top-50 start-50 translate-middle text-secondary"></i>-->
</div>
    <input type="file" id="customFile" name="avatar" hidden onchange="chooseFile(this)" accept="image/png, image/gif, image/jpeg">
<label class="btn btn-success-soft btn-block" for="customFile">Upload</label>
<!--<button type="button" class="btn btn-danger-soft">Remove</button>-->

<p class="text-muted mt-3 mb-0"><span class="me-1">Note:</span>Minimum size 300px x 300px</p>
</div>
</div>
</div>
</div>
</div> 

<div class="row mb-5 gx-5">
<div class="col-xxl-6 mb-5 mb-xxl-0">
<div class="bg-secondary-soft px-4 py-5 rounded">
<div class="row g-3">
<h4 class="mb-4 mt-0">Social media detail</h4>
<div class="col-md-6">
<label class="form-label"><i class="fab fa-fw fa-facebook me-2 text-facebook"></i>Facebook *</label>
<input type="text" name="facebooklink" class="form-control" placeholder aria-label="Facebook" value=<%=p.getFacebookLink()%>>
</div>
<div class="col-md-6">
<label class="form-label"><i class="fab fa-fw fa-instagram text-instagram me-2"></i>Instagram *</label>
<input type="text" name="instragramlink" class="form-control" placeholder aria-label="Instragram" value=<%=p.getInstagramLink()%>>
</div>
</div> 
</div>
</div>

<!--<div class="col-xxl-6">
<div class="bg-secondary-soft px-4 py-5 rounded">
<div class="row g-3">
<h4 class="my-4">Change Password</h4>

<div class="col-md-6">
<label for="exampleInputPassword1" class="form-label">Old password *</label>
<input type="password" class="form-control" id="exampleInputPassword1">
</div>

<div class="col-md-6">
<label for="exampleInputPassword2" class="form-label">New password *</label>
<input type="password" class="form-control" id="exampleInputPassword2">
</div>

<div class="col-md-12">
<label for="exampleInputPassword3" class="form-label">Confirm Password *</label>
<input type="password" class="form-control" id="exampleInputPassword3">
</div>
</div>
</div>
</div>-->
</div> 

<!--<div class="gap-3 d-md-flex justify-content-md-end text-center">-->
<button type="submit" name="button" value="delete" class="btn btn-danger btn-lg">Delete profile</button>
<button type="submit" name="button" value="update" class="btn btn-primary btn-lg">Update profile</button>
<!--<input type="submit" class="btn btn-primary btn-lg" value="Update profile">-->
<!--</div>-->
</form> 
</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
</script>
  </div>
  
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
