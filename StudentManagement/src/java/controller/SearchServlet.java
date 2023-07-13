package controller;


import dal.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dell
 */
public class SearchServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String term = request.getParameter("searchName");
        ArrayList<student> sList = new ArrayList<>();
        StudentDAO sDAO = new StudentDAO();
        if(term == null || term.equalsIgnoreCase("")){
            sList = sDAO.getStudents();
        } else {
            sList = sDAO.getStudentBySearchTerm(term);
        }
       // response.getWriter().print(sList.toArray());
        request.getSession().setAttribute("sList", sList);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         processRequest(request, response); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
