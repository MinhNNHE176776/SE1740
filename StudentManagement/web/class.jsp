<%-- 
    Document   : search
    Created on : Jun 28, 2023, 8:28:40 AM
    Author     : dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="searchServlet" method="GET">
            <label for="search">Name:</label>
            <input type="search" name="searchName" id="search">
            <input type="submit" value="Search">
        </form>
        <div>
            <c:if test="${sessionScope.sList != null}">
                <table border="1px">
                    <tr>
                        <td>id</td>
                        <td>name</td>
                        <td>gender</td>
                        <td>class</td>
                    </tr>
                    
                        <c:forEach items="${sessionScope.sList}" var="s">
                            <tr>
                                <td>${ID}</td>
                                <td>${name}</td>
                                <td>${Gender}</td>
                                <td>${className}</td>
                            </tr> 
                        </c:forEach>
                    
                </table>
            </c:if>
        </div>
    </body>
</html>
