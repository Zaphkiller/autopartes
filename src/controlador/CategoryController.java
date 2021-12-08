package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Category;
import modelo.CategoryDAO;
import modelo.ComboBox;
import modelo.Provider;
import modelo.Tables;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import vista.FrmPrincipal;
import vista.VistaError;
import vista.VistaInfo;
import vista.VistaSuccess;

public class CategoryController implements ActionListener, MouseListener, KeyListener {

    private Category cat;
    private CategoryDAO catDAO;
    private FrmPrincipal vista;

    DefaultTableModel modelo = new DefaultTableModel();

    public CategoryController(Category cat, CategoryDAO catDAO, FrmPrincipal vista) {
        this.cat = cat;
        this.catDAO = catDAO;
        this.vista = vista;

        this.vista.btnRegisterCategory.addActionListener(this);
        this.vista.btnModifyCategory.addActionListener(this);
        this.vista.btnNewCategory.addActionListener(this);

        this.vista.MenuItem_EliminarCategory.addActionListener(this);
        this.vista.MenuItem_ReingresarCategory.addActionListener(this);
        this.vista.tblCategory.addMouseListener(this);
        this.vista.txtSearchCategory.addKeyListener(this);

        listarCategorias();
        llenarCategoria();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegisterCategory) {

            if (vista.txtCodeCategory.getText().equals("")
                    || vista.txtNameCategory.getText().equals("")) {

                /*JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");*/
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);

            } else {

                cat.setCode_category(vista.txtCodeCategory.getText());
                cat.setName_category(vista.txtNameCategory.getText());

                if (catDAO.register(cat)) {

                    limpiarTable();
                    listarCategorias();
                    limpiar();

                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Categoría registrada!");
                    success.setVisible(true);

                } else {

                    /*JOptionPane.showMessageDialog(null, "Error al registar el usuario...");*/
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al registrar categoría!");
                    error.setVisible(true);

                }

            }

        } else if (e.getSource() == vista.btnModifyCategory) {

            if (vista.txtCodeCategory.getText().equals("")
                    || vista.txtNameCategory.getText().equals("")) {

                VistaInfo info = new VistaInfo();
                info.titulo.setText("Todos los campos son obligatorios");
                info.setVisible(true);

            } else {
                cat.setCode_category(vista.txtCodeCategory.getText());
                cat.setName_category(vista.txtNameCategory.getText());
                cat.setId_category(Integer.parseInt(vista.txtIdCategory.getText()));

                if (catDAO.modify(cat)) {
                    limpiarTable();
                    listarCategorias();
                    limpiar();

                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Categoría modificada!");
                    success.setVisible(true);

                } else {
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al modificar categoría!");
                    error.setVisible(true);
                }
            }

        } else if (e.getSource() == vista.MenuItem_EliminarCategory) {
            if (vista.txtIdCategory.getText().equals("")) {
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para eliminar");
                info.setVisible(true);
            } else {
                int id = Integer.parseInt(vista.txtIdCategory.getText());
                if (catDAO.accion("Inactivo", id)) {
                    limpiarTable();
                    listarCategorias();
                    limpiar();
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Categoría eliminada!");
                    success.setVisible(true);
                } else {
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al eliminar categoría!");
                    error.setVisible(true);
                }
            }
        } else if (e.getSource() == vista.MenuItem_ReingresarCategory) {
            if (vista.txtIdCategory.getText().equals("")) {
                VistaInfo info = new VistaInfo();
                info.titulo.setText("Seleccione una fila para reingresar");
                info.setVisible(true);
            } else {
                int id = Integer.parseInt(vista.txtIdCategory.getText());
                if (catDAO.accion("Activo", id)) {
                    limpiarTable();
                    listarCategorias();
                    limpiar();
                    VistaSuccess success = new VistaSuccess();
                    success.titulo.setText("¡Categoría reingresado!");
                    success.setVisible(true);
                } else {
                    VistaError error = new VistaError();
                    error.titulo.setText("¡Error al reingresar usuario!");
                    error.setVisible(true);
                }
            }
        } else {
            limpiar();
        }
    }

    public void listarCategorias() {
        Tables color = new Tables();
        vista.tblCategory.setDefaultRenderer(vista.tblCategory.getColumnClass(0), color);
        List<Category> lista = catDAO.ListaCategories(vista.txtSearchCategory.getText());
        modelo = (DefaultTableModel) vista.tblCategory.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {

            ob[0] = lista.get(i).getId_category();
            ob[1] = lista.get(i).getCode_category();
            ob[2] = lista.get(i).getName_category();
            ob[3] = lista.get(i).getStatus_category();
            modelo.addRow(ob);
        }
        vista.tblCategory.setModel(modelo);
    }

    public void limpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {

            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.tblCategory) {
            int fila = vista.tblCategory.rowAtPoint(e.getPoint());
            vista.txtIdCategory.setText(vista.tblCategory.getValueAt(fila, 0).toString());
            vista.txtCodeCategory.setText(vista.tblCategory.getValueAt(fila, 1).toString());
            vista.txtNameCategory.setText(vista.tblCategory.getValueAt(fila, 2).toString());
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
        if (e.getSource() == vista.txtSearchCategory) {
            limpiarTable();
            listarCategorias();

        }

    }

    private void llenarCategoria() {
        List<Category> lista = catDAO.ListaCategories(vista.txtSearchCategory.getText());
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId_category();
            String name = lista.get(i).getName_category();
            vista.cboCategoria_Producto.addItem(new ComboBox(id, name));
        }
    }

    public void limpiar() {
        vista.txtCodeCategory.setText("");
        vista.txtNameCategory.setText("");
        vista.txtCodeCategory.grabFocus();

    }

}
