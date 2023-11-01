<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Page</title>
</head>
<body>
    <h1>Test Page</h1>

    <c:if test="${not empty listAllMentor}">
        <h2>List of Mentors:</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Rate</th>
                <th>Introduction</th>
            </tr>
            <c:forEach items="${listAllMentor}" var="mentor">
                <tr>
                    <td><c:out value="${mentor.ID}" /></td>
                    <td><c:out value="${mentor.fullname}" /></td>
                    <td><c:out value="${mentor.rate}" /></td>
                    <td><c:out value="${mentor.intro}" /></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty listAllMentor}">
        <p>No mentors available.</p>
    </c:if>
</body>
</html>