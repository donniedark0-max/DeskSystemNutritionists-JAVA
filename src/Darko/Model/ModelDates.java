/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Darko.Model;

import java.sql.Date;

/**
 *
 * @author jjose
 */
public class ModelDates {
    
    private int id_date;
    private int patient_id; // ID del paciente asociado
    private java.sql.Date date; // Fecha de la cita
    private boolean state; 

    public int getId_date() {
        return id_date;
    }

    public void setId_date(int id_date) {
        this.id_date = id_date;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ModelDates(int id_date, int patient_id, Date date, boolean state) {
        this.id_date = id_date;
        this.patient_id = patient_id;
        this.date = date;
        this.state = state;
    }
    
    public ModelDates(){
        
    }
}
