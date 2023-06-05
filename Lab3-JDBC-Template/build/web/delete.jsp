<%-- 
    Document   : delete
    Created on : May 31, 2023, 1:39:31 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Student"%>
<%@page import="DAL.StudentDAO"%>
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
            Student deletingStudent = db.getStudent(studentID);
        %>
        <form action="stlist" method="POST">
            <input type="hidden" name="deletedID" value="<%= studentID %>">
        </form>
        
        
        <script>
            const conf = confirm("Do you want to delete student: "
                    + "\nid: <%=deletingStudent.getId()%>" 
                    + "\nname: <%=deletingStudent.getName()%>"
                    + "\ngender: <%=(deletingStudent.getGender().equals("1"))? "Male" : "Female"%>"
                    + "\ndob: <%=deletingStudent.getDob()%>");
            if(conf){
                document.forms[0].submit();
            } else {
                alert("Delete failed");
                window.location.href = "stlist";
            }
            
        </script>
    </body>
</html>
