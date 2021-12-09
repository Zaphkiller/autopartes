/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import paneles.pnlHome;
import vista.FrmPrincipal;
import vista.VistaWarningSalir;

public class SlidingController implements ActionListener {

    private FrmPrincipal vista;

    public SlidingController(FrmPrincipal vista) {
        this.vista = vista;
        this.vista.btnCompras.addActionListener(this);
        this.vista.btnVentas.addActionListener(this);
        this.vista.btnProductos.addActionListener(this);
        this.vista.btnClientes.addActionListener(this);
        this.vista.btnProveedor.addActionListener(this);
        this.vista.btnUsuarios.addActionListener(this);
        this.vista.btnCategorias.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if (e.getSource() == vista.btnUsuarios) {

            if (!this.vista.btnUsuarios.isSelected()) {

                this.vista.btnCompras.setSelected(false);
                this.vista.btnVentas.setSelected(false);
                this.vista.btnProductos.setSelected(false);
                this.vista.btnClientes.setSelected(false);
                this.vista.btnProveedor.setSelected(false);
                this.vista.btnUsuarios.setSelected(true);
                this.vista.btnCategorias.setSelected(false);

                vista.jtabVENTAS.setSelectedIndex(0);
                
            }

        } else if (e.getSource() == vista.btnClientes) {

            if (!this.vista.btnClientes.isSelected()) {

                this.vista.btnCompras.setSelected(false);
                this.vista.btnVentas.setSelected(false);
                this.vista.btnProductos.setSelected(false);
                this.vista.btnClientes.setSelected(true);
                this.vista.btnProveedor.setSelected(false);
                this.vista.btnUsuarios.setSelected(false);
                this.vista.btnCategorias.setSelected(false);

                vista.jtabVENTAS.setSelectedIndex(1);
            }

        } else if (e.getSource() == vista.btnProveedor) {

            if (!this.vista.btnProveedor.isSelected()) {

                this.vista.btnCompras.setSelected(false);
                this.vista.btnVentas.setSelected(false);
                this.vista.btnProductos.setSelected(false);
                this.vista.btnClientes.setSelected(false);
                this.vista.btnProveedor.setSelected(true);
                this.vista.btnUsuarios.setSelected(false);
                this.vista.btnCategorias.setSelected(false);

                vista.jtabVENTAS.setSelectedIndex(2);
            }

        } else if (e.getSource() == vista.btnCategorias) {

            if (!this.vista.btnCategorias.isSelected()) {

                this.vista.btnCompras.setSelected(false);
                this.vista.btnVentas.setSelected(false);
                this.vista.btnProductos.setSelected(false);
                this.vista.btnClientes.setSelected(false);
                this.vista.btnProveedor.setSelected(false);
                this.vista.btnUsuarios.setSelected(false);
                this.vista.btnCategorias.setSelected(true);

                vista.jtabVENTAS.setSelectedIndex(3);
            }

        } else if (e.getSource() == vista.btnProductos) {

            if (!this.vista.btnProductos.isSelected()) {

                this.vista.btnCompras.setSelected(false);
                this.vista.btnVentas.setSelected(false);
                this.vista.btnProductos.setSelected(true);
                this.vista.btnClientes.setSelected(false);
                this.vista.btnProveedor.setSelected(false);
                this.vista.btnUsuarios.setSelected(false);
                this.vista.btnCategorias.setSelected(false);
                

                vista.jtabVENTAS.setSelectedIndex(4);
            }

        } else if (e.getSource() == vista.btnCompras) {

            if (!this.vista.btnCompras.isSelected()) {

                this.vista.btnCompras.setSelected(true);
                this.vista.btnVentas.setSelected(false);
                this.vista.btnProductos.setSelected(false);
                this.vista.btnClientes.setSelected(false);
                this.vista.btnProveedor.setSelected(false);
                this.vista.btnUsuarios.setSelected(false);
                this.vista.btnCategorias.setSelected(false);

               vista.jtabVENTAS.setSelectedIndex(5);
            }

        } else if (e.getSource() == vista.btnVentas) {

            if (!this.vista.btnVentas.isSelected()) {

                this.vista.btnCompras.setSelected(false);
                this.vista.btnVentas.setSelected(true);
                this.vista.btnProductos.setSelected(false);
                this.vista.btnClientes.setSelected(false);
                this.vista.btnProveedor.setSelected(false);
                this.vista.btnUsuarios.setSelected(false);
                this.vista.btnCategorias.setSelected(false);

                vista.jtabVENTAS.setSelectedIndex(6);
                
            }

        }
    }
    
    private void limpiar() {
        vista.txtCodigoProducto_Producto.setText("");
        vista.txtDescripcionProducto_Producto.setText("");
        vista.txtPrecioVenta_Producto.setText("");
        vista.txtPrecioCompra_Producto.setText("");
        vista.txtDescripcionProducto_Producto.setText("");
        vista.txtPrecioVenta_Producto.setText("");
        vista.txtCodigoProducto_Producto.grabFocus();

    }
}
