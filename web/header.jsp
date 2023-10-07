<%-- 
    Document   : header
    Created on : Sep 17, 2023, 4:20:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<%

// Khai báo biến 
Cookie[] cookies = request.getCookies();

// Kiểm tra xem có cookie loginRemember không
if (cookies != null) {
  for (Cookie cookie : cookies) {
    if (cookie.getName().equals("loginRemember")) {
      
      // Lấy dữ liệu từ cookie
      String[] arr = cookie.getValue().split(":");
      String username = arr[0];
      String password = arr[1];
      
      // Kiểm tra trong CSDL
      AccountDAO db = new AccountDAO();
      Account account = db.getAccountBy(username, password);
      
      // Lưu vào session và chuyển hướng
      if (account != null) {
        request.getSession().setAttribute("acc", account);
        response.sendRedirect("home.jsp");  
      }
    }
  }
} 



        %>
<%
  SkillDAO SkillDAO = new SkillDAO();  
  Account acc = (Account)request.getSession().getAttribute("acc");  
  List<Skill> listSkill = SkillDAO.getListSkill();
  String sID1=(String)request.getAttribute("id1");
  String sID2=(String)request.getAttribute("id2");
  
%>   

<header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

        <h1 class="logo me-auto"><a href="home.jsp">Happy Programming</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

        <nav id="navbar" class="navbar order-last order-lg-0">
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="header?id=1">Mentor</a></li>
                <li><a href="header?id=2">Skills</a></li>              
                <li class="dropdown"><a href="#"><span>Suggest Mentor</span> <i class="bi bi-chevron-down"></i></a>
                    <ul>
                        <%for (Skill s: listSkill){%>
                        <li><a href="#"><%=s.getName()%></a></li> 
                            <%}%>
                    </ul>
                </li>
                <%if (acc!=null){%>
                <%if(acc.getIsMentee()==1){%>
                <li><a href="profile">Profile</a></li>
                <li><a href="">Request</a></li>
                <li><a href="becomementor">Become mentor</a></li>
                    <%}%>
                    <%if(acc.getIsMentor()==1){%>
                <li class="dropdown"><a href="#"><span>Request</span> <i class="bi bi-chevron-down"></i></a>
                    <ul>
                        <li><a href="">Invited</a></li>
                        <li><a href="">Eccepted</a></li>
                        
                    </ul>
                </li>
                <li><a href="updatecvmentor">CV</a></li>
                <%}%>
                <%if(acc.getIsAdmin()==1){%>
                <li class="dropdown"><a href="#"><span>Static</span> <i class="bi bi-chevron-down"></i></a>
                    <ul>
                        <li><a href="">Mentee</a></li>
                        <li><a href="">Mentor</a></li>
                    </ul>
                   </li> 
                <li><a href="">List Mentor</a></li> 
                 <li class="dropdown"><a href="#"><span>Skill</span> <i class="bi bi-chevron-down"></i></a>
                    <ul>
                        <li><a href="">List Skill</a></li>
                        <li><a href="">Create Skill</a></li>
                    </ul>
                   </li> 
                </li>
                <%}%>
                <%}%>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->
        <%if(acc==null){%>
        <a href="login" class="get-started-btn">Sign in</a>
        <%}%>
        <%if(acc!=null){%>
<!--        <a href="#" class="get-started-btn"><%=acc.getUsername()%></a>-->
        <a href="logout" class="get-started-btn">Log out</a>
        <%}%>
    </div>
</header><!-- End Header -->
<section id="hero" class="d-flex justify-content-center align-items-center">
    <div class="container position-relative" data-aos="zoom-in" data-aos-delay="100">
        <%if(sID1==null&&sID2==null){%>
        <h1>WELCOME TO HAPPY PROGRAMMING</h1>      
        <%}%>
        <%if(sID1!=null){ %>     
        <h1>WHAT ARE YOU LOOKING FOR?</h1>      
      <form class="d-flex" action="/happyprogramming/searchmentor" method="post">
    <input class="form-control mr-2" type="search" placeholder="Search mentor here" aria-label="Search" name="name">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
      <%}%>
        <%if(sID2!=null){%>
        <h1>WHAT ARE YOU LOOKING FOR?</h1>      
        <form class="d-flex" action="searchskill" method="post"> 
      <input class="form-control mr-2" type="search" placeholder="Search skill here" aria-label="Search" name="nameskill"> 
      <button class="btn btn-outline-success" type="submit">Search</button> </form>
        <%}%>
        
    </div>
</section>

