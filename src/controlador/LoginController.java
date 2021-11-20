package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmLogin;
import vista.FrmPrincipal;
import vista.VistaError;
import vista.VistaErrorLogin;
import vista.VistaInfo;
import vista.VistaInfoLogin;
import vista.VistaWarningSalir;
import vista.VistaWarningSalirLogin;

public class LoginController implements ActionListener {

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
        if (e.getSource() == loginV.btnLogin) {

            if (loginV.txtUsuario.getText().equals("")
                    || String.valueOf(loginV.txtPassword.getPassword()).equals("")) {
                VistaInfoLogin infologin = new VistaInfoLogin();
                infologin.titulo.setText("Los campos están vacíos");
                infologin.setVisible(true);
            } else {
                String usuario = loginV.txtUsuario.getText();
                String clave = String.valueOf(loginV.txtPassword.getPassword());
                us = usDAO.login(usuario, clave);
                if (us.getNick_user() != null) {
                    FrmPrincipal admin = new FrmPrincipal();
                    admin.setVisible(true);
                    this.loginV.dispose();
                } else {
                    VistaErrorLogin error = new VistaErrorLogin();
                    error.titulo.setText("¡Usuario y/o contraseña incorrectas!");
                    error.setVisible(true);
                }
            }

        } else {

            VistaWarningSalirLogin warningsalir = new VistaWarningSalirLogin();
            warningsalir.titulo.setText("¿Estás seguro que quieres salir?");
            warningsalir.setVisible(true);
        }
    }

}
