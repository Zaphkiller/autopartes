/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ProductDAO;
import modelo.Products;
import vista.FrmPrincipal;


public class ModalProductController implements ActionListener, MouseListener, KeyListener{
    
    private Products prod;
    private ProductDAO prodDAO;
    private FrmPrincipal vista;

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel m;

    public ModalProductController(Products prod, ProductDAO prodDAO, FrmPrincipal vista) {
        this.prod = prod;
        this.prodDAO = prodDAO;
        this.vista = vista;
        
        this.vista.btnAgregarProductoModal.addActionListener(this);
        this.vista.btnCancelarProveedorModal.addActionListener(this);
        this.vista.tblModalProductos.addMouseListener(this);
        this.vista.txtSearchProductModal.addKeyListener(this);
        listarProductos();
        
    }

    
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnAgregarProductoModal) {
            int fselec = vista.tblModalProductos.getSelectedRow();

            try {
                String codigo, descripcion;
                if (fselec == -1) {

                    JOptionPane.showMessageDialog(null, "corregido");

                } else {
                    m = (DefaultTableModel) vista.tblModalProductos.getModel();

                    codigo = vista.tblModalProductos.getValueAt(fselec, 0).toString();
                    descripcion = vista.tblModalProductos.getValueAt(fselec, 1).toString();
                    
                    vista.txtCodigoProducto_Compra.setText(codigo);
                    vista.txtDescripcionProducto_Compra.setText(descripcion);
                }

            } catch (Exception ex) {
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
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
    
    public void listarProductos() {
        
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
