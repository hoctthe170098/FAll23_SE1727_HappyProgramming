<%-- 
    Document   : home.jsp
    Created on : Sep 17, 2023, 4:18:15 PM
    Author     : Admin
--%>

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
           <style>@import url(https://fonts.googleapis.com/css?family=Roboto:300,400,700&display=swap);

.snippet-body {
    font-family: "Roboto", sans-serif;
    background: #EFF1F3;
    min-height: 100vh;
    position: relative;
}

.snippet-body .section-50 {
    padding: 50px 0;
}

.snippet-body .m-b-50 {
    margin-bottom: 50px;
}

.snippet-body .dark-link {
    color: #333;
}

.snippet-body .heading-line {
    position: relative;
    padding-bottom: 5px;
}

.snippet-body .heading-line:after {
    content: "";
    height: 4px;
    width: 75px;
    background-color: #29B6F6;
    position: absolute;
    bottom: 0;
    left: 0;
}

.snippet-body .notification-ui_dd-content {
    margin-bottom: 30px;
}

.snippet-body .notification-list {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: justify;
    -ms-flex-pack: justify;
    justify-content: space-between;
    padding: 20px;
    margin-bottom: 7px;
    background: #fff;
    -webkit-box-shadow: 0 3px 10px rgba(0, 0, 0, 0.06);
    box-shadow: 0 3px 10px rgba(0, 0, 0, 0.06);
}

.snippet-body .notification-list--unread {
    border-left: 2px solid #29B6F6;
}

.snippet-body .notification-list .notification-list_content {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
}

.snippet-body .notification-list .notification-list_content .notification-list_img img {
    height: 48px;
    width: 48px;
    border-radius: 50px;
    margin-right: 20px;
}

.snippet-body .notification-list .notification-list_content .notification-list_detail p {
    margin-bottom: 5px;
    line-height: 1.2;
}

.snippet-body .notification-list .notification-list_feature-img img {
    height: 48px;
    width: 48px;
    border-radius: 5px;
    margin-left: 20px;
}</style>
           <script type='text/javascript' src=''></script>
                                <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>
                                <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js'></script>
    </head>

    <body>
        
        <!-- ======= Header ======= -->
        <jsp:include page="header.jsp"></jsp:include>
        <div oncontextmenu='return false' class='snippet-body'>
            <section class="section-50">
    <div class="container">
        <h3 class="m-b-50 heading-line">Notifications <i class="fa fa-bell text-muted"></i></h3>

        <div class="notification-ui_dd-content">
            <%
                List<Notification> list = (List<Notification>)request.getAttribute("list");
                int number=1;
            %>
            <%for(Notification n:list){%>
            <div class="notification-list notification-list--unread">
                <div class="notification-list_content">
                    <div class="notification-list_detail">
                        <h5 class="text-muted"><%=number++%></h5>
                    </div>
                    <div class="notification-list_img">
                        <img src=<%=n.getAvatarSender()%> alt="user">
                    </div>
                    <div class="notification-list_detail">
                        <%
                            String nameSender="";
                            if(n.getRoleSender()==1){
                            nameSender = "admin";
                            }
                            if(n.getRoleSender()==2){
                            nameSender = "Mentor "+n.getNameSender();
                            }
                            if(n.getRoleSender()==3){
                            nameSender = "Mentee "+n.getNameSender();
                            }
                        %>
                        <p><b><%=nameSender%></b> sent to you</p>
                        <p class="text-muted"><%=n.getContent()%></p>
                         <%
                        int mi = n.getMinute();
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
                        <p class="text-muted"><small><%=time%> ago</small></p>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
        <div class="text-center">
            <%
                int count = list.size()+4;
            %>
            <a href="shownofication?count=<%=count%>" class="dark-link">Load more activity</a>
        </div>

    </div>
</section>
                            <script type='text/javascript'></script>
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
