package com.fannog.proyectocliente.ui.register;

import com.fannog.proyectocliente.utils.FieldUtils;
import com.fannog.proyectocliente.utils.Validator;
import com.fannog.proyectoservidor.DAO.DepartamentoDAO;
import com.fannog.proyectoservidor.DAO.impl.AnalistaDAOImpl;
import com.fannog.proyectoservidor.DAO.impl.DepartamentoDAOImpl;
import com.fannog.proyectoservidor.DAO.impl.EstadoUsuarioDAOImpl;
import com.fannog.proyectoservidor.DAO.impl.EstudianteDAOImpl;
import com.fannog.proyectoservidor.DAO.impl.LocalidadDAOImpl;
import com.fannog.proyectoservidor.DAO.impl.TutorDAOImpl;
import com.fannog.proyectoservidor.entities.Analista;
import com.fannog.proyectoservidor.entities.Departamento;
import com.fannog.proyectoservidor.entities.EstadoUsuario;
import com.fannog.proyectoservidor.entities.Estudiante;
import com.fannog.proyectoservidor.entities.Tutor;
import com.fannog.proyectoservidor.exceptions.ServicioException;
import java.time.Year;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;

public class Register extends javax.swing.JFrame {
    
    Validator validator = new Validator();

    public Register() {
        initComponents();
        camposTipoUsuario();
        llenarComboDepartamento();
    }

    public void llenarComboDepartamento() {
        Departamento departamento = new Departamento();
        DepartamentoDAOImpl depto = new DepartamentoDAOImpl();
        List<Departamento> departamentos = depto.findAll();
        
        comboDepartamento.setModel(new DefaultComboBoxModel<>(departamentos.toArray(String[]::new)));
    }
    
    /*
    METODO PARA COMPROBAR TIPO DE USUARIO ESTA SELECCIONADO Y MODIFICAR
    LA VENTANA DE REGISTRO EN FUNCION DE ESO
     */
    public void camposTipoUsuario() {
        String selectedTipoUsuario = comboTipoUsuario.getSelectedItem().toString();

        if (selectedTipoUsuario.equalsIgnoreCase("tutor")) {
            registerEstudianteForm1.setVisible(false);
            registerTutorForm1.setVisible(true);
        } else if (selectedTipoUsuario.equalsIgnoreCase("estudiante")) {
            registerEstudianteForm1.setVisible(true);
            registerTutorForm1.setVisible(false);
        } else {
            registerEstudianteForm1.setVisible(false);
            registerTutorForm1.setVisible(false);
        }
        //formTutor.setVisible(selectedTipoUsuario.equalsIgnoreCase("tutor"));
    }

    //METODO PARA REGISTRAR UN USUARIO AL SISTEMA
    public void registrarUsuario() throws ServicioException {
       

        LocalidadDAOImpl localidad = new LocalidadDAOImpl();
        EstadoUsuarioDAOImpl estadoUsuario1 = new EstadoUsuarioDAOImpl();
        EstadoUsuario estadoUsuario = estadoUsuario1.findById(1L);

        //RECOPILACIÓN DE DATOS GENERICOS DE USUARIO
        String nombresUsuario = txtNombres.getText();
        String apellidosUsuario = txtApellidos.getText();
        String docUser = txtDocumento.getText();
        docUser = validator.cleanCi(docUser); //LIMPIANDO LOS CARACTERES . Y -
        Long documentoUsuario = Long.parseLong(docUser);
        String emailUsuario = txtEmail.getText();
        String telUsuario = txtTelefono.getText().replace(" ", "");
        Long telefonoUsuario = Long.parseLong(telUsuario);
        String contraseñaUsuario = txtConstrasenia.getText();
        String selectedTipoUsuario = comboTipoUsuario.getSelectedItem().toString();
        String selectedITR = comboITR.getSelectedItem().toString();
        String emailInstitucional = txtEmailInstitucional.getText();
        String localidadUsuario = comboDepartamento.getSelectedItem().toString();

        //CREACIÓN DE USUARIO DE TIPO TUTOR
        if (selectedTipoUsuario.equalsIgnoreCase("tutor")) {
            String areaTutor = registerTutorForm1.getArea();
            String rolTutor = registerTutorForm1.getRol();

            Tutor t1 = new Tutor(areaTutor, rolTutor, apellidosUsuario, documentoUsuario, emailInstitucional, emailUsuario, nombresUsuario, telefonoUsuario, contraseñaUsuario, estadoUsuario, localidad.findById(1924L));
            TutorDAOImpl tutor = new TutorDAOImpl();
            tutor.create(t1);
            System.out.println("Tutor creado");

            //CREACIÓN DE USUARIO DE TIPO ESTUDIANTE
        } else if (selectedTipoUsuario.equalsIgnoreCase("estudiante")) {
            String añoIng = registerEstudianteForm1.getAñoIngreso();
            int añoC = Integer.parseInt(añoIng);
            Year y = Year.of(añoC);
            
            Estudiante e1 = new Estudiante(y, apellidosUsuario, documentoUsuario, emailInstitucional, emailUsuario, nombresUsuario, telefonoUsuario, contraseñaUsuario, estadoUsuario, localidad.findById(1924L));
            EstudianteDAOImpl estudiante = new EstudianteDAOImpl();
            estudiante.create(e1);
            System.out.println("Estudiante creado");

            //CREACIÓN DE USUARIO DE TIPO ANALISTA
        } else {

            Analista a1 = new Analista(apellidosUsuario, documentoUsuario, emailInstitucional, emailUsuario, nombresUsuario, telefonoUsuario, contraseñaUsuario, estadoUsuario, localidad.findById(1924L));
            AnalistaDAOImpl analista = new AnalistaDAOImpl();
            analista.create(a1);
            System.out.println("Analista creado");

        }
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
        registerEstudianteForm1 = new com.fannog.proyectocliente.ui.register.RegisterEstudianteForm();
        registerTutorForm1 = new com.fannog.proyectocliente.ui.register.RegisterTutorForm();
        lblEmailInstitucinal = new javax.swing.JLabel();
        txtEmailInstitucional = new javax.swing.JTextField();
        lblDepartamento = new javax.swing.JLabel();
        comboDepartamento = new javax.swing.JComboBox<>();
        comboLocalidad = new javax.swing.JComboBox<>();
        lblLocalidad = new javax.swing.JLabel();

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

        lblEmailInstitucinal.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblEmailInstitucinal.setText("Email Institucional");

        txtEmailInstitucional.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmailInstitucional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailInstitucionalActionPerformed(evt);
            }
        });

        lblDepartamento.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        lblDepartamento.setText("Departamento");

        comboDepartamento.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDepartamentoActionPerformed(evt);
            }
        });

        comboLocalidad.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        comboLocalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suroeste", "Centro-Sur", "Norte" }));
        comboLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLocalidadActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocalidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerEstudianteForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEmailInstitucinal)
                                        .addGap(147, 147, 147)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidos)
                                    .addComponent(txtEmail)
                                    .addComponent(comboITR, 0, 280, Short.MAX_VALUE)
                                    .addComponent(txtConstrasenia)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDepartamento)
                                            .addComponent(lblApellidos)
                                            .addComponent(lblEmail)
                                            .addComponent(lblConstrasenia)
                                            .addComponent(lblITR))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(registerTutorForm1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 388, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtEmailInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboDepartamento, 0, 281, Short.MAX_VALUE)))
                        .addGap(42, 42, 42))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipoDeUsuario)
                        .addGap(12, 12, 12)
                        .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblITR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboITR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmailInstitucinal)
                    .addComponent(lblDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLocalidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(registerEstudianteForm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(registerTutorForm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    }//GEN-LAST:event_comboTipoUsuarioItemStateChanged

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed

    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed

    }//GEN-LAST:event_txtApellidosActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
//        try {
//            registrarUsuario();
//        } catch (ServicioException ex) {
//            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
//        }

        LocalidadDAOImpl localidad = new LocalidadDAOImpl();
        EstadoUsuarioDAOImpl estadoUsuario = new EstadoUsuarioDAOImpl();
        
        System.out.println(estadoUsuario.findAll());
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        FieldUtils.esTexto(evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        FieldUtils.esTexto(evt);
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void comboDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepartamentoActionPerformed

    private void txtEmailInstitucionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailInstitucionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailInstitucionalActionPerformed

    private void comboLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLocalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLocalidadActionPerformed

    public static void main(String args[]) throws NamingException {
        
        DepartamentoDAO depDAO = InitialContext.doLookup("ejb:ProyectoServidor/ProyectoEJB-ejb/DepartamentoDAOImpl!com.fannog.proyectoservidor.DAO.DepartamentoDAO");
                                                                
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
    private javax.swing.JLabel lblEmailInstitucinal;
    private javax.swing.JLabel lblITR;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoDeUsuario;
    private com.fannog.proyectocliente.ui.register.RegisterEstudianteForm registerEstudianteForm1;
    private com.fannog.proyectocliente.ui.register.RegisterTutorForm registerTutorForm1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtConstrasenia;
    private javax.swing.JFormattedTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailInstitucional;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
