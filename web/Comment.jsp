<%-- 
    Document   : Comment
    Created on : Sep 28, 2023, 12:30:07 AM
    Author     : admin
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comment</title>
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

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
        <style>
           .colorful-form {
                margin-top: 40px;
                max-width: fit-content;
                margin: 40px auto;
                padding: 20px;
                background-color: #f5f5f5;
                border-radius: 10px;
            }

            .form-group {

                margin-bottom: 20px;
            }

            .form-label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
                color: #333;
            }

            .form-input {
                width: 400px;
                padding: 10px;
                border: none;
                background-color: #fff;
                color: #333;
                border-radius: 5px;
            }

            textarea.form-input {
                height: 100px;
            }

            .form-button {
                display: block;
                width: 100%;
                padding: 10px;
                background-color: #ff6f69;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .form-button:hover {
                background-color: #ff5f59;
            }
        </style>
        <!-- MDB -->
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <script type ="text/javascript ">
                function content(){
                var xhttp;
                var username = document.myform.Username.value;
                var content = document.myform.Content.value;
                var url = "CommentController?Content="+content+"&Username"+username;

                if (window.XMLHttpRequest)
                {
                xhttp = new XMLHttpRequest();
                } else{
                xhttp = new AtiveXObject("Microsoft.XMLHTTP");
                }


                xhttp.onreadystatachange = function(){
                if(xhttp.readyState == 4)
                {
                var data = xhttp.responseText;
                document.getElementById(" ").innerHTML = data;
                }

                }
                xhttp.open("POST",url,true);
                http.send();
                }
            </script>

        </head>
    <body>
        <form action="myform">
            Username: <input type="text" name="Username"/>
            <br/>
            <br/>
            <textarea style="width: 300px; height: 100px " name="Content">
                
            </textarea>
            <br/> 
            <br/> 
            <input type="button" value="Post" onclick=""/>

        </form>

    </body>
    <div id="mycomment">

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
