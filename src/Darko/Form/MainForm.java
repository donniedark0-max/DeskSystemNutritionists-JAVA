package Darko.Form;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Darko.Component.Header; // Importar la clase Header desde el mismo paquete Form
import java.sql.SQLException;
import java.text.ParseException;

public class MainForm extends javax.swing.JPanel {

    public MainForm() throws ParseException, SQLException {
        initComponents();
        show(new Form_1());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        header1 = new Darko.Component.Header();

        setBackground(new java.awt.Color(250, 250, 250));

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param event
     */
    public void addEventMenu(ActionListener event) {
        header1.addEventMenu(event);
    }

    public void initMoving(JFrame fram) {
        header1.initMoving(fram);
    }

    public void show(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private Darko.Component.Header header1;
    // End of variables declaration//GEN-END:variables
}
