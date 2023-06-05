<%-- 
    Document   : createStudent
    Created on : May 30, 2023, 2:52:57 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="POST">
            <label for="name">Name: </label>
            <input type="text" name="name" id="name" placeholder="abc">
            <br>
            <label for="male">Gender: </label>
            <input type="radio" name="gender" id="male" value="1" checked>
            <label for="male">Male</label>
            <input type="radio" name="gender" id="female" value="0">
            <label for="female">Female</label>
            <br>
            <label for="dob">DOB: </label>
            <input type="text" name="dob" id="dob" placeholder="dd/MM/yyyy">
            <br>
            <input type="submit" value="Create">
        </form>
    </body>
</html>
