<%-- 
    Document   : class
    Created on : Jul 3, 2023, 6:12:46 PM
    Author     : DELL
--%>
<%@page import="model.student"%>
<%@page import="java.util.List"%>

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
    <body>
        <div class="header">
            <div class="header_contents">
                <div class="logo1">
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link
                        href="https://fonts.googleapis.com/css2?family=Dancing+Script&family=Noto+Sans+Chakma&display=swap"
                        rel="stylesheet">
                    <p style="font-family:Dancing Script">Mon's Uni</p>
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
                        <select class="select-box">
                            <option value="">Class</option>
                            <option value="1.">1.Class File</option>
                            <option value="1.">2.Subject</option>

                        </select>
                    </div>
                    <div class="menu3">
                        <i class="fa-solid fa-users"></i>
                        <select class="select-box">
                            <option value="">Student</option>
                            <option value="1.">1.Student File</option>
                            <option value="1.">2.Student Movement</option>
                            <option value="1.">3.Grade Entry</option>
                        </select>
                    </div>
                    <!--                <div class="menu4">
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
        
        <a href="http://localhost:9999/StudentManagement/add.jsp">Add Student</a>
        <% List<student> students =(List<student>) request.getAttribute("studentlist"); %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Class Name</th>
                </tr>
            </thead>

            <tbody>
                <% for(student student: students){ %>

                <tr>
                    <td><%=student.getId() %></td>
                    <td><%=student.getName() %></td>
                    <td><%=student.getGender() %></td>
                    <td><%=student.getClassName() %></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <a href="http://localhost:9999/StudentManagement/stlist">Back</a>
    </body>
</html>
