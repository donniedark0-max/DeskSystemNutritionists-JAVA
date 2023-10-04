/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Darko.Form;

import Connection.Database;
import Darko.Model.ModelAppoint;
import Darko.Model.ModelMedRecord;
import Darko.Model.ModelPatient;
import Service.ServicePatient;
import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author jjose
 */


public class Form_6 extends javax.swing.JPanel {
    
     private ServicePatient serviceP;
        /**
         * Creates new form Form_6
         */
//    public Form_6(){
//           con = Database.getInstance().getConnection();
//       }
    private ModelMedRecord MedRecord;
    private ModelAppoint appoint;
    private ModelPatient patient;
    private ModelPatient patient_id;
     public ModelPatient getPatient() {
        return patient;
    }
     public ModelPatient getPatient_id() {
        return patient_id;
    }
             
    public Form_6(ActionListener eventRegister, java.sql.Connection con) {
        initComponents();
        patient = new ModelPatient();
         initRegister(eventRegister);
        FlatInterFont.install();
        
        UIManager.put("defaultFont", new Font( FlatInterFont.FAMILY, Font.PLAIN, 12 ));
        this.setBackground(new Color(255, 255, 255));
        
        jLabel1.setFont(new Font(FlatInterFont.FAMILY, Font.BOLD, 24 ));
        jLabel2.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 15 ));
        jLabel3.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 15 ));
        jLabel4.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 10 ));
        jLabel5.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 12 ));
        jLabel6.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 12 ));
        jLabel7.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 15 ));
        jLabel8.setFont(new Font(FlatInterFont.FAMILY, Font.PLAIN, 15 ));

        btnCalcIMC.setBackground(new Color(7, 164, 121));
        btnCalcIMC.setForeground(new Color(0,95,50));
        btnGuardar.setBackground(new Color(7, 164, 121));
        btnGuardar.setForeground(new Color(250, 250, 250));
        
        
//         calIBM(eventCalculate);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        txtNombre = new textfield.TextField();
        txtApellido = new textfield.TextFieldAp();
        txtEdad = new textfield.TextFieldEd();
        txtFNac = new textfield.TextFieldFNac();
        txtDni = new textfield.TextFieldDNI();
        txtTel = new textfield.TextFieldTel();
        cmbxGener = new combo_suggestion.ComboBoxSuggestion();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bxASSi = new checkbox.JCheckBoxCustom();
        bxASNo = new checkbox.JCheckBoxCustom();
        txtEspec = new textfield_suggestion.TextFieldSuggestion();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMedic = new textfield_suggestion.TextFieldSuggestion();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtPeso = new textfield.TextFieldPeso();
        txtTall = new textfield.TextFieldTall();
        btnCalcIMC = new Darko.Swing.ButtonOutLine();
        jLabel8 = new javax.swing.JLabel();
        textAreaScroll1 = new textarea.TextAreaScroll();
        txtDxNutri = new textarea.TextArea();
        txtObs = new textarea.TextAreaScroll();
        txtObser = new textarea.TextArea();
        jSeparator4 = new javax.swing.JSeparator();
        btnGuardar = new Darko.Swing.Button();
        jSeparator5 = new javax.swing.JSeparator();
        txtIMC = new javax.swing.JTextField();
        btnGuardar2 = new Darko.Swing.Button();

        setBackground(new java.awt.Color(250, 250, 250));

        txtNombre.setLineColor(new java.awt.Color(51, 153, 0));
        txtNombre.setSelectionColor(new java.awt.Color(102, 204, 0));

        txtApellido.setLineColor(new java.awt.Color(51, 153, 0));
        txtApellido.setSelectionColor(new java.awt.Color(102, 204, 0));

        txtEdad.setLineColor(new java.awt.Color(0, 153, 0));
        txtEdad.setSelectionColor(new java.awt.Color(102, 204, 0));

        txtFNac.setLineColor(new java.awt.Color(51, 153, 0));
        txtFNac.setSelectionColor(new java.awt.Color(102, 204, 0));

        txtDni.setLineColor(new java.awt.Color(51, 153, 0));
        txtDni.setSelectionColor(new java.awt.Color(102, 204, 0));

        txtTel.setLineColor(new java.awt.Color(51, 153, 0));
        txtTel.setSelectionColor(new java.awt.Color(102, 204, 0));

        cmbxGener.setForeground(new java.awt.Color(0, 204, 0));
        cmbxGener.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        cmbxGener.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("HISTORIA CLÍNICA NUTRICIONAL");

        jLabel2.setText("DATOS PERSONALES");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setText("ANTECEDENTES SALUD/ ENFERMEDAD");

        jLabel4.setText("(Diabetes, hipertensión, asma, etc)");

        bxASSi.setBackground(new java.awt.Color(51, 204, 0));
        bxASSi.setText("SÍ");

        bxASNo.setBackground(new java.awt.Color(246, 105, 105));
        bxASNo.setText("NO");

        txtEspec.setSelectionColor(new java.awt.Color(51, 153, 0));

        jLabel5.setText("Especificar:");

        jLabel6.setText("Medicamento:");

        txtMedic.setSelectionColor(new java.awt.Color(51, 153, 0));

        jLabel7.setText("COMPOSICIPON CORPORAL");

        txtPeso.setLineColor(new java.awt.Color(51, 153, 0));
        txtPeso.setSelectionColor(new java.awt.Color(102, 204, 0));

        txtTall.setLineColor(new java.awt.Color(51, 153, 0));
        txtTall.setSelectionColor(new java.awt.Color(102, 204, 0));

        btnCalcIMC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCalcIMC.setText("CALCULAR IMC");
        btnCalcIMC.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCalcIMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcIMCActionPerformed(evt);
            }
        });

        jLabel8.setText("DIAGNÓSTICO");

        textAreaScroll1.setLabelText("Dx Nutricional:");
        textAreaScroll1.setLineColor(new java.awt.Color(51, 204, 0));

        txtDxNutri.setColumns(20);
        txtDxNutri.setRows(5);
        txtDxNutri.setSelectionColor(new java.awt.Color(102, 204, 0));
        textAreaScroll1.setViewportView(txtDxNutri);

        txtObs.setLabelText("Observación:");
        txtObs.setLineColor(new java.awt.Color(51, 204, 0));

        txtObser.setColumns(20);
        txtObser.setRows(5);
        txtObser.setSelectionColor(new java.awt.Color(102, 204, 0));
        txtObs.setViewportView(txtObser);

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnGuardar.setText("GUARDAR");
        btnGuardar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtIMC.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtIMC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIMC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 0), 1, true));
        txtIMC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtIMC.setEnabled(false);
        txtIMC.setSelectionColor(new java.awt.Color(51, 204, 255));

        btnGuardar2.setText("GUARDAR IMC");
        btnGuardar2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbxGener, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(bxASSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(bxASNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnCalcIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtIMC))
                                        .addComponent(txtPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                        .addComponent(txtTall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(125, 125, 125))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(129, 129, 129))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMedic, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEspec, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)))))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtObs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(268, 268, 268)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(835, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bxASSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bxASNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEspec, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(2, 2, 2)
                                .addComponent(txtMedic, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(btnCalcIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtFNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbxGener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1)))
                        .addGap(21, 21, 21))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcIMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcIMCActionPerformed
        // TODO add your handling code here:
        String heightStr = txtTall.getText();
        String weightStr = txtPeso.getText();

            // Verifica que los campos no estén vacíos
            if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
                try {
                    // Convierte los valores a números
                    double height = Double.parseDouble(heightStr);
                    double weight = Double.parseDouble(weightStr);

                    // Calcula el índice de masa corporal (IBM)
                    double ibm = weight / (height * height);
                    ibm = Math.round(ibm * 10.0) / 10.0;
                    System.out.println("IMC: " + ibm);
                    // Configura el resultado en txtIBM
                    
                    String ibmString = Double.toString(ibm);
                    txtIMC.setText(ibmString);
                } catch (NumberFormatException ex) {
                    // Manejo de errores si los valores ingresados no son números válidos
                    txtIMC.setText("Error");
                }
            } else {
                // Manejo de errores si alguno de los campos está vacío
                txtIMC.setText("Error");
            }
              
    }//GEN-LAST:event_btnCalcIMCActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
         try {
             registerPatient(patient);
             insertMedRecord(MedRecord);
             insertAppoint(appoint);
             
             // TODO add your handling code here:
         } catch (SQLException ex) {
             Logger.getLogger(Form_6.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed
        
 ModelPatient patient = this.getPatient();
    double bmi = patient.getBmi();
         try {
             insertIBM(patient, bmi);
             // TODO add your handling code here:
         } catch (SQLException ex) {
             Logger.getLogger(Form_6.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnGuardar2ActionPerformed
        
    
//        private void register(){
//            ModelPatient patient = this.getPatient();
//            if (patient != null) {
//            try {
//    //            serviceP.insertPatient(patient);
//                 int patient_id = insertPatient(patient);
//                 System.out.println("Generated patientId: " + patient_id);
////                this.insertPatient(patient);
////                this.insertIBM(patient);
//                if (patient_id != -1) { // Agrega una verificación para asegurarte de que "patientId" sea válido
//                insertIBM(patient_id, patient.getBmi());
//            } else {
//                JOptionPane.showMessageDialog(this, "Error Registering Patient.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(this, "Error Register.", "Error", JOptionPane.ERROR_MESSAGE);
//                System.out.println(e.getLocalizedMessage());
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Patient is empty.", "Error", JOptionPane.ERROR_MESSAGE);
//
//          }
//        }
    
    private void initRegister(ActionListener eventRegister){
        btnGuardar.addActionListener(eventRegister);
        btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String dniString = txtDni.getText().trim();
                int patient_id = Integer.parseInt(dniString);
                String first_name = txtNombre.getText().trim();
                String last_name = txtApellido.getText().trim();
                String birthdate = txtFNac.getText().trim();
                String gender = cmbxGener.getSelectedItem().toString().trim();
                String heightText = txtTall.getText().trim();
                String weightText = txtPeso.getText().trim();
                double height = Double.parseDouble(heightText);
                double weight = Double.parseDouble(weightText);
                String bmitext = txtIMC.getText().trim();
                double bmi_value = Double.parseDouble(bmitext);
                //Historia Clinica
                String specify = txtEspec.getText().trim();
                String medicament = txtMedic.getText().trim();
                Date fechaActual = new Date();

        // Convierte la fecha actual a java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(fechaActual.getTime());

                //Appointements
                String dx_Nutritional = txtDxNutri.getText().trim();
                String notes = txtObser.getText().trim();
                patient = new ModelPatient(patient_id, first_name, last_name, birthdate, gender, height, weight, bmi_value);
                patient.setHeight(height);
                patient.setWeight(weight);
                //History
                MedRecord = new ModelMedRecord(patient_id, sqlDate, medicament, specify);
                System.out.println("Historial medico "+ patient_id+ sqlDate + specify +medicament);
                appoint = new ModelAppoint(patient_id, dx_Nutritional,notes);
                System.out.println("Observaciones : "+ patient_id+  dx_Nutritional + notes);
            }
            
        });
    }
    
    
    public void insertMedRecord(ModelMedRecord MedRecord) throws SQLException{
        Connection con = null;
        Date fechaActual = new Date();

        // Convierte la fecha actual a java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(fechaActual.getTime());
        
        con = Database.getInstance().getConnection();
        PreparedStatement p = con.prepareStatement("INSERT INTO medical_records (patient_id, record_date,Medicant, Note) VALUES (?,?,?,?)");
        p.setInt(1, MedRecord.getPatient_id());
        p.setDate(2,sqlDate);
        p.setString(3, MedRecord.getMedicant());
        p.setString(4, MedRecord.getNote());
        p.executeUpdate();
            p.close();
    }
    
    public void insertAppoint(ModelAppoint appoint) throws SQLException{
        Connection con = null;
       
        con = Database.getInstance().getConnection();
        PreparedStatement p = con.prepareStatement("INSERT INTO appointments (patient_id, dx_Nutritional,notes) VALUES (?,?,?)");
        p.setInt(1, appoint.getPatient_id());
        p.setString(2,appoint.getDx_Nutritional());
        p.setString(3, appoint.getNotes());
        p.executeUpdate();
            p.close();
    }
    
     
    public int insertPatient(ModelPatient patient) throws SQLException{
        Connection con = null;
         
//        if (isEmpty(patient)){
//            return;
//        }
         
            // Obtiene la conexión desde la clase Database
            con = Database.getInstance().getConnection();
       PreparedStatement p = con.prepareStatement("INSERT INTO patients (patient_id, first_name, last_name, birthdate, gender, height, weight) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
       p.setInt(1, patient.getPatient_id());
       p.setString(2,patient.getFirst_name());
       p.setString(3, patient.getLast_name());
       p.setString(4, patient.getBirthdate());
       p.setString(5, patient.getGender());
       p.setString(6, Double.toString(patient.getHeight()));
       p.setString(7, Double.toString(patient.getWeight()));
       
       
    
           int rowsAffected = p.executeUpdate();
    if (rowsAffected == 1) {
        ResultSet generatedKeys = p.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1); // Retorna el patient_id generado
        }
    }
    return -1;
    }
    
    
    
    private void insertIBM(ModelPatient patient, double bmi) throws SQLException {
     try {
            int patientId = patient.getPatient_id(); // Asegúrate de que patientId se obtenga de manera correcta
            Connection con = Database.getInstance().getConnection();
            LocalDate currentDate = LocalDate.now();
            java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

            // Verifica si el paciente con el ID existe en la tabla "patients"
             if (!patientExists(con, patientId)) {
            // Si no existe, muestra un mensaje de error
            System.out.println("Error: El paciente con ID " + patientId + " no existe en la tabla patients.");
            return; // Ahora está dentro de un método válido
             }
        
            // Obtiene la conexión desde la clase Database
            con = Database.getInstance().getConnection();
            PreparedStatement p = con.prepareStatement("INSERT INTO bmi_history (patient_id, date, bmi_value) VALUES (?,?,?)");
            p.setInt(1, patientId);
            p.setDate(2, sqlDate);
            p.setDouble(3, bmi);
            p.executeUpdate();
            p.close();
            System.out.println("BMI history inserted successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error inserting BMI history.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getLocalizedMessage());
        }
     }
    
    private int registerPatient(ModelPatient patient) throws SQLException {
    int patientId = insertPatient(patient);
    if (patientId == patient.getPatient_id()) {
        System.out.println("Patient registered successfully. Patient ID: " + patientId);
    } else {
        System.out.println("Error registering patient.");
    }
    return patientId;
}
    
//    private void completeRegistration(ModelPatient patient, double bmi) {
//    try {
//        int patientId = registerPatient(patient);
//        if (patientId == patient.getPatient_id()) {
//            insertIBM(patientId, bmi);
//            // Aquí puedes realizar cualquier otra acción después de completar la inserción en bmi_history
//            System.out.println("BMI history inserted successfully.");
//        
//        } else {
//                JOptionPane.showMessageDialog(this, "Error Registering Patient en funcion complete registtration.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, "Error Register.", "Error", JOptionPane.ERROR_MESSAGE);
//            System.out.println(e.getLocalizedMessage());
//        }
//    }
    
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Darko.Swing.ButtonOutLine btnCalcIMC;
    private Darko.Swing.Button btnGuardar;
    private Darko.Swing.Button btnGuardar2;
    private checkbox.JCheckBoxCustom bxASNo;
    private checkbox.JCheckBoxCustom bxASSi;
    private combo_suggestion.ComboBoxSuggestion cmbxGener;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private textarea.TextAreaScroll textAreaScroll1;
    private textfield.TextFieldAp txtApellido;
    private textfield.TextFieldDNI txtDni;
    private textarea.TextArea txtDxNutri;
    private textfield.TextFieldEd txtEdad;
    private textfield_suggestion.TextFieldSuggestion txtEspec;
    private textfield.TextFieldFNac txtFNac;
    private javax.swing.JTextField txtIMC;
    private textfield_suggestion.TextFieldSuggestion txtMedic;
    private textfield.TextField txtNombre;
    private textarea.TextAreaScroll txtObs;
    private textarea.TextArea txtObser;
    private textfield.TextFieldPeso txtPeso;
    private textfield.TextFieldTall txtTall;
    private textfield.TextFieldTel txtTel;
    // End of variables declaration//GEN-END:variables
}