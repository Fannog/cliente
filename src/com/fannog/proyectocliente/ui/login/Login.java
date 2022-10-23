package com.fannog.proyectocliente.ui.login;

import com.fannog.proyectocliente.ui.estudiante.MenuEstudiante;
import com.fannog.proyectocliente.ui.analista.MenuAnalista;
import com.fannog.proyectocliente.ui.register.Register;
import com.fannog.proyectocliente.ui.tutor.MenuTutor;
import com.fannog.proyectocliente.utils.BeanFactory;
import com.fannog.proyectocliente.utils.FieldUtils;
import com.fannog.proyectoservidor.DAO.UsuarioDAO;
import com.fannog.proyectoservidor.exceptions.ServicioException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private BeanFactory beanFactory = BeanFactory.create();
    boolean esTutor = false;
    boolean esEstudiante = false;
    boolean esAnalista = false;

    public Login() {
        initComponents();
    }

//    public void showUsuarioRol(UsuarioDAO usuarioDAO) throws ServicioException {
//        usuarioDAO = beanFactory.lookup("Usuario");
//        String nombreUsuario = txtNombreUsuario.getText().trim();
//        int rolUsuario = usuarioDAO.findByNombreUsuario(nombreUsuario).getRolUsuario();
//
//        switch (rolUsuario) {
//            case 1 -> {
//                MenuEstudiante menuEstudiante = new MenuEstudiante();
//                this.esEstudiante = true;
//                menuEstudiante.setVisible(esEstudiante);
//            }
//            case 2 -> {
//                MenuTutor menuTutor = new MenuTutor();
//                this.esTutor = true;
//                menuTutor.setVisible(esTutor);
//            }
//            case 3 -> {
//                MenuAnalista menuAnalista = new MenuAnalista();
//                this.esAnalista = true;
//                menuAnalista.setVisible(esAnalista);
//            }
//            default -> {
//            }
//        }
//        
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnInciarSesion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesión");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Source Sans Pro Black", 0, 36)); // NOI18N
        jLabel1.setText("Iniciar sesión ahora");

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 0, 24)); // NOI18N
        jLabel2.setText("Sistema de gesitón de constancias en la carrera LTI");

        txtNombreUsuario.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        jLabel3.setText("Nombre de usuario de UTEC");

        jLabel4.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        jLabel4.setText("Contraseña");

        btnInciarSesion.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        btnInciarSesion.setText("Iniciar sesión");
        btnInciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInciarSesionActionPerformed(evt);
            }
        });

        jLabel5.setText("O");

        btnRegistrar.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrarse");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4)
                    .addComponent(txtNombreUsuario)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(btnInciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2))
                    .addComponent(txtPassword))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(70, 70, 70)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnInciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        dispose();

        Register register = new Register();
        register.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyTyped
        FieldUtils.esTextoConPunto(evt);
    }//GEN-LAST:event_txtNombreUsuarioKeyTyped

    private void btnInciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInciarSesionActionPerformed
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String password = new String(txtPassword.getPassword());

        UsuarioDAO usuarioDAO = beanFactory.lookup("Usuario");

        try {
            usuarioDAO.login(nombreUsuario, password);
            dispose();

//            showUsuarioRol(usuarioDAO);
        } catch (ServicioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnInciarSesionActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInciarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
