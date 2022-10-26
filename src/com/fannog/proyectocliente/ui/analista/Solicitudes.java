package com.fannog.proyectocliente.ui.analista;

import com.fannog.proyectocliente.utils.BeanFactory;
import com.fannog.proyectocliente.utils.DataTableModel;
import com.fannog.proyectocliente.utils.Globals;
import com.fannog.proyectoservidor.DAO.AccionSolicitudDAO;
import com.fannog.proyectoservidor.DAO.AdjuntoSolicitudDAO;
import com.fannog.proyectoservidor.DAO.SolicitudDAO;
import com.fannog.proyectoservidor.entities.AccionSolicitud;
import com.fannog.proyectoservidor.entities.AdjuntoSolicitud;
import com.fannog.proyectoservidor.entities.Solicitud;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;

public class Solicitudes extends javax.swing.JPanel {

    private DataTableModel<Solicitud> solicitudTableModel = createSolicitudModel();

    public Solicitudes() {
        initComponents();
        enableTabs(false);
        enableOperationBtns(false);
        btnDescargar.setEnabled(false);

        tableSolicitudes.getSelectionModel().addListSelectionListener(this::handleTableSolicitudesSelectionEvent);
        listAdjuntos.getSelectionModel().addListSelectionListener(this::handleListAdjuntosSelection);

        try {
            loadSolicitudes();
        } catch (Exception ex) {
        }
    }

    private void loadSolicitudes() throws Exception {
        SolicitudDAO solicitudDAO = BeanFactory.local().lookup("Solicitud");

        List<Solicitud> solicitudes = solicitudDAO.findAllWithRelations();
        solicitudTableModel.setListRows(solicitudes);
        tableSolicitudes.setModel(solicitudTableModel);
    }

    private void loadAdjuntos(Long idSolicitud) throws Exception {
        AdjuntoSolicitudDAO adjuntoSolicitudDAO = BeanFactory.local().lookup("AdjuntoSolicitud");

        List<AdjuntoSolicitud> adjuntosSolicitud = adjuntoSolicitudDAO.findAllBySolicitud(idSolicitud);

        DefaultListModel listModel = new DefaultListModel<AdjuntoSolicitud>();

        listModel.addAll(adjuntosSolicitud);

        listAdjuntos.setModel(listModel);
    }

    private void loadAcciones(Long idSolicitud) throws Exception {
        AccionSolicitudDAO accionSolicitudDAO = BeanFactory.local().lookup("AccionSolicitud");

        List<AccionSolicitud> accionesSolicitud = accionSolicitudDAO.findAllBySolicitud(idSolicitud);

        DefaultListModel listModel = new DefaultListModel<AccionSolicitud>();

        listModel.addAll(accionesSolicitud);

        listAcciones.setModel(listModel);
    }

    
    private void enableOperationBtns(boolean enabled) {
        jButton1.setEnabled(enabled);
        jButton3.setEnabled(enabled);
    }

    private void enableTabs(boolean enabled) {
        jTabbedPane2.setEnabledAt(0, enabled);
        jTabbedPane2.setEnabledAt(1, enabled);
        jTabbedPane2.setEnabledAt(2, enabled);
    }

    private DataTableModel createSolicitudModel() {

        String[] COLUMNS = {"ID", "Estudiante", "Tipo", "Estado"};

        return new DataTableModel<Solicitud>() {
            @Override
            public Object getValueAt(Solicitud solicitud, int columnas) {
                return switch (columnas) {
                    case -1 ->
                        solicitud;
                    case 0 ->
                        solicitud.getId();
                    case 1 ->
                        solicitud.getEstudiante().getNombreUsuario();
                    case 2 ->
                        solicitud.getTipo().getNombre();
                    case 3 ->
                        solicitud.getEstado().getNombre();
                    default ->
                        null;
                };
            }

            @Override
            public String getColumnName(int column) {
                return COLUMNS[column];
            }

            @Override
            public int getColumnCount() {
                return COLUMNS.length;
            }
        };
    }


    private Solicitud getSelectedSolicitud() {
        int row = tableSolicitudes.getSelectedRow();

        Solicitud s = (Solicitud) tableSolicitudes.getValueAt(row, -1);

        return s;
    }

    private AdjuntoSolicitud getSelectedAdjunto() {
        return listAdjuntos.getSelectedValue();
    }

    private void handleTableSolicitudesSelectionEvent(ListSelectionEvent e) {
        boolean seleccionValida = getSelectedSolicitud() != null;

        if (seleccionValida) {
            Solicitud solicitud = getSelectedSolicitud();

            try {
                loadAcciones(solicitud.getId());
                loadAdjuntos(solicitud.getId());
            } catch (Exception ex) {
            }
        }

        enableTabs(seleccionValida);
        enableOperationBtns(seleccionValida);
    }

    private void handleListAdjuntosSelection(ListSelectionEvent e) {
        boolean seleccionValida = !listAdjuntos.isSelectionEmpty();

        btnDescargar.setEnabled(seleccionValida);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSolicitudes = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAdjuntos = new javax.swing.JList<>();
        jToolBar2 = new javax.swing.JToolBar();
        btnDescargar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listAcciones = new javax.swing.JList<>();

        jToolBar1.setRollover(true);

        jButton1.setText("Emitir");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton3.setText("Registrar acción");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        tableSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableSolicitudes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tableSolicitudes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Info.", jPanel1);

        jScrollPane1.setViewportView(listAdjuntos);

        jToolBar2.setRollover(true);

        btnDescargar.setText("Descargar");
        btnDescargar.setFocusable(false);
        btnDescargar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDescargar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDescargar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Archivos adj.", jPanel2);

        listAcciones.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof AccionSolicitud) {
                    AccionSolicitud a = (AccionSolicitud) value;

                    String parsedFechaHora = a.getFecHora().format(Globals.dateTimeFormatter);

                    setText(a.getDetalle() + " (" + parsedFechaHora + ")");
                }

                return this;
            }
        });
        jScrollPane3.setViewportView(listAcciones);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Acciones", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        AdjuntoSolicitud adjunto = getSelectedAdjunto();

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setSelectedFile(new File(adjunto.getNombArchivo()));
        fileChooser.setDialogTitle("Descargar archivo");

        int option = fileChooser.showSaveDialog(parentFrame);

        if (option == JFileChooser.APPROVE_OPTION) {
            String strPath = fileChooser.getSelectedFile().getAbsolutePath();
            
            System.out.println(strPath);

            if (!strPath.toLowerCase().endsWith(".pdf")) {
                strPath += ".pdf";
            }

            Path path = new File(strPath).toPath();

            byte[] fileContent = adjunto.getArchivo();

            try {
                Files.write(path, fileContent);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnDescargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDescargar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JList<String> listAcciones;
    private javax.swing.JList<AdjuntoSolicitud> listAdjuntos;
    private javax.swing.JTable tableSolicitudes;
    // End of variables declaration//GEN-END:variables
}
