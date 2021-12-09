package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;


    public boolean register(Cliente cli) {

        String sql = "INSERT INTO cliente(name_cliente,lastname_cliente,dni_cliente,phone_cliente,address_cliente) values (?,?,?,?,?)";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getName_cliente());
            ps.setString(2, cli.getLastname_cliente());
            ps.setString(3, cli.getDni_cliente());
            ps.setString(4, cli.getPhone_cliente());
            ps.setString(5, cli.getAddress_cliente());
            ps.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }

    }
    
    public List ListaClientes(String valor) {

        List<Cliente> ListaClientes = new ArrayList();
        String sql = "SELECT * FROM cliente ORDER BY status_cliente ASC";
        String search = "SELECT *FROM cliente where name_cliente LIKE '%"
                + valor + "%' OR dni_cliente LIKE'%" + valor + "%'";

        try {
            con = cn.getConexion();
            if (valor.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

            } else {
                ps = con.prepareStatement(search);
                rs = ps.executeQuery();
            }

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId_cliente(rs.getInt("id_cliente"));
                cli.setName_cliente(rs.getString("name_cliente"));
                cli.setLastname_cliente(rs.getString("lastname_cliente"));
                cli.setDni_cliente(rs.getString("dni_cliente"));
                cli.setPhone_cliente(rs.getString("phone_cliente"));
                cli.setAddress_cliente(rs.getString("address_cliente"));
                cli.setStatus_cliente(rs.getString("status_cliente"));
              
                ListaClientes.add(cli);
            }

        } catch (Exception e) {
        }

        return ListaClientes;

    }
     
    public boolean modify(Cliente cli) {
        String sql = "UPDATE cliente SET name_cliente=?, lastname_cliente=?, dni_cliente=?, phone_cliente=?, address_cliente=? where id_cliente=?";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getName_cliente());
            ps.setString(2, cli.getLastname_cliente());
            ps.setString(3, cli.getDni_cliente());
            ps.setString(4, cli.getPhone_cliente());
            ps.setString(5, cli.getAddress_cliente());
            ps.setInt(6, cli.getId_cliente());
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
        
        
    }
    
    public boolean accion(String status_cliente, int id_cliente) {
        String sql = "UPDATE cliente SET status_cliente=? where id_cliente=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, status_cliente);
            ps.setInt(2, id_cliente);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
   
  
}
