package com.fannog.proyectocliente.ui.analista;

import com.docmosis.SystemManager;
import com.docmosis.document.DocumentProcessor;
import com.docmosis.template.population.DataProviderBuilder;
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
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;

public class Solicitudes extends javax.swing.JPanel {

    private DataTableModel<Solicitud> solicitudTableModel = createSolicitudModel();
    private JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

    public JFrame getParentFrame() {
        return parentFrame;
    }

    public DataTableModel<Solicitud> getSolicitudTableModel() {
        return solicitudTableModel;
    }

    public Solicitudes() {
        initComponents();
        enableTabs(false);
        enableOperationBtns(false);
        btnDescargar.setEnabled(false);

        tableSolicitudes.getSelectionModel().addListSelectionListener(this::handleTableSolicitudesSelectionEvent);
        listAdjuntos.getSelectionModel().addListSelectionListener(this::handleListAdjuntosSelection);

        ((DefaultTableCellRenderer) tableSolicitudes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.LEFT);

        try {
            loadSolicitudes();
        } catch (Exception ex) {
        }
    }

    public void loadSolicitudes() throws Exception {
        SolicitudDAO solicitudDAO = BeanFactory.local().lookup("Solicitud");

        List<Solicitud> solicitudes = solicitudDAO.findAllWithRelations();
        solicitudTableModel.setListRows(solicitudes);
        tableSolicitudes.setModel(solicitudTableModel);
    }

    public void loadAdjuntos(Long idSolicitud) throws Exception {
        AdjuntoSolicitudDAO adjuntoSolicitudDAO = BeanFactory.local().lookup("AdjuntoSolicitud");

        List<AdjuntoSolicitud> adjuntosSolicitud = adjuntoSolicitudDAO.findAllBySolicitud(idSolicitud);

        DefaultListModel listModel = new DefaultListModel<AdjuntoSolicitud>();

        listModel.addAll(adjuntosSolicitud);

        listAdjuntos.setModel(listModel);
    }

    public void loadAcciones(Long idSolicitud) throws Exception {
        AccionSolicitudDAO accionSolicitudDAO = BeanFactory.local().lookup("AccionSolicitud");

        List<AccionSolicitud> accionesSolicitud = accionSolicitudDAO.findAllBySolicitud(idSolicitud);

        DefaultListModel listModel = new DefaultListModel<AccionSolicitud>();

        listModel.addAll(accionesSolicitud);

        listAcciones.setModel(listModel);
    }

    private void enableOperationBtns(boolean enabled) {
        btnCargarPlantilla.setEnabled(enabled);
        btnRegistrarAccion.setEnabled(enabled);
        btnEmitir.setEnabled(enabled);
    }

    private void enableTabs(boolean enabled) {
        jTabbedPane2.setEnabledAt(0, enabled);
        jTabbedPane2.setEnabledAt(1, enabled);
    }

    public DataTableModel createSolicitudModel() {

        String[] COLUMNS = {"ID", "Estudiante", "Tipo", "Estado"};

        return new DataTableModel<Solicitud>(COLUMNS) {
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
        };
    }

    public Solicitud getSelectedSolicitud() {
        int row = tableSolicitudes.getSelectedRow();

        Solicitud s = (Solicitud) tableSolicitudes.getValueAt(row, -1);

        return s;
    }

    public AdjuntoSolicitud getSelectedAdjunto() {
        return listAdjuntos.getSelectedValue();
    }

    public void handleTableSolicitudesSelectionEvent(ListSelectionEvent e) {
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

    public void handleListAdjuntosSelection(ListSelectionEvent e) {
        boolean seleccionValida = !listAdjuntos.isSelectionEmpty();

        btnDescargar.setEnabled(seleccionValida);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnCargarPlantilla = new javax.swing.JButton();
        btnRegistrarAccion = new javax.swing.JButton();
        btnEmitir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSolicitudes = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAdjuntos = new javax.swing.JList<>();
        jToolBar2 = new javax.swing.JToolBar();
        btnDescargar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listAcciones = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        jToolBar1.setRollover(true);

        btnCargarPlantilla.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        btnCargarPlantilla.setText("Cargar plantilla");
        btnCargarPlantilla.setFocusable(false);
        btnCargarPlantilla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCargarPlantilla.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCargarPlantilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarPlantillaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCargarPlantilla);

        btnRegistrarAccion.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        btnRegistrarAccion.setText("Registrar acción");
        btnRegistrarAccion.setFocusable(false);
        btnRegistrarAccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarAccion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAccionActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRegistrarAccion);

        btnEmitir.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        btnEmitir.setText("Emitir");
        btnEmitir.setFocusable(false);
        btnEmitir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmitir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEmitir);

        tableSolicitudes.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        tableSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableSolicitudes.setRowHeight(30);
        tableSolicitudes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableSolicitudes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableSolicitudes);

        jTabbedPane2.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N

        listAdjuntos.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(listAdjuntos);

        jToolBar2.setRollover(true);

        btnDescargar.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
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

        jPanel3.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N

        listAcciones.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        listAcciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listAcciones.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof AccionSolicitud) {
                    AccionSolicitud a = (AccionSolicitud) value;

                    String parsedFechaHora = a.getFecHora().format(Globals.dateTimeFormatter);
                    String text = "<html>" + a.getDetalle() + "<br/>(" + parsedFechaHora + ")" + " </html>";

                    setText(text);
                }

                return this;
            }
        }
    );
    listAcciones.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
    listAcciones.setVisibleRowCount(-1);
    jScrollPane3.setViewportView(listAcciones);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
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
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextField1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jTabbedPane2)
                    .addContainerGap())
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2)))
            .addContainerGap())
    );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        AdjuntoSolicitud adjunto = getSelectedAdjunto();

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
        fileChooser.setSelectedFile(new File(adjunto.getNombArchivo()));
        fileChooser.setDialogTitle("Descargar archivo");

        int option = fileChooser.showSaveDialog(parentFrame);

        if (option == JFileChooser.APPROVE_OPTION) {
            String strPath = fileChooser.getSelectedFile().getAbsolutePath();

            Path path = new File(strPath).toPath();

            byte[] fileContent = adjunto.getArchivo();

            try {
                Files.write(path, fileContent);
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_btnDescargarActionPerformed

    private void btnCargarPlantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarPlantillaActionPerformed
        Solicitud solicitud = getSelectedSolicitud();

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Descargar archivo");

        int option = fileChooser.showSaveDialog(parentFrame);

        if (option == JFileChooser.APPROVE_OPTION) {
            byte[] plantillaContent = solicitud.getTipo().getPlantilla();

            FileOutputStream fos = null;
            File templateFile = null;

            SystemManager.initialise();

            DataProviderBuilder dpb = new DataProviderBuilder();

            dpb.add("nombres", "Marcos");
            dpb.add("apellidos", "Cianzio");

            try {
                templateFile = File.createTempFile("plantilla", ".doc", null);
                fos = new FileOutputStream(templateFile);
                fos.write(plantillaContent);

                if (templateFile.canRead()) {
                    DocumentProcessor.renderDoc(templateFile, fileChooser.getSelectedFile(), dpb.getDataProvider());

                    Desktop.getDesktop().open(fileChooser.getSelectedFile());
                }
            } catch (Exception e) {
            } finally {
                try {
                    fos.close();
                } catch (IOException ex) {
                }

                templateFile.delete();
                SystemManager.release();
            }
        }
    }//GEN-LAST:event_btnCargarPlantillaActionPerformed

    private void btnRegistrarAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAccionActionPerformed
        new NewAccion(parentFrame, true, getSelectedSolicitud(), this).show();
     }//GEN-LAST:event_btnRegistrarAccionActionPerformed

    private void btnEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirActionPerformed
        new Emitir(parentFrame, true, getSelectedSolicitud(), this).show();
    }//GEN-LAST:event_btnEmitirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarPlantilla;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JButton btnEmitir;
    private javax.swing.JButton btnRegistrarAccion;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JList<String> listAcciones;
    private javax.swing.JList<AdjuntoSolicitud> listAdjuntos;
    private javax.swing.JTable tableSolicitudes;
    // End of variables declaration//GEN-END:variables
}
