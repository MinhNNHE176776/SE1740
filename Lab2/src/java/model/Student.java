package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;

/**
 *
 * @author DELL
 */
public class Student {
    int id;
    String name;
    Boolean gender;
    Date DOB;

    public Student() {
    }

    public Student(int id, String name, Boolean gender, Date DOB) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
}
