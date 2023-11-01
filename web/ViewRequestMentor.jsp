<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <title>Request Mentor</title>
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
        
	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="assets/css/style.css">
        <style>
            .block-27 ul {
  padding: 0;
  margin: 0; }
  .block-27 ul li {
    display: inline-block;
    margin-bottom: 4px;
    font-weight: 400; }
    .block-27 ul li a, .block-27 ul li span {
      color: gray;
      text-align: center;
      display: inline-block;
      width: 40px;
      height: 40px;
      line-height: 40px;
      border-radius: 50%;
      border: 1px solid #e6e6e6; }
    .block-27 ul li.active a, .block-27 ul li.active span {
      background: #4ba1fa;
      color: #fff;
      border: 1px solid transparent; }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">					
					<div class="table-wrap">
						<table class="table">
					    <thead class="thead-primary">
					      <tr>
					        <th>Number</th>
					        <th>Title</th>
					        <th>Date</th>
					        <th>From</th>
					        <th>To</th>
					        <th>Actions</th>
					      </tr>
					    </thead>
					    <tbody>
                                                <%int count=1;%>
                                           <c:forEach items="${listReq}" var="r">
                                               <tr>
					        <th scope="row" class="scope" ><%=count++%></th>
					        <td>${r.title}</td>
					        <td>${r.date}</td>
					        <td>${r.from}</td>
					        <td>${r.to}</td>
					        <td>
                                                <a href="detailrequestmentor?idrequest=${r.ID}" class="btn btn-primary">Detail</a>
                                                </td>
					      </tr>                                               
                                            </c:forEach>					     					  					
					    </tbody>
					  </table>
					</div>
				</div>
			</div>
             <div class="block-27">
              <ul>
                  <c:if test="${index>1}">
                    <li><a href="listrequestmentor?status=${status}&index=${index-1}">&lt;</a></li>
                  </c:if>          
                <c:forEach var="i" begin="1" end="${page}">
                    <c:choose>
                        <c:when test="${index==i}">
                         <li class="active"><span><a href="listrequestmentor?status=${status}&index=${i}">${i}</a></span></li>    
                        </c:when>
                        <c:otherwise>
                            <li><span><a href="listrequestmentor?status=${status}&index=${i}">${i}</a></span></li>     
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${index<page}">
                    <li><a href="listrequestmentor?status=${status}&index=${index+1}">&gt;</a></li>
                  </c:if>            
              </ul>
            </div>
		</div>
	</section>
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
