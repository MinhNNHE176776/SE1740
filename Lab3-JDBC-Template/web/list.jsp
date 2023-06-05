<%-- 
    Document   : list
    Created on : Apr 19, 2022, 10:09:49 AM
    Author     : AD
--%>

<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <h1> Student List </h1>
    <br/>
        <%
            ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
        %>
    </head>
    <body>
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
                    DOB
                </td>
            </tr>
        <% for (Student s : students) {
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
                        <%=s.getDob()%>
                    </td>
                    <td>   
                    <a href="edit?id=<%=s.getId()%>">Edit</a>
                    <a href="delete?id=<%=s.getId()%>">Delete</a>
                    </td>
                    
                </tr>
        <%}%>
        </table>
        <a href="createJSP.jsp">Create</a>
    </body>
</html>