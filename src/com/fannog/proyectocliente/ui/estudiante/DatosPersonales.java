package com.fannog.proyectocliente.ui.estudiante;

import com.fannog.proyectocliente.ui.modificarUs.ModPasswords;
import com.fannog.proyectocliente.ui.modificarUs.ModificarUs;
import com.fannog.proyectocliente.utils.BeanFactory;
import com.fannog.proyectocliente.utils.Globals;
import com.fannog.proyectoservidor.DAO.LocalidadDAO;
import com.fannog.proyectoservidor.DAO.UsuarioDAO;
import com.fannog.proyectoservidor.entities.Estudiante;
import com.fannog.proyectoservidor.entities.Localidad;
import com.fannog.proyectoservidor.entities.Tutor;
import com.fannog.proyectoservidor.entities.Usuario;
import com.fannog.proyectoservidor.exceptions.ServicioException;
import java.util.List;

public class DatosPersonales extends javax.swing.JPanel {

    private String nombreUsuario;

    public DatosPersonales() {
        initComponents();
    }

//    public DatosPersonales(String nombreUsuario) {
//        this();
//        try {
//            traerUsuario(nombreUsuario);
//
//        } catch (ServicioException e) {
//
//        }
//
//    }
    public void traerUsuario(String nombreUsuario) throws ServicioException, Exception {
        UsuarioDAO usuarioDAO = BeanFactory.local().lookup("Usuario");
        Usuario usuario = usuarioDAO.findByNombreUsuario(nombreUsuario);

        LocalidadDAO localidadDAO = BeanFactory.local().lookup("Localidad");
        List<Localidad> localidades = localidadDAO.findByNombre(usuario.getLocalidad().getNombre());

        lblNombres1.setText(usuario.getNombres());
        lblApellidos1.setText(usuario.getApellidos());
        lblNombreUsuario1.setText(usuario.getNombreUsuario());
        lblDocumento1.setText(usuario.getDocumento());
        lblEmail1.setText(usuario.getEmail());
        lblTelefono1.setText(String.valueOf(usuario.getTelefono()));

        for (Localidad l : localidades) {
            if (l.getId().longValue() == usuario.getLocalidad().getId().longValue()) {
                lblDepartamento1.setText(l.getDepartamento().getNombre());
                lblLocalida1.setText(l.getNombre());
            }
        }

        if (usuario instanceof Estudiante) {
            System.out.println("Estas en estudiante");
            Estudiante estudiante = (Estudiante) usuario;

            lblGeneracion1.setText(String.valueOf(estudiante.getGeneracion()));

            lblGeneracion1.setVisible(true);
            lblArea1.setVisible(false);
            lblRol1.setVisible(false);

            lblGeneracion.setVisible(true);
            lblArea.setVisible(false);
            lblRol.setVisible(false);

        } else if (usuario instanceof Tutor) {
            System.out.println("Estas en tutor");
            Tutor tutor = (Tutor) usuario;
            lblArea1.setText(tutor.getArea());
            lblRol1.setText(tutor.getRol());

            lblGeneracion1.setVisible(false);
            lblArea1.setVisible(true);
            lblRol1.setVisible(true);

            lblGeneracion.setVisible(false);
            lblArea.setVisible(true);
            lblRol.setVisible(true);

        } else {
            System.out.println("Estas en analista");

            lblGeneracion1.setVisible(false);
            lblArea1.setVisible(false);
            lblRol1.setVisible(false);

            lblGeneracion.setVisible(false);
            lblArea.setVisible(false);
            lblRol.setVisible(false);
        }

    }

    public void cambiarDatos(String nombreUsuario) throws ServicioException, Exception {
        ModificarUs modificarUsuario = new ModificarUs();
        modificarUsuario.populateComboDepartamento();
        modificarUsuario.populateComboITR();
        modificarUsuario.traerUsuario(nombreUsuario);
        modificarUsuario.setVisible(true);
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblITR = new javax.swing.JLabel();
        lblNombres1 = new javax.swing.JLabel();
        lblApellidos1 = new javax.swing.JLabel();
        lblNombreUsuario1 = new javax.swing.JLabel();
        lblDocumento1 = new javax.swing.JLabel();
        lblTelefono1 = new javax.swing.JLabel();
        lblEmail1 = new javax.swing.JLabel();
        lblITR1 = new javax.swing.JLabel();
        lblGeneracion = new javax.swing.JLabel();
        lblGeneracion1 = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        lblArea1 = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblRol1 = new javax.swing.JLabel();
        btnModificarDatos = new javax.swing.JButton();
        btnModificarPass = new javax.swing.JButton();
        lblDepartamento = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        lblDepartamento1 = new javax.swing.JLabel();
        lblLocalida1 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Datos Personales");

        lblNombres.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombres.setText("Nombres");

        lblApellidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblApellidos.setText("Apellidos");

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombreUsuario.setText("Nombre de Usuario");

        lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPassword.setText("Contraseña");

        lblDocumento.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDocumento.setText("Documento");

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTelefono.setText("Teléfono");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblEmail.setText("Email");

        lblITR.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblITR.setText("ITR");

        lblNombres1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombres1.setText("Nombre");

        lblApellidos1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblApellidos1.setText("Apellido");

        lblNombreUsuario1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombreUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreUsuario1.setText("Usuario");

        lblDocumento1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDocumento1.setText("55555555");

        lblTelefono1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTelefono1.setText("09100000");

        lblEmail1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblEmail1.setText("@utec");

        lblITR1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblITR1.setText("ITR");

        lblGeneracion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGeneracion.setText("Generación");

        lblGeneracion1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGeneracion1.setText("Gen");

        lblArea.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblArea.setText("Área");

        lblArea1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblArea1.setText("Area");

        lblRol.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRol.setText("Rol");

        lblRol1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRol1.setText("Rol");

        btnModificarDatos.setText("Modificar Datos");
        btnModificarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarDatosMouseClicked(evt);
            }
        });

        btnModificarPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificarPass.setText("Modificar");
        btnModificarPass.setPreferredSize(new java.awt.Dimension(81, 32));
        btnModificarPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarPassMouseClicked(evt);
            }
        });

        lblDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDepartamento.setText("Departamento");

        lblLocalidad.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblLocalidad.setText("Localidad");

        lblDepartamento1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDepartamento1.setText("Departamento");

        lblLocalida1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblLocalida1.setText("Localidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 470, Short.MAX_VALUE)
                            .addComponent(btnModificarDatos))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNombres)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNombres1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLocalidad)
                                        .addComponent(lblITR)
                                        .addComponent(lblArea)
                                        .addComponent(lblRol)
                                        .addComponent(lblGeneracion))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblITR1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblGeneracion1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblArea1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblRol1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblLocalida1, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTelefono)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTelefono1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEmail)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEmail1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDocumento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNombreUsuario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNombreUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblApellidos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblApellidos1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDepartamento)
                                        .addComponent(lblPassword))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnModificarPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblDepartamento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(lblNombres1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(lblApellidos1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblNombreUsuario1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocumento)
                    .addComponent(lblDocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblEmail1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(lblTelefono1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento)
                    .addComponent(lblDepartamento1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocalidad)
                    .addComponent(lblLocalida1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblITR)
                    .addComponent(lblITR1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGeneracion)
                    .addComponent(lblGeneracion1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArea)
                    .addComponent(lblArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRol)
                    .addComponent(lblRol1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarDatos)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarDatosMouseClicked
        try {
            cambiarDatos(Globals.getLoggedUser().getNombreUsuario());
        } catch (ServicioException e) {
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnModificarDatosMouseClicked

    private void btnModificarPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarPassMouseClicked
        // TODO add your handling code here:
        ModPasswords modPass = new ModPasswords();
        modPass.setNombreUsuario(nombreUsuario);
        modPass.setVisible(true);
    }//GEN-LAST:event_btnModificarPassMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificarDatos;
    private javax.swing.JButton btnModificarPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblApellidos1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblArea1;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDepartamento1;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblDocumento1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblGeneracion;
    private javax.swing.JLabel lblGeneracion1;
    private javax.swing.JLabel lblITR;
    private javax.swing.JLabel lblITR1;
    private javax.swing.JLabel lblLocalida1;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblNombreUsuario1;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNombres1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblRol1;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    // End of variables declaration//GEN-END:variables
}
