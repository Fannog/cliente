package com.fannog.proyectocliente.ui.analista;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JFrame;

public class MenuAnalista extends JFrame {

    public MenuAnalista() {
        initComponents();

        jTabbedPane2.setIconAt(0, new FlatSVGIcon("com/fannog/proyectocliente/icons/certificate.svg", 20, 20));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        constancias1 = new com.fannog.proyectocliente.ui.analista.Constancias();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        constancias3 = new com.fannog.proyectocliente.ui.analista.Constancias();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu - Analista");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jTabbedPane2.addTab("Constancias", constancias3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 631, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        setSize(new java.awt.Dimension(1016, 651));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fannog.proyectocliente.ui.analista.Constancias constancias1;
    private com.fannog.proyectocliente.ui.analista.Constancias constancias3;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
