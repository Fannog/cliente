package com.fannog.proyectocliente.ui.register;

import com.fannog.proyectocliente.utils.FieldUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();

        formTutor.setVisible(false);
    }

    public void camposTipoUsuario() {
        String selectedTipoUsuario = comboTipoUsuario.getSelectedItem().toString();

        formTutor.setVisible(selectedTipoUsuario.equalsIgnoreCase("tutor"));
        formEstudiante.setVisible(selectedTipoUsuario.equalsIgnoreCase("estudiante"));
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
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblConstrasenia = new javax.swing.JLabel();
        txtConstrasenia = new javax.swing.JPasswordField();
        lblTipoDeUsuario = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        comboTipoUsuario = new javax.swing.JComboBox<>();
        comboITR = new javax.swing.JComboBox<>();
        lblITR = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JFormattedTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        formEstudiante = new com.fannog.proyectocliente.ui.register.RegisterEstudianteForm();
        formTutor = new com.fannog.proyectocliente.ui.register.RegisterTutorForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrarse");

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

        lblEmail.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        try {
            txtDocumento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDocumento.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("09# ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.setFont(new java.awt.Font("Source Sans Pro", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(formTutor, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(formEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombres)
                            .addComponent(txtDocumento)
                            .addComponent(txtTelefono)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblDocumento)
                                    .addComponent(lblTipoDeUsuario)
                                    .addComponent(lblNombres))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos)
                            .addComponent(txtEmail)
                            .addComponent(comboITR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtConstrasenia)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellidos)
                                    .addComponent(lblEmail)
                                    .addComponent(lblConstrasenia)
                                    .addComponent(lblITR))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDocumento)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefono))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblConstrasenia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtConstrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblITR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboITR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipoDeUsuario)
                        .addGap(12, 12, 12)
                        .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addComponent(formEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUsuarioActionPerformed
        camposTipoUsuario();
    }//GEN-LAST:event_comboTipoUsuarioActionPerformed

    private void comboITRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboITRActionPerformed

    }//GEN-LAST:event_comboITRActionPerformed

    private void comboTipoUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoUsuarioItemStateChanged
        String selectedTipoUsuario = comboTipoUsuario.getSelectedItem().toString();

        formTutor.setVisible(selectedTipoUsuario.equalsIgnoreCase("tutor"));
        formEstudiante.setVisible(selectedTipoUsuario.equalsIgnoreCase("estudiante"));
    }//GEN-LAST:event_comboTipoUsuarioItemStateChanged

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed

    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed

    }//GEN-LAST:event_txtApellidosActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        if (comprobarCamposBlancos() == true) {

        } else if (verificarCaracteres() == true) {

        } else if (validarFechaIngreso() == true) {

        } else {
            System.out.println("Registro... En proceso");
        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        FieldUtils.esTexto(evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        FieldUtils.esTexto(evt);
    }//GEN-LAST:event_txtApellidosKeyTyped

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
    private javax.swing.JComboBox<String> comboTipoUsuario;
    private com.fannog.proyectocliente.ui.register.RegisterEstudianteForm formEstudiante;
    private com.fannog.proyectocliente.ui.register.RegisterTutorForm formTutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblConstrasenia;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblITR;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoDeUsuario;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtConstrasenia;
    private javax.swing.JFormattedTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JFormattedTextField txtTelefono;
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
        } else if (matcher.find() == false) {
            JOptionPane.showMessageDialog(this, "Email debe tener formato ejemplo@ejemplo.com");
            return true;
        } else if (txtConstrasenia.getPassword().length >= 20 || txtConstrasenia.getPassword().length <= 4) {
            JOptionPane.showMessageDialog(this, "Contraseña debe tener entre 4 y 20 caracteres");
            return true;
        } else if ((comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("tutor"))) {
            if (formTutor.getArea().length() >= 50 || formTutor.getArea().length() <= 2) {
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
            if (formEstudiante.getAñoIngreso() == null) {
                JOptionPane.showMessageDialog(this, "Año de Ingreso se encuentra vacío");
                return true;
            }
        } else if (comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("estudiante")) {
            if (formTutor.getArea().isBlank()) {
                JOptionPane.showMessageDialog(this, "Año de Ingreso se encuentra vacío");
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public boolean validarFechaIngreso() {
        try {
            Date fechaActual = new Date(System.currentTimeMillis());
            Optional<Integer> fechaIngreso = formEstudiante.getAñoIngreso();
            Date fechaFundacion = new Date(1012);
            SimpleDateFormat date = new SimpleDateFormat("yyyy");
            Date fechaInicioDate = date.parse(fechaIngreso.toString());

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
