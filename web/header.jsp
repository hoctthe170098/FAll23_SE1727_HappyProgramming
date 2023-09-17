<%-- 
    Document   : header
    Created on : Sep 17, 2023, 4:20:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<%
  SkillDAO SkillDAO = new SkillDAO();  
  Account acc = (Account)request.getSession().getAttribute("acc");  
  List<Skill> listSkill = SkillDAO.getListSkill();
%>   
<header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

        <h1 class="logo me-auto"><a href="home.jsp">Mentor</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

        <nav id="navbar" class="navbar order-last order-lg-0">
            <ul>
                <li><a class="active" href="index.html">Home</a></li>
                <li><a href="">Mentor</a></li>
                <li><a href="courses.html">Skills</a></li>
                <li><a href="trainers.html">Trainers</a></li>
                <li><a href="events.html">Events</a></li>
                <li><a href="pricing.html">Pricing</a></li>
                <li class="dropdown"><a href="#"><span>Suggest Mentor</span> <i class="bi bi-chevron-down"></i></a>
                    <ul>
                        <!--              <li><a href="#">Drop Down 1</a></li>
                                      <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                                        <ul>
                                          <li><a href="#">Deep Drop Down 1</a></li>
                                          <li><a href="#">Deep Drop Down 2</a></li>
                                          <li><a href="#">Deep Drop Down 3</a></li>
                                          <li><a href="#">Deep Drop Down 4</a></li>
                                          <li><a href="#">Deep Drop Down 5</a></li>
                                        </ul>
                                      </li>
                                      <li><a href="#">Drop Down 2</a></li>
                                      <li><a href="#">Drop Down 3</a></li>
                                      <li><a href="#">Drop Down 4</a></li>-->
                        <%for (Skill s: listSkill){%>
                        <li><a href="#"><%=s.getName()%></a></li> 
                            <%}%>
                    </ul>
                </li>

                <!--          <li class="dropdown"><a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>
                            <ul>
                              <li><a href="#">Drop Down 1</a></li>
                              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                                <ul>
                                  <li><a href="#">Deep Drop Down 1</a></li>
                                  <li><a href="#">Deep Drop Down 2</a></li>
                                  <li><a href="#">Deep Drop Down 3</a></li>
                                  <li><a href="#">Deep Drop Down 4</a></li>
                                  <li><a href="#">Deep Drop Down 5</a></li>
                                </ul>
                              </li>
                              <li><a href="#">Drop Down 2</a></li>
                              <li><a href="#">Drop Down 3</a></li>
                              <li><a href="#">Drop Down 4</a></li>
                            </ul>
                          </li>-->
                <li><a href="contact.html">Contact</a></li>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->

        <a href="courses.html" class="get-started-btn">Get Started</a>

    </div>
</header><!-- End Header -->

