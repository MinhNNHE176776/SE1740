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
import model.subject;

public class StudentDAO extends DBContext {

    Connection conn = null;

    public ArrayList<student> getStudents() {

        ArrayList<student> students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            conn = new DBContext().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                student s = new student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getInt("Gender"));
                s.setClassName(rs.getString("className"));
                s.setPoint(rs.getFloat("avgmark"));
                students.add(s);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public student getStudent(int id) {
        try {
            String sql = "SELECT ID,name,gender,className FROM student s\n"
                    + "WHERE ID = ?";
            conn = new DBContext().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                student s = new student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getInt("Gender"));
                s.setClassName(rs.getString("className"));

                return s;
            }

        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<student> getStudentBySearchTerm(String term) {
        ArrayList<student> students = new ArrayList<>();
        try {
            String sql = "SELECT ID,name,Gender,className,avgmark FROM student\n"
                    + "WHERE name like ?";
            conn = new DBContext().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + term + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                student s = new student();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getInt("Gender"));
                s.setClassName(rs.getString("className"));
                s.setPoint(rs.getFloat("avgmark"));
                students.add(s);
            }

        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public boolean insertStudent(student student) throws Exception {
        int lineAffected = 0;
        try {
            String insertQuery = "INSERT INTO student (ID,name,Gender,className) VALUES(?,?,?,?)";
            conn = new DBContext().getConnection();
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setInt(1, student.getId());
            insertStatement.setString(2, student.getName());
            insertStatement.setInt(3, student.getGender());
            insertStatement.setString(4, student.getClassName());
//            insertStatement.setFloat(5, student.getPoint());
            lineAffected = insertStatement.executeUpdate();
            insertStatement.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (lineAffected == 1) {
            return true;
        }
        return false;
    }

    public boolean insertPoint(student student) throws Exception {
    int lineAffected = 0;
    try {
        String updateQuery = "UPDATE student\n"
                + "SET avgmark = ?\n"
                + "WHERE ID = ?;";
        conn = new DBContext().getConnection();
        PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
        updateStatement.setFloat(1, student.getPoint());
        updateStatement.setInt(2, student.getId());
        
        lineAffected = updateStatement.executeUpdate();
        
        updateStatement.close();
        conn.close();
    } catch (Exception ex) {
        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex; // Rethrow the exception to notify the caller about the error
    }
    
    return lineAffected == 1;
}


    public ArrayList<student> getStudentbyClass(String term) {
        ArrayList<student> students = new ArrayList<>();
        try {
            String sql = "SELECT ID,name,Gender,className FROM student \n"
                    + "WHERE className like ?";
            conn = new DBContext().getConnection();
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

    public ArrayList<subject> getSubject(String term) {
        ArrayList<subject> subjects = new ArrayList<>();
        try {
            String sql = "SELECT * FROM subject \n"
                    + "WHERE subjectcode like ?";
            conn = new DBContext().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + term + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                subject s = new subject();
                s.setSubjectcode(rs.getString("subjectcode"));
                s.setSubjectname(rs.getString("subjectname"));
                s.setLink(rs.getString("link"));
                subjects.add(s);
            }

        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjects;
    }

    public void updateStudent(student s) {
        try {
            String sql = "UPDATE [student]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[Gender] = ?\n"
                    + "      ,[className] = ?\n"
                    + " WHERE [id] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, s.getName());
            statement.setInt(2, s.getGender());
            statement.setString(3, s.getClassName());
            statement.setInt(4, s.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStudent(int id) {
        try {
            String sql = "DELETE Student WHERE id=?";
            conn = new DBContext().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
