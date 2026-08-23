/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.hospitalsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author junio
 */

public class HospitalSystemTest {

    @Test
    public void registerPatientWorks() {
        HospitalSystem hs = new HospitalSystem();

        Patient p = new Patient(
                "P01",
                "John",
                "Doe",
                30,
                "Male",
                "Flu",
                PatientType.INPATIENT
        );

        hs.registerPatient(p);

        // should have 1 patient now
        assertEquals(1, hs.getPatients().size());
    }

    @Test
    public void duplicateIdNotAllowed() {
        HospitalSystem hs = new HospitalSystem();

        Patient p1 = new Patient(
                "P01",
                "John",
                "Doe",
                30,
                "Male",
                "Flu",
                PatientType.OUTPATIENT
        );

        Patient p2 = new Patient(
                "P01",
                "Jane",
                "Smith",
                25,
                "Female",
                "Cold",
                PatientType.EMERGENCY
        );

        hs.registerPatient(p1);
        hs.registerPatient(p2);

        // duplicate ID should not be added
        assertEquals(1, hs.getPatients().size());
    }

    @Test
    public void searchPatientWorks() {
        HospitalSystem hs = new HospitalSystem();

        Patient p = new Patient(
                "P02",
                "Sarah",
                "Jones",
                25,
                "Female",
                "Headache",
                PatientType.OUTPATIENT
        );

        hs.registerPatient(p);

        // patient should be found using the ID
        assertEquals("P02", hs.getPatients().get(0).getId());
    }

    @Test
    public void updateConditionWorks() {
        HospitalSystem hs = new HospitalSystem();

        Patient p = new Patient(
                "P03",
                "David",
                "Williams",
                35,
                "Male",
                "Flu",
                PatientType.OUTPATIENT
        );

        hs.registerPatient(p);

        hs.updatePatient("P03", "Pneumonia");

        // condition should have changed
        assertEquals(
                "Pneumonia",
                hs.getPatients().get(0).getCondition()
        );
    }

    @Test
    public void deletePatientWorks() {
        HospitalSystem hs = new HospitalSystem();

        Patient p = new Patient(
                "P04",
                "Mike",
                "Brown",
                40,
                "Male",
                "Injury",
                PatientType.INPATIENT
        );

        hs.registerPatient(p);

        hs.deletePatient("P04");

        // patient should be removed
        assertTrue(hs.getPatients().isEmpty());
    }

    @Test
    public void inpatientTypeWorks() {
        HospitalSystem hs = new HospitalSystem();

        Patient p = new Patient(
                "P05",
                "Peter",
                "Johnson",
                45,
                "Male",
                "Broken leg",
                PatientType.INPATIENT
        );

        hs.registerPatient(p);

        // should be an inpatient
        assertEquals(
                PatientType.INPATIENT,
                hs.getPatients().get(0).getType()
        );
    }

    @Test
    public void outpatientTypeWorks() {
        HospitalSystem hs = new HospitalSystem();

        Patient p = new Patient(
                "P06",
                "Mary",
                "Jones",
                28,
                "Female",
                "Flu",
                PatientType.OUTPATIENT
        );

        hs.registerPatient(p);

        // should be an outpatient
        assertEquals(
                PatientType.OUTPATIENT,
                hs.getPatients().get(0).getType()
        );
    }

    @Test
    public void emergencyTypeWorks() {
        HospitalSystem hs = new HospitalSystem();

        Patient p = new Patient(
                "P07",
                "Robert",
                "Miller",
                50,
                "Male",
                "Chest pain",
                PatientType.EMERGENCY
        );

        hs.registerPatient(p);

        // should be an emergency patient
        assertEquals(
                PatientType.EMERGENCY,
                hs.getPatients().get(0).getType()
        );
    }

    @Test
    public void wardExists() {
        HospitalSystem hs = new HospitalSystem();

        // hospital should have a ward
        assertNotNull(hs.ward);
    }

    @Test
    public void bedCanBeAllocated() {
        HospitalSystem hs = new HospitalSystem();

        // allocate a bed to patient P01
        boolean result = hs.ward.allocateBed("P01");

        // allocation should be successful
        assertTrue(result);
    }

    @Test
    public void bedCanBeReleased() {
        HospitalSystem hs = new HospitalSystem();

        hs.ward.allocateBed("P01");

        // release the patient's bed
        boolean result = hs.ward.releaseBed("P01");

        // release should be successful
        assertTrue(result);
    }

    @Test
    public void bedCannotBeReleasedTwice() {
        HospitalSystem hs = new HospitalSystem();

        hs.ward.allocateBed("P01");

        hs.ward.releaseBed("P01");

        // patient no longer has a bed
        boolean result = hs.ward.releaseBed("P01");

        assertFalse(result);
    }

    @Test
    public void twentyBedsCanBeFilled() {
        HospitalSystem hs = new HospitalSystem();

        // fill all 20 beds
        for (int i = 1; i <= 20; i++) {
            assertTrue(hs.ward.allocateBed("P" + i));
        }
    }

    @Test
    public void noMoreThanTwentyBeds() {
        HospitalSystem hs = new HospitalSystem();

        // fill all 20 beds
        for (int i = 1; i <= 20; i++) {
            hs.ward.allocateBed("P" + i);
        }

        // 21st patient should not get a bed
        boolean result = hs.ward.allocateBed("P21");

        assertFalse(result);
    }
}