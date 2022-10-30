package com.fannog.proyectocliente.ui.analista;

import com.fannog.proyectocliente.utils.BeanFactory;
import com.fannog.proyectoservidor.DAO.ItrDAO;
import com.fannog.proyectoservidor.entities.Itr;
import com.fannog.proyectoservidor.exceptions.ServicioException;

public class CreateOrEditITR extends javax.swing.JDialog {

    private Itr itr;
    private GestionItrs gestionItrsPanel;

    public CreateOrEditITR(java.awt.Frame parent, boolean modal, Itr itr, GestionItrs gestionItrsPanel) {
        super(parent, modal);
        this.itr = itr;
        this.gestionItrsPanel = gestionItrsPanel;

        if (itr == null) {
            btnEditOrCreate.setText("Crear");
        } else {
            btnEditOrCreate.setText("Actualizar");
        }

        initComponents();
    }

    public void updateITR() throws ServicioException, Exception {
        ItrDAO itrDAO = BeanFactory.local().lookup("Itr");

        String newNombre = txtNombre.getText();

        itr.setNombre(newNombre);

        itrDAO.edit(itr);
    }

    public void createITR() throws ServicioException, Exception {
        ItrDAO itrDAO = BeanFactory.local().lookup("Itr");

        String nombre = txtNombre.getText();

        Itr newItr = new Itr(nombre);

        itrDAO.create(newItr);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnEditOrCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Nombre:");

        btnCancelar.setText("Cancelar");

        btnEditOrCreate.setText("Editar");
        btnEditOrCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditOrCreateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditOrCreate)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditOrCreate)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditOrCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditOrCreateMouseClicked
        try {
            if (itr == null) {
                 createITR();
            } else {
                updateITR();
            }

            gestionItrsPanel.getItrsTableModel().fireTableDataChanged();
        } catch (ServicioException ex) {
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnEditOrCreateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditOrCreate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
