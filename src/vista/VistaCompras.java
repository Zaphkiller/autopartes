package vista;

import vista.ModalSeleccionProveedor;

public class VistaCompras extends javax.swing.JPanel {

    /**
     * Creates new form VistaCompras
     */
    public VistaCompras() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSButtonMaterialDos1 = new RSMaterialComponent.RSButtonMaterialDos();
        rSLabelBorder1 = new rojeru_san.rslabel.RSLabelBorder();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSPanelMaterialGradient1 = new RSMaterialComponent.RSPanelMaterialGradient();
        jLabel1 = new javax.swing.JLabel();
        pnlSlider = new newscomponents.RSPanelEffect();
        jPanel3 = new javax.swing.JPanel();
        btnSeleccionaProductos = new newscomponents.RSButtonGradientIcon_new();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        txtCompra = new rojeru_san.rslabel.RSLabelBorderRound();
        rSLabelFecha1 = new rojeru_san.RSLabelFecha();
        rSLabelSombra1 = new rojeru_san.rslabel.RSLabelSombra();
        txtDireccionProveedor = new RSMaterialComponent.RSTextFieldMaterial();
        txtTitular = new RSMaterialComponent.RSTextFieldMaterial();
        txtTelefonoProveedor = new RSMaterialComponent.RSTextFieldMaterial();
        txtNombreProveedor = new RSMaterialComponent.RSTextFieldMaterial();
        txtCorreoProveedor = new RSMaterialComponent.RSTextFieldMaterial();
        btnSeleccionProveedor = new newscomponents.RSButtonGradientIcon_new();
        rSButtonGradientIcon_new4 = new newscomponents.RSButtonGradientIcon_new();
        rSButtonGradientIcon_new5 = new newscomponents.RSButtonGradientIcon_new();
        tabCompras1 = new vista.TabCompras();

        rSButtonMaterialDos1.setText("rSButtonMaterialDos1");

        rSLabelBorder1.setText("rSLabelBorder1");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(153, 153, 153)));

        rSPanelMaterialGradient1.setBgShade(new java.awt.Color(51, 102, 255));
        rSPanelMaterialGradient1.setColorPrimario(new java.awt.Color(0, 102, 255));
        rSPanelMaterialGradient1.setShadowBottom(false);
        rSPanelMaterialGradient1.setShadowLeft(false);
        rSPanelMaterialGradient1.setShadowRight(false);
        rSPanelMaterialGradient1.setShadowTop(false);

        jLabel1.setFont(new java.awt.Font("Roboto Cn", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Compras");

        javax.swing.GroupLayout rSPanelMaterialGradient1Layout = new javax.swing.GroupLayout(rSPanelMaterialGradient1);
        rSPanelMaterialGradient1.setLayout(rSPanelMaterialGradient1Layout);
        rSPanelMaterialGradient1Layout.setHorizontalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE))
        );
        rSPanelMaterialGradient1Layout.setVerticalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
            .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlSlider.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnSeleccionaProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-add-user.png"))); // NOI18N
        btnSeleccionaProductos.setText("Seleccionar Productos");
        btnSeleccionaProductos.setColorSecundarioHover(new java.awt.Color(0, 102, 153));
        btnSeleccionaProductos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SELECT_ALL);

        rSLabelSombra1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSLabelSombra1.setText("Código");
        rSLabelSombra1.setColorDeSombra(new java.awt.Color(255, 255, 255));

        txtDireccionProveedor.setPlaceholder("Dirección fiscal");

        txtTitular.setPlaceholder("Titular");

        txtTelefonoProveedor.setPlaceholder("Teléfono de contacto");

        txtNombreProveedor.setPlaceholder("Nombre del proveedor");

        txtCorreoProveedor.setPlaceholder("Correo electrónico");

        btnSeleccionProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-add-user.png"))); // NOI18N
        btnSeleccionProveedor.setText("Seleccionar Proveedor");
        btnSeleccionProveedor.setColorSecundarioHover(new java.awt.Color(0, 102, 153));
        btnSeleccionProveedor.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SELECT_ALL);
        btnSeleccionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionProveedorActionPerformed(evt);
            }
        });

        rSButtonGradientIcon_new4.setBackground(new java.awt.Color(0, 255, 51));
        rSButtonGradientIcon_new4.setText("Cancelar");
        rSButtonGradientIcon_new4.setToolTipText("");
        rSButtonGradientIcon_new4.setColorPrimario(new java.awt.Color(255, 102, 102));
        rSButtonGradientIcon_new4.setColorPrimarioHover(new java.awt.Color(255, 0, 0));
        rSButtonGradientIcon_new4.setColorSecundario(new java.awt.Color(204, 0, 51));
        rSButtonGradientIcon_new4.setColorSecundarioHover(new java.awt.Color(255, 0, 0));
        rSButtonGradientIcon_new4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);

        rSButtonGradientIcon_new5.setBackground(new java.awt.Color(0, 255, 51));
        rSButtonGradientIcon_new5.setText("Generar compra");
        rSButtonGradientIcon_new5.setToolTipText("");
        rSButtonGradientIcon_new5.setColorPrimario(new java.awt.Color(0, 204, 51));
        rSButtonGradientIcon_new5.setColorPrimarioHover(new java.awt.Color(0, 255, 0));
        rSButtonGradientIcon_new5.setColorSecundario(new java.awt.Color(0, 102, 51));
        rSButtonGradientIcon_new5.setColorSecundarioHover(new java.awt.Color(0, 255, 0));
        rSButtonGradientIcon_new5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCorreoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnSeleccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(134, 134, 134)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(tabCompras1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(rSButtonGradientIcon_new5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rSButtonGradientIcon_new4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeleccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(rSLabelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnSeleccionaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(tabCompras1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSButtonGradientIcon_new5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonGradientIcon_new4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSlider.add(jPanel3, "card2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionProveedorActionPerformed
        
    }//GEN-LAST:event_btnSeleccionProveedorActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnSeleccionProveedor;
    private newscomponents.RSButtonGradientIcon_new btnSeleccionaProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private newscomponents.RSPanelEffect pnlSlider;
    private newscomponents.RSButtonGradientIcon_new rSButtonGradientIcon_new4;
    private newscomponents.RSButtonGradientIcon_new rSButtonGradientIcon_new5;
    private RSMaterialComponent.RSButtonMaterialDos rSButtonMaterialDos1;
    private rojeru_san.rslabel.RSLabelBorder rSLabelBorder1;
    private rojeru_san.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojeru_san.rslabel.RSLabelSombra rSLabelSombra1;
    private RSMaterialComponent.RSPanelMaterialGradient rSPanelMaterialGradient1;
    private vista.TabCompras tabCompras1;
    private rojeru_san.rslabel.RSLabelBorderRound txtCompra;
    private RSMaterialComponent.RSTextFieldMaterial txtCorreoProveedor;
    private RSMaterialComponent.RSTextFieldMaterial txtDireccionProveedor;
    private RSMaterialComponent.RSTextFieldMaterial txtNombreProveedor;
    private RSMaterialComponent.RSTextFieldMaterial txtTelefonoProveedor;
    private RSMaterialComponent.RSTextFieldMaterial txtTitular;
    // End of variables declaration//GEN-END:variables
}
