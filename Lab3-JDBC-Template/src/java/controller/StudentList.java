/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.StudentDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author AD
 */
//@WebServlet(urlPatterns = {"/list"})
public class StudentList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {            
        StudentDAO db = new StudentDAO();
        PrintWriter out = response.getWriter();
        if(request.getAttribute("insertedStudent") != null){
            Student insertedStudent = (Student)request.getAttribute("insertedStudent");
            db.insertStudent(insertedStudent);
        }
        if(request.getAttribute("updatedStudent") != null){
            Student updatedStudent = (Student)request.getAttribute("updatedStudent");
            db.updateStudent(updatedStudent);
        }
        if(request.getParameter("deletedID") != null){
            int deletedID = Integer.parseInt(request.getParameter("deletedID"));
            db.deleteStudent(deletedID);
        }
        ArrayList<Student> students = db.getStudents();
        if(students == null)
        {
            
            out.println("Cannot get the data");    
        }
        else
        {
            request.setAttribute("students", students);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
