/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class student {
    private int id;
    private String className;
    private String name;
    private int gender;
    float point;

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }
    
    public int getId() {
        return id;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

 public String getClassName() {
        return className;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public void setName(String name) {
        this.name = name;
    }
    
}
