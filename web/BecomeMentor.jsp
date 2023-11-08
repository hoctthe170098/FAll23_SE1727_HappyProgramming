<%-- 
    Document   : BecomeMentor
    Created on : Oct 1, 2023, 9:58:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Become a mentor?</title>
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
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>
            .contact{
                padding: 4%;

            }
            .col-md-3{
                background: limegreen;
                padding: 4%;
                border-top-left-radius: 0.5rem;
                border-bottom-left-radius: 0.5rem;
            }
            .contact-info{
                margin-top:10%;
            }
            .contact-info img{
                margin-bottom: 15%;
            }
            .contact-info h2{
                margin-bottom: 10%;
            }
            .col-md-9{
                background: #fff;
                padding: 3%;
                border-top-right-radius: 0.5rem;
                border-bottom-right-radius: 0.5rem;
            }
            .contact-form label{
                font-weight:600;
            }
            .contact-form button{
                background: #25274d;
                color: #fff;
                font-weight: 600;
                width: 25%;
            }
            .contact-form button:focus{
                box-shadow:none;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
        boolean isExist = (boolean)request.getAttribute("isExistProfile");
        %>
        <%
            if(!isExist){
        %>
        <div><h2 style="text-align: center">You must update profile if want to become a mentor</h2></div>
        <%}%>
        <%
            if(isExist){
            BecomeMentor bm = (BecomeMentor)request.getAttribute("BecomeMentor");
            if(bm!=null){
        %>
        <div><h2 style="text-align: center">Your request has been sent and is awaiting approval</h2></div>
        
            <div class="container contact">
                <div class="row">
                    <div class="col-md-3">
                        <div class="contact-info">
                            <img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
                            <h2 style="color: white">Become a mentor?</h2>
                            <h4 style="color: white">Give us some information if you want become a mentor</h4>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="contact-form">

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Introduction:</label>
                                <div class="col-sm-10">
                                    <%=bm.getIntro()%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Reason :</label>
                                <div class="col-sm-10">
                                    <%=bm.getReason()%>
                                </div>
                            </div>   
                            <%
                              String skill=bm.getSkill()[0];
                              for(int i=1;i<bm.getSkill().length;i++){
                              skill+=", "+bm.getSkill()[i];
                              }
                            %>
                            <div class="form-group">
                                <div class="col-sm-10">
                                   Skill: <%=skill%>
                                </div>
                              
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Experience:</label>
                                <div class="col-sm-10">
                                    <%=bm.getEx()%>
                                </div>
                            </div>
                                <form action="becomementor" method="post" name="formdelete">
                            <div class="form-group">        
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" name="button" value="delete" class="btn btn-default" onclick="return submitForm(document.forms['formdelete'])">Delete Request</button>
                                </div>
                            </div>
                                </form>
                                <script src="assets/js/sweetalert.min.js"></script>
<script>
    function submitForm(form){
        swal({
            title: "Are you sure?",
            text: "This request will be deleted!",
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
            </div>
        
        <%}%>
        <%if(bm==null){%>

        <form action="becomementor" method="get">
            <div class="container contact">
                <div class="row">
                    <div class="col-md-3">
                        <div class="contact-info">
                            <img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
                            <h2 style="color: white">Become a mentor?</h2>
                            <h4 style="color: white">Give us some information if you want become a mentor</h4>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="contact-form">

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Introduction:</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="3" name="intro" id="intro" required></textarea>
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Reason:</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="3" name="reason" id="intro" required></textarea>
                                </div>
                            </div>
                            <%
                               SkillDAO sDao = new SkillDAO();
                               List<Skill> listSkill = sDao.getListSkill();
                            %>
                            <div class="form-group">
                                <label class="control-label col-sm-10">Skill(you must choose at least one skill):<span style="color:red">${msgS}</span></label>
                                <div class="col-sm-10"> 
                                    <%
                                        for(Skill s:listSkill){
                                    %>
                                    <input type="checkbox"  name="skill" value=<%=s.getName()%> <%=(s.getID()==1)?"checked":""%>/> <%=s.getName()%>
                                    <%}%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Experience:</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" name="ex" id="ex" required></textarea>
                                </div>
                            </div>
                            <div class="form-group">        
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" name="button" value="register" class="btn btn-default">Register</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <%}%>
        <%}%>
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
