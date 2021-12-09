/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ProductDAO;
import modelo.Products;
import vista.FrmPrincipal;

/**
 *
 * @author Natsu98fx
 */
public class ModalProductVentaController implements ActionListener {

    private Products prod;
    private ProductDAO prodDAO;
    private FrmPrincipal vista;

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel m;
    

    public ModalProductVentaController(Products prod, ProductDAO prodDAO, FrmPrincipal vista) {
        this.prod = prod;
        this.prodDAO = prodDAO;
        this.vista = vista;
        listarProductosVenta();
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnAgregarProductoModalVentas) {
            int fselec = vista.tblModalProductosVentas.getSelectedRow();

            try {
                String id,codigo,descripcion,precio;
                if (fselec == -1) {
                    JOptionPane.showMessageDialog(null, "corregido");
                } else {
                    m = (DefaultTableModel) vista.tblModalProductos.getModel();
                    
                    id= vista.tblModalProductosVentas.getValueAt(fselec, 0).toString();
                    codigo = vista.tblModalProductosVentas.getValueAt(fselec, 1).toString();
                    descripcion = vista.tblModalProductosVentas.getValueAt(fselec, 2).toString();
                    precio = vista.tblModalProductosVentas.getValueAt(fselec, 4).toString();
                    vista.txtIdProducto_Compra.setText(id);
                    vista.txtCodigoProducto_Compra.setText(codigo);
                    vista.txtDescripcionProducto_Compra.setText(descripcion);
                    vista.txtPrecio_Compra.setText(""+precio);
                    
               }

            } catch (Exception ex) {
            }
        }
    }
    
    public void listarProductosVenta() {
        
        List<Products> lista = prodDAO.ListaProductos(vista.txtSearchProductModal.getText());
        modelo = (DefaultTableModel) vista.tblModalProductos.getModel();
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
        vista.tblModalProductos.setModel(modelo);
    }
    

}
