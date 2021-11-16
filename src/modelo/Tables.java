package modelo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Tables extends DefaultTableCellRenderer {

//super. para generar getTableCellRendererComponent
    @Override
    public Component getTableCellRendererComponent(
            JTable jtable, Object o, boolean bln, boolean bln1, int row, int col) {
        super.getTableCellRendererComponent(jtable, o, bln, bln1, row, col);
        if (jtable.getValueAt(row, col).toString().equals("Inactivo")) {
            setBackground(Color.cyan);
            setForeground(Color.black);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
}
