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
public class ModelMedRecord {
    private int record_id;
    private int patient_id;
    private java.sql.Date record_date; // Fecha de la hitoria medica
    private String medicant;
    private String note;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    

    public String getMedicant() {
        return medicant;
    }

    public void setMedicant(String medicant) {
        this.medicant = medicant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
public ModelMedRecord(int patient_id, Date record_date, String medicant, String note) {
        
        this.patient_id = patient_id;
        this.record_date = record_date;
        this.medicant = medicant;
        this.note = note;
    }
}
