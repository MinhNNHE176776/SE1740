<%-- 
    Document   : person-create
    Created on : Jul 2, 2023, 9:08:41 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/2.7/person/create" method ="post">
            <input name="id" placeholder="id..."> <!-- comment -->
            <br>
            <input name="name" placeholder="name..."><!-- comment -->
            <br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>
