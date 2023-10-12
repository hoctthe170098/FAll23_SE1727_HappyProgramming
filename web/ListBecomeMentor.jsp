<%-- 
    Document   : List Request BecomeMentor
    Created on : Oct 11, 2023, 1:24:30 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List BecomeMentor</title>
    </head>
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
                <th>Intro</th>
                <th>Ex</th>
                <th>Skill</th>
                
            </tr>
            <c:forEach var="becommentor" items="${listMentor}">
                <tr>
                    <td><c:out value="${becomementor.id}" /></td>
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
