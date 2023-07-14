<%-- 
    Document   : list
    Created on : Apr 19, 2022, 10:09:49 AM
    Author     : AD
--%>

<%@page import="model.student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mon's Uni</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <script src="https://kit.fontawesome.com/38998be14e.js" crossorigin="anonymous"></script>

        <%
            ArrayList<student> students = (ArrayList<student>)request.getAttribute("students");
        %>
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
                        <select  class="select-box" name="links" id="" size="1" onchange="window.location.href = this.value";>
                            <option value="">Statistics</option>
                            <option value="http://localhost:9999/StudentManagement/statistic.jsp">1.School Statistics</option>
                            
                        </select>
                    </div>
                    <div class="menu6">
                        <i class="fa-sharp fa-solid fa-book-open"></i>
                    <select  class="select-box" name="links" id="" size="1" onchange="window.location.href = this.value";>
                            <option value="">Report</option>
                            <option value="http://localhost:9999/StudentManagement/report.jsp">School Report</option>
                            
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <h1> Student List </h1>
        <div class="back">
            <a href="http://localhost:9999/StudentManagement/home.html">Back to main</a>
        </div>
        <br/>
        
        <table border="1">
            <tr>
                <td>
                    ID
                </td>
                <td>
                    Name
                </td>
                <td>
                    Gender
                </td>
                <td>
                    Class Name
                </td>
            </tr>
            <% for (student s : students) {
            %>
            <tr>
                <td>
                    <%=s.getId() %>
                </td> 
                <td>
                    <%=s.getName()%>
                </td>
                <td>
                    <%=s.getGender()%>
                </td>                
                <td>
                    <%=s.getClassName()%>
                </td>
                <td>   
                    <a href="update.jsp?id=<%=s.getId()%>">Edit</a>
                    <a href="delete.jsp?id=<%=s.getId()%>">Delete</a>
                </td>

            </tr>
            <%}%>
        </table>
        <br>
        <div class="add">
            <a style=" color:white;text-decoration: none;background-color: rgb(71, 31, 31);padding:5px;" href="add.jsp">Add Student</a>
        </div>
        
    </body>
</html>