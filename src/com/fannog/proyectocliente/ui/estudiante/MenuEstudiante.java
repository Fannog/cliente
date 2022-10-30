package com.fannog.proyectocliente.ui.estudiante;

import com.fannog.proyectocliente.utils.BeanFactory;
import com.fannog.proyectoservidor.DAO.EstadoSolicitudDAO;
import com.fannog.proyectoservidor.DAO.SolicitudDAO;
import com.fannog.proyectoservidor.entities.EstadoSolicitud;
import com.fannog.proyectoservidor.entities.Solicitud;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import java.awt.Dialog.ModalityType;
import javax.swing.JDialog;

public class MenuEstudiante extends javax.swing.JFrame {

    private TableRowSorter<DefaultTableModel> sorter;
    private Date yourDate = new Date();
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(" dd-MMMM-yyyy");

    public MenuEstudiante() {
        initComponents();

        try {
            populatecomboEstadoSolicitud();

            llenarModeloTabla();
            llenarTablaListaSolicitudes();
            addAllEstadosFilter();
        } catch (Exception ex) {
        }
    }

    public void addAllEstadosFilter() {
        comboEstadoSolicitud.addItem("Todos");
    }

    public void removerColumnas() {

        DefaultTableModel modelo = (DefaultTableModel) tablaListaSolicitudes.getModel();
        modelo.setColumnCount(0);
    }

    private void clearTable() {
        DefaultTableModel tb = (DefaultTableModel) tablaListaSolicitudes.getModel();
        int a = tablaListaSolicitudes.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    private void populatecomboEstadoSolicitud() throws Exception {
        EstadoSolicitudDAO estadoSolicitudDAO = BeanFactory.local().lookup("EstadoSolicitud");

        List<EstadoSolicitud> estadoSolicitudes = estadoSolicitudDAO.findAll();

        comboEstadoSolicitud.setModel(new DefaultComboBoxModel(estadoSolicitudes.toArray()));

    }

    public void llenarModeloTabla() {
        String selectedEstado = String.valueOf(comboEstadoSolicitud.getSelectedItem());

        DefaultTableModel modelo = (DefaultTableModel) tablaListaSolicitudes.getModel();

        modelo.addColumn("ID Solicitud");
        modelo.addColumn("Detalle");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
        modelo.addColumn("Tipo Constancia");

    }

    public void llenarTablaListaSolicitudes() throws Exception {
        SolicitudDAO solicitudDAO = BeanFactory.local().lookup("Solicitud");
        List<Solicitud> solicitudes = solicitudDAO.findAllWithRelations();
        DefaultTableModel modelo = (DefaultTableModel) tablaListaSolicitudes.getModel();

        if (!solicitudes.isEmpty()) {
            for (Solicitud s : solicitudes) {

                String date = DATE_FORMAT.format(s.getFecha());

                modelo.addRow(new Object[]{s.getId(), s.getDetalle(), date, (s.getEstado()).getNombre(), (s.getTipo()).getNombre()});
            }

            tablaListaSolicitudes.setModel(modelo);
            tablaListaSolicitudes.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaListaSolicitudes.setRowSorter(sorter);

        } else {
            JOptionPane.showMessageDialog(this, "No haz realizado ninguna solicitud");
        }
    }

    public void llenarTablaEstadoIngresado() throws Exception {
        SolicitudDAO solicitudDAO = BeanFactory.local().lookup("Solicitud");
        List<Solicitud> solicitudes = solicitudDAO.findAll();
        DefaultTableModel modelo = (DefaultTableModel) tablaListaSolicitudes.getModel();

        if (!solicitudes.isEmpty()) {
            for (Solicitud s : solicitudes) {

                String date = DATE_FORMAT.format(s.getFecha());

                if (((s.getEstado()).getNombre()).equalsIgnoreCase("ingresado")) {
                    modelo.addRow(new Object[]{s.getId(), s.getDetalle(), date, (s.getEstado()).getNombre(), (s.getTipo()).getNombre()});
                }
            }

            tablaListaSolicitudes.setModel(modelo);
            tablaListaSolicitudes.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaListaSolicitudes.setRowSorter(sorter);

        } else {
            JOptionPane.showMessageDialog(this, "No hay solicitudes ingresadas");
        }
    }

    public void llenarTablaEstadoEnProceso() throws Exception {
        SolicitudDAO solicitudDAO = BeanFactory.local().lookup("Solicitud");
        List<Solicitud> solicitudes = solicitudDAO.findAll();
        DefaultTableModel modelo = (DefaultTableModel) tablaListaSolicitudes.getModel();

        if (!solicitudes.isEmpty()) {
            for (Solicitud s : solicitudes) {

                String date = DATE_FORMAT.format(s.getFecha());

                if (((s.getEstado()).getNombre()).equalsIgnoreCase("en proceso")) {
                    modelo.addRow(new Object[]{s.getId(), s.getDetalle(), date, (s.getEstado()).getNombre(), (s.getTipo()).getNombre()});
                }
            }

            tablaListaSolicitudes.setModel(modelo);
            tablaListaSolicitudes.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaListaSolicitudes.setRowSorter(sorter);

        } else {
            JOptionPane.showMessageDialog(this, "No hay solicitudes en proceso");
        }
    }

    public void llenarTablaEstadoFinalizado() throws Exception {
        SolicitudDAO solicitudDAO = BeanFactory.local().lookup("Solicitud");
        List<Solicitud> solicitudes = solicitudDAO.findAll();
        DefaultTableModel modelo = (DefaultTableModel) tablaListaSolicitudes.getModel();

        if (!solicitudes.isEmpty()) {
            for (Solicitud s : solicitudes) {

                String date = DATE_FORMAT.format(s.getFecha());

                if (((s.getEstado()).getNombre()).equalsIgnoreCase("finalizado")) {
                    modelo.addRow(new Object[]{s.getId(), s.getDetalle(), date, (s.getEstado()).getNombre(), (s.getTipo()).getNombre()});
                }
            }

            tablaListaSolicitudes.setModel(modelo);
            tablaListaSolicitudes.setAutoCreateRowSorter(true);
            sorter = new TableRowSorter<>(modelo);
            tablaListaSolicitudes.setRowSorter(sorter);

        } else {
            JOptionPane.showMessageDialog(this, "No hay solicitudes finalizadas");
        }
    }

    private void activarBotonesUD() {
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
    }

    private void activarBotonesSC() {
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    private Solicitud getSolicitudSeleccionada() {
        int row = tablaListaSolicitudes.getSelectedRow();

        Solicitud s = (Solicitud) tablaListaSolicitudes.getValueAt(row, tablaListaSolicitudes.getSelectedRow());

        System.out.println(s);

        return s;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        popupMenu1 = new java.awt.PopupMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaSolicitudes = new javax.swing.JTable();
        comboEstadoSolicitud = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        datosPersonales1 = new com.fannog.proyectocliente.ui.estudiante.DatosPersonales();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaListaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
        ));
        jScrollPane1.setViewportView(tablaListaSolicitudes);

        comboEstadoSolicitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEstadoSolicitud.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof EstadoSolicitud) {
                    EstadoSolicitud estadoSolicitud = (EstadoSolicitud) value;
                    setText(estadoSolicitud.getNombre());
                }
                return this;
            }
        });
        comboEstadoSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoSolicitudActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Estado");

        jToolBar1.setRollover(true);

        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);
        jToolBar1.add(jSeparator1);

        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar.setFocusable(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBorrar.setFocusable(false);
        btnBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarMouseClicked(evt);
            }
        });
        jToolBar1.add(btnBorrar);
        jToolBar1.add(jSeparator2);

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        jToolBar1.add(btnCancelar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addGap(202, 202, 202)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboEstadoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboEstadoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Constancias", jPanel1);
        jTabbedPane1.addTab("Datos personales", datosPersonales1);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseClicked
    }//GEN-LAST:event_btnBorrarMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void comboEstadoSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoSolicitudActionPerformed

        if ((comboEstadoSolicitud.getSelectedItem().toString().equalsIgnoreCase("Todos"))) {
            clearTable();
            
            try {
                llenarTablaListaSolicitudes();
            } catch (Exception ex) {
            }
        } else {
            EstadoSolicitud estado = (EstadoSolicitud) comboEstadoSolicitud.getSelectedItem();

            String strEstado = estado.getNombre();

            boolean estaIngresado = strEstado.equalsIgnoreCase("ingresado");
            boolean estaEnProceso = strEstado.equalsIgnoreCase("en proceso");

            removerColumnas();
            llenarModeloTabla();

            if (estaIngresado) {
                clearTable();

                try {
                    llenarTablaEstadoIngresado();
                } catch (Exception ex) {
                }
            } else if (estaEnProceso) {
                clearTable();

                try {
                    llenarTablaEstadoEnProceso();
                } catch (Exception ex) {
                }
            } else {
                clearTable();

                try {
                    llenarTablaEstadoFinalizado();
                } catch (Exception ex) {
                }
            }
        }
    }//GEN-LAST:event_comboEstadoSolicitudActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        try {
            NuevaSolicitud dialogNuevaSolicitud = new NuevaSolicitud();
            dialogNuevaSolicitud.setModalityType(ModalityType.APPLICATION_MODAL);
            dialogNuevaSolicitud.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialogNuevaSolicitud.setVisible(true);
        } catch (Exception ex) {
        }

    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> comboEstadoSolicitud;
    private com.fannog.proyectocliente.ui.estudiante.DatosPersonales datosPersonales1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable tablaListaSolicitudes;
    // End of variables declaration//GEN-END:variables

}
