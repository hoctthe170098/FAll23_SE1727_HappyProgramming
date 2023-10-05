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
            .comment-box{
                width: 50%;
                border: 1px solid #ccc;
                margin: 50px 0;
                padding: 10px 20px;
                font-family: 'poppins', sans-serif;
                border-radius: 5px;
                margin-left: 25%;
                margin-top: 80px;
                box-shadow: 0px 0px 10px 1px rgb(165, 165, 165);
                
            }
            .comment-box p{
                text-align: left;
                font-size: 28px;
                color: #777;
            }
            .comment-form input, .comment-form textarea{
                width: 100%;
                padding: 10px;
                margin: 5px 0;
                box-sizing: border-box;
                outline: none;
                font-size: 18px;
                font-family: 'poppins', sans-serif;
                border: 1px solid #ddd;
                color: #777;
            }
            .comment-form button{
                margin: 10px 0;
                border: none;
                background-color: #d0d0d0;
                padding: 10px;
                font-size: 18px;
                border-radius: 3px;
                color: #444;
                
            }
            button:hover{
                color: #white;
                background-color: #444;
            }
            @media(max-width:900px){
                .comment-box{
                    width: 80%;
                    margin: 5%;
                }
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
        <div class ="comment-box">
            <p>Leave a comment</p>
            <form class="comment-form">
                <input type="text" placeholder="Name"><!-- comment -->
                <textarea rows="10" placeholder="Write your comment"></textarea>
                <button type="submit">Post Comment</button>
            </form>
        </div>

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
