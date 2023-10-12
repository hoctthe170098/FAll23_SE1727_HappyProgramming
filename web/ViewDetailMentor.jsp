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
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
         <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail of mentor</title>
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
    
    .comment {
    background-color: #eee
}

.comment .card {
    background-color: #fff;
    border: none
}

.comment .form-color {
    background-color: #fafafa
}

.comment .form-control {
    height: 48px;
    border-radius: 25px
}

.comment .form-control:focus {
    color: #495057;
    background-color: #fff;
    border-color: #35b69f;
    outline: 0;
    box-shadow: none;
    text-indent: 10px
}

.comment .c-badge {
    background-color: #35b69f;
    color: white;
    height: 20px;
    font-size: 11px;
    width: 92px;
    border-radius: 5px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 2px
}

.comment .comment-text {
    font-size: 13px
}

.comment .wish {
    color: #35b69f
}

.comment .user-feed {
    font-size: 14px;
    margin-top: 12px
}

.clearfix .pagination {
    float: right;
    margin: 0 0 5px;
}
.clearfix .pagination li a {
    border: none;
    font-size: 13px;
    min-width: 30px;
    min-height: 30px;
    color: #999;
    margin: 0 2px;
    line-height: 30px;
    border-radius: 2px !important;
    text-align: center;
    padding: 0 6px;
}
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
    </head>
    <body>
       <!-- ======= Header ======= -->
  <jsp:include page="header.jsp"></jsp:include>
  <div class="profile">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
<div class="container">
<div class="row">
<div class="col-12">
<%
   Profile p = (Profile)request.getAttribute("p");
%>
<div class="my-5">
<h3>Details of Mentor <%=p.getFullname()%></h3>
<hr>
</div>
<%
String[] str = p.getFullname().split(" ");
String firstname="";
        for (int i=0;i<str.length-1;i++){
             firstname=firstname+str[i];
        }
        firstname=firstname;
        String lastname = str[str.length-1];
        String gender;
 if(p.isGender()==true) gender="Male";
 else gender="Female";
%>

<div class="row mb-5 gx-5">
<div class="col-xxl-4">
<div class="bg-secondary-soft px-4 py-5 rounded">
<div class="row g-3">
<h4 class="mb-4 mt-0">Avatar</h4>
<div class="text-center">
<div class="square position-relative display-2 mb-3">
   <img style="height: 300px;width: 360px" class="square position-relative display-2 mb-3" src=<%=p.getAvatar()%> id="image" alt=""/>  
</div>
</div>
</div>
</div>
</div>
<div class="col-xxl-8 mb-5 mb-xxl-0">
<div class="bg-secondary-soft px-4 py-5 rounded">
<div class="row g-3">
<h4 class="mb-4 mt-0">Contact detail</h4>

<div class="col-md-6">
<label class="form-label">First Name :</label>
<b><%=firstname%></b>
</div>

<div class="col-md-6">
<label class="form-label">Last Name :</label>
<b><%=lastname%></b>
</div>

<div class="col-md-6">
<label class="form-label">Phone number :</label>
<b><%=p.getPhone()%></b>
</div>
<div class="col-md-6">
<label class="form-label">Birth :</label>
<%String date =(String)request.getAttribute("date");
%>
<b><%=date%></b>
</div>
 <div class="col-md-6">
<label class="form-label">Address :</label>
<b><%=p.getAddress()%></b>
</div>
<div class="col-md-6">
<label class="form-label">Gender :</label>
<b><%=gender%></b>
</div>
 <div class="col-md-6">
     <%
     String email=(String)request.getAttribute("email");
     %>
<label for="inputEmail4" class="form-label">Email :</label>
<b><%=email%></b>
</div>
</div> 
</div>
</div>


</div> 
<%
    Mentor m = (Mentor)request.getAttribute("m");
%>
<div class="row mb-5 gx-5">
<div class="col-xxl-6 mb-5 mb-xxl-0">
<div class="bg-secondary-soft px-4 py-5 rounded">
<div class="row g-3">
<h4 class="mb-4 mt-0">Experience detail</h4>
<div class="col-md-12">
<label class="form-label">Introduction :</label><br>
<b><%=m.getIntro()%></b>
</div>
<div class="col-md-12">
<label class="form-label">Skill :</label>
<%
SkillDAO sDao = new SkillDAO();
MentorSkillDAO msDao = new MentorSkillDAO();
List<Skill> listSkill = sDao.getListSkill();
List<Integer> ListSkillMentor = (List<Integer>)request.getAttribute("ListSkillMentor");
%>
 <div class="col-sm-12"> 
<%
 for(Skill s : listSkill){
%>
<%if(msDao.isExistSkill(s.getID(),ListSkillMentor)){%>
<b><%=s.getName()%></b>
<br>
<%}%>
<%}%>
</div>
</div>
<div class="col-md-12">
<label class="form-label">Experience :</label><br>
<b><%=m.getExperience()%></b>
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
<label class="form-label"><i class="fab fa-fw fa-facebook me-2 text-facebook"></i>Facebook :</label>
<b><%=p.getFacebookLink()%></b>
</div>
<div class="col-md-6">
<label class="form-label"><i class="fab fa-fw fa-instagram text-instagram me-2"></i>Instagram :</label>
<b><%=p.getInstagramLink()%></b>
</div>
</div> 
</div>
</div>
</div> 
</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
</script>
  </div>
<div oncontextmenu='return false' class='snippet-body' class="comment" >
         <div class="container mt-5 mb-5">
    <div class="row height d-flex justify-content-center align-items-center">
        <div class="col-md-7">
            <div style="height: 400px;overflow-y:auto; " class="card">
                <div class="p-3">
                    <h6>Comment about Mentor <%=p.getFullname()%></h6>
                </div>
                <div class="mt-2">
                    <%
                        List<CommentInfo> listComment = (List<CommentInfo>)request.getAttribute("listComment");
                    %>
                    <%for(CommentInfo c: listComment){%>
                    <%
                        int mi = c.getMinute();
                        String time="";
                        if (mi<60){
                        time+=mi+"m";
                        }else if(mi<1440){
                        time+=mi/60+"h";
                        }else if(mi<43200){
                        time+=mi/1440+"d";
                        }else if(mi<518400){
                        time+=mi/43200 + "month";
                        }else time+=mi/518400 +"y";
                    %>
                    <div class="d-flex flex-row p-3"> <img src=<%=c.getAvatar()%> width="40" height="40" class="rounded-circle mr-3">
                        <div class="w-100">
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="d-flex flex-row align-items-center"> <span class="mr-2"><b><%=c.getFullName()%></b></span></div> <small><%=time%> ago</small>
                            </div>
                            <p class="text-justify comment-text mb-0"><%=c.getComment()%></p>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
</div>
     <script type='text/javascript'></script>
</div>
<%
    int idMentor =(int) request.getAttribute("idmentor");
%>
<div style="text-align: center">
    <form action="detailmentor?idmentor=<%=idMentor%>" method="post">
<button type="submit" name="button" value="rate" class="btn btn-danger btn-lg">Rate and Comment</button>
<button type="submit" name="button" value="request" class="btn btn-primary btn-lg">Request</button>  
   </form>
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
