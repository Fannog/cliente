package com.fannog.proyectocliente.ui.register;

import com.fannog.proyectocliente.ui.login.Login;
import com.fannog.proyectocliente.utils.BeanFactory;
import com.fannog.proyectocliente.utils.FieldUtils;
import com.fannog.proyectocliente.utils.Validator;
import com.fannog.proyectoservidor.DAO.AnalistaDAO;
import com.fannog.proyectoservidor.DAO.DepartamentoDAO;
import com.fannog.proyectoservidor.DAO.EstadoUsuarioDAO;
import com.fannog.proyectoservidor.DAO.EstudianteDAO;
import com.fannog.proyectoservidor.DAO.TutorDAO;
import com.fannog.proyectoservidor.DAO.UsuarioDAO;
import com.fannog.proyectoservidor.entities.Analista;
import com.fannog.proyectoservidor.entities.Departamento;
import com.fannog.proyectoservidor.entities.EstadoUsuario;
import com.fannog.proyectoservidor.entities.Estudiante;
import com.fannog.proyectoservidor.entities.Localidad;
import com.fannog.proyectoservidor.entities.Tutor;
import com.fannog.proyectoservidor.entities.Usuario;
import com.fannog.proyectoservidor.exceptions.ServicioException;
import java.awt.Component;
import java.util.List;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    private BeanFactory beanFactory = BeanFactory.create();
    private Validator validator = new Validator();
    boolean esTutor = false;
    boolean esEstudiante = true;

    public Register() {
        initComponents();

        showTipoUsuarioFields();
        populateComboDepartamento();
    }

    public void populateComboDepartamento() {
        DepartamentoDAO depDAO = beanFactory.lookup("Departamento");

        List<Departamento> departamentos = depDAO.findAllWithLocalidades();

        comboDepartamento.setModel(new DefaultComboBoxModel(departamentos.toArray()));

        departamentoChanged();
    }

    public void departamentoChanged() {
        Departamento selectedDepartamento = (Departamento) comboDepartamento.getSelectedItem();
        List<Localidad> localidades = selectedDepartamento.getLocalidades();

        comboLocalidad.setModel(new DefaultComboBoxModel(localidades.toArray()));
    }

    public void showTipoUsuarioFields() {
        String selectedTipoUsuario = String.valueOf(comboTipoUsuario.getSelectedItem());
        this.esTutor = selectedTipoUsuario.equalsIgnoreCase("tutor");
        this.esEstudiante = selectedTipoUsuario.equalsIgnoreCase("estudiante");

        registerEstudianteForm1.setVisible(esEstudiante);
        registerTutorForm1.setVisible(esTutor);
    }

    public void registrarUsuario() throws ServicioException, NamingException {
        EstadoUsuarioDAO estUsuDAO = beanFactory.lookup("EstadoUsuario");
        EstadoUsuario estado = estUsuDAO.findById(1L);

        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String documento = txtDocumento.getText();
        documento = validator.cleanCi(documento); //LIMPIANDO LOS CARACTERES . Y -
//        Long parsedDocumento = Long.parseLong(documento);
        String email = txtEmail.getText();
        Integer telefono = Integer.parseInt(txtTelefono.getText().replace(" ", ""));
        String password = new String(txtPassword.getPassword());
        String itr = comboITR.getSelectedItem().toString();
        Localidad localidad = (Localidad) comboLocalidad.getSelectedItem();

        UsuarioDAO usuarioDao = beanFactory.lookup("Usuario");
        Usuario usuario = null;

        if (esTutor) {
            String area = registerTutorForm1.getArea();
            String rol = registerTutorForm1.getRol();

            usuario = new Tutor(area, rol, apellidos, documento, email, nombres, telefono, password, estado, localidad, 2L);
        }

        if (esEstudiante) {
            Integer generacion = Integer.parseInt(registerEstudianteForm1.getAñoIngreso());

            usuario = new Estudiante(generacion, apellidos, documento, email, nombres, telefono, password, estado, localidad, 1L);
        }

        if (!esEstudiante && !esTutor) {
            usuario = new Analista(apellidos, documento, email, nombres, telefono, password, estado, localidad, 3L);
        }
        
        usuarioDao.create(usuario);

        JOptionPane.showMessageDialog(this, "Usuario registrado con éxito. Quedas a espera de verificación");
        
        dispose();
        
        Login login = new Login();
        login.setVisible(true);

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
        txtPassword = new javax.swing.JPasswordField();
        lblTipoDeUsuario = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        comboTipoUsuario = new javax.swing.JComboBox<>();
        comboITR = new javax.swing.JComboBox<>();
        lblITR = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JFormattedTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        registerEstudianteForm1 = new com.fannog.proyectocliente.ui.register.RegisterEstudianteForm();
        registerTutorForm1 = new com.fannog.proyectocliente.ui.register.RegisterTutorForm();
        lblDepartamento = new javax.swing.JLabel();
        comboDepartamento = new javax.swing.JComboBox<>();
        comboLocalidad = new javax.swing.JComboBox<>();
        lblLocalidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrarse");

        jLabel1.setFont(new java.awt.Font("Source Serif Pro Black", 0, 36)); // NOI18N
        jLabel1.setText("Registrarse");

        txtNombres.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        txtPassword.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N

        lblTipoDeUsuario.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblTipoDeUsuario.setText("Tipo de usuario");

        btnRegistrarse.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        comboTipoUsuario.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESTUDIANTE", "TUTOR", "ANALISTA" }));
        comboTipoUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoUsuarioItemStateChanged(evt);
            }
        });

        comboITR.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboITR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUROESTE", "CENTRO-SUR", "NORTE" }));

        lblITR.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblITR.setText("ITR");

        try {
            txtDocumento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDocumento.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("09# ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N

        lblDepartamento.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblDepartamento.setText("Departamento");

        comboDepartamento.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDepartamentoItemStateChanged(evt);
            }
        });
        comboDepartamento.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Departamento) {
                    Departamento departamento = (Departamento) value;
                    setText(departamento.getNombre());
                }
                return this;
            }
        });

        comboLocalidad.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboLocalidad.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Localidad) {
                    Localidad localidad = (Localidad) value;
                    setText(localidad.getNombre());
                }
                return this;
            }
        });

        lblLocalidad.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblLocalidad.setText("Localidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(registerTutorForm1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(156, 156, 156))
                                    .addComponent(comboTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtDocumento)
                                    .addComponent(comboLocalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblDocumento)
                                    .addComponent(lblTipoDeUsuario)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(219, 219, 219))
                                    .addComponent(txtNombres))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail)
                                    .addComponent(txtPassword)
                                    .addComponent(comboITR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDepartamento)
                                            .addComponent(lblEmail)
                                            .addComponent(lblConstrasenia)
                                            .addComponent(lblITR)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(39, 39, 39)))
                                        .addGap(180, 180, 180))))
                            .addComponent(registerEstudianteForm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombres)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDocumento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDocumento)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblConstrasenia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipoDeUsuario)
                                .addGap(12, 12, 12)
                                .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblITR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboITR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDepartamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLocalidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerEstudianteForm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerTutorForm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        try {
            registrarUsuario();
        } catch (ServicioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NamingException ex) {
        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        FieldUtils.esTexto(evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        FieldUtils.esTexto(evt);
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void comboTipoUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoUsuarioItemStateChanged
        showTipoUsuarioFields();
    }//GEN-LAST:event_comboTipoUsuarioItemStateChanged

    private void comboDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDepartamentoItemStateChanged
        departamentoChanged();
    }//GEN-LAST:event_comboDepartamentoItemStateChanged

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
    private javax.swing.JComboBox<String> comboDepartamento;
    private javax.swing.JComboBox<String> comboITR;
    private javax.swing.JComboBox<String> comboLocalidad;
    private javax.swing.JComboBox<String> comboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblConstrasenia;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblITR;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoDeUsuario;
    private com.fannog.proyectocliente.ui.register.RegisterEstudianteForm registerEstudianteForm1;
    private com.fannog.proyectocliente.ui.register.RegisterTutorForm registerTutorForm1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
