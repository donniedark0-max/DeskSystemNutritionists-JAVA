/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connection.Database;
import Darko.Model.ModelPatient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author jjose
 */
public class ServicePatient {
    private final Connection con;
    
    public ServicePatient(){
        con = Database.getInstance().getConnection();
    }
    public void insertIBM(ModelPatient patient) throws SQLException{
          if (patient != null) {
//         if (isEmpty(patient)){
       
         LocalDate currentDate = LocalDate.now();
       

        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
        
       PreparedStatement p = con.prepareStatement("INSERT INTO bmi_history (patient_id, date, bmi_value) VALUES (?,?,?)");
       p.setInt(1, patient.getPatient_id());
        p.setDate(2, sqlDate);
       p.setDouble(3, patient.getBmi());
       p.execute();
       ResultSet r = p.executeQuery();
       r.close();
       p.close();
     }  else {
        // Manejo de error si patient es null
        System.out.println("Error: El objeto patient es nulo");
    }
     }
    public void insertPatient(ModelPatient patient) throws SQLException{
//        if (isEmpty(patient)){
//            return;
//        }
         
       PreparedStatement p = con.prepareStatement("INSERT INTO patients (patient_id, first_name, last_name, birthdate, gender, height, weight) VALUES (?,?,?,?,?,?,?)");
       p.setInt(1, patient.getPatient_id());
       p.setString(2,patient.getFirst_name());
       p.setString(3, patient.getLast_name());
       p.setString(4, patient.getBirthdate());
       p.setString(5, patient.getGender());
       p.setString(6, Double.toString(patient.getHeight()));
       p.setString(7, Double.toString(patient.getWeight()));
       p.execute();
       ResultSet r = p.executeQuery();
       r.close();
       p.close();
    }
     
    
//    public boolean isEmpty(ModelPatient patient){
//        return patient.getFirst_name().isEmpty() || patient.getLast_name().isEmpty() || patient.getBirthdate().isEmpty() || patient.getGender().isEmpty() ||Double.isNaN(patient.getHeight()) || Double.isNaN(patient.getWeight());
//    }
    
//    public static double CalculateIBM(double height, double weight) {
//    // Realiza el cálculo del índice de masa corporal (IBM)
//    double ibm = weight / (height * height);
//    return ibm;
//    }
    
}


