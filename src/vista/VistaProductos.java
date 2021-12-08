package vista;

import controlador.ClienteController;
import controlador.ProductController;
import controlador.ProviderController;
import controlador.UserController;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import modelo.ComboBox;
import modelo.ProductDAO;
import modelo.Products;
import modelo.Provider;
import modelo.ProviderDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class VistaProductos extends javax.swing.JPanel {
    
  Products pro = new Products();
  ProductDAO prodDAO = new ProductDAO();
  Provider provi = new Provider();

    public VistaProductos() {
            
        initComponents();
        prodDAO.ConsultarProveedor(cboProveedor_Producto);
        prodDAO.ConsultarCategoria(cboCategoria_Producto);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PoupMenuProducts = new rojerusan.RSPopuMenu();
        MenuItem_EliminarProducto = new javax.swing.JMenuItem();
        MenuItem_ReingresarProducto = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        rSPanelMaterialGradient1 = new RSMaterialComponent.RSPanelMaterialGradient();
        jLabel1 = new javax.swing.JLabel();
        pnlSlider = new newscomponents.RSPanelEffect();
        txtSearchProductos = new RSMaterialComponent.RSTextFieldIconOne();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new rojerusan.RSTableMetro();
        btnNewProduct = new newscomponents.RSButtonGradientIcon_new();
        btnRegisterProduct = new newscomponents.RSButtonGradientIcon_new();
        btnModifyProduct = new newscomponents.RSButtonGradientIcon_new();
        txtIdProducto = new RSMaterialComponent.RSTextFieldOne();
        txtCodigoProducto_Producto = new RSMaterialComponent.RSTextFieldOne();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcionProducto_Producto = new RSMaterialComponent.RSTextFieldOne();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioCompra_Producto = new RSMaterialComponent.RSTextFieldOne();
        jLabel5 = new javax.swing.JLabel();
        cboProveedor_Producto = new rojerusan.RSComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtPrecioVenta_Producto = new RSMaterialComponent.RSTextFieldOne();
        jLabel6 = new javax.swing.JLabel();
        cboCategoria_Producto = new rojerusan.RSComboBox();
        jLabel10 = new javax.swing.JLabel();
        lblFoto = new rojerusan.RSLabelImage();
        btnBuscarFoto = new rojeru_san.RSButtonRiple();

        MenuItem_EliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        MenuItem_EliminarProducto.setText("Eliminar");
        PoupMenuProducts.add(MenuItem_EliminarProducto);

        MenuItem_ReingresarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ingresar.png"))); // NOI18N
        MenuItem_ReingresarProducto.setText("Reingresar");
        MenuItem_ReingresarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_ReingresarProductoActionPerformed(evt);
            }
        });
        PoupMenuProducts.add(MenuItem_ReingresarProducto);
        MenuItem_ReingresarProducto.getAccessibleContext().setAccessibleDescription("");

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(995, 702));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(153, 153, 153)));

        rSPanelMaterialGradient1.setBgShade(new java.awt.Color(51, 102, 255));
        rSPanelMaterialGradient1.setColorPrimario(new java.awt.Color(0, 102, 255));
        rSPanelMaterialGradient1.setShadowBottom(false);
        rSPanelMaterialGradient1.setShadowLeft(false);
        rSPanelMaterialGradient1.setShadowRight(false);
        rSPanelMaterialGradient1.setShadowTop(false);

        jLabel1.setFont(new java.awt.Font("Roboto Cn", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Módulo de Productos");

        javax.swing.GroupLayout rSPanelMaterialGradient1Layout = new javax.swing.GroupLayout(rSPanelMaterialGradient1);
        rSPanelMaterialGradient1.setLayout(rSPanelMaterialGradient1Layout);
        rSPanelMaterialGradient1Layout.setHorizontalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelMaterialGradient1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        rSPanelMaterialGradient1Layout.setVerticalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlSlider.setBackground(new java.awt.Color(255, 255, 255));

        txtSearchProductos.setForeground(new java.awt.Color(51, 51, 51));
        txtSearchProductos.setBorderColor(new java.awt.Color(204, 204, 204));
        txtSearchProductos.setColorIcon(new java.awt.Color(51, 51, 51));
        txtSearchProductos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        txtSearchProductos.setPhColor(new java.awt.Color(102, 102, 102));
        txtSearchProductos.setPlaceholder("Buscar");

        tblProductos.setBackground(new java.awt.Color(255, 255, 255));
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código", "Descripción", "Stock", "Precio", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setBackgoundHover(new java.awt.Color(102, 255, 255));
        tblProductos.setComponentPopupMenu(PoupMenuProducts);
        tblProductos.setEditingColumn(0);
        tblProductos.setEditingRow(0);
        tblProductos.setSelectionBackground(new java.awt.Color(51, 153, 255));
        tblProductos.setWidthBorderRows(0);
        jScrollPane1.setViewportView(tblProductos);

        btnNewProduct.setBackground(new java.awt.Color(0, 255, 51));
        btnNewProduct.setText("Nuevo");
        btnNewProduct.setToolTipText("");
        btnNewProduct.setColorPrimario(new java.awt.Color(0, 204, 51));
        btnNewProduct.setColorPrimarioHover(new java.awt.Color(0, 255, 0));
        btnNewProduct.setColorSecundario(new java.awt.Color(0, 102, 51));
        btnNewProduct.setColorSecundarioHover(new java.awt.Color(0, 255, 0));
        btnNewProduct.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);

        btnRegisterProduct.setBackground(new java.awt.Color(75, 172, 198));
        btnRegisterProduct.setText("Registrar");
        btnRegisterProduct.setToolTipText("");
        btnRegisterProduct.setColorPrimario(new java.awt.Color(75, 172, 198));
        btnRegisterProduct.setColorPrimarioHover(new java.awt.Color(0, 255, 255));
        btnRegisterProduct.setColorSecundario(new java.awt.Color(75, 85, 215));
        btnRegisterProduct.setColorSecundarioHover(new java.awt.Color(0, 255, 255));
        btnRegisterProduct.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEND);

        btnModifyProduct.setBackground(new java.awt.Color(0, 255, 51));
        btnModifyProduct.setText("Modificar");
        btnModifyProduct.setToolTipText("");
        btnModifyProduct.setColorPrimario(new java.awt.Color(255, 102, 102));
        btnModifyProduct.setColorPrimarioHover(new java.awt.Color(255, 0, 0));
        btnModifyProduct.setColorSecundario(new java.awt.Color(204, 0, 51));
        btnModifyProduct.setColorSecundarioHover(new java.awt.Color(255, 0, 0));
        btnModifyProduct.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);

        txtIdProducto.setEditable(false);
        txtIdProducto.setBackground(new java.awt.Color(204, 204, 204));
        txtIdProducto.setForeground(new java.awt.Color(0, 102, 255));
        txtIdProducto.setBorderColor(new java.awt.Color(0, 102, 255));
        txtIdProducto.setMargin(new java.awt.Insets(3, 2, 3, 2));
        txtIdProducto.setOpaque(false);
        txtIdProducto.setPhColor(new java.awt.Color(0, 0, 0));
        txtIdProducto.setPlaceholder("Id Producto");
        txtIdProducto.setSelectionColor(new java.awt.Color(51, 51, 51));

        txtCodigoProducto_Producto.setForeground(new java.awt.Color(0, 102, 255));
        txtCodigoProducto_Producto.setBorderColor(new java.awt.Color(0, 102, 255));
        txtCodigoProducto_Producto.setMargin(new java.awt.Insets(3, 2, 3, 2));
        txtCodigoProducto_Producto.setOpaque(false);
        txtCodigoProducto_Producto.setPhColor(new java.awt.Color(0, 0, 153));
        txtCodigoProducto_Producto.setPlaceholder("Código...");
        txtCodigoProducto_Producto.setSelectionColor(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Código");

        txtDescripcionProducto_Producto.setForeground(new java.awt.Color(0, 102, 255));
        txtDescripcionProducto_Producto.setBorderColor(new java.awt.Color(0, 102, 255));
        txtDescripcionProducto_Producto.setMargin(new java.awt.Insets(3, 2, 3, 2));
        txtDescripcionProducto_Producto.setOpaque(false);
        txtDescripcionProducto_Producto.setPhColor(new java.awt.Color(0, 0, 153));
        txtDescripcionProducto_Producto.setPlaceholder("Descripción del producto...");
        txtDescripcionProducto_Producto.setSelectionColor(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Descripción del Producto");

        txtPrecioCompra_Producto.setForeground(new java.awt.Color(0, 102, 255));
        txtPrecioCompra_Producto.setBorderColor(new java.awt.Color(0, 102, 255));
        txtPrecioCompra_Producto.setMargin(new java.awt.Insets(3, 2, 3, 2));
        txtPrecioCompra_Producto.setOpaque(false);
        txtPrecioCompra_Producto.setPhColor(new java.awt.Color(0, 0, 153));
        txtPrecioCompra_Producto.setPlaceholder("");
        txtPrecioCompra_Producto.setSelectionColor(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Precio Compra");

        cboProveedor_Producto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        cboProveedor_Producto.setColorArrow(new java.awt.Color(0, 102, 255));
        cboProveedor_Producto.setColorBorde(new java.awt.Color(0, 0, 255));
        cboProveedor_Producto.setColorFondo(new java.awt.Color(0, 102, 255));
        cboProveedor_Producto.setColorSeleccion(new java.awt.Color(0, 102, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Seleccionar Proveedor");

        txtPrecioVenta_Producto.setForeground(new java.awt.Color(0, 102, 255));
        txtPrecioVenta_Producto.setBorderColor(new java.awt.Color(0, 102, 255));
        txtPrecioVenta_Producto.setMargin(new java.awt.Insets(3, 2, 3, 2));
        txtPrecioVenta_Producto.setOpaque(false);
        txtPrecioVenta_Producto.setPhColor(new java.awt.Color(0, 0, 153));
        txtPrecioVenta_Producto.setPlaceholder("");
        txtPrecioVenta_Producto.setSelectionColor(new java.awt.Color(51, 51, 51));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Precio Venta");

        cboCategoria_Producto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        cboCategoria_Producto.setColorArrow(new java.awt.Color(0, 102, 255));
        cboCategoria_Producto.setColorBorde(new java.awt.Color(0, 0, 255));
        cboCategoria_Producto.setColorFondo(new java.awt.Color(0, 102, 255));
        cboCategoria_Producto.setColorSeleccion(new java.awt.Color(0, 102, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Seleccionar Categoría");

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        btnBuscarFoto.setText("Buscar imagen");
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSliderLayout = new javax.swing.GroupLayout(pnlSlider);
        pnlSlider.setLayout(pnlSliderLayout);
        pnlSliderLayout.setHorizontalGroup(
            pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSliderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSliderLayout.createSequentialGroup()
                        .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCodigoProducto_Producto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addComponent(txtPrecioCompra_Producto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(19, 19, 19)
                        .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcionProducto_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlSliderLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSliderLayout.createSequentialGroup()
                                .addComponent(txtPrecioVenta_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboProveedor_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                            .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlSliderLayout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlSliderLayout.createSequentialGroup()
                                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboCategoria_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))))))
                .addGap(22, 22, 22)
                .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(btnBuscarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSliderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnRegisterProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnModifyProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSliderLayout.createSequentialGroup()
                .addGap(498, 498, 498)
                .addComponent(txtSearchProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSliderLayout.setVerticalGroup(
            pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSliderLayout.createSequentialGroup()
                .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSliderLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSliderLayout.createSequentialGroup()
                                .addComponent(txtCodigoProducto_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(pnlSliderLayout.createSequentialGroup()
                                .addComponent(txtDescripcionProducto_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlSliderLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPrecioVenta_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPrecioCompra_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlSliderLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboProveedor_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel10)
                        .addGap(3, 3, 3)
                        .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCategoria_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlSliderLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(txtSearchProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifyProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItem_ReingresarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem_ReingresarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuItem_ReingresarProductoActionPerformed

    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        if (jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            rsdragdropfiles.RSDragDropFiles.setCopiar(jf.getSelectedFile().toString(), "src/imgsave/imagen.png");
            lblFoto.setIcon(new ImageIcon(jf.getSelectedFile().toString()));
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem MenuItem_EliminarProducto;
    public javax.swing.JMenuItem MenuItem_ReingresarProducto;
    public rojerusan.RSPopuMenu PoupMenuProducts;
    public rojeru_san.RSButtonRiple btnBuscarFoto;
    public newscomponents.RSButtonGradientIcon_new btnModifyProduct;
    public newscomponents.RSButtonGradientIcon_new btnNewProduct;
    public newscomponents.RSButtonGradientIcon_new btnRegisterProduct;
    public rojerusan.RSComboBox cboCategoria_Producto;
    public rojerusan.RSComboBox cboProveedor_Producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public rojerusan.RSLabelImage lblFoto;
    private newscomponents.RSPanelEffect pnlSlider;
    private RSMaterialComponent.RSPanelMaterialGradient rSPanelMaterialGradient1;
    public rojerusan.RSTableMetro tblProductos;
    public RSMaterialComponent.RSTextFieldOne txtCodigoProducto_Producto;
    public RSMaterialComponent.RSTextFieldOne txtDescripcionProducto_Producto;
    public RSMaterialComponent.RSTextFieldOne txtIdProducto;
    public RSMaterialComponent.RSTextFieldOne txtPrecioCompra_Producto;
    public RSMaterialComponent.RSTextFieldOne txtPrecioVenta_Producto;
    public RSMaterialComponent.RSTextFieldIconOne txtSearchProductos;
    // End of variables declaration//GEN-END:variables
 public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaWarningSalir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaWarningSalir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaWarningSalir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaWarningSalir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaWarningSalir().setVisible(true);
            }
        });
    }
}
