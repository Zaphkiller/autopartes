
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.ComboBox;
import modelo.Provider;
import modelo.ProviderDAO;
import modelo.Tables;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import vista.FrmPrincipal;
import vista.VistaError;
import vista.VistaInfo;
import vista.VistaSuccess;


public class ProviderController implements ActionListener, MouseListener, KeyListener{
    
    private Provider pro;
    private ProviderDAO proDAO;
    private FrmPrincipal vista;
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ProviderController(Provider pro, ProviderDAO proDAO, FrmPrincipal vista) {
        this.pro = pro;
        this.proDAO = proDAO;
        this.vista = vista;
        
        this.vista.btnRegisterProvider.addActionListener(this);
        this.vista.btnModifyProvider.addActionListener(this);
        this.vista.btnNewProvider.addActionListener(this);
        
        this.vista.MenuItemEliminarProveedor.addActionListener(this);
        this.vista.MenuItemReingresarProveedor.addActionListener(this);
        this.vista.tblProviders.addMouseListener(this);
        this.vista.txtSearchProvider.addKeyListener(this);
        
        listarProveedores();
        llenarProveedor();
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.btnRegisterProvider){
            if(vista.txtRucProvider.getText().equals("")
               || vista.txtNameProvider.getText().equals("")){
                
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);
            } else{
                pro.setRuc_provider(vista.txtRucProvider.getText());
                pro.setName_provider(vista.txtNameProvider.getText());
                pro.setPhone_provider(vista.txtPhoneProvider.getText());
                pro.setEmail_provider(vista.txtEmailProvider.getText());
                pro.setAddress_provider(vista.txtAddressProvider.getText());
                
                if(proDAO.register(pro)){
                    limpiarTable();
                    listarProveedores();
                    limpiar();
                    
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Proveedor registrado!");
                    success.setVisible(true);
                }else{
                    
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al registrar proveedor!");
                    error.setVisible(true);
                }
            }
        }else if(e.getSource() == vista.btnModifyProvider){
            if(vista.txtRucProvider.getText().equals("")
               || vista.txtNameProvider.getText().equals("")){
                
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);
            }else{
                
                pro.setRuc_provider(vista.txtRucProvider.getText());
                pro.setName_provider(vista.txtNameProvider.getText());
                pro.setPhone_provider(vista.txtPhoneProvider.getText());
                pro.setEmail_provider(vista.txtEmailProvider.getText());
                pro.setAddress_provider(vista.txtAddressProvider.getText());
                pro.setId_provider(Integer.parseInt(vista.txtIdProvider.getText()));
                
                if(proDAO.modify(pro)){
                    
                    limpiarTable();
                    listarProveedores();
                    limpiar();
                    
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Proveedor modifiado!");
                    success.setVisible(true);
                    
                }else{
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al modificar proveedor!");
                    error.setVisible(true);
                }
            
            }
        }else if(e.getSource() == vista.MenuItemEliminarProveedor){
            if(vista.txtIdProvider.getText().equals("")){
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para eliminar");
                info.setVisible(true);
                
            }else{
                int id = Integer.parseInt(vista.txtIdProvider.getText());
                
                if(proDAO.accion("Inactivo", id)){
                    limpiarTable();
                    listarProveedores();
                    limpiar();
                    
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Proveedor eliminado!");
                    success.setVisible(true);
                }else{
                    
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al eliminar uproveedor!");
                    error.setVisible(true);
                
                }
            }
        }else if(e.getSource() == vista.MenuItemReingresarProveedor){
        
            if(vista.txtIdProvider.getText().equals("")){
                
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para reingresar");
                info.setVisible(true);
                
            }else{
                int id = Integer.parseInt(vista.txtIdProvider.getText());
                if(proDAO.accion("Activo", id)){
                    
                   limpiarTable();
                   listarProveedores();
                   limpiar();
                   
                   VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Proveedor reingresado!");
                    success.setVisible(true);
                
                }else{
                    
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al reingresar proveedor!");
                    error.setVisible(true);
                
                }
            }
        }else{
            limpiar();
        }
        
        
    }
    
    public void listarProveedores(){
        Tables color = new Tables();
        vista.tblProviders.setDefaultRenderer(vista.tblProviders.getColumnClass(0) ,color);
        List<Provider> lista = proDAO.ListaProviders(vista.txtSearchProvider.getText());
        modelo = (DefaultTableModel) vista.tblProviders.getModel();
        
        Object[] ob = new Object[7];
        
        for (int i = 0; i < lista.size(); i++) {
            
            ob[0] = lista.get(i).getId_provider();
            ob[1] = lista.get(i).getRuc_provider();
            ob[2] = lista.get(i).getName_provider();
            ob[3] = lista.get(i).getPhone_provider();
            ob[4] = lista.get(i).getEmail_provider();
            ob[5] = lista.get(i).getAddress_provider();
            ob[6] = lista.get(i).getStatus_provider();
            
            modelo.addRow(ob);
            
        }
        
        vista.tblProviders.setModel(modelo);
        
    }

    public void limpiarTable(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            
            modelo.removeRow(i);
            i= i-1;
            
        }
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.tblProviders){
            int fila = vista.tblProviders.rowAtPoint(e.getPoint());
            vista.txtIdProvider.setText(vista.tblProviders.getValueAt(fila, 0).toString());
            vista.txtRucProvider.setText(vista.tblProviders.getValueAt(fila, 1).toString());
            vista.txtNameProvider.setText(vista.tblProviders.getValueAt(fila, 2).toString());
            vista.txtPhoneProvider.setText(vista.tblProviders.getValueAt(fila, 3).toString());
            vista.txtEmailProvider.setText(vista.tblProviders.getValueAt(fila, 4).toString());
            vista.txtAddressProvider.setText(vista.tblProviders.getValueAt(fila, 5).toString());
            
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
        if(e.getSource() == vista.txtSearchProvider){
            limpiarTable();
            listarProveedores();
            
        }
    }
    
    private void llenarProveedor(){
        List<Provider> lista = proDAO.ListaProviders(vista.txtSearchProvider.getText());     
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId_provider();
            String name = lista.get(i).getName_provider();
            vista.cboProveedor_Producto.addItem(new ComboBox(id, name));
            vista.cboProveedor_Compra.addItem(new ComboBox(id, name));
                   
        }
    }
    
    
    public void limpiar(){
        vista.txtRucProvider.setText("");
        vista.txtNameProvider.setText("");
        vista.txtPhoneProvider.setText("");
        vista.txtEmailProvider.setText("");
        vista.txtAddressProvider.setText("");
    } 
    
}
