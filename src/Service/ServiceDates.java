/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connection.Database;
import Darko.Model.ModelDates;
import Darko.Model.ModelPatient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author jjose
 */
public class ServiceDates {
    private final Connection con;
    
    public ServiceDates(){
        con= Database.getInstance().getConnection();
    }
    
    public void insertDate(ModelPatient patient, ModelDates date) throws SQLException{
        try {
            int patientId = patient.getPatient_id(); // Asegúrate de que patientId se obtenga de manera correcta
            Connection con = Database.getInstance().getConnection();
         
            // Verifica si el paciente con el ID existe en la tabla "patients"
             if (!patientExists(con, patientId)) {
            // Si no existe, muestra un mensaje de error
            System.out.println("Error: El paciente con ID " + patientId + " no existe en la tabla patients.");
            return; // Ahora está dentro de un método válido
             }
        
       PreparedStatement p = con.prepareStatement("INSERT INTO dates (patient_id, date, state) VALUES (?,?,?)");
       p.setInt(1, patientId);
       p.setDate(2, date.getDate());
       p.setBoolean(3, date.isState());
       p.execute();
       ResultSet r = p.executeQuery();
       r.close();
       p.close();
      } catch (SQLException e) {
            System.out.println("ERROR INSERT DATE");
          System.out.println(e.getLocalizedMessage());
        }
    }
    private boolean patientExists(Connection con, int patientId) throws SQLException {
    PreparedStatement existsQuery = con.prepareStatement("SELECT COUNT(*) FROM patients WHERE patient_id = ?");
    existsQuery.setInt(1, patientId);
    ResultSet result = existsQuery.executeQuery();

    if (result.next()) {
        int count = result.getInt(1);
        return count > 0; // Si count > 0, significa que el paciente con el DNI existe
    }

    return false; // Si no se encuentra ningún paciente con el DNI
}
    
}
