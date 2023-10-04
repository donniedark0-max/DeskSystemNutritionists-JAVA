package Darko.Form;

import Chart.ModelChartLine;
import Chart.ModelChartPie;
import Connection.Database;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import table.TableCustom;

public class Form_1 extends javax.swing.JPanel {

    public Form_1() throws ParseException, SQLException {
        initComponents();
          TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        testData(jTable1);
        initData();
    }

    
    
    
    private void initData() throws ParseException {
        
        
        // Crear una lista para almacenar los datos de la base de datos
        List<ModelChartPie> list1 = obtenerDatosPie();

        // Asignar los datos a tu gráfico de pastel
        chartPie.setModel(list1);
        
       Map<String, Integer> datosPorDiaSemana = obtenerDatosDesdeBaseDeDatos();

        // Crear una lista de objetos ModelChartLine a partir de los datos consolidados
        List<ModelChartLine> list = new ArrayList<>();
        list.add(new ModelChartLine("Lunes", obtenerValorSegunDia(datosPorDiaSemana, "lunes")));
        list.add(new ModelChartLine("Martes", obtenerValorSegunDia(datosPorDiaSemana, "martes")));
        list.add(new ModelChartLine("Miércoles", obtenerValorSegunDia(datosPorDiaSemana, "miércoles")));
        list.add(new ModelChartLine("Jueves", obtenerValorSegunDia(datosPorDiaSemana, "jueves")));
        list.add(new ModelChartLine("Viernes", obtenerValorSegunDia(datosPorDiaSemana, "viernes")));
        list.add(new ModelChartLine("Sábado", obtenerValorSegunDia(datosPorDiaSemana, "sábado")));
        list.add(new ModelChartLine("Domingo", obtenerValorSegunDia(datosPorDiaSemana, "domingo")));

        // Establecer los datos en el segundo gráfico
        chartLine1.setModel(list);

        System.out.println("Contenido de datosPorDiaSemana: " + datosPorDiaSemana);   
        }
    
    private int obtenerValorSegunDia(Map<String, Integer> datosPorDiaSemana, String dia) {
    Integer valor = datosPorDiaSemana.get(dia);
    return valor != null ? valor.intValue() : 0;
}    
    private Map<String, Integer> obtenerDatosDesdeBaseDeDatos() throws ParseException {
    Map<String, Integer> valoresPorDiaSemana = new HashMap<>();
    Connection con = null;
    con = Database.getInstance().getConnection();

    try  {
        // Consulta SQL para contar las filas por fecha en la tabla bmi_history
        String sql = "SELECT date, COUNT(*) AS count FROM bmi_history GROUP BY date";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Define el idioma español para los formatos de fecha
        Locale locale = new Locale("es", "ES");

        // Define el formato de fecha para analizar las fechas
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        // Define el formato de día de la semana
        SimpleDateFormat formatoDiaSemana = new SimpleDateFormat("EEEE", locale);

        // Iterar a través de los resultados de la consulta
        while (resultSet.next()) {
            String fecha = resultSet.getString("date"); // Obtiene la fecha
            int count = resultSet.getInt("count"); // Obtiene el recuento

            // Convierte la fecha al formato correcto
            Date fechaDate = formatoFecha.parse(fecha);

            String diaSemana = formatoDiaSemana.format(fechaDate);

            // Verifica si ya hay un valor para ese día de la semana y, si es así, suma el recuento al valor existente
            if (valoresPorDiaSemana.containsKey(diaSemana)) {
                int valorExistente = valoresPorDiaSemana.get(diaSemana);
                valoresPorDiaSemana.put(diaSemana, valorExistente + count);
            } else {
                // Si no hay un valor existente para ese día de la semana, simplemente agrega el nuevo valor
                valoresPorDiaSemana.put(diaSemana, count);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return valoresPorDiaSemana;
}

   private List<ModelChartPie> obtenerDatosPie() throws ParseException {
    List<ModelChartPie> listaDatos = new ArrayList<>();
    Connection con = null;
    con = Database.getInstance().getConnection();

    try  {
        // Consulta SQL para contar los textos específicos en la columna dx_Nutritional
        String sql = "SELECT dx_Nutritional, COUNT(*) AS count FROM appointments " +
                     "GROUP BY dx_Nutritional";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Mapea los nombres de los textos específicos a los colores
        Map<String, Color> coloresPorTexto = new HashMap<>();
        coloresPorTexto.put("Normopeso", new Color(4, 174, 243));
        coloresPorTexto.put("Sobrepeso", new Color(215, 39, 250));
        coloresPorTexto.put("Obesidad", new Color(44, 88, 236));
        coloresPorTexto.put("Obesidad II", new Color(21, 202, 87));
        coloresPorTexto.put("Obesidad III", new Color(127, 63, 255));

        // Itera a través de los resultados de la consulta
        while (resultSet.next()) {
            String textoEspecifico = resultSet.getString("dx_Nutritional"); // Obtiene el texto específico
            int count = resultSet.getInt("count"); // Obtiene el recuento

            // Verifica si el texto específico tiene un color mapeado
            Color color = coloresPorTexto.get(textoEspecifico);
            if (color == null) {
                // Si no hay un color mapeado para el texto específico, usa un color predeterminado
                color = Color.BLACK;
            }

            // Agrega un nuevo objeto ModelChartPie a la lista
            listaDatos.add(new ModelChartPie(textoEspecifico, count, color));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaDatos;
}

 
    private void testData(JTable table) throws SQLException {
                Connection con = null;
        con = Database.getInstance().getConnection();

      // Crear una consulta SQL
    String consulta = "SELECT P.patient_id, P.first_name, P.last_name, B.bmi_value, P.birthdate, P.gender " +
                     "FROM patients P " +
                     "LEFT JOIN bmi_history B ON P.patient_id = B.patient_id";
    
    // Preparar la consulta
    PreparedStatement preparedStatement = con.prepareStatement(consulta);

    // Ejecutar la consulta
    ResultSet resultado = preparedStatement.executeQuery();

    // Agregar las columnas al modelo de la tabla
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    int numeroPaciente = 1;
    // Agregar filas a la tabla desde el resultado de la consulta
    while (resultado.next()) {
        String patientId = resultado.getString("patient_id");
        String firstName = resultado.getString("first_name");
        String lastName = resultado.getString("last_name");
        double bmiValue = resultado.getDouble("bmi_value");
        Date birthdate = resultado.getDate("birthdate");
        String gender = resultado.getString("gender");

        // Agregar una fila al modelo de la tabla
        model.addRow(new Object[]{numeroPaciente,patientId, firstName, lastName, bmiValue, birthdate, gender});
        
         numeroPaciente++;
    }      
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartPie = new Chart.ChartPie();
        chartLine1 = new Chart.ChartLine();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new Darko.Swing.Button();
        btnPDF = new Darko.Swing.ButtonOutLine();

        setBackground(new java.awt.Color(250, 250, 250));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Nombre", "Apellido", "IMC", "Cumpleaños", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        btnEliminar.setBackground(new java.awt.Color(102, 204, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chartLine1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chartPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarPacienteSeleccionado();
        JOptionPane.showMessageDialog(this, "Usuario eliminado con exito");
        try {
            testData(jTable1);
        } catch (SQLException ex) {
            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            initData();
        } catch (ParseException ex) {
            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed

        MessageFormat header = new MessageFormat("PACIENTES");
        MessageFormat footer = new MessageFormat("   (0, number,integer)SISTEMA DE GESTION | PREVENTORIO         ");
        PrintRequestAttributeSet set; // TODO add your handling code here:
        set = new HashPrintRequestAttributeSet();
        set.add(OrientationRequested.LANDSCAPE);
        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH,header, footer, true, set, true);
        } catch (PrinterException ex) {
            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException ex) {
            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "\n"+ "PDF generado");
    }//GEN-LAST:event_btnPDFActionPerformed

    private void eliminarPacienteSeleccionado() {
    // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = jTable1.getSelectedRow();
    
    if (filaSeleccionada >= 0) {
        // Obtener el valor de patient_id de la fila seleccionada
        String patientId = jTable1.getModel().getValueAt(filaSeleccionada, 1).toString();
        
        // Eliminar registros en tablas hijas (asegúrate de seguir el orden correcto)
        eliminarRegistrosEnTablaBmiHistory(patientId);
        eliminarRegistrosEnTablaAppointments(patientId);
        eliminarRegistrosEnTablaMedicalRecords(patientId);
        eliminarRegistrosEnTablaDates(patientId);
        
        // Finalmente, eliminar el paciente de la tabla patients
        eliminarPacienteEnTablaPatients(patientId);
    }
}

private void eliminarRegistrosEnTablaBmiHistory(String patientId) {
Connection con = null;
    PreparedStatement preparedStatement = null;

    try {
        // Establecer la conexión a la base de datos
        con = Database.getInstance().getConnection();

        // Crear la consulta SQL para eliminar los registros en bmi_history
        String sql = "DELETE FROM bmi_history WHERE patient_id = ?";
        preparedStatement = con.prepareStatement(sql);

        // Establecer el valor de patient_id en la consulta
        preparedStatement.setString(1, patientId);

        // Ejecutar la consulta para eliminar los registros
        int filasAfectadas = preparedStatement.executeUpdate();

        // Comprobar si se eliminaron registros y mostrar un mensaje
        if (filasAfectadas > 0) {
            System.out.println("Se han eliminado " + filasAfectadas + " registros en bmi_history para el paciente con patient_id: " + patientId);
        } else {
            System.out.println("No se encontraron registros en bmi_history para el paciente con patient_id: " + patientId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            // Cerrar la conexión y el PreparedStatement
            if (preparedStatement != null) {
                preparedStatement.close();
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

private void eliminarRegistrosEnTablaAppointments(String patientId) {
    Connection con = null;
    PreparedStatement preparedStatement = null;

    try {
        // Establecer la conexión a la base de datos
        con = Database.getInstance().getConnection();

        // Crear la consulta SQL para eliminar los registros en appointments
        String sql = "DELETE FROM appointments WHERE patient_id = ?";
        preparedStatement = con.prepareStatement(sql);

        // Establecer el valor de patient_id en la consulta
        preparedStatement.setString(1, patientId);

        // Ejecutar la consulta para eliminar los registros
        int filasAfectadas = preparedStatement.executeUpdate();

        // Comprobar si se eliminaron registros y mostrar un mensaje
        if (filasAfectadas > 0) {
            System.out.println("Se han eliminado " + filasAfectadas + " registros en appointments para el paciente con patient_id: " + patientId);
        } else {
            System.out.println("No se encontraron registros en appointments para el paciente con patient_id: " + patientId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            // Cerrar la conexión y el PreparedStatement
            if (preparedStatement != null) {
                preparedStatement.close();
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

private void eliminarRegistrosEnTablaMedicalRecords(String patientId) {
    Connection con = null;
    PreparedStatement preparedStatement = null;

    try {
        // Establecer la conexión a la base de datos
        con = Database.getInstance().getConnection();

        // Crear la consulta SQL para eliminar los registros en medical_records
        String sql = "DELETE FROM medical_records WHERE patient_id = ?";
        preparedStatement = con.prepareStatement(sql);

        // Establecer el valor de patient_id en la consulta
        preparedStatement.setString(1, patientId);

        // Ejecutar la consulta para eliminar los registros
        int filasAfectadas = preparedStatement.executeUpdate();

        // Comprobar si se eliminaron registros y mostrar un mensaje
        if (filasAfectadas > 0) {
            System.out.println("Se han eliminado " + filasAfectadas + " registros en medical_records para el paciente con patient_id: " + patientId);
        } else {
            System.out.println("No se encontraron registros en medical_records para el paciente con patient_id: " + patientId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            // Cerrar la conexión y el PreparedStatement
            if (preparedStatement != null) {
                preparedStatement.close();
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

private void eliminarRegistrosEnTablaDates(String patientId) {
    Connection con = null;
    PreparedStatement preparedStatement = null;

    try {
        // Establecer la conexión a la base de datos
        con = Database.getInstance().getConnection();

        // Crear la consulta SQL para eliminar los registros en dates
        String sql = "DELETE FROM dates WHERE patient_id = ?";
        preparedStatement = con.prepareStatement(sql);

        // Establecer el valor de patient_id en la consulta
        preparedStatement.setString(1, patientId);

        // Ejecutar la consulta para eliminar los registros
        int filasAfectadas = preparedStatement.executeUpdate();

        // Comprobar si se eliminaron registros y mostrar un mensaje
        if (filasAfectadas > 0) {
            System.out.println("Se han eliminado " + filasAfectadas + " registros en dates para el paciente con patient_id: " + patientId);
        } else {
            System.out.println("No se encontraron registros en dates para el paciente con patient_id: " + patientId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            // Cerrar la conexión y el PreparedStatement
            if (preparedStatement != null) {
                preparedStatement.close();
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

private void eliminarPacienteEnTablaPatients(String patientId) {
    Connection con = null;
    PreparedStatement preparedStatement = null;

    try {
        // Establecer la conexión a la base de datos
        con = Database.getInstance().getConnection();

        // Crear la consulta SQL para eliminar el paciente en patients
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        preparedStatement = con.prepareStatement(sql);

        // Establecer el valor de patient_id en la consulta
        preparedStatement.setString(1, patientId);

        // Ejecutar la consulta para eliminar el paciente
        int filasAfectadas = preparedStatement.executeUpdate();

        // Comprobar si se eliminó el paciente y mostrar un mensaje
        if (filasAfectadas > 0) {
            System.out.println("Se ha eliminado al paciente con patient_id: " + patientId);
        } else {
            System.out.println("No se encontró al paciente con patient_id: " + patientId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            // Cerrar la conexión y el PreparedStatement
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Darko.Swing.Button btnEliminar;
    private Darko.Swing.ButtonOutLine btnPDF;
    private Chart.ChartLine chartLine1;
    private Chart.ChartPie chartPie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
