<%-- 
    Document   : Footer
    Created on : Sep 18, 2023, 11:06:41 AM
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
<footer id="footer">

    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-4 col-md-6 footer-contact">
            <h3>Happy Programming</h3>
            <p>
              Thach Hoa Thach That <br>
              Hoa Lac, Ha Hoi<br>
              FPTU <br><br>
              <strong>Phone:</strong>0912345678<br>
              <strong>Email:</strong> info@fpt.edu.com<br>
            </p>
          </div>

          <div class="col-lg-4 col-md-6 footer-links">
            <h4>Useful Links</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="home.jsp">Home</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="header?id=1">Mentor</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="header?id=2">Skill</a></li>
            </ul>
          </div>

          <div class="col-lg-4 col-md-6 footer-links">
            <h4>Our Skill</h4>
            <ul>
               <%for (Skill s: listSkill){%>
              <li><i class="bx bx-chevron-right"></i> <a href="#"><%=s.getName()%></a></li>
              <%}%>
            </ul>
          </div>
<!--          <div class="col-lg-4 col-md-6 footer-newsletter">
            <h4>Search</h4>
            <p>Search mentor here</p>
            <form action="" method="post">
              <input type="text" name=""><input type="submit" value="Search">
            </form>
          </div>-->
        </div>
      </div>
    </div>
<!--    <div class="container d-md-flex py-4">

      <div class="me-md-auto text-center text-md-start">
        <div class="copyright">
          &copy; Copyright <strong><span>Mentor</span></strong>. All Rights Reserved
        </div>
        <div class="credits">
           All the links in the footer should remain intact. 
           You can delete the links only if you purchased the pro version. 
           Licensing information: https://bootstrapmade.com/license/ 
           Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/ 
          Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
        </div>
      </div>
      <div class="social-links text-center text-md-right pt-3 pt-md-0">
        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
        <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
        <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
        <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
        <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
      </div>
    </div>-->
  </footer><!-- End Footer -->
