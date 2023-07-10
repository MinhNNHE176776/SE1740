<%-- 
    Document   : hello
    Created on : Jul 2, 2023, 8:33:52 AM
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
        <h1>Hello World!</h1>
        <%
            String ip=request.getRemoteAddr();
            int x=10;
            Object obj = request.getAttribute("msg");
            String s= (String)obj;
        %>
        
        <%=ip%>
        <p> <%=x%> </p>
        <%= s %>
    </body>
</html>
