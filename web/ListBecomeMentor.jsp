<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>List Become Mentor</title>
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
                background-color: #5fcf80;
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

                color: white;
                padding: 6px 12px;
                margin-right: 5px;
                border: none;
                border-radius: 4px;
            }
            .block-27 ul {
                padding: 0;
                margin: 0;
            }
            .block-27 ul li {
                display: inline-block;
                margin-bottom: 4px;
                font-weight: 400;
            }
            .block-27 ul li a, .block-27 ul li span {
                color: gray;
                text-align: center;
                display: inline-block;
                width: 40px;
                height: 40px;
                line-height: 40px;
                border-radius: 50%;
                border: 1px solid #e6e6e6;
            }
            .block-27 ul li.active a, .block-27 ul li.active span {
                background: #4ba1fa;
                color: #fff;
                border: 1px solid transparent;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <h1>List Register to Become Mentor</h1>

            <div class="container-fluid mb-20" >      
                <table border="1">
                    <tr>

                        <th>Name</th>
                        <th>Reason</th>
                        <th>CV</th>
                        <th>Actions</th>
                    </tr>
                <c:forEach items="${listCV}" var="cv">
                    <tr>
                        <td>${cv.getP().getFullname()}</td>
                        <td style="width: 700px;">${cv.getReason()}</td>
                        <td><b><a href="viewcvmentee?idmentee=${cv.getID()}">CV</a></b></td>
                        <td>
                            <a style= "background-color: yellowgreen " class="btn btn-outline-danger" onclick="return Accept(${cv.getID()})"><i class="bi bi-pencil"></i>Accept</a>
                            <a style = " background-color: red"class="btn btn-outline-danger" onclick="return Reject(${cv.getID()})" style="padding: 6px"><i class="bi bi-trash"></i>Reject</a></td>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="block-27">
            <ul>
                <c:if test="${index>1}">
                    <li><a href="listbecomementor?index=${index-1}">&lt;</a></li>
                    </c:if>          
                    <c:forEach var="i" begin="1" end="${page}">
                        <c:choose>
                            <c:when test="${index==i}">
                            <li class="active"><span><a href="listbecomementor?index=${i}">${i}</a></span></li>    
                                    </c:when>
                                    <c:otherwise>
                            <li><span><a href="listbecomementor?index=${i}">${i}</a></span></li>     
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <c:if test="${index<page}">
                    <li><a href="listbecomementor?index=${index+1}">&gt;</a></li>
                    </c:if>            
            </ul>
        </div>
        <script src="assets/js/sweetalert.min.js"></script>
        <script>
                                function Accept(ID) {
                                    swal({
                                        title: "Are you sure?",
                                        text: "This mentee will become a mentor!",
                                        icon: "warning",
                                        buttons: true,
                                        dangerMode: true,
                                    }
                                    )
                                            .then((isOkay) => {
                                                if (isOkay) {
                                                    window.location.href = 'actionadminregisterbecomementor?action=accept&ID=' + ID;
                                                }
                                            }
                                            );
                                    return false;
                                }
        </script>
        <script>
                                function Reject(ID) {
                                    swal({
                                        title: "Are you sure?",
                                        text: "This mentee will get out of list register to become a mentor!",
                                        icon: "warning",
                                        buttons: true,
                                        dangerMode: true,
                                    }
                                    )
                                            .then((isOkay) => {
                                                if (isOkay) {
                                                    window.location.href = 'actionadminregisterbecomementor?action=reject&ID=' + ID;
                                                }
                                            }
                                            );
                                    return false;
                                }
        </script>
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
