package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        } else if (e.getSource() == vista.btnBuscarProducto_Compras) {
             
                    JOptionPane.showMessageDialog(null, "corregido");
  

        } else {
            limpiar();
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

    private void limpiar() {
        vista.txtCodigoProducto_Producto.setText("");
        vista.txtDescripcionProducto_Producto.setText("");
        vista.txtPrecioVenta_Producto.setText("");
        vista.txtPrecioCompra_Producto.setText("");
        vista.txtDescripcionProducto_Producto.grabFocus();

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
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txtSearchProductos) {
            limpiarTable();
            listarProductos();
        }
    }

}
