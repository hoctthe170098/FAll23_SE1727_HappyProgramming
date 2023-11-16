<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
<head>
    
     <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>List Skill</title>
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
    </style>
</head>
<body>
     <jsp:include page="header.jsp"></jsp:include>
    <h1>Manage Skill</h1>
    <P>ToTal Skill: ${totalSkill}</P>
    <div class="container-fluid mb-20" >
         <div class="btn-container">
        <a style = "background-color:#007aff "class="btn btn-outline-danger" href="createskill"><i class="bi bi-plus"></i> Create Skill</a>
        
    </div>  
        
    <table border="1">
        <tr>
            
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
            <th>Options</th>
        </tr>
        <c:forEach items="${skillList}" var="skill">
            <tr>
                
                <td>${skill.name}</td>
                <td style="width: 700px;">${skill.description}</td>
                <td><img src="${skill.image}" width="50" height="50" alt="${skill.name}"></td>
                <td>
                    <a style= "background-color: yellowgreen " class="btn btn-outline-danger" href="editskill?editSkillID=${skill.ID}"><i class="bi bi-pencil"></i> Edit</a>
                    <a style = " background-color: red"class="btn btn-outline-danger" onclick ="Delete(${skill.ID})" style="padding: 6px"><i class="bi bi-trash"></i>Delete</a></td>
                </td>
            </tr>
        </c:forEach>
    </table>
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
