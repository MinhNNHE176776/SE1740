<%-- 
    Document   : update
    Created on : May 31, 2023, 10:28:28 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.student"%>
<%@page import="dal.StudentDAO"%>
<%@page import="java.text.ParseException"%>
<%--<%@page import="java.sql.Date"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            StudentDAO db = new StudentDAO();
            int studentID = 0;
            try{
                studentID = Integer.parseInt(request.getParameter("id"));
            }
            catch(Exception e){
            }
            student updatingStudent = db.getStudent(studentID);
        %>
        <!--<div><% // out.println(updatingStudent.getName() + " " + updatingStudent.getDob() + " " + updatingStudent.getGender()); %></div>-->

        <form>
            <label>ID: </label>
            <input type="text" name="id" value="<%= updatingStudent.getId()%>" readonly>
            <br>
            <label>Name: </label>
            <input type="text" name="name" value="<%= updatingStudent.getName()%>">
            <br>
            <label for="male">Gender: </label>
            <input type="text" name="gender" value="<%=updatingStudent.getGender()%>">      
            <br>
            <label>Class Name: </label>
            <input type="text" name="className" value="<%= updatingStudent.getClassName()%>">
            <br>
            <input type="submit" value="Update" name="submit">
        </form>
        <%
            student student = null;
            if (request.getParameter("submit") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                int gender =Integer.parseInt( request.getParameter("gender"));
                String className = request.getParameter("className");
                
                
                    
                    student = new student();
                    student.setId(id);
                    student.setName(name);
                    student.setGender(gender);
                    student.setClassName(className);
                    out.println(student.getId() + " " + student.getName() + " " + student.getGender() + " " + student.getClassName());
                    request.setAttribute("updatedStudent", student);
                    request.getRequestDispatcher("/stlist").forward(request, response);
                 
            }
        %>
    </body>
</html>
