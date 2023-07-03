<%-- 
    Document   : personDetail
    Created on : Jul 2, 2023, 9:30:50 AM
    Author     : DELL
--%>
<%@page import="model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <% 
            Person p= (Person) request.getAttribute("person");
        %>
        <p> ID: <%= p.getId() %> </p>
        <p> Name: <%= p.getName() %> </p>
    </body>
</html>