
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmLogin;
import vista.FrmPanelPrincipal;



public class LoginController implements ActionListener{  
    public Usuario us;
    public UsuarioDAO usDAO;
    public FrmLogin loginV;

    public LoginController(Usuario us, UsuarioDAO usDAO, FrmLogin loginV) {
        this.us = us;
        this.usDAO = usDAO;
        this.loginV = loginV;
        this.loginV.btnLogin.addActionListener(this);
        this.loginV.btnCancelar.addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == loginV.btnLogin){
           
           if(loginV.txtUsuario.getText().equals("")
               || String.valueOf(loginV.txtPassword.getPassword()).equals("")){
               JOptionPane.showMessageDialog(null, "Los campos están vacíos");
           }else{
               String usuario = loginV.txtUsuario.getText();
               String clave = String.valueOf(loginV.txtPassword.getPassword());
               us = usDAO.login(usuario, clave);
               if(us.getNick_usuario() != null){
                   FrmPanelPrincipal admin = new FrmPanelPrincipal();
                   admin.setVisible(true);
                   this.loginV.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "¡Usuario y/o contraseña no válidas!");
               }
           }
           
       }else{
       
           int  respuesta = JOptionPane.showConfirmDialog(null, "Estás seguro que deseas salir", "Pregunta",
                   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           
           if(respuesta == 0){
           
            System.exit(0);
           }
       }
    }
    
}
