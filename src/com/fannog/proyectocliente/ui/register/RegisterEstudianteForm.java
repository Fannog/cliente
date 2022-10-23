package com.fannog.proyectocliente.ui.register;

import com.fannog.proyectoservidor.DAO.DepartamentoDAO;
import com.fannog.proyectoservidor.entities.Departamento;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class RegisterEstudianteForm extends javax.swing.JPanel {

    public RegisterEstudianteForm() {
        initComponents();
        populateComboGeneracion();
    }

    public String getAñoIngreso() {
       return comboGeneracion.getSelectedItem().toString();
        
    }
    
    public void populateComboGeneracion() {

        //List<String> generaciones = null;
        LocalDate current_date = LocalDate.now();
        int current_Year = current_date.getYear();
        
        for(int i = 2012; i <= current_Year; i++ ){
            String año = String.valueOf(i);
            comboGeneracion.addItem(año);
            //generaciones.add(año);
        }
        
        //comboGeneracion.setModel(new DefaultComboBoxModel(generaciones.toArray()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnioIngreso = new javax.swing.JLabel();
        comboGeneracion = new javax.swing.JComboBox<>();

        lblAnioIngreso.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblAnioIngreso.setText("Año de ingreso");
        lblAnioIngreso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        comboGeneracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboGeneracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGeneracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAnioIngreso)
                .addContainerGap(287, Short.MAX_VALUE))
            .addComponent(comboGeneracion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAnioIngreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboGeneracion, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboGeneracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGeneracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGeneracionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboGeneracion;
    private javax.swing.JLabel lblAnioIngreso;
    // End of variables declaration//GEN-END:variables
}
