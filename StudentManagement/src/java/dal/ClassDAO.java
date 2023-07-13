///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package dal;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import model.class1;
//import model.subject;
//public class ClassDAO extends DBContext{
//    Connection conn=null;
//    public ArrayList<subject> getSubject() {
//        
//        ArrayList<subject> subjects = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM student";
//            conn=new DBContext().getConnection();
//            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                student s = new student();
//                s.setId(rs.getInt("ID"));
//                s.setName(rs.getString("name"));
//                s.setGender(rs.getInt("Gender"));
//                s.setClassName(rs.getString("className"));
//                s.setPoint(rs.getInt("avgmark"));
//                students.add(s);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return students;
//    }
//}
