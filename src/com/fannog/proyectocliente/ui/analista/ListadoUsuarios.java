/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fannog.proyectocliente.ui.analista;

import com.fannog.proyectocliente.utils.BeanFactory;
import com.fannog.proyectoservidor.DAO.AnalistaDAO;
import com.fannog.proyectoservidor.DAO.EstadoUsuarioDAO;
import com.fannog.proyectoservidor.DAO.EstudianteDAO;
import com.fannog.proyectoservidor.DAO.TutorDAO;
import com.fannog.proyectoservidor.DAO.UsuarioDAO;
import com.fannog.proyectoservidor.entities.Analista;
import com.fannog.proyectoservidor.entities.EstadoUsuario;
import com.fannog.proyectoservidor.entities.Estudiante;
import com.fannog.proyectoservidor.entities.Tutor;
import com.fannog.proyectoservidor.entities.Usuario;
import com.fannog.proyectoservidor.exceptions.ServicioException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rodrigo
 */
public class ListadoUsuarios extends javax.swing.JFrame {

    private BeanFactory beanFactory = BeanFactory.create();
    private TableRowSorter<DefaultTableModel> sorter;
    private boolean esTutor = false;
    private boolean esEstudiante = true;

    /**
     * Creates new form ListadoUsuarios
     */
    public ListadoUsuarios() {
        initComponents();
        llenarComboFiltro();
        llenarModeloTabla();
        llenarTablaEstudiantes();
    }

    public void llenarModeloTabla() {
        String selectedTipoUsuario = String.valueOf(comboTipoUsuario.getSelectedItem());
        this.esTutor = selectedTipoUsuario.equalsIgnoreCase("tutores");
        this.esEstudiante = selectedTipoUsuario.equalsIgnoreCase("estudiantes");

        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();

        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Documento");
        modelo.addColumn("Email");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Departamento");
        modelo.addColumn("Localidad");
        modelo.addColumn("ITR");

        if (esTutor) {
            modelo.addColumn("Área");
            modelo.addColumn("Rol");
        }
        if (esEstudiante) {
            modelo.addColumn("Generación");
        }

    }

    public void removerColumnas() {
        
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        modelo.setColumnCount(0);
    }

    public void llenarTablaEstudiantes() {
        EstudianteDAO estudDao = beanFactory.lookup("Estudiante");
        List<Estudiante> estudiantes = estudDao.findAll();
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();

        if (!estudiantes.isEmpty()) {
            for (Estudiante e : estudiantes) {

                modelo.addRow(new Object[]{e.getNombres(), e.getApellidos(), e.getDocumento(), e.getNombreUsuario(), e.getTelefono(), e.getEmail(), e.getGeneracion()});
            }

            tablaUsuarios.setModel(modelo);
            tablaUsuarios.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaUsuarios.setRowSorter(sorter);
        } else {
            JOptionPane.showMessageDialog(this, "No hay usuarios estudiantes");
        }
    }

    public void llenarTablaTutor() {
        TutorDAO tutorDAO = beanFactory.lookup("Tutor");
        List<Tutor> tutores = tutorDAO.findAll();
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();

        if (!tutores.isEmpty()) {
            for (Tutor t : tutores) {

                modelo.addRow(new Object[]{t.getNombres(), t.getApellidos(), t.getDocumento(), t.getNombreUsuario(), t.getTelefono(), t.getEmail(), t.getArea()});
            }

            tablaUsuarios.setModel(modelo);
            tablaUsuarios.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaUsuarios.setRowSorter(sorter);
        } else {
            JOptionPane.showMessageDialog(this, "No hay usuarios tutores");
        }
    }

    public void llenarTablaAnalista() {
        AnalistaDAO analistaDAO = beanFactory.lookup("Analista");
        List<Analista> analistas = analistaDAO.findAll();
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();

        if (!analistas.isEmpty()) {
            for (Analista a : analistas) {

                modelo.addRow(new Object[]{a.getNombres(), a.getApellidos(), a.getDocumento(), a.getNombreUsuario(), a.getTelefono(), a.getEmail()});
            }

            tablaUsuarios.setModel(modelo);
            tablaUsuarios.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaUsuarios.setRowSorter(sorter);
        } else {
            JOptionPane.showMessageDialog(this, "No hay usuarios tutores");
        }
    }

    private void clearTable() {
        DefaultTableModel tb = (DefaultTableModel) tablaUsuarios.getModel();
        int a = tablaUsuarios.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void botonAltaBajaEnabled() throws ServicioException {
        String estadoUsuario = estadoDeUsuario();

        if (estadoUsuario.equalsIgnoreCase("Activo")) {
            btnAlta.setEnabled(false);
            btnBaja.setEnabled(true);
        } else if (estadoUsuario.equalsIgnoreCase("Sin Activar")) {
            btnAlta.setEnabled(true);
            btnBaja.setEnabled(false);
        } else {
            btnAlta.setEnabled(false);
            btnBaja.setEnabled(false);
        }
    }

    public void setEstadoUsuario() {
        try {
            UsuarioDAO usuarioDAO = beanFactory.lookup("Usuario");
            EstadoUsuarioDAO estUsuDAO = beanFactory.lookup("EstadoUsuario");

            String nombreUsuario = (String) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 3);
            Usuario usuario = usuarioDAO.findByNombreUsuario(nombreUsuario);
            String estadoUsuario = estadoDeUsuario();

            if (estadoUsuario.equalsIgnoreCase("Activo")) {
                EstadoUsuario estado = estUsuDAO.findById(1L);
                usuario.setEstado(estado);
                usuarioDAO.edit(usuario);
            } else {
                EstadoUsuario estado = estUsuDAO.findById(2L);
                usuario.setEstado(estado);
                usuarioDAO.edit(usuario);
            }

        } catch (ServicioException e) {

        }
    }

    public String estadoDeUsuario() {
        String nombreUsuario = (String) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 3);
        UsuarioDAO usuarioDAO = beanFactory.lookup("Usuario");
        List<Usuario> usuarios = usuarioDAO.findAllWithEstadosUsuario();

        String estadoUsuario = "";

        for (Usuario u : usuarios) {
            if (nombreUsuario.equalsIgnoreCase(u.getNombreUsuario())) {
                estadoUsuario = u.getEstado().getNombre();
            }
        }

        return estadoUsuario;
    }

    public void filtrarTabla() {
        try {
            int opcionFiltro = comboFiltroUsuarios.getSelectedIndex();
            String textoFiltro = txtFiltro.getText();

            sorter.setRowFilter(RowFilter.regexFilter(textoFiltro, opcionFiltro));
        } catch (Exception e) {
        }
    }

    public void llenarComboFiltro() {

        String selectedTipoUsuario = String.valueOf(comboTipoUsuario.getSelectedItem());
        this.esTutor = selectedTipoUsuario.equalsIgnoreCase("tutores");
        this.esEstudiante = selectedTipoUsuario.equalsIgnoreCase("estudiantes");

        comboFiltroUsuarios.addItem("Nombres");
        comboFiltroUsuarios.addItem("Apellidos");
        comboFiltroUsuarios.addItem("Documento");
        comboFiltroUsuarios.addItem("Email");
        comboFiltroUsuarios.addItem("Teléfono");
        comboFiltroUsuarios.addItem("Departamento");
        comboFiltroUsuarios.addItem("Localidad");
        comboFiltroUsuarios.addItem("ITR");

        if (esTutor) {
            comboFiltroUsuarios.addItem("Área");
            comboFiltroUsuarios.addItem("Rol");

        }
        if (esEstudiante) {
            comboFiltroUsuarios.addItem("Generación");

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        comboTipoUsuario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        comboFiltroUsuarios = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Listado de Usuarios");

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        comboTipoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiantes", "Tutores", "Analistas" }));
        comboTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Tipo de Usuario:");

        lblFiltro.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblFiltro.setText("Filtro:");

        comboFiltroUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboFiltroUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroUsuariosActionPerformed(evt);
            }
        });

        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.setPreferredSize(new java.awt.Dimension(133, 31));

        btnAlta.setText("Alta");
        btnAlta.setEnabled(false);
        btnAlta.setPreferredSize(new java.awt.Dimension(133, 31));
        btnAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAltaMouseClicked(evt);
            }
        });

        btnBaja.setText("Baja");
        btnBaja.setEnabled(false);
        btnBaja.setPreferredSize(new java.awt.Dimension(133, 31));
        btnBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBajaMouseClicked(evt);
            }
        });

        btnAtras.setText("Atras");
        btnAtras.setPreferredSize(new java.awt.Dimension(133, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFiltro)
                                .addGap(18, 18, 18)
                                .addComponent(comboFiltroUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFiltro)
                            .addComponent(comboFiltroUsuarios))
                        .addGap(14, 14, 14)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUsuarioActionPerformed
        // TODO add your handling code here:
        boolean esEstudiante = comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("estudiantes");
        boolean esTutor = comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("tutores");
        
        comboFiltroUsuarios.removeAllItems();
        llenarComboFiltro();
        removerColumnas();
        llenarModeloTabla();

        if (esEstudiante) {
            clearTable();
            llenarTablaEstudiantes();
        } else if (esTutor) {
            clearTable();
            llenarTablaTutor();
        } else {
            clearTable();
            llenarTablaAnalista();
        }
    }//GEN-LAST:event_comboTipoUsuarioActionPerformed

    private void comboFiltroUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFiltroUsuariosActionPerformed

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:
        btnModificar.setEnabled(true);
        try {
            botonAltaBajaEnabled();
        } catch (ServicioException ex) {
            Logger.getLogger(ListadoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void btnAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAltaMouseClicked
        // TODO add your handling code here:
        setEstadoUsuario();
        tablaUsuarios.clearSelection();
        btnAlta.setEnabled(false);
    }//GEN-LAST:event_btnAltaMouseClicked

    private void btnBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBajaMouseClicked
        // TODO add your handling code here:
        setEstadoUsuario();
        tablaUsuarios.clearSelection();
        btnBaja.setEnabled(false);
    }//GEN-LAST:event_btnBajaMouseClicked

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        filtrarTabla();
    }//GEN-LAST:event_txtFiltroKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboFiltroUsuarios;
    private javax.swing.JComboBox<String> comboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
