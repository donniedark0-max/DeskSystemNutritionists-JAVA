/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Darko.Form;

import Connection.Database;
import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import table.TableCustom;

/**
 *
 * @author jjose
 */
public class Form_3 extends javax.swing.JPanel {

    /**
     * Creates new form Form_3
     */
    public Form_3() throws SQLException {
        initComponents();
        
        
         FlatInterFont.install();
        
        UIManager.put("defaultFont", new Font( FlatInterFont.FAMILY, Font.PLAIN, 12 ));
        this.setBackground(new Color(255, 255, 255));

        jLabel1.setFont(new Font(FlatInterFont.FAMILY, Font.BOLD, 24 ));
      
         this.setBackground(Color.WHITE);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        testData(jTable1);
    }

    private void testData(JTable table) throws SQLException {
                Connection con = null;
        con = Database.getInstance().getConnection();

    try {
    // Crear una consulta SQL que obtenga datos de múltiples tablas usando JOIN
    String consulta = "SELECT " +
                      "P.patient_id, P.first_name, P.last_name, BH.bmi_value, P.weight, P.height, " +
                      "A.dx_Nutritional, A.notes " +
                      "FROM patients P " +
                      "INNER JOIN medical_records M ON P.patient_id = M.patient_id " +
                      "INNER JOIN appointments A ON P.patient_id = A.patient_id " +
                      "INNER JOIN bmi_history BH ON P.patient_id = BH.patient_id";
    
    // Preparar la consulta
    PreparedStatement preparedStatement = con.prepareStatement(consulta);

    // Ejecutar la consulta
    ResultSet resultado = preparedStatement.executeQuery();

    // Agregar las columnas al modelo de la tabla
    DefaultTableModel model = (DefaultTableModel) table.getModel();

    // Agregar filas a la tabla desde el resultado de la consulta
    while (resultado.next()) {
        int patientId = resultado.getInt("patient_id");
        String firstName = resultado.getString("first_name");
        String lastName = resultado.getString("last_name");
        double bmiValue = resultado.getDouble("bmi_value");
        double weight = resultado.getDouble("weight");
        double height = resultado.getDouble("height");
        String dxNutritional = resultado.getString("dx_Nutritional");
        String notes = resultado.getString("notes");

        // Agregar una fila al modelo de la tabla
        model.addRow(new Object[]{patientId, firstName, lastName, bmiValue, weight, height, dxNutritional, notes});
    }
    } catch (SQLException e) {
    // Manejo de errores si ocurre alguna excepción SQL
    e.printStackTrace();
}
                
            
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnPDF = new Darko.Swing.ButtonOutLine();

        setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setText("Historial consultas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Apellido", "IMC", "Peso", "Talla", "Dx Nutricional", "Observación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(270);
        }

        btnPDF.setBackground(new java.awt.Color(51, 153, 0));
        btnPDF.setText("PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(462, 462, 462)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(469, 469, 469)
                                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed

  MessageFormat header = new MessageFormat("HISTORIAL DE CONSULTAS");
        MessageFormat footer = new MessageFormat("   (0, number,integer)SISTEMA DE GESTION | PREVENTORIO         ");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            jTable1.print(JTable.PrintMode.FIT_WIDTH,header, footer, true, set, true);
            JOptionPane.showMessageDialog(null, "\n"+ "PDF generado");
        } catch (java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(null,  "\n"+ "ERROR"
                    +  "\n"+ e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Darko.Swing.ButtonOutLine btnPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
