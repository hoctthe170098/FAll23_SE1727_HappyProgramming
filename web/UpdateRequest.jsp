<%-- 
    Document   : UpdateRequest
    Created on : Oct 16, 2023, 2:15:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <title>Update Request</title>
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
        <style type="text/css">
            .profile{margin-top:20px;
color: #9b9ca1;
}
.profile .bg-secondary-soft {
    background-color: rgba(208, 212, 217, 0.1) !important;
}
.profile .rounded {
    border-radius: 5px !important;
}
.profile .py-5 {
    padding-top: 3rem !important;
    padding-bottom: 3rem !important;
}
.profile .px-4 {
    padding-right: 1.5rem !important;
    padding-left: 1.5rem !important;
}
.profile .file-upload .square {
    height: 250px;
    width: 250px;
    margin: auto;
    vertical-align: middle;
    border: 1px solid #e5dfe4;
    background-color: #fff;
    border-radius: 5px;
}
.profile .text-secondary {
    --bs-text-opacity: 1;
    color: rgba(208, 212, 217, 0.5) !important;
}
.profile .btn-success-soft {
    color: #28a745;
    background-color: rgba(40, 167, 69, 0.1);
}
.profile .btn-danger-soft {
    color: #dc3545;
    background-color: rgba(220, 53, 69, 0.1);
}
.profile .form-control {
    display: block;
    width: 100%;
    padding: 0.5rem 1rem;
    font-size: 0.9375rem;
    font-weight: 400;
    line-height: 1.6;
    color: #29292e;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #e5dfe4;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    border-radius: 5px;
    -webkit-transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
    transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
        </style>
    </head>
    <body>
        <!-- ======= Header ======= -->
       <jsp:include page="header.jsp"></jsp:include>
                  <div class="profile">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
<div class="container">
<div class="row">
<div class="col-12">
<div class="my-5">
<h3 style="text-align: center">Update Request</h3>
<hr>
</div>
    <%
        Request r = (Request)request.getSession().getAttribute("request");
    %>
<%
    String msgE = (String)request.getAttribute("msgE");
%>
<%if(msgE!=null){%>
<p style="color: red" class="text-danger"><%=msgE%></p>
<%}%>
<form class="file-upload" action="updateordeleterequest" method="post" onsubmit="return submitForm(this)">
    
<div class="row mb-5 gx-5">

<div class="col-xxl-8 mb-5 mb-xxl-0">
<div class="bg-secondary-soft px-4 py-5 rounded">
<div class="row g-3">
<h4 class="mb-4 mt-0">Update details</h4>

<div class="col-md-12">
<label class="form-label">Title *</label>
<input type="text" name="title" class="form-control" placeholder aria-label="Title" value="<%=r.getTitle()%>" required>
</div>

<div class="col-md-6">
    <%
        String msgD = (String)request.getAttribute("msgD");
    %>
    <%if(msgD!=null){%>
    <label class="form-label">Date *<span style="color:red"><%=msgD%></span></label>
    <%}%>
    <%if(msgD==null){%>
    <label class="form-label">Date *</label>
    <%}%>
    <input type="date" name="date" class="form-control" placeholder aria-label="Date" value=<%=r.getDate()%> required>
</div>
<div class="col-md-3">
<label class="form-label">From *</label>
<input type="number" name="from" class="form-control" min="8" max="20" step="0.5" value=<%=r.getFrom()%> required>
</div>
 <div class="col-md-3">
<label class="form-label">To *</label>
<input type="number" name="to" class="form-control" min="10" max="22" step="0.5" value=<%=r.getTo()%> required>
</div>
<div class="col-md-12">
    <%
        String msgS = (String)request.getAttribute("msgS");
    %>
    <%if(msgS!=null){%>
    <label class="form-label">Skill *<span style="color:red"><%=msgS%></span></label>
    <%}%>
    <%if(msgS==null){%>
    <label class="form-label">Skill *</label>
    <%}%>
<div>
<%      
        int idMentor = r.getIDMentor();
        MentorSkillDAO msDAO = new MentorSkillDAO();
        SkillDAO sDAO = new SkillDAO();
        MentorSkill mentorSkill = msDAO.getSkillByName(idMentor);
        List<Skill> listSkill = sDAO.getListSkill();
        HashMap<Integer,String> hSkill = new HashMap<>();
        for (Skill s: listSkill){
            if(msDAO.isExistSkill(s.getID(), mentorSkill.getListSkillID())) hSkill.put(s.getID(), s.getName());
        }
        Set<Integer> key = hSkill.keySet();
%>
<%
    for(int id: key){
%>
<%if(id==r.getIDSkill()){%>
<input style="margin-right:5px" type="radio" name="idskill" value=<%=id%> checked /><span style="margin-right: 15px"><b><%=hSkill.get(id)%></b></span>
<%}%>
<%if(id!=r.getIDSkill()){%>
<input style="margin-right:5px" type="radio" name="idskill" value=<%=id%> /><span style="margin-right: 15px"><b><%=hSkill.get(id)%></b></span>
<%}%>
<%}%>
</div>
</div>
<div class="col-md-9">
<label class="form-label">Address *</label>
<input type="text" name="address" class="form-control" placeholder aria-label="Address" value="<%=r.getAddress()%>" required>
</div>
<div class="col-md-3">
<label class="form-label">Can pay *</label>
<input type="number" min="10" name="money" class="form-control" placeholder aria-label="Address" value=<%=r.getMoney()%> required>
</div>
<div class="col-md-12">
<label class="form-label">Detail *</label>
<textarea class="form-control" rows="3" name="detail" id="ex" required><%=r.getDetails()%></textarea>   
</div>
</div> 
</div>
</div>
</div> 
<div style="text-align: center">
    <button type="submit" class="btn btn-primary btn-lg">Update Request</button>
</div>
<!--</div>-->
</form> 
<script src="assets/js/sweetalert.min.js"></script>
<script>
    function submitForm(form){
        swal({
            title: "Are you sure?",
            text: "This request will be updated, If this is a accepted request, a notification will sent to mentor",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }             
            )
            .then((isOkay) =>{
                if(isOkay){
                    form.submit();
                }
            }
            );
    return false;
    }
</script>
</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
</script>
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
