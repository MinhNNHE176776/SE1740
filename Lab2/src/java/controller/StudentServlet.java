/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import model.Student;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author DELL
 */
public class StudentServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Student s = new Student();
            Random r = new Random();

            ArrayList<Student> students = new ArrayList<Student>();

            String para = request.getParameter("para");
            Integer n = NumberOfStudents(para);

            if (n != null) {
                for (int i = 0; i < n; i++) {
                    int id = i + 1;
                    String name = RandomString();
                    Boolean gender = r.nextBoolean();
                    Date DOB = RandomDate();
                    Student student = new Student(id, name, gender, DOB);
                    students.add(student);
                }
                request.setAttribute("students", students);
            }
            
            
            request.getRequestDispatcher("student.jsp").forward(request, response);
        }
    }

    public Integer NumberOfStudents(String a) {
        int num;
        try {
            num = Integer.parseInt(a);
            if (num <= 0) {
                throw new Exception();
            } else {
                return num;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public String RandomString() {
        Random r = new Random();

        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder();
        int l = r.nextInt(14)+1;
        for (int i = 0; i < l; i++) {
            int randomInt = r.nextInt(chars.length());
            char randomChar = chars.charAt(randomInt);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public Date RandomDate() {
        Random r = new Random();
        SimpleDateFormat d= new SimpleDateFormat("MM-dd-yyyy");
        String strD = (r.nextInt(30)+1)+"-"+(r.nextInt(11)+1)+"-"+(r.nextInt(53)+1970);
        try{
            Date date= d.parse(strD);
            return date;
        }catch(ParseException e){
            return null;
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
