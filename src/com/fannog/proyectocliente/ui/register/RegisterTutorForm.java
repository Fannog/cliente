package com.fannog.proyectocliente.ui.register;

public class RegisterTutorForm extends javax.swing.JPanel {

    public RegisterTutorForm() {
        initComponents();
    }

    public String getArea() {
        return txtArea.getText();
    }

    public String getRol() {
        return String.valueOf(comboRolTutor.getSelectedItem());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArea = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        lblRolTutor = new javax.swing.JLabel();
        comboRolTutor = new javax.swing.JComboBox<>();

        lblArea.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblArea.setText("Área correspondiente");

        txtArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });
        txtArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaKeyTyped(evt);
            }
        });

        lblRolTutor.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblRolTutor.setText("Rol del Tutor");

        comboRolTutor.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboRolTutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encargado", "Tutor" }));
        comboRolTutor.setToolTipText("");
        comboRolTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRolTutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArea)
                    .addComponent(txtArea, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRolTutor)
                    .addComponent(comboRolTutor, 0, 239, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblRolTutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboRolTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblArea)
                .addGap(11, 11, 11)
                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed

    }//GEN-LAST:event_txtAreaActionPerformed

    private void txtAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaKeyTyped
    }//GEN-LAST:event_txtAreaKeyTyped

    private void comboRolTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRolTutorActionPerformed

    }//GEN-LAST:event_comboRolTutorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboRolTutor;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblRolTutor;
    private javax.swing.JTextField txtArea;
    // End of variables declaration//GEN-END:variables
}
