package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Student;
import DAL.StudentDAO;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            StudentDAO db = new StudentDAO();
            int studentID = 0;
            try{
                studentID = Integer.parseInt(request.getParameter("id"));
            }
            catch(Exception e){
                
            }
            Student updatingStudent = db.getStudent(studentID);
        
      out.write("\n");
      out.write("        <!--<div>");
 // out.println(updatingStudent.getName() + " " + updatingStudent.getDob() + " " + updatingStudent.getGender()); 
      out.write("</div>-->\n");
      out.write("\n");
      out.write("        <form>\n");
      out.write("            <label>ID: </label>\n");
      out.write("            <input type=\"text\" name=\"id\" value=\"");
      out.print( updatingStudent.getId());
      out.write("\" readonly>\n");
      out.write("            <br>\n");
      out.write("            <label>Name: </label>\n");
      out.write("            <input type=\"text\" name=\"name\" value=\"");
      out.print( updatingStudent.getName());
      out.write("\">\n");
      out.write("            <br>\n");
      out.write("            <label for=\"male\">Gender: </label>\n");
      out.write("            <input type=\"radio\" name=\"gender\" value=\"1\" id=\"male\" ");
if("1".equals(updatingStudent.getGender())){
      out.write("checked");
}
      out.write(">\n");
      out.write("            <label>Male</label>\n");
      out.write("            <input type=\"radio\" name=\"gender\" value=\"0\" id=\"female\" ");
if("0".equals(updatingStudent.getGender())){
      out.write("checked");
}
      out.write(">\n");
      out.write("            <label>Female</label>\n");
      out.write("            <br>\n");
      out.write("            ");

                String pattern = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String formatDate = simpleDateFormat.format(updatingStudent.getDob());
            
      out.write("\n");
      out.write("            <label>DOB: </label>\n");
      out.write("            <input type=\"text\" name=\"dob\" value=\"");
      out.print( formatDate);
      out.write("\">\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\" value=\"Update\" name=\"submit\" onclick=\"Confirm()\">\n");
      out.write("        </form>\n");
      out.write("        ");

            String hello = "hi";
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
                } catch (ParseException e) {
                    out.println("Unparseable date. Try pattern: dd/MM/yyyy");
                }
                request.getRequestDispatcher("/list").forward(request, response);
            }
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("//            function Confirm(){\n");
      out.write("//                \n");
      out.write("\n");
      out.write("//            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
