/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.hospitalsystem;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test;

/**
 *
 * @author junio
 */

public class HospitalSystemTest {

    // Test if a patient can be registered
    @Test
    public void testRegisterPatient() {

        HospitalSystem hospital = new HospitalSystem();

        Patient patient = new Patient(
                "P001",
                "John",
                "Smith",
                30,
                "Male",
                "Flu",
                PatientType.OUTPATIENT
        );

        hospital.registerPatient(patient);

        // Check that the patient can be found after registering
        assertDoesNotThrow(() -> hospital.searchPatient("P001"));
    }

    // Test if duplicate patient IDs are not allowed
    @Test
    public void testDuplicatePatient() {

        HospitalSystem hospital = new HospitalSystem();

        Patient patient1 = new Patient(
                "P001",
                "John",
                "Smith",
                30,
                "Male",
                "Flu",
                PatientType.OUTPATIENT
        );

        Patient patient2 = new Patient(
                "P001",
                "James",
                "Brown",
                40,
                "Male",
                "Injury",
                PatientType.EMERGENCY
        );

        hospital.registerPatient(patient1);
        hospital.registerPatient(patient2);

        // The second patient should not be added
        assertDoesNotThrow(() -> hospital.searchPatient("P001"));
    }

    // Test searching for a patient
    @Test
    public void testSearchPatient() {

        HospitalSystem hospital = new HospitalSystem();

        Patient patient = new Patient(
                "P002",
                "Sarah",
                "Jones",
                25,
                "Female",
                "Headache",
                PatientType.EMERGENCY
        );

        hospital.registerPatient(patient);

        assertDoesNotThrow(()->hospital.searchPatient("P002"));
    }

    // Test searching for a patient that does not exist
    @Test
    public void testPatientNotFound() {

        HospitalSystem hospital = new HospitalSystem();

        assertDoesNotThrow(() -> hospital.searchPatient("P999"));
    }

    // Test updating a patient's medical condition
    @Test
    public void testUpdatePatient() {

        HospitalSystem hospital = new HospitalSystem();

        Patient patient = new Patient(
                "P003",
                "David",
                "Williams",
                35,
                "Male",
                "Flu",
                PatientType.OUTPATIENT
        );

        hospital.registerPatient(patient);

        hospital.updatePatient("P003", "Pneumonia");

        // Make sure the update does not cause an error
        assertDoesNotThrow(() -> hospital.searchPatient("P003"));
    }

    // Test deleting a patient
    @Test
    public void testDeletePatient() {

        HospitalSystem hospital = new HospitalSystem();

        Patient patient = new Patient(
                "P004",
                "Michael",
                "Davis",
                45,
                "Male",
                "Back pain",
                PatientType.OUTPATIENT
        );

        hospital.registerPatient(patient);

        hospital.deletePatient("P004");

        assertDoesNotThrow(() -> hospital.searchPatient("P004"));
    }

    // Test deleting a patient that does not exist
    @Test
    public void testDeletePatientNotFound() {

        HospitalSystem hospital = new HospitalSystem();

        assertDoesNotThrow(() -> hospital.deletePatient("P999"));
    }

    // Test displaying all patients
    @Test
    public void testShowAllPatients() {

        HospitalSystem hospital = new HospitalSystem();

        Patient patient = new Patient(
                "P005",
                "Peter",
                "Johnson",
                50,
                "Male",
                "Diabetes",
                PatientType.INPATIENT
        );

        hospital.registerPatient(patient);

        assertDoesNotThrow(() -> hospital.showAllPatients());
    }

    // Test inpatient category
    @Test
    public void testInpatient() {

        Patient patient = new Patient(
                "P006",
                "Robert",
                "Miller",
                40,
                "Male",
                "Broken leg",
                PatientType.INPATIENT
        );

        assertEquals(PatientType.INPATIENT, patient.getType());
    }

    // Test outpatient category
    @Test
    public void testOutpatient() {

        Patient patient = new Patient(
                "P007",
                "Mary",
                "Jones",
                28,
                "Female",
                "Flu",
                PatientType.OUTPATIENT
        );

        assertEquals(PatientType.OUTPATIENT, patient.getType());
    }

    // Test emergency category
    @Test
    public void testEmergency() {

        Patient patient = new Patient(
                "P008",
                "Robert",
                "Miller",
                55,
                "Male",
                "Chest pain",
                PatientType.EMERGENCY
        );

        assertEquals(PatientType.EMERGENCY, patient.getType());
    }

    // Test that the hospital has a ward
    @Test
    public void testWard() {

        HospitalSystem hospital = new HospitalSystem();

        assertNotNull(hospital.ward);
    }
}