package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Usuario login(String usuario, String password) {
        String sql = "Select * from users where nick_user=? and password=?";
        Usuario us = new Usuario();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setId_user(rs.getInt("id_user"));
                us.setNick_user(rs.getString("nick_user"));
                us.setName(rs.getString("name"));
                us.setLast_name(rs.getString("last_name"));
                us.setDni(rs.getString("dni"));
                us.setPassword(rs.getString("password"));
                us.setEmail(rs.getString("email"));
                us.setPhone(rs.getString("phone"));
                us.setRole(rs.getString("role"));
                us.setStatus(rs.getString("status"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return us;
    }

    public boolean register(Usuario us) {

        String sql = "INSERT INTO users(nick_user,name,last_name,dni,password,email,phone,role) values (?,?,?,?,?,?,?,?)";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNick_user());
            ps.setString(2, us.getName());
            ps.setString(3, us.getLast_name());
            ps.setString(4, us.getDni());
            ps.setString(5, us.getPassword());
            ps.setString(6, us.getEmail());
            ps.setString(7, us.getPhone());
            ps.setString(8, us.getRole());
            ps.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }

    }

    public List ListaUsers(String valor) {

        List<Usuario> ListaUsers = new ArrayList();
        String sql = "SELECT * FROM users ORDER BY status ASC";
        String search = "SELECT *FROM users where nick_user LIKE '%"
                + valor + "%' OR name LIKE'%" + valor + "%'";

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
                Usuario us = new Usuario();
                us.setId_user(rs.getInt("id_user"));
                us.setNick_user(rs.getString("nick_user"));
                us.setName(rs.getString("name"));
                us.setLast_name(rs.getString("last_name"));
                us.setDni(rs.getString("dni"));
                us.setPassword(rs.getString("password"));
                us.setEmail(rs.getString("email"));
                us.setPhone(rs.getString("phone"));
                us.setRole(rs.getString("role"));
                us.setStatus(rs.getString("status"));
                ListaUsers.add(us);
            }

        } catch (Exception e) {
        }

        return ListaUsers;

    }
    
    public boolean modify(Usuario us) {
        String sql = "UPDATE users SET nick_user=?, name=?, last_name=?, dni=?, password=?, email=?,phone=?,role=? where id_user=?";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNick_user());
            ps.setString(2, us.getName());
            ps.setString(3, us.getLast_name());
            ps.setString(4, us.getDni());
            ps.setString(5, us.getPassword());
            ps.setString(6, us.getEmail());
            ps.setString(7, us.getPhone());
            ps.setString(8, us.getRole());
            ps.setInt(9, us.getId_user());
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

   public boolean accion(String status, int id_user) {
        String sql = "UPDATE users SET status=? where id_user=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, id_user);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
  
}
