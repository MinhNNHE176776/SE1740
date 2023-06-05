<%-- 
    Document   : update
    Created on : May 31, 2023, 10:28:28 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Student"%>
<%@page import="DAL.StudentDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
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
            Student updatingStudent = db.getStudent(studentID);
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
            <input type="radio" name="gender" value="1" id="male" <%if("1".equals(updatingStudent.getGender())){%>checked<%}%>>
            <label>Male</label>
            <input type="radio" name="gender" value="0" id="female" <%if("0".equals(updatingStudent.getGender())){%>checked<%}%>>
            <label>Female</label>
            <br>
            <%
                String pattern = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String formatDate = simpleDateFormat.format(updatingStudent.getDob());
            %>
            <label>DOB: </label>
            <input type="text" name="dob" value="<%= formatDate%>">
            <br>
            <input type="submit" value="Update" name="submit">
        </form>
        <%
            Student student = null;
            if (request.getParameter("submit") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String gender = request.getParameter("gender");
                String dob = request.getParameter("dob");
                java.sql.Date sqlDOB = null;
                try {
                    java.util.Date utilDOB = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
                    sqlDOB = new java.sql.Date(utilDOB.getTime());
                    student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setGender(gender);
                    student.setDob(sqlDOB);
                    out.println(student.getId() + " " + student.getName() + " " + student.getGender() + " " + student.getDob());
                    request.setAttribute("updatedStudent", student);
                    request.getRequestDispatcher("/stlist").forward(request, response);
                } catch (ParseException e) {
                    out.println("Unparseable date. Try pattern: dd/MM/yyyy");
                }
            }
        %>
    </body>
</html>
