package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ComboBox;
import modelo.ProductDAO;
import modelo.Products;
import modelo.Tables;
import modelo.Usuario;
import vista.FrmPrincipal;
import vista.VistaError;
import vista.VistaInfo;
import vista.VistaSuccess;

public class ProductController implements ActionListener, MouseListener, KeyListener {

    private Products prod;
    private ProductDAO prodDAO;
    private FrmPrincipal vista;

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel temp;

    public ProductController(Products prod, ProductDAO prodDAO, FrmPrincipal vista) {
        this.prod = prod;
        this.prodDAO = prodDAO;
        this.vista = vista;

        this.vista.btnRegisterProduct.addActionListener(this);
        this.vista.btnModifyProduct.addActionListener(this);
        this.vista.btnNewProduct.addActionListener(this);
        this.vista.MenuItem_EliminarProducto.addActionListener(this);
        this.vista.MenuItem_ReingresarProducto.addActionListener(this);
        this.vista.btnBuscarProducto_Compras.addActionListener(this);
        this.vista.tblProductos.addMouseListener(this);
        this.vista.tblModalProductos.addMouseListener(this);
        this.vista.txtSearchProductos.addKeyListener(this);
        this.vista.txtCodigoProducto_Compra.addKeyListener(this);
        this.vista.txtCantidad_Compra.addKeyListener(this);
        this.vista.txtPagar_Compra.addKeyListener(this);
        this.vista.btnGenerarCompra.addActionListener(this);
        listarProductos();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegisterProduct) {

            if (vista.txtCodigoProducto_Producto.getText().equals("")
                    || vista.txtDescripcionProducto_Producto.getText().equals("")
                    || vista.txtPrecioCompra_Producto.getText().equals("")
                    || vista.txtPrecioVenta_Producto.getText().equals("")) {

                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);

            } else {

                prod.setCode_product(vista.txtCodigoProducto_Producto.getText());
                prod.setDescription_product(vista.txtDescripcionProducto_Producto.getText());
                prod.setPurchase_price(Double.parseDouble(vista.txtPrecioCompra_Producto.getText()));
                prod.setSale_price(Double.parseDouble(vista.txtPrecioVenta_Producto.getText()));

                ComboBox itemP = (ComboBox) vista.cboProveedor_Producto.getSelectedItem();
                ComboBox itemC = (ComboBox) vista.cboCategoria_Producto.getSelectedItem();
                prod.setId_provider(itemP.getId());
                prod.setId_category(itemC.getId());

                if (prodDAO.register(prod)) {

                    limpiarTable();
                    listarProductos();
                    limpiar();

                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Producto registrado!");
                    success.setVisible(true);

                } else {

                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al registrar producto!");
                    error.setVisible(true);

                }

            }

        } else if (e.getSource() == vista.btnModifyProduct) {

            if (vista.txtCodigoProducto_Producto.getText().equals("")
                    || vista.txtDescripcionProducto_Producto.getText().equals("")
                    || vista.txtPrecioCompra_Producto.getText().equals("")
                    || vista.txtPrecioVenta_Producto.getText().equals("")) {

                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);

            } else {
                prod.setCode_product(vista.txtCodigoProducto_Producto.getText());
                prod.setDescription_product(vista.txtDescripcionProducto_Producto.getText());
                prod.setPurchase_price(Double.parseDouble(vista.txtPrecioCompra_Producto.getText()));
                prod.setSale_price(Double.parseDouble(vista.txtPrecioVenta_Producto.getText()));
                ComboBox itemP = (ComboBox) vista.cboProveedor_Producto.getSelectedItem();
                ComboBox itemC = (ComboBox) vista.cboCategoria_Producto.getSelectedItem();

                prod.setId_provider(itemP.getId());
                prod.setId_category(itemC.getId());
                prod.setId_product(Integer.parseInt(vista.txtIdProducto.getText()));

                if (prodDAO.modify(prod)) {
                    limpiarTable();
                    listarProductos();
                    limpiar();

                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Producto modificado!");
                    success.setVisible(true);

                } else {
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al modificar producto!");
                    error.setVisible(true);
                }
            }

        } else if (e.getSource() == vista.MenuItem_EliminarProducto) {
            if (vista.txtIdProducto.getText().equals("")) {
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para eliminar");
                info.setVisible(true);
            } else {
                int id = Integer.parseInt(vista.txtIdProducto.getText());
                if (prodDAO.accion("Inactivo", id)) {
                    limpiarTable();
                    listarProductos();
                    limpiar();

                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Producto eliminado!");
                    success.setVisible(true);
                } else {
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al eliminar producto!");
                    error.setVisible(true);
                }
            }
        } else if (e.getSource() == vista.MenuItem_ReingresarProducto) {
            if (vista.txtIdProducto.getText().equals("")) {
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para reingresar");
                info.setVisible(true);
            } else {
                int id = Integer.parseInt(vista.txtIdProducto.getText());
                if (prodDAO.accion("Activo", id)) {
                    limpiarTable();
                    listarProductos();
                    limpiar();

                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Producto reingresado!");
                    success.setVisible(true);
                } else {
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al reingresar producto!");
                    error.setVisible(true);
                }
            }
        } else if (e.getSource() == vista.btnGenerarCompra) {
            insertarCompra();
        }
    }

    public void listarProductos() {
        Tables color = new Tables();
        vista.tblProductos.setDefaultRenderer(vista.tblProductos.getColumnClass(0), color);
        List<Products> lista = prodDAO.ListaProductos(vista.txtSearchProductos.getText());
        modelo = (DefaultTableModel) vista.tblProductos.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_product();
            ob[1] = lista.get(i).getCode_product();
            ob[2] = lista.get(i).getDescription_product();
            ob[3] = lista.get(i).getQuantity();
            ob[4] = lista.get(i).getSale_price();
            ob[5] = lista.get(i).getStatus_product();
            modelo.addRow(ob);
        }
        vista.tblProductos.setModel(modelo);
    }

    public void limpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void limpiarTableDetalle() {
        for (int i = 0; i < temp.getRowCount(); i++) {
            temp.removeRow(i);
            i = i - 1;
        }
    }

    private void limpiar() {
        vista.txtCodigoProducto_Producto.setText("");
        vista.txtDescripcionProducto_Producto.setText("");
        vista.txtPrecioVenta_Producto.setText("");
        vista.txtPrecioCompra_Producto.setText("");
        vista.txtDescripcionProducto_Producto.setText("");
        vista.txtPrecioVenta_Producto.setText("");
        vista.txtCodigoProducto_Producto.grabFocus();

    }

    private void limpiarCampos() {
        vista.txtCodigoProducto_Compra.setText("");
        vista.txtIdProducto_Compra.setText("");
        vista.txtDescripcionProducto_Compra.setText("");
        vista.txtPrecio_Compra.setText("");
        vista.txtCantidad_Compra.setText("");
        vista.txtPagar_Compra.setText("");
        vista.txtCodigoProducto_Compra.grabFocus();

    }

    private void CalcularSubtotal() {
        double subtotal = 0.00;
        int numfila = vista.tblCompras.getRowCount();
        for (int i = 0; i < numfila; i++) {
            subtotal = subtotal + Double.parseDouble(String.valueOf(vista.tblCompras.getValueAt(i, 4)));
        }

    }

    public void CalcularIGV() {
        double igv = 0.00;
        int numfila = vista.tblCompras.getRowCount();
        for (int i = 0; i < numfila; i++) {

            igv = igv + Double.parseDouble(String.valueOf(vista.tblCompras.getValueAt(i, 5)));
        }
    }

    public void CalcularTotal() {
        double total = 0.00;
        int numfila = vista.tblCompras.getRowCount();
        for (int i = 0; i < numfila; i++) {

            total = total + Double.parseDouble(String.valueOf(vista.tblCompras.getValueAt(i, 6)));
        }
        vista.txtTotalPago_Compra.setText("" + total);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.tblProductos) {

            int fila = vista.tblProductos.rowAtPoint(e.getPoint());
            vista.txtIdProducto.setText(vista.tblProductos.getValueAt(fila, 0).toString());
            prod = prodDAO.SearchProduct(Integer.parseInt(vista.txtIdProducto.getText()));
            vista.txtCodigoProducto_Producto.setText(prod.getCode_product());
            vista.txtDescripcionProducto_Producto.setText(prod.getDescription_product());
            vista.txtPrecioCompra_Producto.setText("" + prod.getPurchase_price());
            vista.txtPrecioVenta_Producto.setText("" + prod.getSale_price());
            vista.cboProveedor_Producto.setSelectedItem(new ComboBox(prod.getId_provider(), prod.getName_provider()));
            vista.cboCategoria_Producto.setSelectedItem(new ComboBox(prod.getId_category(), prod.getName_category()));
        } else if (e.getSource() == vista.btnProductos) {
            vista.jtabVENTAS.setSelectedIndex(7);
            limpiarTable();
            listarProductos();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == vista.txtCantidad_Compra) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                double subtotal = 0.0;
                double igv = 0.0;
                double total = 0.0;

                int cantidad = Integer.parseInt(vista.txtCantidad_Compra.getText());
                String descripcion = vista.txtDescripcionProducto_Compra.getText();
                double precio = Integer.parseInt(vista.txtIdProducto_Compra.getText());
                int codigo = Integer.parseInt(vista.txtIdProducto_Compra.getText());

                subtotal = cantidad * precio;
                igv = Double.parseDouble(String.format("%2f", subtotal * 0.18));
                
                total = subtotal + igv;

                if (cantidad > 0) {
                    temp = (DefaultTableModel) vista.tblCompras.getModel();
                    ArrayList lista = new ArrayList();
                    int elemento = 1;
                    lista.add(elemento);
                    lista.add(codigo);
                    lista.add(descripcion);
                    lista.add(cantidad);
                    lista.add(precio);
                    lista.add(subtotal);
                    lista.add(igv);
                    lista.add(total);

                    Object[] obj = new Object[7];
                    obj[0] = lista.get(1);
                    obj[1] = lista.get(2);
                    obj[2] = lista.get(3);
                    obj[3] = lista.get(4);
                    obj[4] = lista.get(5);
                    obj[5] = lista.get(6);
                    obj[6] = lista.get(7);

                    temp.addRow(obj);

                    vista.tblCompras.setModel(temp);
                    limpiarCampos();
                    CalcularSubtotal();
                    CalcularIGV();
                    CalcularTotal();
                    vista.txtCodigoProducto_Compra.requestFocus();

                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txtCantidad_Compra) {
            int cantidad;
            double precio;
            if (vista.txtCantidad_Compra.getText().equals("")) {
                cantidad = 1;
                precio = Double.parseDouble(vista.txtPrecio_Compra.getText());
                vista.txtPagar_Compra.setText("" + precio);
            } else {
                cantidad = Integer.parseInt(vista.txtCantidad_Compra.getText());
                precio = Double.parseDouble(vista.txtPrecio_Compra.getText());
                vista.txtPagar_Compra.setText("" + cantidad * precio);
            }
        } else if (e.getSource() == vista.txtPagar_Compra) {
            int pagar;
            if (vista.txtPagar_Compra.getText().equals("")) {
                vista.txtVueltoCompra.setText("");
            } else {
                pagar = Integer.parseInt(vista.txtPagar_Compra.getText());
                double total = Double.parseDouble(vista.txtTotalPago_Compra.getText());
                vista.txtVueltoCompra.setText("" + Double.parseDouble(String.format("%2f", (pagar - total))));
                
            }
        }
    }

    public void insertarCompra() {
        ComboBox id_prov = (ComboBox) vista.cboProveedor_Compra.getSelectedItem();
        int id_provider = id_prov.getId();
        String total = vista.txtTotalPago_Compra.getText();

        if (prodDAO.RegisterPurchase(id_provider, total)) {
            int code_purchase = prodDAO.CodePurchase();
            for (int i = 0; i < vista.tblCompras.getRowCount(); i++) {
                double precio = Double.parseDouble(vista.tblCompras.getValueAt(i, 3).toString());
                int cantidad = Integer.parseInt(vista.tblCompras.getValueAt(i, 2).toString());
                int code = Integer.parseInt(vista.tblCompras.getValueAt(i, 0).toString());
                double subtotal = precio * cantidad;
                prodDAO.RegisterPurchaseDetail(code_purchase, code, precio, cantidad, precio, subtotal);
                prod = prodDAO.SearchIdProduct(code);
                int StockActual = prod.getQuantity() + cantidad;
                prodDAO.UpdateStock(StockActual, code);
            }

            limpiarTableDetalle();
            VistaSuccess success = new VistaSuccess();
            success.titulo.setText("¡Compra generada con éxito!");
            success.setVisible(true);

        }

    }

}
