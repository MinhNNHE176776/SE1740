/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Student;
/**
 *
 * @author dell
 */
public class CreateStudent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        java.sql.Date sqlDOB = null;
        try {
            java.util.Date utilDOB = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
            sqlDOB = new java.sql.Date(utilDOB.getTime());
            Student student = new Student();
            student.setName(name);
            student.setGender(gender);
            student.setDob(sqlDOB);
            request.setAttribute("insertedStudent", student);
        } catch (ParseException e) {
        }
        request.getRequestDispatcher("/stlist").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
