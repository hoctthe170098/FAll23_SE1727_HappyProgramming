<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
<head>
    <title>List of Skills</title>
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
    </style>
</head>
<body>
    <h1>Manage Skill</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
            <th>Options</th>
        </tr>
        <c:forEach items="${skillList}" var="skill">
            <tr>
                <td>${skill.ID}</td>
                <td>${skill.name}</td>
                <td style="width: 700px;">${skill.description}</td>
                <td><img src="${skill.image}" width="50" height="50" alt="${skill.name}"></td>
                <td>
                    <a class="btn btn-outline-danger" href="UpdateSkill?id=${skill.ID}" style="padding: 6px;margin-right: 5px"><i class="bi bi-trash"></i>Edit</a>
                    <a class="btn btn-outline-danger" onclick ="Delete(${skill.ID})" style="padding: 6px"><i class="bi bi-trash"></i>Delete</a></td>
                </td>
            </tr>
        </c:forEach>
    </table>
 <div class="btn-container">
        <a class="btn btn-outline-danger" href="createskill"><i class="bi bi-plus"></i> Create Skill</a>
        <a class="btn btn-outline-danger" href="home.jsp"><i class="bi bi-plus"></i> Back to home</a>
    </div>    
    <div id="editForm" style="display: none;">
        <h2>Edit Skill</h2>
        <form action="editskill" method="post">
            <input type="hidden" id="editSkillID" name="skillID">
            <label for="editSkillName">Name:</label>
            <input type="text" id="editSkillName" name="skillName" required><br><br>

            <label for="editSkillImage">Image:</label>
            <input type="file" id="editSkillImage" name="skillImage" accept="image/*">

            <label for="editSkillDescription">Description:</label><br>
            <textarea id="editSkillDescription" name="skillDescription" rows="4" required></textarea><br><br>
            <p class="text-danger">${mess}</p>
            <input type="submit" value="Save">
        </form>
            
    </div>

<script>
       function Delete(ID){
           var option = confirm('Are you sure to delete?');
           if(option === true) {
               window.location.href = 'DeleteSkill?ID=' + ID;
           }
       }
   </script>
</body>
</html>
