    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.student;

public class StudentDAO extends DBContext{
    Connection conn=null;
    public ArrayList<student> getStudents() {
        
        ArrayList<student> students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            conn=new DBContext().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                student s = new student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getInt("Gender"));
                s.setClassName(rs.getString("className"));
                s.setPoint(rs.getInt("avgmark"));
                students.add(s);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    public ArrayList<student> getStudentBySearchTerm(String term) {
        ArrayList<student> students = new ArrayList<>();
        try {
            String sql = "SELECT ID,name,gender,className,avgmark FROM student\n"
                    + "WHERE name LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + term + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                student s = new student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getInt("Gender"));
                s.setClassName(rs.getString("className"));
                s.setPoint(rs.getInt("avgmark"));
                students.add(s);
            }

        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    public boolean insertStudent(student student)throws Exception{
        int lineAffected = 0;
        try{
            String insertQuery = "INSERT INTO student (ID,name,Gender,className,avgmark) VALUES(?,?,?,?,?)";
            conn=new DBContext().getConnection();
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setInt(1, student.getId());
            insertStatement.setString(2, student.getName());
            insertStatement.setInt(3, student.getGender());
            insertStatement.setString(4, student.getClassName());
            insertStatement.setFloat(5, student.getPoint());
            lineAffected = insertStatement.executeUpdate();
             insertStatement.close();
            conn.close();
        }catch (Exception e) {
            throw(e);
    }
     if(lineAffected == 1) return true;
        return false;
    }
    public ArrayList<student> getStudentbyClass(String term){
        ArrayList<student> students = new ArrayList<>();
        try {
            String sql = "SELECT ID,name,Gender,className FROM student \n"
                    + "WHERE className like ?";
            conn=new DBContext().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
           statement.setString(1, "%" + term + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                student s = new student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getInt("Gender"));
                s.setClassName(rs.getString("className"));
//                s.setPoint(rs.getInt("avgmark"));
                students.add(s);
            }

        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
}
 