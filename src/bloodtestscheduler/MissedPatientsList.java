/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucasandrade
 * 
 * Tracks the last 5 patients who did not show up for their appointment 
 * Uses a List to store 5 no-shows patients
 */

public class MissedPatientsList {
    private List<Patient> missedPatients; // stores the last 5 no-show patients
    
    // constructor:
    
    public MissedPatientsList(){
        this.missedPatients = new LinkedList<>();
    }
    
    
    public void addMissedPatient(Patient patient) {
        if (!missedPatients.isEmpty() && missedPatients.size() == 5) { 
            missedPatients.remove(0); // this will remove the oldest no-show patient only if it's not empty
            }
        missedPatients.add(patient);
    }

    
    // Retrieving the list of the last 5 no-show patients:
    public List<Patient> getMissedPatients() {
        return missedPatients;
    }
    
    // Checking if there are no missed patients
    public boolean isEmpty() {
        return missedPatients.isEmpty();
    }
    
}
