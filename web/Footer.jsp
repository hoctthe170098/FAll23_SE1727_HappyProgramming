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
              <li><i class="bx bx-chevron-right"></i> <a href="home">Home</a></li>
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
        </div>
      </div>
    </div>
  </footer><!-- End Footer -->
