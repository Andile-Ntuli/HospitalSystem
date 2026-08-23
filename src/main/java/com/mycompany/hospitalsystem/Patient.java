/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsystem;

/**
 *
 * @author junio
 */
public class Patient {
    private String id;
    private String fname;
    private String lname;
    private int age;
    private String gender;
    private String condition;
    private PatientType type;
    
    public Patient(String id, String fname, String lname, int age, String gender, String condition, PatientType type){
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.age = age;
    this.condition = condition;
    this.type = type;
}
    
public String getId(){return id;}
public String getLname(){return lname;}
public PatientType getType(){return type;}

public void setCondition(String condition){this.condition = condition;}

public void displayDetails(){
    System.out.println(id +" " + fname + " " + lname + " " + age + " " + gender + " " + condition + " " + type);
   }
}
