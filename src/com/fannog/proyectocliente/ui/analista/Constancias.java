package com.fannog.proyectocliente.ui.analista;

public class Constancias extends javax.swing.JPanel {

    public Constancias() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        solicitudes1 = new com.fannog.proyectocliente.ui.analista.Solicitudes();

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout solicitudes1Layout = new javax.swing.GroupLayout(solicitudes1);
        solicitudes1.setLayout(solicitudes1Layout);
        solicitudes1Layout.setHorizontalGroup(
            solicitudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        solicitudes1Layout.setVerticalGroup(
            solicitudes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Solicitudes", solicitudes1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.fannog.proyectocliente.ui.analista.Solicitudes solicitudes1;
    // End of variables declaration//GEN-END:variables
}
