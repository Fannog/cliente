package com.fannog.proyectocliente.ui.analista;

import com.fannog.proyectocliente.ui.modificarUs.ModificarUs;
import com.fannog.proyectocliente.utils.BeanFactory;
import com.fannog.proyectoservidor.DAO.AnalistaDAO;
import com.fannog.proyectoservidor.DAO.EstadoUsuarioDAO;
import com.fannog.proyectoservidor.DAO.EstudianteDAO;
import com.fannog.proyectoservidor.DAO.LocalidadDAO;
import com.fannog.proyectoservidor.DAO.TutorDAO;
import com.fannog.proyectoservidor.DAO.UsuarioDAO;
import com.fannog.proyectoservidor.entities.Analista;
import com.fannog.proyectoservidor.entities.EstadoUsuario;
import com.fannog.proyectoservidor.entities.Estudiante;
import com.fannog.proyectoservidor.entities.Localidad;
import com.fannog.proyectoservidor.entities.Tutor;
import com.fannog.proyectoservidor.entities.Usuario;
import com.fannog.proyectoservidor.exceptions.ServicioException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ListaUsuarios extends javax.swing.JPanel {

    private TableRowSorter<DefaultTableModel> sorter;
    private boolean esTutor = false;
    private boolean esEstudiante = true;

    public ListaUsuarios() {
        initComponents();
    }

    public void llenarModeloTabla() {
        String selectedTipoUsuario = String.valueOf(comboTipoUsuario.getSelectedItem());
        this.esTutor = selectedTipoUsuario.equalsIgnoreCase("tutores");
        this.esEstudiante = selectedTipoUsuario.equalsIgnoreCase("estudiantes");

        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();

        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Nombre de Usuario");
        modelo.addColumn("Documento");
        modelo.addColumn("Email");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Departamento");
        modelo.addColumn("Localidad");
        modelo.addColumn("ITR");
        modelo.addColumn("Estado");

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

    public void llenarTablaEstudiantes() throws ServicioException, Exception {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        EstudianteDAO estuDAO = BeanFactory.local().lookup("Estudiante");

        List<Estudiante> estudiantes = estuDAO.findAllWithAll();

        LocalidadDAO localidadDAO = BeanFactory.local().lookup("Localidad");

        if (!estudiantes.isEmpty()) {
            for (Estudiante e : estudiantes) {

                List<Localidad> localidades = localidadDAO.findByNombre(e.getLocalidad().getNombre());
                for (Localidad l : localidades) {
                    if (l.getId().longValue() == e.getLocalidad().getId().longValue()) {
                        modelo.addRow(new Object[]{e.getNombres(), e.getApellidos(), e.getNombreUsuario(), e.getDocumento(), e.getEmail(), e.getTelefono(), l.getDepartamento().getNombre(), l.getNombre(), e.getItr().getNombre(), e.getEstado().getNombre(), e.getGeneracion()});
                    } else {
                    }
                }

            }

            tablaUsuarios.setModel(modelo);
            tablaUsuarios.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaUsuarios.setRowSorter(sorter);
            tablaUsuarios.setDefaultEditor(Object.class, null);
        } else {
            JOptionPane.showMessageDialog(this, "No hay usuarios estudiantes");
        }

    }

    public void llenarTablaTutor() throws ServicioException, Exception {
        TutorDAO tutorDAO = BeanFactory.local().lookup("Tutor");
        List<Tutor> tutores = tutorDAO.findAllWithAll();
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();

        LocalidadDAO localidadDAO = BeanFactory.local().lookup("Localidad");

        if (!tutores.isEmpty()) {
            for (Tutor t : tutores) {

                List<Localidad> localidades = localidadDAO.findByNombre(t.getLocalidad().getNombre());
                for (Localidad l : localidades) {
                    if (l.getId().longValue() == t.getLocalidad().getId().longValue()) {

                        modelo.addRow(new Object[]{t.getNombres(), t.getApellidos(), t.getNombreUsuario(), t.getDocumento(), t.getEmail(), t.getTelefono(), l.getDepartamento().getNombre(), l.getNombre(), t.getItr().getNombre(), t.getEstado().getNombre(), t.getArea(), t.getRol()});
                    }
                }
            }

            tablaUsuarios.setModel(modelo);
            tablaUsuarios.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaUsuarios.setRowSorter(sorter);
        } else {
            JOptionPane.showMessageDialog(this, "No hay usuarios tutores");
        }
    }

    public void llenarTablaAnalista() throws ServicioException, Exception {
        AnalistaDAO analistaDAO = BeanFactory.local().lookup("Analista");
        List<Analista> analistas = analistaDAO.findAllWithAll();
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();

        LocalidadDAO localidadDAO = BeanFactory.local().lookup("Localidad");

        if (!analistas.isEmpty()) {
            for (Analista a : analistas) {

                List<Localidad> localidades = localidadDAO.findByNombre(a.getLocalidad().getNombre());
                for (Localidad l : localidades) {
                    if (l.getId().longValue() == a.getLocalidad().getId().longValue()) {
                        modelo.addRow(new Object[]{a.getNombres(), a.getApellidos(), a.getNombreUsuario(), a.getDocumento(), a.getEmail(), a.getTelefono(), l.getDepartamento().getNombre(), l.getNombre(), a.getItr().getNombre(), a.getEstado().getNombre()});
                    } else {

                        System.out.println("Nooo Listado");
                    }
                }
            }

            tablaUsuarios.setModel(modelo);
            tablaUsuarios.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaUsuarios.setRowSorter(sorter);
        } else {
            JOptionPane.showMessageDialog(this, "No hay usuarios analistas");
        }
    }

    private void clearTable() {
        DefaultTableModel tb = (DefaultTableModel) tablaUsuarios.getModel();
        int a = tablaUsuarios.getRowCount() - 1;
        if (a >= 0) {
            for (int i = a; i >= 0; i--) {
                tb.removeRow(tb.getRowCount() - 1);
            }
        }

    }

    public void botonAltaBajaEnabled() throws ServicioException, Exception {
        String estadoUsuario = estadoDeUsuario();

        if (estadoUsuario.equalsIgnoreCase("Activo")) {
            btnAlta.setEnabled(false);
            btnBaja.setEnabled(true);
        } else if (estadoUsuario.equalsIgnoreCase("Sin Activar")) {
            btnAlta.setEnabled(true);
            btnBaja.setEnabled(true);
        } else if (estadoUsuario.equalsIgnoreCase("Eliminado")) {
            btnAlta.setEnabled(true);
            btnBaja.setEnabled(false);
        }
    }

    public void activarUsuario() throws Exception {
        try {
            UsuarioDAO usuarioDAO = BeanFactory.local().lookup("Usuario");
            EstadoUsuarioDAO estUsuDAO = BeanFactory.local().lookup("EstadoUsuario");

            String nombreUsuario = (String) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2);
            Usuario usuario = usuarioDAO.findByNombreUsuario(nombreUsuario);
            String estadoUsuario = estadoDeUsuario();

            if (!estadoUsuario.equalsIgnoreCase("Activo")) {
                EstadoUsuario estado = estUsuDAO.findById(2L);
                usuario.setEstado(estado);
                usuarioDAO.edit(usuario);
            }
        } catch (ServicioException e) {

        }
    }

    public String estadoDeUsuario() throws Exception {
        String nombreUsuario = (String) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2);
        UsuarioDAO usuarioDAO = BeanFactory.local().lookup("Usuario");
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
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltro, opcionFiltro));

        } catch (Exception e) {
        }
    }

    public void llenarComboFiltro() {

        String selectedTipoUsuario = String.valueOf(comboTipoUsuario.getSelectedItem());
        this.esTutor = selectedTipoUsuario.equalsIgnoreCase("tutores");
        this.esEstudiante = selectedTipoUsuario.equalsIgnoreCase("estudiantes");

        comboFiltroUsuarios.addItem("Nombres");
        comboFiltroUsuarios.addItem("Apellidos");
        comboFiltroUsuarios.addItem("Nombre de Usuario");
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

    public void cambiarDatosEst() throws ServicioException, Exception {
        String nombreUsuario = (String) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2);

        ModificarUs modificarUsuario = new ModificarUs();
        modificarUsuario.traerUsuario(nombreUsuario);
        modificarUsuario.populateComboDepartamento();
        modificarUsuario.populateComboITR();
        modificarUsuario.setVisible(true);
//
//        EstudianteDAO estuDAO = beanFactory.lookup("Estudiante");
//        String nombreUsuario = (String) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2);
//        Estudiante estudiante = estuDAO.findByNombreUsuario(nombreUsuario);
//
//        ModificarUsEst modificarUsuarioEstudiante = new ModificarUsEst(estudiante);
//        modificarUsuarioEstudiante.setVisible(true);

    }

    public void bajaUsuario() throws ServicioException, Exception {
        String nombreUsuario = (String) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2);
        UsuarioDAO usuarioDAO = BeanFactory.local().lookup("Usuario");
        Usuario usuario = usuarioDAO.findByNombreUsuario(nombreUsuario);

        EstadoUsuarioDAO estadoDAO = BeanFactory.local().lookup("EstadoUsuario");
        EstadoUsuario estado = estadoDAO.findById(3L);

        usuario.setEstado(estado);
        usuarioDAO.edit(usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboTipoUsuario = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboFiltroUsuarios = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Usuarios");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tipo de Usuario:");

        comboTipoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiantes", "Tutores", "Analistas" }));
        comboTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoUsuarioActionPerformed(evt);
            }
        });

        txtFiltro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Filtro:");

        comboFiltroUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnAlta.setText("Alta");
        btnAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAltaMouseClicked(evt);
            }
        });

        btnBaja.setText("Baja");
        btnBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBajaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboFiltroUsuarios, 0, 127, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboFiltroUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnAlta)
                    .addComponent(btnBaja))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUsuarioActionPerformed
        boolean esEstudiante = comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("estudiantes");
        boolean esTutor = comboTipoUsuario.getSelectedItem().toString().equalsIgnoreCase("tutores");

        comboFiltroUsuarios.removeAllItems();
        llenarComboFiltro();
        removerColumnas();
        llenarModeloTabla();

        if (esEstudiante) {
            clearTable();
            try {
                llenarTablaEstudiantes();

            } catch (ServicioException e) {
            } catch (Exception ex) {
            }
        }
        if (esTutor) {
            clearTable();
            try {
                llenarTablaTutor();
            } catch (ServicioException e) {
            } catch (Exception ex) {
            }
        }
        if (!esEstudiante && !esTutor) {
            clearTable();
            try {
                llenarTablaAnalista();
            } catch (ServicioException e) {
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_comboTipoUsuarioActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        btnModificar.setEnabled(true);
        try {
            botonAltaBajaEnabled();
        } catch (ServicioException ex) {
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void btnAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAltaMouseClicked
        int confirmacion = JOptionPane.showConfirmDialog(null, "Por favor, confirme que desea realizar la baja del usuario", "Confirmar baja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmacion == 0) {
            try {
                activarUsuario();
            } catch (Exception ex) {
            }

            tablaUsuarios.clearSelection();
            btnAlta.setEnabled(false);
            clearTable();

            try {
                llenarTablaEstudiantes();
            } catch (ServicioException e) {
            } catch (Exception ex) {
            }
        }

    }//GEN-LAST:event_btnAltaMouseClicked

    private void btnBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBajaMouseClicked
        int confirmacion = JOptionPane.showConfirmDialog(null, "Por favor, confirme que desea realizar la baja del usuario", "Confirmar baja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmacion == 0) {
            try {
                bajaUsuario();

                tablaUsuarios.clearSelection();
                btnBaja.setEnabled(false);
                clearTable();
                llenarTablaEstudiantes();
            } catch (ServicioException ex) {
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_btnBajaMouseClicked

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        filtrarTabla();
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        try {
            cambiarDatosEst();
        } catch (ServicioException ex) {
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnModificarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboFiltroUsuarios;
    private javax.swing.JComboBox<String> comboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
