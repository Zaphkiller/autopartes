package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Usuario login(String usuario, String password) {
        String sql = "Select * from user_login where nick_usuario=? and password=?";
        Usuario us = new Usuario();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setCodigo_usuario(rs.getInt("codigo_usuario"));
                us.setApellido(rs.getString("apellido"));
                us.setNombre(rs.getString("nombre"));
                us.setNick_usuario(rs.getString("nick_usuario"));
                us.setPassword(rs.getString("password"));
                us.setRol(rs.getString("rol"));
                us.setPerfil(rs.getString("perfil"));
                us.setEstado(rs.getString("estado"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return us;
    }

    
}
