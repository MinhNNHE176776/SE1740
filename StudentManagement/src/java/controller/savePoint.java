/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.student;

/**
 *
 * @author DELL
 */
public class savePoint extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet savePoint</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet savePoint at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String IOT102=request.getParameter("IOT102");
        String PRJ301=request.getParameter("PRJ301");
        String CSD201=request.getParameter("CSD201");
        String CEA201=request.getParameter("CEA201");
        String PRF192=request.getParameter("PRF192");
        String DBI202=request.getParameter("DBI202");
        String id=request.getParameter("id");
    
        student s = new student();
        s.setPoint((Float.parseFloat(CSD201)+Float.parseFloat(IOT102)+Float.parseFloat(PRJ301))/3);
        s.setId(Integer.parseInt(id));
        out.println(s.getId());
        out.println(s.getPoint());
        out.println(CSD201);
        out.println(PRJ301);
        out.println(IOT102);
//        StudentDAO sDao = new StudentDAO();
//        try {
//   //         out.print(sDao.insertStudent(student));
//            sDao.insertPoint(s);
//            
//        } catch (Exception ex) {
//            ex.printStackTrace(out);
//        }
        //response.sendRedirect("classpoint.jsp");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
