
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
import modelo.Tables;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmPanelPrincipal;
import vista.VistaUsuarios;

public class UserController implements ActionListener, MouseListener, KeyListener{
    
    private Usuario us;
    private UsuarioDAO usDAO;
    private VistaUsuarios vista;
    
    DefaultTableModel modelo = new DefaultTableModel();

    public UserController(Usuario us, UsuarioDAO usDAO, VistaUsuarios vista) {
        this.us = us;
        this.usDAO = usDAO;
        this.vista = vista;
        
       this.vista.btnRegisterUser.addActionListener(this);
       this.vista.btnModifyUser.addActionListener(this);
       this.vista.btnNewUser.addActionListener(this);
       
       this.vista.MenuItem_EliminarUser.addActionListener(this);
       this.vista.MenuItem_ReingresarUser.addActionListener(this);
       this.vista.tblUsers.addMouseListener(this);
       this.vista.txtSearchUser.addKeyListener(this);
       listarUsuarios();
           
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnRegisterUser){
            
            if(vista.txtNickname.getText().equals("")
               || vista.txtName.getText().equals("")
               || vista.txtLastname.getText().equals("")
               || vista.txtDni.getText().equals("")
               || String.valueOf(vista.txtPassword.getPassword()).equals("")){
                
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            
            }else{
                
                us.setNick_user(vista.txtNickname.getText());
                us.setName(vista.txtName.getText());
                us.setLast_name(vista.txtLastname.getText());
                us.setDni(vista.txtDni.getText());
                us.setPassword(String.valueOf(vista.txtPassword.getPassword()));
                us.setEmail(vista.txtEmail.getText());
                us.setPhone(vista.txtPhone.getText());
                us.setRole(vista.cboRole.getSelectedItem().toString());
                
                if(usDAO.register(us)){
                    
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Usuario registrado con éxito...");
                
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Error al registar el usuario...");
                
                }
            
            
            }
        
        }else if(e.getSource() == vista.btnModifyUser){
            
            if(vista.txtNickname.getText().equals("")
                || vista.txtName.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                
            }else{
                us.setNick_user(vista.txtNickname.getText());
                us.setName(vista.txtName.getText());
                us.setLast_name(vista.txtLastname.getText());
                us.setDni(vista.txtDni.getText());
                us.setPassword(String.valueOf(vista.txtPassword.getPassword()));
                us.setEmail(vista.txtEmail.getText());
                us.setPhone(vista.txtPhone.getText());
                us.setRole(vista.cboRole.getSelectedItem().toString());
                us.setId_user(Integer.parseInt(vista.txtIduser.getText()));
                
                if(usDAO.modify(us)){
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    
                    JOptionPane.showMessageDialog(null, "Usuario modificado con éxito...");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al modificar usuario...");
                }
            }
        
        }else if(e.getSource() == vista.MenuItem_EliminarUser){
            
            if(vista.txtIduser.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar");
            
            }else{
            
                int id = Integer.parseInt(vista.txtIduser.getText());
                if(usDAO.accion("Activo", id)){
                    
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    
                    JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar usuario");
                }
            }
        
        }else if(e.getSource() == vista.MenuItem_ReingresarUser){
            if(vista.txtIduser.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "Seleccione una fila para reingresar");
            } else{
            
                int id = Integer.parseInt(vista.txtIduser.getText());
                if(usDAO.accion("Activo", id)){
                    
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    
                    JOptionPane.showMessageDialog(null, "Usuario reingresado");
                    
                }else{
                     JOptionPane.showMessageDialog(null, "Error al reingresar usuario");
                }
            }
        
        }else{
            limpiar();
        }
    }
    
    public void listarUsuarios() {
        Tables color = new Tables();
        vista.tblUsers.setDefaultRenderer(vista.tblUsers.getColumnClass(0), color);
        List<Usuario> lista = usDAO.ListaUsers(vista.txtSearchUser.getText());
        modelo = (DefaultTableModel) vista.tblUsers.getModel();
        Object[] ob = new Object[10];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_user();
            ob[1] = lista.get(i).getNick_user();
            ob[2] = lista.get(i).getName();
            ob[3] = lista.get(i).getLast_name();
            ob[4] = lista.get(i).getDni();
            ob[5] = lista.get(i).getPassword();
            ob[6] = lista.get(i).getEmail();
            ob[7] = lista.get(i).getPhone();
            ob[8] = lista.get(i).getRole();
            ob[9] = lista.get(i).getStatus();
            modelo.addRow(ob);
        }
        vista.tblUsers.setModel(modelo);
    }

    public void limpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
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
        if (e.getSource() == vista.txtSearchUser) {
            limpiarTable();
            listarUsuarios();
            
        }
    }
    
    private void limpiar() {
        vista.txtNickname.setText("");
        vista.txtName.setText("");
        vista.txtLastname.setText("");
        vista.txtDni.setText("");
        vista.txtPassword.setText("");
        vista.txtEmail.setText("");
        vista.txtEmail.setText("");
        
    }

   
    
}
