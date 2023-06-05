<%-- 
    Document   : student
    Created on : 25-05-2023, 2:41:02
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import =" java.util.ArrayList"%>
<%@page import =" model.Student"%>
<%@page import =" java.text.SimpleDateFormat" %>
<%@page import =" java.util.Date" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
        %>
        <%!
            public String convertDate(Date d){
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = formatter.format(d);
                return strDate;
            }
        %>  
        <style>
            table{
              border: black 1px solid;   
              margin: 2px;
            }
            td{
              border: black 1px solid;   
              margin:1px;
            }
        </style>
    </head>
    <body>
        <form action="StudentServlet" >
        Number of Students: 
        <input type="text" name="para" value=""/>
        <input type="submit" value="generate"/>
        </form>
        <% if(students != null){ %>
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Gender</td>
                    <td>DOB</td>
                    
            
                </tr>
            </thead>
            <tbody>
                <%
                     for(Student s: students) {
                %>
                <tr>
                    <td><%= s.getId() %></td>
                    <td><%= s.getName() %></td>
                    <td><%
                        if(s.getGender()==true){ %>
                            <input type="checkbox" onclick="return false"  checked>
                        <%}else{%>
                            <input type="checkbox" onclick="return false">
                        <%}%>
                    </td>
                    <td><%= convertDate(s.getDOB()) %></td>
                </tr>
                <%}%>   
            </tbody>
        </table>  
            <%}%>  


    </body>
</html>
