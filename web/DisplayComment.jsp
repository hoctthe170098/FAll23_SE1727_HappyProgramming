<%-- 
    Document   : DisplayComment
    Created on : Sep 28, 2023, 1:53:29 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Comment</title>
    </head>
    <body>
        <c:forEach items="${listcomment}" var="list" >
            <p>${list.username}</p>
            <br/>
            <p>${list.content}</p>
        </c:forEach>
    </body>
</html>
