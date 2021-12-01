
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class CategoryDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
public boolean register(Category cat) {

        String sql = "INSERT INTO categories(id_category,name_category) values (?,?)";

        try {
             con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cat.getId_category());
            ps.setString(2, cat.getName_category());
            ps.execute();
            return true;


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }

    }

public List ListaCategories(String valor){
    List<Category> ListaCategories = new ArrayList();
        String sql = "SELECT * FROM categories ORDER BY status_category ASC";
        String search = "SELECT *FROM categories where name_category LIKE '%"
                + valor + "%' OR code_category LIKE'%" + valor + "%'";

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
                Category cat = new Category();
                cat.setId_category(rs.getInt("id_category"));
                cat.setCode_category(rs.getString("code_category"));
                cat.setName_category(rs.getString("name_category"));
                cat.setStatus_category(rs.getString("status_category"));
                ListaCategories.add(cat);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return ListaCategories;

}

public boolean modify(Category cat){
    
     String sql = "UPDATE categories SET code_category=?, name_category=? where id_category=?";
     
     try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getCode_category());
            ps.setString(2, cat.getName_category());
            ps.setInt(3, cat.getId_category());
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }

}

public boolean accion(String status_category, int id_category){
    
    String sql = "UPDATE categories SET status_category=? where id_category=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, status_category);
            ps.setInt(2, id_category);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }


}
    
   
}
