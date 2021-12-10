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
import vista.FrmPrincipal;
import vista.VistaInfo;
import vista.VistaSuccess;
import vista.VistaError;
import vista.VistaWarningSalir;

public class UserController implements ActionListener, MouseListener, KeyListener {

    private Usuario us;
    private UsuarioDAO usDAO;
    private FrmPrincipal vista;

    DefaultTableModel modelo = new DefaultTableModel();

    public UserController(Usuario us, UsuarioDAO usDAO, FrmPrincipal vista) {
        this.us = us;
        this.usDAO = usDAO;
        this.vista = vista;

        this.vista.btnRegisterUser.addActionListener(this);
        this.vista.btnModifyUser.addActionListener(this);
        this.vista.btnNewUser.addActionListener(this);
/*
        this.vista.MenuItem_EliminarUser.addActionListener(this);
        this.vista.MenuItem_ReingresarUser.addActionListener(this);*/
        this.vista.tblUsers.addMouseListener(this);
        this.vista.txtSearchUser.addKeyListener(this);
        listarUsuarios();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegisterUser) {

            if (vista.txtNickname.getText().equals("")
                    || vista.txtName.getText().equals("")
                    || vista.txtLastname.getText().equals("")
                    || vista.txtDni.getText().equals("")
                    || String.valueOf(vista.txtPassword.getPassword()).equals("")) {

                /*JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");*/
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);

            } else {

                us.setNick_user(vista.txtNickname.getText());
                us.setName(vista.txtName.getText());
                us.setLast_name(vista.txtLastname.getText());
                us.setDni(vista.txtDni.getText());
                us.setPassword(String.valueOf(vista.txtPassword.getPassword()));
                us.setEmail(vista.txtEmail.getText());
                us.setPhone(vista.txtPhone.getText());
                us.setRole(vista.cboRole.getSelectedItem().toString());

                if (usDAO.register(us)) {

                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    /*JOptionPane.showMessageDialog(null, "Usuario registrado con éxito...");*/
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Usuario registrado!");
                    success.setVisible(true);


                } else {

                    /*JOptionPane.showMessageDialog(null, "Error al registar el usuario...");*/
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al registrar usuario!");
                    error.setVisible(true);

                }

            }

        } else if (e.getSource() == vista.btnModifyUser) {

            if (vista.txtNickname.getText().equals("")
                    || vista.txtName.getText().equals("")) {

                /*JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");*/
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);

            } else {
                us.setNick_user(vista.txtNickname.getText());
                us.setName(vista.txtName.getText());
                us.setLast_name(vista.txtLastname.getText());
                us.setDni(vista.txtDni.getText());
                us.setPassword(String.valueOf(vista.txtPassword.getPassword()));
                us.setEmail(vista.txtEmail.getText());
                us.setPhone(vista.txtPhone.getText());
                us.setRole(vista.cboRole.getSelectedItem().toString());
                us.setId_user(Integer.parseInt(vista.txtIduser.getText()));

                if (usDAO.modify(us)) {
                    limpiarTable();
                    listarUsuarios();
                    limpiar();

                    /*JOptionPane.showMessageDialog(null, "Usuario modificado con éxito...");*/
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Usuario modificado!");
                    success.setVisible(true);

                } else {
                    /*JOptionPane.showMessageDialog(null, "Error al modificar usuario...");*/
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al modificar usuario!");
                    error.setVisible(true);
                }
            }

        }else if (e.getSource() == vista.MenuItem_EliminarUser) {
            if (vista.txtIduser.getText().equals("")) {
                /*JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");*/
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para eliminar");
                info.setVisible(true);
            } else {
                int id = Integer.parseInt(vista.txtIduser.getText());
                if (usDAO.accion("Inactivo", id)) {
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    /*JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito...");*/
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Usuario eliminado!");
                    success.setVisible(true);
                } else {
                    /*JOptionPane.showMessageDialog(null, "Error eliminado con éxito...");*/
                     VistaError error = new VistaError();
                    error.titulo.setText("¡Error al eliminar usuario!");
                    error.setVisible(true);
                }
            }
        } else if (e.getSource() == vista.MenuItem_ReingresarUser) {
            if (vista.txtIduser.getText().equals("")) {
                /*JOptionPane.showMessageDialog(null, "Seleccione una fila para reingresar");*/
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para reingresar");
                info.setVisible(true);
            } else {
                int id = Integer.parseInt(vista.txtIduser.getText());
                if (usDAO.accion("Activo", id)) {
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    /*JOptionPane.showMessageDialog(null, "Usuario reingresado");*/
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Usuario reingresado!");
                    success.setVisible(true);
                } else {
                    /*JOptionPane.showMessageDialog(null, "Error al reingresar");*/
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al reingresar usuario!");
                    error.setVisible(true);
                }
            }
        }  else {
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
        if (e.getSource() == vista.tblUsers) {
            int fila = vista.tblUsers.rowAtPoint(e.getPoint());
            vista.txtIduser.setText(vista.tblUsers.getValueAt(fila, 0).toString());
            vista.txtNickname.setText(vista.tblUsers.getValueAt(fila, 1).toString());
            vista.txtName.setText(vista.tblUsers.getValueAt(fila, 2).toString());
            vista.txtLastname.setText(vista.tblUsers.getValueAt(fila, 3).toString());
            vista.txtDni.setText(vista.tblUsers.getValueAt(fila, 4).toString());
            vista.txtPassword.setText(vista.tblUsers.getValueAt(fila, 5).toString());
            vista.txtEmail.setText(vista.tblUsers.getValueAt(fila, 6).toString());
            vista.txtPhone.setText(vista.tblUsers.getValueAt(fila, 7).toString());
            vista.cboRole.setSelectedItem(vista.tblUsers.getValueAt(fila, 8).toString());
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
        vista.txtPhone.setText("");
        vista.txtNickname.grabFocus();

    }

}
