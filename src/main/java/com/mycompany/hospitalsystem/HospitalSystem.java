/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospitalsystem;
import java.util.ArrayList;
import java.util.Iterator; 
import java.util.List; 
import java.util.Scanner; 

/**
 *
 * @author junio
 */
public class HospitalSystem { 
    private List<Patient> patients = new ArrayList<>();
    public Ward ward = new Ward();

    // Register patient
    public void registerPatient(Patient p) { 
        for (Patient pt : patients) {
            if (pt.getId().equals(p.getId())) {
                System.out.println("Duplicate ID not allowed.");
                return;
            }
        }
        patients.add(p);
        System.out.println("Patient registration successful.");
    }

    // Search patient
    public void searchPatient(String id) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                System.out.println("Patient found:");
                p.displayDetails();
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    // Update patient
    public void updatePatient(String id, String newCondition) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                p.setCondition(newCondition);
                System.out.println("Patient details updated.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    // Delete patient
    public void deletePatient(String id) {
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            Patient p = it.next();
            if (p.getId().equals(id)) {
                it.remove();
                System.out.println("Patient deleted.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    // Show all patients
    public void showAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }
        System.out.println("Registered Patients:");
        for (Patient p : patients) {
            p.displayDetails();
        }
    }

    // Main menu
    public static void main(String[] args) {
        HospitalSystem hs = new HospitalSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MediCare Hospital System ===");
            System.out.println("1) Register Patient");
            System.out.println("2) Search Patient");
            System.out.println("3) Update Patient");
            System.out.println("4) Delete Patient");
            System.out.println("5) Show All Patients");
            System.out.println("6) Manage Beds");
            System.out.println("7) Quit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("First name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last name: ");
                    String ln = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Gender: ");
                    String g = sc.nextLine();
                    System.out.print("Condition: ");
                    String cond = sc.nextLine();
                    System.out.print("Category (INPATIENT/OUTPATIENT/EMERGENCY): ");
                    PatientType type = PatientType.valueOf(sc.nextLine().toUpperCase());

                    hs.registerPatient(new Patient(id, fn, ln, age, g, cond, type));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    hs.searchPatient(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    String uid = sc.nextLine();
                    System.out.print("Enter new condition: ");
                    hs.updatePatient(uid, sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    hs.deletePatient(sc.nextLine());
                    break;

                case 5:
                    hs.showAllPatients();
                    break;

                case 6:
                    hs.ward.showBeds();
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }
}
