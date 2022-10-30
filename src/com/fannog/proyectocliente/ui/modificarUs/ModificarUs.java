package com.fannog.proyectocliente.ui.modificarUs;

import com.fannog.proyectocliente.utils.BeanFactory;
import com.fannog.proyectocliente.utils.FieldUtils;
import com.fannog.proyectocliente.utils.Globals;
import com.fannog.proyectocliente.utils.Validator;
import com.fannog.proyectoservidor.DAO.DepartamentoDAO;
import com.fannog.proyectoservidor.DAO.ItrDAO;
import com.fannog.proyectoservidor.DAO.LocalidadDAO;
import com.fannog.proyectoservidor.DAO.UsuarioDAO;
import com.fannog.proyectoservidor.entities.Analista;
import com.fannog.proyectoservidor.entities.Departamento;
import com.fannog.proyectoservidor.entities.Estudiante;
import com.fannog.proyectoservidor.entities.Itr;
import com.fannog.proyectoservidor.entities.Localidad;
import com.fannog.proyectoservidor.entities.Tutor;
import com.fannog.proyectoservidor.entities.Usuario;
import com.fannog.proyectoservidor.exceptions.ServicioException;
import java.awt.Component;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ModificarUs extends javax.swing.JFrame {

    private Validator validator = new Validator();

    public ModificarUs() {
        initComponents();

        try {
            traerUsuario(Globals.getLoggedUser().getNombreUsuario());
        } catch (ServicioException e) {
        } catch (Exception ex) {
        }
    }

    public void editarEstudiantes() throws ServicioException, Exception {
        UsuarioDAO usuarioDAO = BeanFactory.local().lookup("Usuario");
        Usuario usuarioFind = usuarioDAO.findByNombreUsuario(txtNombreUsuario.getText());

        if (usuarioFind instanceof Estudiante) {
            Estudiante usuario = (Estudiante) usuarioFind;
            usuario.setNombres(txtNombres.getText());
            usuario.setApellidos(txtApellidos.getText());
            usuario.setDocumento(txtDocumento.getText());
            usuario.setEmail(txtTelefono.getText());
            usuario.setTelefono(Integer.parseInt(txtEmail.getText()));
            Localidad localidad = (Localidad) comboLocalidad.getSelectedItem();
            usuario.setLocalidad(localidad);
            Itr itr = (Itr) comboITRs.getSelectedItem();
            usuario.setItr(itr);
            usuario.setGeneracion(Integer.parseInt(modEst1.getGeneracion()));

            usuarioDAO.edit(usuario);

        } else if (usuarioFind instanceof Tutor) {
            Tutor usuario = (Tutor) usuarioFind;
            usuario.setNombres(txtNombres.getText());
            usuario.setApellidos(txtApellidos.getText());
            usuario.setDocumento(txtDocumento.getText());
            usuario.setEmail(txtTelefono.getText());
            usuario.setTelefono(Integer.parseInt(txtEmail.getText()));
            Localidad localidad = (Localidad) comboLocalidad.getSelectedItem();
            usuario.setLocalidad(localidad);
            Itr itr = (Itr) comboITRs.getSelectedItem();
            usuario.setItr(itr);
            usuario.setArea(modTut1.getArea());
            usuario.setRol(modTut1.getRol());

            usuarioDAO.edit(usuario);
        } else {
            Analista usuario = (Analista) usuarioFind;
            usuario.setNombres(txtNombres.getText());
            usuario.setApellidos(txtApellidos.getText());
            usuario.setDocumento(txtDocumento.getText());
            usuario.setEmail(txtTelefono.getText());
            usuario.setTelefono(Integer.parseInt(txtEmail.getText()));
            Localidad localidad = (Localidad) comboLocalidad.getSelectedItem();
            usuario.setLocalidad(localidad);
            Itr itr = (Itr) comboITRs.getSelectedItem();
            usuario.setItr(itr);

            usuarioDAO.edit(usuario);
        }

    }

    public void traerUsuario(String nombreUsuario) throws ServicioException, Exception {
        UsuarioDAO usuarioDAO = BeanFactory.local().lookup("Usuario");
        Usuario usuario = usuarioDAO.findByNombreUsuario(nombreUsuario);

        LocalidadDAO localidadDAO = BeanFactory.local().lookup("Localidad");
        List<Localidad> localidades = localidadDAO.findByNombre(usuario.getLocalidad().getNombre());

        txtNombres.setText(usuario.getNombres());
        txtApellidos.setText(usuario.getApellidos());
        txtNombreUsuario.setText(usuario.getNombreUsuario());
        txtPassword.setText("**********");
        txtDocumento.setText(usuario.getDocumento());
        txtEmail.setText("0" + String.valueOf(usuario.getTelefono()));
        txtTelefono.setText(usuario.getEmail());
        for (Localidad l : localidades) {
            if (l.getId().longValue() == usuario.getLocalidad().getId().longValue()) {
                comboDepartamento.setSelectedItem(l.getDepartamento().getNombre());
                comboLocalidad.setSelectedItem(l.getNombre());

            }
            comboITRs.setSelectedItem(usuario.getItr().getNombre());
        }

        if (usuario instanceof Estudiante) {
            System.out.println("Estas en estudiante");
            Estudiante estudiante = (Estudiante) usuario;

            modEst1.setVisible(true);
            modTut1.setVisible(false);
            modEst1.populateComboGeneracion();
            modEst1.setGeneracion(String.valueOf(estudiante.getGeneracion()));

        } else if (usuario instanceof Tutor) {
            System.out.println("Estas en tutor");
            Tutor tutor = (Tutor) usuario;

            modEst1.setVisible(false);
            modTut1.setVisible(true);

            modTut1.setArea(tutor.getArea());
            modTut1.setRol(tutor.getRol());

        } else {
            System.out.println("Estas en analista");

            modEst1.setVisible(false);
            modTut1.setVisible(false);
        }

    }

    public void populateComboDepartamento() throws Exception {
        DepartamentoDAO depDAO = BeanFactory.local().lookup("Departamento");

        List<Departamento> departamentos = depDAO.findAllWithLocalidades();

        comboDepartamento.setModel(new DefaultComboBoxModel(departamentos.toArray()));

        departamentoChanged();
    }

    public void departamentoChanged() {
        Departamento selectedDepartamento = (Departamento) comboDepartamento.getSelectedItem();
        List<Localidad> localidades = selectedDepartamento.getLocalidades();

        comboLocalidad.setModel(new DefaultComboBoxModel(localidades.toArray()));
    }

    public void populateComboITR() throws Exception {
        ItrDAO itrDAO = BeanFactory.local().lookup("Itr");

        List<Itr> itrs = itrDAO.findAll();

        comboITRs.setModel(new DefaultComboBoxModel(itrs.toArray()));
    }

    public void controlEditar() throws ServicioException, Exception {
        UsuarioDAO usuarioDAO = BeanFactory.local().lookup("Usuario");
        Usuario usuario = usuarioDAO.findByNombreUsuario(txtNombreUsuario.getText());

        String documento = txtDocumento.getText();
        documento = validator.cleanCi(documento);

        if (txtNombres.getText().trim().length() < 2 || txtNombres.getText().trim().length() > 50) {
            throw new ServicioException("El campo Nombres debe tener entre 2 y 50 caracteres");
        } else if (txtApellidos.getText().trim().length() < 2 || txtApellidos.getText().trim().length() > 50) {
            throw new ServicioException("El campo Apellidos debe tener entre 2 y 50 caracteres");
        } else if (documento.length() != 8) {
            throw new ServicioException("El campo Documento debe tener formato 1.234.567-8");
        } else if (usuario instanceof Estudiante) {
            if (!txtEmail.getText().endsWith("@estudiantes.utec.edu.uy")) {
                throw new ServicioException("El email de estudiante debe terminar con @estudiantes.utec.edu.uy");
            }
        } else if (!(usuario instanceof Analista)) {
            if (!txtEmail.getText().endsWith("@utec.edu.uy")) {
                throw new ServicioException("El email debe terminar con @utec.edu.uy");
            }
        } else if (txtTelefono.getText().length() != 9) {
            throw new ServicioException("El campo Teléfono debe tener formato 09XXXXXXX");
        } else if (usuario instanceof Tutor) {
            if (modTut1.getArea().trim().length() < 2 || modTut1.getArea().trim().length() > 50) {
                throw new ServicioException("El campo Area debe tener entre 2 y 50 caracteres");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        modTut1 = new com.fannog.proyectocliente.ui.modificarUs.ModTut();
        modEst1 = new com.fannog.proyectocliente.ui.modificarUs.ModEst();
        jLabel10 = new javax.swing.JLabel();
        comboDepartamento = new javax.swing.JComboBox<>();
        comboLocalidad = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        comboITRs = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Modificar Datos de Estudiante");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Nombres");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Documento");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Nombre de Usuario");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Teléfono");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("ITR");

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        txtNombreUsuario.setEnabled(false);
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

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

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Contraseña");

        txtPassword.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Departamento");

        comboDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDepartamentoActionPerformed(evt);
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

        comboLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLocalidadActionPerformed(evt);
            }
        });
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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Localidad");

        comboITRs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboITRsActionPerformed(evt);
            }
        });
        comboITRs.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Itr) {
                    Itr itr = (Itr) value;
                    setText(itr.getNombre());
                }
                return this;
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addComponent(txtDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addComponent(comboDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboLocalidad, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(modTut1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(200, 200, 200)
                                        .addComponent(comboITRs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(modEst1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGuardar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreUsuario)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDocumento)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboLocalidad)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboITRs)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modEst1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modTut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showConfirmDialog(this, "Se ha cancelado la modificación");
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            controlEditar();

            int confirmarcion = JOptionPane.showConfirmDialog(null, "Por favor, confirme que desea realizar la modificación", "Confirmar modificación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirmarcion == 0) {

                editarEstudiantes();
                dispose();

            }
        } catch (ServicioException e) {
        } catch (Exception ex) {
            Logger.getLogger(ModificarUs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
        FieldUtils.esTexto(evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        // TODO add your handling code here:
        FieldUtils.esTexto(evt);
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void comboDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepartamentoActionPerformed

    private void comboLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLocalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLocalidadActionPerformed

    private void comboITRsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboITRsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboITRsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboDepartamento;
    private javax.swing.JComboBox<String> comboITRs;
    private javax.swing.JComboBox<String> comboLocalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.fannog.proyectocliente.ui.modificarUs.ModEst modEst1;
    private com.fannog.proyectocliente.ui.modificarUs.ModTut modTut1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
