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
public class Form_2 extends javax.swing.JPanel {

    /**
     * Creates new form Form_2
     */
    public Form_2() throws SQLException {
        initComponents();
        
        
         FlatInterFont.install();
        
        UIManager.put("defaultFont", new Font( FlatInterFont.FAMILY, Font.PLAIN, 12 ));
        this.setBackground(new Color(255, 255, 255));

        jLabel1.setFont(new Font(FlatInterFont.FAMILY, Font.BOLD, 24 ));
                jLabel2.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 15 ));
        jLabel3.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 15 ));
        jLabel4.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 15 ));

         this.setBackground(Color.WHITE);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        testData(jTable1);
        
        
    }
    
    private void testData(JTable table) throws SQLException {
                Connection con = null;
        con = Database.getInstance().getConnection();

    // Crear una consulta SQL
    String consulta = "SELECT M.patient_id, M.record_date, P.first_name, P.last_name, M.Medicant, M.Note, P.height, P.weight " +
                  "FROM medical_records M " +
                  "INNER JOIN patients P ON M.patient_id = P.patient_id";
            // Preparar la consulta
            PreparedStatement preparedStatement = con.prepareStatement(consulta);

            // Ejecutar la consulta
            ResultSet resultado = preparedStatement.executeQuery();

            // Agregar las columnas al modelo de la tabla
              DefaultTableModel model = (DefaultTableModel) table.getModel();
//        model.addRow(new Object[]{1, "pattient_id"});
//            model.addRow(new Object[]{2,"record_date"});
//            model.addRow(new Object[]{3,"Medicant"});
//            model.addRow(new Object[]{4,"Note"});

            // Agregar filas a la tabla desde el resultado de la consulta
            while (resultado.next()) {
                String dni = resultado.getString("patient_id");
                String nombre = resultado.getString("first_name");
                String apellido = resultado.getString("last_name");
                String medicant = resultado.getString("Medicant");
                String note = resultado.getString("Note");
                double peso = resultado.getDouble("height");
                double talla = resultado.getDouble("weight");

                // Agregar una fila al modelo de la tabla
    model.addRow(new Object[]{dni, nombre, apellido, medicant, note, peso, talla});
            }
                
            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonOutLine1 = new Darko.Swing.ButtonOutLine();

        setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setText("HISTORIAL MEDICO");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre ", "Apellido", "Medicamento", "Nota", "Peso", "Talla"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(50);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
        }

        jLabel2.setText("Recuerda que si deseas");

        jLabel3.setText("eliminar un paciente puedes ");

        jLabel4.setText("hacerlo desde Dashboard");

        buttonOutLine1.setBackground(new java.awt.Color(51, 153, 0));
        buttonOutLine1.setText("PDF");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(buttonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(66, 66, 66)
                        .addComponent(buttonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(214, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOutLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
        MessageFormat header = new MessageFormat("HISTORIAL MEDICO");
        MessageFormat footer = new MessageFormat("   (0, number,integer)SISTEMA DE GESTION | PREVENTORIO         ");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            jTable1.print(JTable.PrintMode.FIT_WIDTH,header, footer, true, set, true);
            JOptionPane.showMessageDialog(null, "\n"+ "PDF generado");
        } catch (java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(null,  "\n"+ "ERROR"
                    +  "\n"+ e);
        }
            
            
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonOutLine1ActionPerformed

    
    
    
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Darko.Swing.ButtonOutLine buttonOutLine1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
}
