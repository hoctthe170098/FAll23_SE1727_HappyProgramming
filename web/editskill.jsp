<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Import the necessary libraries --%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Skill</title>
     <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 20px;
                background-color: #f0f0f0;
            }

            h1 {
                text-align: center;
            }

            form {
                max-width: 500px;
                margin: 0 auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            label {
                display: block;
                margin-bottom: 8px;
            }

            input[type="text"],
            input[type="file"],
            textarea {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            textarea {
                height: 100px;
            }

            input[type="submit"],
            .hover-button {
                background-color: #007bff;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            input[type="submit"]:hover,
            .hover-button:hover {
                background-color: #0056b3;
            }
        </style>
</head>
<body>
    

    <h1>Edit Skill</h1>
<form action="editskill?editSkillID=${skillID}" method="post" enctype="multipart/form-data">
    <label >ID:${skillID}</label>
    <input type="hidden" id="skillID" name="editSkillID" value="${skillID}">
    
    <label for="editSkillName">Name:</label>
    <input type="text" id="editSkillName"id="editSkillName"" value="${skillName}" required><br><br>

    <label for="editSkillImage">Current Image:</label>
   
    <input type="hidden" name="currentSkillImage" value="${skillImage}">
    
    <img src="${skillImage}" alt="CurrentImage" width="200">
   
     <label for="skillImage">Update Image:</label>
     
            <input type="file" id="skillImage" name="skillImage" accept="image/png, image/gif, image/jpeg" >
     
    <label for="editSkillDescription">Description:</label><br>
    <textarea id="editSkillDescription" name="skillDescription" rows="4" required>${skillDescription}</textarea><br><br>
    <input type="submit" value="Save">
</form>

    
  
</body>
</html>
