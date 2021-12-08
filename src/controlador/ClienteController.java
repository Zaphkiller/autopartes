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
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Tables;
import modelo.Usuario;
import vista.FrmPrincipal;
import vista.VistaError;
import vista.VistaInfo;
import vista.VistaSuccess;

public class ClienteController implements ActionListener, MouseListener, KeyListener {

    private Cliente cli;
    private ClienteDAO cliDAO;
    private FrmPrincipal vista;

    DefaultTableModel modelo = new DefaultTableModel();

    public ClienteController(Cliente cli, ClienteDAO cliDAO, FrmPrincipal vista) {
        this.cli = cli;
        this.cliDAO = cliDAO;
        this.vista = vista;

        this.vista.btnRegisterCliente.addActionListener(this);
        this.vista.btnModifyCliente.addActionListener(this);
        this.vista.btnNewCliente.addActionListener(this);

        this.vista.MenuItem_EliminarCliente.addActionListener(this);
        this.vista.MenuItem_ReingresarCliente.addActionListener(this);
        this.vista.tblClientes.addMouseListener(this);
        this.vista.txtSearchCliente.addKeyListener(this);
        listarClientes();
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegisterCliente) {

            if ( vista.txtNameCliente.getText().equals("")
                    || vista.txtLastnameCliente.getText().equals("")
                    || vista.txtDniCliente.getText().equals("")) {

                /*JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");*/
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);

            } else {

                cli.setName_cliente(vista.txtNameCliente.getText());
                cli.setLastname_cliente(vista.txtLastnameCliente.getText());
                cli.setDni_cliente(vista.txtDniCliente.getText());
                cli.setPhone_cliente(vista.txtPhoneCliente.getText());
                cli.setAddress_cliente(vista.txtAddressCliente.getText());

                if (cliDAO.register(cli)) {

                    limpiarTable();
                    listarClientes();
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

        } else if (e.getSource() == vista.btnModifyCliente) {

            if (vista.txtNameCliente.getText().equals("")
                    || vista.txtLastnameCliente.getText().equals("")) {

                /*JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");*/
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);

            } else {
                cli.setName_cliente(vista.txtNameCliente.getText());
                cli.setLastname_cliente(vista.txtLastnameCliente.getText());
                cli.setDni_cliente(vista.txtDniCliente.getText());
                cli.setAddress_cliente(vista.txtAddressCliente.getText());
                cli.setPhone_cliente(vista.txtPhoneCliente.getText());
                cli.setId_cliente(Integer.parseInt(vista.txtIdCliente.getText()));

                if (cliDAO.modify(cli)) {
                    limpiarTable();
                    listarClientes();
                    limpiar();

                    /*JOptionPane.showMessageDialog(null, "Usuario modificado con éxito...");*/
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Usuario modiciado!");
                    success.setVisible(true);

                } else {
                    /*JOptionPane.showMessageDialog(null, "Error al modificar usuario...");*/
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al modificar usuario!");
                    error.setVisible(true);
                }
            }

        } else if (e.getSource() == vista.MenuItem_EliminarCliente) {
            if (vista.txtIdCliente.getText().equals("")) {
                /*JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");*/
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para eliminar");
                info.setVisible(true);
            } else {
                int id = Integer.parseInt(vista.txtIdCliente.getText());
                if (cliDAO.accion("Inactivo", id)) {
                    limpiarTable();
                    listarClientes();
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
        } else if (e.getSource() == vista.MenuItem_ReingresarCliente) {
            if (vista.txtIdCliente.getText().equals("")) {
                /*JOptionPane.showMessageDialog(null, "Seleccione una fila para reingresar");*/
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para reingresar");
                info.setVisible(true);
            } else {
                int id = Integer.parseInt(vista.txtIdCliente.getText());
                if (cliDAO.accion("Activo", id)) {
                    limpiarTable();
                    listarClientes();
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
        } else {
            limpiar();
        }
    }

    public void listarClientes() {
        Tables color = new Tables();
        vista.tblClientes.setDefaultRenderer(vista.tblClientes.getColumnClass(0), color);
        List<Cliente> lista = cliDAO.ListaClientes(vista.txtSearchCliente.getText());
        modelo = (DefaultTableModel) vista.tblClientes.getModel();
        
        Object[] ob = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_cliente();
            ob[1] = lista.get(i).getName_cliente();
            ob[2] = lista.get(i).getLastname_cliente();
            ob[3] = lista.get(i).getDni_cliente();
            ob[4] = lista.get(i).getPhone_cliente();
            ob[5] = lista.get(i).getAddress_cliente();
            ob[6] = lista.get(i).getStatus_cliente();
            
            modelo.addRow(ob);
        }
        
        vista.tblClientes.setModel(modelo);
    }

    public void limpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.tblClientes){
           
            int fila = vista.tblClientes.rowAtPoint(e.getPoint());
            vista.txtIdCliente.setText(vista.tblClientes.getValueAt(fila, 0).toString());
            vista.txtNameCliente.setText(vista.tblClientes.getValueAt(fila, 1).toString());
            vista.txtLastnameCliente.setText(vista.tblClientes.getValueAt(fila, 2).toString());
            vista.txtDniCliente.setText(vista.tblClientes.getValueAt(fila, 3).toString());
            vista.txtAddressCliente.setText(vista.tblClientes.getValueAt(fila, 4).toString());
            vista.txtPhoneCliente.setText(vista.tblClientes.getValueAt(fila, 5).toString());

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
        if (e.getSource() == vista.txtSearchCliente) {
            limpiarTable();
            listarClientes();
        }

    }

    private void limpiar() {
        vista.txtNameCliente.setText("");
        vista.txtLastnameCliente.setText("");
        vista.txtDniCliente.setText("");
        vista.txtPhoneCliente.setText("");
        vista.txtAddressCliente.setText("");
        vista.txtNameCliente.grabFocus();

    }

}
