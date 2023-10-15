<%-- 
    Document   : List Request BecomeMentor
    Created on : Oct 11, 2023, 1:24:30 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List BecomeMentor</title>
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
    </head>
     <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <body>
         <jsp:include page="header.jsp"></jsp:include>
       <center>
        <h1>Mentor Management</h1>
        <h2>
            <a href="/new"></a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All </a>
             
        </h2>
    </center>
         <div align="center">
        <table border="1" cellpadding="4">
            <caption><h2>List BecomeMentor</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Intro</th>
                <th>Ex</th>
                <th>Skill</th>
                
            </tr>
            <c:forEach var="becommentor" items="${listMentor}">
                <tr>
                    <td><c:out value="${becomementor.id}" /></td>
                    <td><c:out value="${account.name}" /></td>
                    <td><c:out value="${becomementor.intro}" /></td>
                    <td><c:out value="${becomementor.ex}" /></td>
                    <td><c:out value="${becomementor.skill}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${becomementor.id}' />">Accepted</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${becomementor.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
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
