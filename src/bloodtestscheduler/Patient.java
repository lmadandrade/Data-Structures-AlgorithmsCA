/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

/**
 *
 * @author lucasandrade
 */
public class Patient {
    private String name;
    private String priority; // urgent, medium or low
    private int age;
    private boolean fromHospital; // if coming from a hospital ward = true
    private String gpName;
    
    // constructor
    public Patient (String name, String priority, int age, boolean fromHospital, String gpName){
        this.name = name;
        this.priority = priority;
        this.age = age;
        this.fromHospital = fromHospital;
        this.gpName = gpName;
    }
    
    // getters for accessing patient details:
    
    public String getName(){
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public int getAge() {
        return age;
    }

    public boolean isFromHospital() {
        return fromHospital;
    }

    public String getGpName() {
        return gpName;
    }
    
    @Override
    public String toString() {
        return name + " (" + priority + ", " + age + " years, " + 
               (fromHospital ? "Hospital" : "Home") + ", GP: " + gpName + ")";
    }
    
    
}
