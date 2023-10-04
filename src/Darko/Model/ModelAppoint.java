/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Darko.Model;

/**
 *
 * @author jjose
 */
public class ModelAppoint {
    private int appointment_id;
    private int patient_id;
    private String dx_Nutritional;
    private String notes;

    public ModelAppoint(int patient_id, String dx_Nutritional, String notes) {
        this.patient_id = patient_id;
        this.dx_Nutritional = dx_Nutritional;
        this.notes = notes;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getDx_Nutritional() {
        return dx_Nutritional;
    }

    public void setDx_Nutritional(String dx_Nutritional) {
        this.dx_Nutritional = dx_Nutritional;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
