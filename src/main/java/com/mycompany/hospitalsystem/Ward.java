/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsystem;

/**
 *
 * @author junio
 */
public class Ward {
 
    private String[] beds = new String[20];

    public boolean allocateBed(String pid) {
        for (int i = 0; i < beds.length; i++) {
            if (beds[i] == null) {
                beds[i] = pid;
                System.out.println("Bed B" + (i+1) + " allocated to " + pid);
                return true;
            }
        }
        System.out.println("No beds available.");
        return false;
    }


    public boolean releaseBed(String pid) {
        for (int i = 0; i < beds.length; i++) {
            if (pid.equals(beds[i])) {
                beds[i] = null;
                System.out.println("Bed B" + (i+1) + " released.");
                return true;
            }
        }
        System.out.println("Patient not found in beds.");
        return false;
    }


    public void showBeds() {
        for (int i = 0; i < beds.length; i++) {
            System.out.println("B" + (i+1) + ": " + (beds[i] == null ? "Available" : "Occupied by " + beds[i]));
        }
    }
}

