package com.fannog.proyectocliente.ui.register;

import java.util.Optional;

public class RegisterEstudianteForm extends javax.swing.JPanel {

    public RegisterEstudianteForm() {
        initComponents();
    }

    public String getAñoIngreso() {
       return txtAñoIngreso.getText();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnioIngreso = new javax.swing.JLabel();
        txtAñoIngreso = new javax.swing.JFormattedTextField();

        lblAnioIngreso.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblAnioIngreso.setText("Año de ingreso");
        lblAnioIngreso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        try {
            txtAñoIngreso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtAñoIngreso.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAnioIngreso)
                .addContainerGap(287, Short.MAX_VALUE))
            .addComponent(txtAñoIngreso)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAnioIngreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAñoIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAnioIngreso;
    private javax.swing.JFormattedTextField txtAñoIngreso;
    // End of variables declaration//GEN-END:variables
}
