/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bloodtestscheduler;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author lucasandrade
 * 
 * Use a priority queue to show the next person to be done, 
 * based on priority, age and whether they are currently coming from a hospital ward.
 */
public class BloodTestScheduler {
    private PriorityQueue<Patient> patientQueue; // scheduling queue
    private List<Patient> scheduledPatients; // stores processed patients
    
    // constructor to init Priority Queue and Scheduled List
    
    public BloodTestScheduler(){
        this.patientQueue = new PriorityQueue<>(new PatientComparator());
        this.scheduledPatients = new ArrayList<>();
    }
    
    // adding patient to the scheduled queue
    
    public void addPatient(Patient patient){
        patientQueue.offer(patient);
    }
    
    // Retrieving and removing the next high priority patient from the queue
    
    public Patient getNextPatient(){
        Patient next = patientQueue.poll();
        if (next != null){
        scheduledPatients.add(next); //store in the list
        }
        
        return next;
    }
    
    // Retrieving a list of all scheduled patients
    
    public List<Patient> getScheduledPatients() {
        return scheduledPatients;
    }
    
    // Checking if the queue is empty
    
    public boolean isQueueEmpty() {
        return patientQueue.isEmpty();
    }
    
    public List<Patient> getQueuedPatients() {
        return new ArrayList<>(patientQueue); // Returns current patients in queue
    }

    
}

// Comparator to determine patient priority. Project Requirements:
// 1. Higher priority patients are processed first: "urgent" > "medium" > "low"
// 2. If two patients have the same priority, the older patient is prioritized
// 3. If age is also the same, hospital patients have priority

class PatientComparator implements Comparator<Patient> {
    
    @Override
    
    public int compare(Patient p1, Patient p2) {
        
        // Convert priority to numeric values
        int priorityCompare = Integer.compare(getPriorityValue(p2.getPriority()), getPriorityValue(p1.getPriority()));
        if (priorityCompare != 0) {
            return priorityCompare; // Higher priority first
        }

        // If priority is the same, compare age (older first)
        int ageCompare = Integer.compare(p2.getAge(), p1.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }

        // If age is also the same, hospital patients get priority
        return Boolean.compare(p2.isFromHospital(), p1.isFromHospital());
    }

    // Convert priority from String to Integer
    private int getPriorityValue(String priority) {
        return switch (priority.toLowerCase()) {
            case "urgent" -> 3;
            case "medium" -> 2;
            case "low" -> 1;
            default -> 0; // default to 0 for unexpected values
        };
    }
}