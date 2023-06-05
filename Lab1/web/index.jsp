<%-- 
    Document   : index
    Created on : May 22, 2023, 10:41:52 AM
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
        <%! String destin; %>
        <%! String name=new String("JSP World");%>
        <%! public String getName(){ return name;} %>
        <B><%= getName() %></B>
    </body>
</html>
