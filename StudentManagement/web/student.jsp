<%-- 
    Document   : student
    Created on : Jul 3, 2023, 9:30:58 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
    </head>
    <body>
        <form action="/StudentManagement/classController" method="post">
            <div>
                <label>ID:</label>
                <input type="number" name="id"/>
            </div> 
            
            <div>
                <label>Name:</label>
                <input type="text" name="name"/>
            </div> 
            
            <div>
                <label>Class Name:</label>
                <input type="text" name="className"/>
            </div> 
            
            <div>               
                <button type="submit">Add</button>
            </div> 
        </form>
    </body>
</html>
