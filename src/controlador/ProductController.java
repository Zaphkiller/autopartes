 
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ComboProveedor;
import modelo.Product;
import modelo.ProductDAO;
import vista.VistaProductos;

public class ProductController implements ActionListener, MouseListener,KeyListener{
    
    private Product prod;
    private ProductDAO prodDAO;
    
    private vista.VistaProductos vista;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel temp;

    public ProductController(Product prod, ProductDAO prodDAO, VistaProductos vista) {
        this.prod = prod;
        this.prodDAO = prodDAO;
        this.vista = vista;
        
        this.vista.btnRegisterProduct.addActionListener(this);
        this.vista.btnModifyProduct.addActionListener(this);
        this.vista.btnNewProduct.addActionListener(this);
        this.vista.tblProductos.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnRegisterProduct){
            if(vista.txtCodigoProducto.getText().equals("")
               || vista.txtDescripcionProducto.getText().equals("")
               || vista.txtPrecioCompra.getText().equals("")
               || vista.txtPrecioVenta.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }else{
              
             
             
            }
        }
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
