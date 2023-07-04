/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import java.util.List;
import model.student;
/**
 *
 * @author DELL
 */
public class studentService {
    private static List<student> list =new ArrayList<>();
    
    public void create(student student){
        list.add(student);
    }
    public List<student> getAll(){
        return list;
    }
}
