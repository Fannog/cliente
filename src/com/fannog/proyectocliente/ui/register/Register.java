package com.fannog.proyectocliente.ui.register;

import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
        camposTipoUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblConstrasenia = new javax.swing.JLabel();
        txtConstrasenia = new javax.swing.JPasswordField();
        lblTipoDeUsuario = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        comboTipoUsuario = new javax.swing.JComboBox<>();
        comboITR = new javax.swing.JComboBox<>();
        lblITR = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        lblAnioIngreso = new javax.swing.JLabel();
        txtAnioIngreso = new javax.swing.JTextField();
        comboRolTutor = new javax.swing.JComboBox<>();
        lblRolTutor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrarse");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Source Serif Pro Black", 0, 36)); // NOI18N
        jLabel1.setText("Registrarse");

        txtNombres.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        lblNombres.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblNombres.setText("Nombres");

        lblApellidos.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblApellidos.setText("Apellidos");

        lblDocumento.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblDocumento.setText("Documento");

        txtDocumento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblTelefono.setText("Telefono");

        lblConstrasenia.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblConstrasenia.setText("Contraseña");

        txtConstrasenia.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N

        lblTipoDeUsuario.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblTipoDeUsuario.setText("Tipo de usuario");

        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        comboTipoUsuario.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Tutor", "Analista" }));
        comboTipoUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoUsuarioItemStateChanged(evt);
            }
        });
        comboTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoUsuarioActionPerformed(evt);
            }
        });

        comboITR.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboITR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suroeste", "Centro-Sur", "Norte" }));
        comboITR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboITRActionPerformed(evt);
            }
        });

        lblITR.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblITR.setText("ITR");

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

        lblAnioIngreso.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblAnioIngreso.setText("Año de ingreso");
        lblAnioIngreso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtAnioIngreso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAnioIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioIngresoActionPerformed(evt);
            }
        });
        txtAnioIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioIngresoKeyTyped(evt);
            }
        });

        comboRolTutor.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboRolTutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encargado", "Tutor" }));
        comboRolTutor.setToolTipText("");
        comboRolTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRolTutorActionPerformed(evt);
            }
        });

        lblRolTutor.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblRolTutor.setText("Rol del Tutor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboRolTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRolTutor)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblNombres)
                            .addGap(180, 180, 180)
                            .addComponent(lblApellidos))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblDocumento)
                            .addGap(161, 161, 161)
                            .addComponent(lblEmail))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblTelefono)
                            .addGap(181, 181, 181)
                            .addComponent(lblConstrasenia))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(txtConstrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblTipoDeUsuario)
                            .addGap(127, 127, 127)
                            .addComponent(lblITR))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboITR, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAnioIngreso)
                                .addComponent(txtAnioIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblArea)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombres)
                    .addComponent(lblApellidos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDocumento)
                    .addComponent(lblEmail))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono)
                    .addComponent(lblConstrasenia))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConstrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoDeUsuario)
                    .addComponent(lblITR))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboITR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArea)
                    .addComponent(lblAnioIngreso))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnioIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRolTutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboRolTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarse)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUsuarioActionPerformed

    }//GEN-LAST:event_comboTipoUsuarioActionPerformed

    private void comboITRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboITRActionPerformed

    }//GEN-LAST:event_comboITRActionPerformed

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed

    }//GEN-LAST:event_txtAreaActionPerformed

    private void comboTipoUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoUsuarioItemStateChanged
        camposTipoUsuario();
    }//GEN-LAST:event_comboTipoUsuarioItemStateChanged

    private void txtAnioIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioIngresoActionPerformed

    }//GEN-LAST:event_txtAnioIngresoActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed

    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed

    }//GEN-LAST:event_txtApellidosActionPerformed

    private void comboRolTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRolTutorActionPerformed

    }//GEN-LAST:event_comboRolTutorActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        if (comprobarCamposBlancos() == true) {

        } else if (verificarCaracteres() == true) {

        } else if (!txtTelefono.getText().startsWith("09")) {
            JOptionPane.showMessageDialog(this, "Telefono debe tener formato 09XXXXXXX");
        } else if (validarFechaIngreso() == true) {

        } else {
            System.out.println("Registro... En proceso");
        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        esNumero(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        esNumero(evt);
    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        esTexto(evt);

    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        esTexto(evt);
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtAnioIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioIngresoKeyTyped
        esNumero(evt);
    }//GEN-LAST:event_txtAnioIngresoKeyTyped

    private void txtAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaKeyTyped
        esTexto(evt);
    }//GEN-LAST:event_txtAreaKeyTyped

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Register().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JComboBox<String> comboITR;
    private javax.swing.JComboBox<String> comboRolTutor;
    private javax.swing.JComboBox<String> comboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAnioIngreso;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblConstrasenia;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblITR;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblRolTutor;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoDeUsuario;
    private javax.swing.JTextField txtAnioIngreso;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtArea;
    private javax.swing.JPasswordField txtConstrasenia;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public boolean verificarCaracteres() {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(txtEmail.getText());

        if (txtNombres.getText().length() >= 50 || txtNombres.getText().length() <= 2) {
            JOptionPane.showMessageDialog(this, "Nombres debe contener entre 2 y 50 caracteres");
            return true;
        } else if (txtApellidos.getText().length() >= 50 || txtApellidos.getText().length() <= 2) {
            JOptionPane.showMessageDialog(this, "Apellidos debe contener entre 2 y 50 caracteres");
            return true;
        } else if (txtDocumento.getText().length() != 8) {
            JOptionPane.showMessageDialog(this, "Documento debe tener formato 12345678");
            return true;
        } else if (matcher.find() == false) {
            JOptionPane.showMessageDialog(this, "Email debe tener formato ejemplo@ejemplo.com");
            return true;
        } else if (txtTelefono.getText().length() != 9) {
            JOptionPane.showMessageDialog(this, "Telefono debe tener 9 digitos");
            return true;
        } else if (txtConstrasenia.getPassword().length >= 20 || txtConstrasenia.getPassword().length <= 4) {
            JOptionPane.showMessageDialog(this, "Contraseña debe tener entre 4 y 20 caracteres");
            return true;
        } else if (comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("estudiante")) {
            if (txtAnioIngreso.getText().length() != 4) {
                JOptionPane.showMessageDialog(this, "Año de Ingreso debe tener 4 digitos");
                return true;
            }
        } else if ((comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("tutor"))) {
            if (txtArea.getText().length() >= 50 || txtArea.getText().length() <= 2) {
                JOptionPane.showMessageDialog(this, "");
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public boolean comprobarCamposBlancos() {
        if (txtNombres.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Nombres se encuentra vacío");
            return true;
        } else if (txtApellidos.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Apellidos se encuentra vacío");
            return true;
        } else if (txtDocumento.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Docuemento se encuentra vacío");
            return true;
        } else if (txtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Email se encuentra vacío");
            return true;
        } else if (txtTelefono.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Teléfono se encuentra vacío");
            return true;
        } else if (txtConstrasenia.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Contraseña se encuentra vacío");
            return true;
        } else if (comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("estudiante")) {
            if (txtAnioIngreso.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Año de Ingreso se encuentra vacío");
                return true;
            }
        } else if (comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("estudiante")) {
            if (txtArea.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Año de Ingreso se encuentra vacío");
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    /**
     *
     */
    public void camposTipoUsuario() {
        if (comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("tutor")) {
            txtArea.setVisible(true);
            lblArea.setVisible(true);
            lblRolTutor.setVisible(true);
            comboRolTutor.setVisible(true);

            lblAnioIngreso.setVisible(false);
            txtAnioIngreso.setVisible(false);

        } else if (comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("estudiante")) {
            lblAnioIngreso.setVisible(true);
            txtAnioIngreso.setVisible(true);

            txtArea.setVisible(false);
            lblArea.setVisible(false);
            lblRolTutor.setVisible(false);
            comboRolTutor.setVisible(false);
        } else {
            lblAnioIngreso.setVisible(false);
            txtAnioIngreso.setVisible(false);
            txtArea.setVisible(false);
            lblArea.setVisible(false);
            lblRolTutor.setVisible(false);
            comboRolTutor.setVisible(false);
        }
    }

    public void esNumero(java.awt.event.KeyEvent evt) {
        Character c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    public void esTexto(java.awt.event.KeyEvent evt) {
        Character c = evt.getKeyChar();

        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }

    public boolean validarFechaIngreso() {
        try {
            Date fechaActual = new Date(System.currentTimeMillis());
            String fechaIngreso = txtAnioIngreso.getText();
            Date fechaFundacion = new Date(1012);
            SimpleDateFormat date = new SimpleDateFormat("yyyy");
            Date fechaInicioDate = date.parse(fechaIngreso);

            if (fechaInicioDate.after(fechaActual)) {
                JOptionPane.showMessageDialog(this, "Año de Ingreso es mayor al año actual");
                return true;
                //No funciona aun
            } else if (fechaInicioDate.before(fechaFundacion)) {
                JOptionPane.showMessageDialog(this, "Año de Ingreso es menor al año de fundación de UTEC");
                return true;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
