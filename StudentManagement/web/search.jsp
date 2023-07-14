<%-- 
    Document   : search
    Created on : Jun 28, 2023, 8:28:40 AM
    Author     : dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Mon's Uni</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <script src="https://kit.fontawesome.com/38998be14e.js" crossorigin="anonymous"></script>
    </head>
    <div class="header">
        <div class="header_contents">
            <div class="logo1">
                <link rel="preconnect" href="https://fonts.googleapis.com">
                <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                <link
                    href="https://fonts.googleapis.com/css2?family=Dancing+Script&family=Noto+Sans+Chakma&display=swap"
                    rel="stylesheet">
                <p style="font-family:Dancing Script">Mon's Uni</p>
                <img style="width:60px" src="album/school.png">
                <h1 style="font-family:Dancing Script">never too late to study</h1>
            </div>
            <div class="menu">
                <div class="menu1">
                    <i class="fa-solid fa-school"></i>
                    <select  class="select-box" name="links" id="" size="1" onchange="window.location.href = this.value";>
                        <option value="">School</option>
                        <option value="http://localhost:9999/StudentManagement/schoolinf.html">1.Information  </option>
                        <option value="http://localhost:9999/StudentManagement/map.html">2.Map</option>   

                    </select>
                </div>
                <div class="menu2">
                    <i class="fa-solid fa-chalkboard"></i>
                    <select  class="select-box" name="links" id="" size="1" onchange="window.location.href = this.value";>
                        <option value="">Class</option>
                        <option value="http://localhost:9999/StudentManagement/classfile.jsp">1.Class File</option>
                        <option value="http://localhost:9999/StudentManagement/subjectfile.jsp">2.Subject</option>

                    </select>
                </div>
                <div class="menu3">
                    <i class="fa-solid fa-users"></i>

                    <select  class="select-box" name="links" id="" size="1" onchange="window.location.href = this.value";>
                        <option value="">Student</option>
                        <option value="http://localhost:9999/StudentManagement/search.jsp">1.Student File</option>
                        <option value="http://localhost:9999/StudentManagement/stlist">2.Student Movement</option>
                        <option value="http://localhost:9999/StudentManagement/classpoint.jsp">3.Grade Entry</option>
                    </select>
                </div>
                <!--                    <div class="menu4">
                                        <i class="fa-solid fa-graduation-cap"></i>
                                        <select class="select-box">
                                            <option value="">Summation</option>
                                            <option value="1.">1.Spring Summation</option>
                                            <option value="1.">2.Summer Summation</option>
                                            <option value="1.">3.Fall Summation</option>
                                        </select>
                                    </div>-->
                <div class="menu5">
                    <img style="width:18px" src="album/bar-chart.png">
                    <select class="select-box">
                        <option value="">Statistics</option>
                        <option value="1.">1.Class Statistics</option>
                        <option value="1.">2.Student Statistics</option>
                        <option value="1.">3.Study Result Statistics</option>
                    </select>
                </div>
                <div class="menu6">
                    <i class="fa-sharp fa-solid fa-book-open"></i>
                    <select class="select-box">
                        <option value="">Report</option>
                        <option value="1.">1.Class Report</option>
                        <option value="1.">2.Student Report</option>
                        <option value="1.">3.Study Result Report</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="back">
        <a href="http://localhost:9999/StudentManagement/home.html">Back to main</a>
    </div>
    <form action="searchServlet" method="GET">
        <label for="search">Name:</label>
        <input type="search" name="searchName" id="search">
        <input type="submit" value="Search">
    </form>
    <div>
        <c:if test="${sessionScope.sList != null}">
            <table border="1px">
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Gender</td>
                    <td>Class Name</td>
                    <td>Average Point</td>
                </tr>

                <c:forEach items="${sessionScope.sList}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.gender}</td>
                        <td>${s.className}</td>
                        <td>
                            <fmt:formatNumber value="${s.point}" pattern="#0.00" />
                        </td>
                    </tr> 
                </c:forEach>

            </table>
        </c:if>
    </div>
</body>
</html>
