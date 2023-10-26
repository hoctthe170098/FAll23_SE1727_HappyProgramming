<%-- 
    Document   : mentoradmin
    Created on : Oct 24, 2023, 11:17:53 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>List of Mentor</title>
       
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
    <style>
        h1 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px auto;
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:nth-child(odd) {
            background-color: #fff;
        }

        .btn {
            text-decoration: none;
            background-color: #007bff;
            color: white;
            padding: 6px 12px;
            margin-right: 5px;
            border: none;
            border-radius: 4px;
        }
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
          <jsp:include page="header.jsp"></jsp:include>
          
      <h1>Manage Mentor</h1>
     
    <table border="1">
        <tr>
            <th>FullName</th>
            <th>Rate</th>
            <th>Image</th>
            <th>Intro</th>
            <th>Facebook</th>
            <th>Instagram</th>
            <th>Options</th>
        </tr>
        <c:forEach items="${mentorlist}" var="mentor">
    <tr>
        <td>${mentor.fullname}</td>
        <td style="width: 700px;">${mentor.rate}</td>
        <td><img style="height: 125px; width: 125px" src="${mentor.avatar}" class="img-fluid" alt=""></td>
        <td>${mentor.intro}</td>
        <td> <a  href="${mentor.facebook}"><i class="bi bi-facebook custom-icon"></i></a></td>
        <td><a href="${mentor.inta}"><i class="bi bi-instagram custom-instagram-icon"></i></a></td>
        <td>
            
            <a style = " background-color: red" class="btn btn-outline-danger" onclick="Delete(${mentor.ID})" style="padding: 6px"><i class="bi bi-trash"></i>Delete</a>
        </td>
    </tr>
</c:forEach>
    </table>
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
                            <script>
       function Delete(ID){
           var option = confirm('Are you sure to delete?');
           if(option === true) {
               window.location.href = 'Deletementor?ID=' + ID;
           }
       }
   </script>
</body>

</html>
