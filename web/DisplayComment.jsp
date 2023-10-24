<%-- 
    Document   : home.jsp
    Created on : Sep 17, 2023, 4:18:15 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Notification</title>
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
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Manrope:wght@200&display=swap');
            @import url(http://fonts.googleapis.com/css?family=Calibri:400,300,700);
            .lastcomment{
                font-family: 'Calibri', sans-serif !important
            }
            .mt-100{
                margin-top: 100px
            }
            .mb-100{
                margin-bottom:100px
            }
            .card1{
                position: relative;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-orient: vertical;
                -webkit-box-direction: normal;
                -ms-flex-direction: column;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0px solid transparent;
                border-radius: 0px
            }
            .card-body{
                -webkit-box-flex: 1;
                -ms-flex: 1 1 auto;
                flex: 1 1 auto;
                padding: 1.25rem
            }
            .card1 .card-title{
                position: relative;
                font-weight: 600;
                margin-bottom: 10px
            }
            .comment-widgets{
                position: relative;
                margin-bottom: 10px
            }
            .comment-widgets .comment-row{
                border-bottom: 1px solid transparent;
                padding: 14px;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                margin: 10px 0
            }
            .p-2{
                padding: 0.5rem !important
            }
            .comment-text{
                padding-left: 15px
            }
            .w-100{
                width: 100% !important
            }
            .m-b-15{
                margin-bottom: 15px
            }
            .btn-sm{
                padding: 0.25rem 0.5rem;
                font-size: 0.76563rem;
                line-height: 1.5;
                border-radius: 1px
            }
            .btn-cyan{
                color: #fff;
                background-color: #27a9e3;
                border-color: #27a9e3
            }
            .btn-cyan:hover{
                color: #fff;
                background-color: #1a93ca;
                border-color: #198bbe
            }
            .comment-widgets .comment-row:hover{
                background: rgba(0, 0, 0, 0.05)
            }
            .comment {
                height: 100%
            }

            .comment {
                display: grid;
                place-items: center;
                font-family: 'Manrope', sans-serif;
                /*    background: #5fcf80;*/

            }

            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                padding: 20px;
                width: 450px;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border-radius: 6px;
                -moz-box-shadow: 0px 0px 5px 0px rgba(212, 182, 212, 1)
            }

            .comment-box{

                padding:5px;
            }



            .comment-area textarea{
                resize: none;
                border: 1px solid #ad9f9f;
            }


            .form-control:focus {
                color: #495057;
                background-color: #fff;
                border-color: #ffffff;
                outline: 0;
                box-shadow: 0 0 0 1px rgb(255, 0, 0) !important;
            }

            .send {
                color: #fff;
                background-color: #ff0000;
                border-color: #ff0000;
            }

            .send:hover {
                color: #fff;
                background-color: #f50202;
                border-color: #f50202;
            }


            .rating {
                display: flex;
                margin-top: -10px;
                flex-direction: row-reverse;
                margin-left: -4px;
                float: left;
            }

            .rating>input {
                display: none
            }

            .rating>label {
                position: relative;
                width: 19px;
                font-size: 25px;
                color: #ff0000;
                cursor: pointer;
            }

            .rating>label::before {
                content: "\2605";
                position: absolute;
                opacity: 0
            }

            .rating>label:hover:before,
            .rating>label:hover~label:before {
                opacity: 1 !important
            }

            .rating>input:checked~label:before {
                opacity: 1
            }

            .rating:hover>input:checked~label:before {
                opacity: 0.4
            }
        </style>
    </head>

    <body>

        <!-- ======= Header ======= -->
        <jsp:include page="header.jsp"></jsp:include>
        <c:choose>
            <c:when test="${account=='false'}">
            <center>
                <h3>You must sign in to do this task</h3> 
            </center>
        </c:when>
        <c:when test="${closed!='true'}">
            <center>
                <h3>You can't rate or comment for this mentor</h3>
            </center>
        </c:when>
        <c:otherwise>
            <div class="comment">
                <div class="row d-flex justify-content-center mt-100 mb-100">
                    <div class="col-lg-6">
                        <div class="card1">
                            <div class="card-body text-center">
                                <h4 class="card-title">Latest Comments</h4>
                            </div>
                            <c:if test="${listC.size()>0}">
                            <c:forEach items="listC" var="c">
                                <div class="comment-widgets">
                                    <!-- Comment Row -->
                                    <div class="d-flex flex-row comment-row m-t-0">                                   
                                        <div class="comment-text w-100">
                                            <span class="text-muted float-right">${c.time}</span> <span class="m-b-15 d-block">${c.Comment}</span>
                                            <div class="comment-footer"><button type="button" class="btn btn-danger btn-sm">Delete</button> </div>
                                        </div>
                                    </div> 
                                </div> 
                            </c:forEach>    
                            </c:if>
                        </div>
                    </div>
                    <div class="card col-lg-6">
                        <div class="row">
                            <div class="col-10">
                                <div class="comment-box ml-2">
                                    <h4>Add a comment</h4>
                                    <form action="comment" method="post">
                                        <div class="rating"> 
                                            <input type="radio" name="rating" value="5" id="5"><label for="5">☆</label>
                                            <input type="radio" name="rating" value="4" id="4"><label for="4">☆</label> 
                                            <input type="radio" name="rating" value="3" id="3"><label for="3">☆</label>
                                            <input type="radio" name="rating" value="2" id="2"><label for="2">☆</label>
                                            <input type="radio" name="rating" value="1" id="1"><label for="1">☆</label>
                                        </div>
                                        <div class="comment-area">
                                            <textarea class="form-control" name="comment" placeholder="what is your view?" rows="4" required=""></textarea>
                                        </div>
                                        <div class="comment-btns mt-2">
                                            <div class="row">
                                                <div class="col-6">
                                                    <div class="pull-right">
                                                        <button class="btn btn-success send btn-sm">Send<i class="fa fa-long-arrow-right ml-1"></i></button>      
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:otherwise>    
    </c:choose>
    <script>
        function submitForm(form) {
            swal({
                title: "Are you sure?",
                text: "This request will be deleted!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            }
            )
                    .then((isOkay) => {
                        if (isOkay) {
                            form.submit();
                        }
                    }
                    );
            return false;
        }
    </script>
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
