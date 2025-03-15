/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import java.util.List;

/**
 *
 * @author lucasandrade
 */
public class TestScheduler {
    public static void main(String[] args) {
        
        BloodTestScheduler scheduler = new BloodTestScheduler();

        // Add test patients
        scheduler.addPatient(new Patient("Alice", "urgent", 70, true, "Dr. Smith"));
        scheduler.addPatient(new Patient("Bob", "medium", 50, false, "Dr. Johnson"));
        scheduler.addPatient(new Patient("Charlie", "urgent", 80, false, "Dr. Brown"));
        scheduler.addPatient(new Patient("David", "low", 30, true, "Dr. Adams"));
        scheduler.addPatient(new Patient("Eve", "medium", 60, true, "Dr. Clark"));

        // process patients based on priority
        System.out.println("Processing Patients in Order:");
        while (!scheduler.isQueueEmpty()) {
            System.out.println(scheduler.getNextPatient());
        }

        // Create MissedPatientsList 
        MissedPatientsList missedList = new MissedPatientsList();

        // Add 6 test no-show patients to see if only last 5 remain
        missedList.addMissedPatient(new Patient("Frank", "medium", 40, false, "Dr. White"));
        missedList.addMissedPatient(new Patient("Grace", "low", 35, false, "Dr. Gray"));
        missedList.addMissedPatient(new Patient("Hank", "urgent", 55, true, "Dr. Green"));
        missedList.addMissedPatient(new Patient("Ivy", "medium", 50, true, "Dr. Blue"));
        missedList.addMissedPatient(new Patient("Jack", "low", 45, false, "Dr. Red"));
        missedList.addMissedPatient(new Patient("Kelly", "urgent", 65, true, "Dr. Yellow")); // This should push out "Frank"

        // Print last 5 no-shows
        System.out.println("\nLast 5 Missed Patients:");
        List<Patient> missedPatients = missedList.getMissedPatients();
        for (Patient p : missedPatients) {
            System.out.println(p);
        }
    }
}

