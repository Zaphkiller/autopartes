/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

/**
 *
 * @author Natsu98fx
 */
public class TabClientes extends javax.swing.JPanel {

    /**
     * Creates new form TabClientes
     */
    public TabClientes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetroCustom1 = new RSMaterialComponent.RSTableMetroCustom();

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setIntensity(5);
        rSPanelMaterial1.setRound(10);

        rSTableMetroCustom1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "codigo", "Nombres", "Apellidos", "dni", "email", "telefono"
            }
        ));
        jScrollPane1.setViewportView(rSTableMetroCustom1);

        javax.swing.GroupLayout rSPanelMaterial1Layout = new javax.swing.GroupLayout(rSPanelMaterial1);
        rSPanelMaterial1.setLayout(rSPanelMaterial1Layout);
        rSPanelMaterial1Layout.setHorizontalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        rSPanelMaterial1Layout.setVerticalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    private RSMaterialComponent.RSTableMetroCustom rSTableMetroCustom1;
    // End of variables declaration//GEN-END:variables
}
