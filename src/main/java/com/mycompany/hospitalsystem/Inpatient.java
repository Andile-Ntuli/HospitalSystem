/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsystem;
public class Inpatient extends Patient {
    private String wardNo;
    private String bedNo;

    public Inpatient(String id, String fname, String lname, int age, String gender, String condition, PatientType type, String wardNo, String bedNo) {
        super(id, fname, lname, age, gender, condition, type);
        this.wardNo = wardNo;
        this.bedNo = bedNo;
    }
/**
 *
 * @author junio
 */
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Ward: " + wardNo + " Bed: " + bedNo);
    }
    
}
