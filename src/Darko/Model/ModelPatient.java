/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Darko.Model;

/**
 *
 * @author jjose
 */
public class ModelPatient {
    
    
    int patient_id;
    String first_name;
    String last_name;
    String birthdate;
    String gender;
    Double height;
    Double weight;
    Double bmi;

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firs_name) {
        this.first_name = firs_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ModelPatient(int patient_id, String first_name, String last_name, String birthdate, String gender, double height, double weight, double bmi) {
        this.patient_id = patient_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
    }
    public ModelPatient(){
        
    }
}
