
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;


    public boolean register(Product prod) {

        String sql = "INSERT INTO products(code_product,description_product,purchase_price,sale_price,quantity,id_provider,id_category) values (?,?,?,?,?,?,?)";
     
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCode_product());
            ps.setString(2, prod.getDescription_product());
            ps.setDouble(3, prod.getPurchase_price());
            ps.setDouble(4, prod.getSale_price());
            ps.setInt(5, prod.getQuantity());
            ps.setInt(6, prod.getId_provider());
            ps.setInt(7, prod.getId_category());
            ps.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }

    }
    
    public List ListaProductos(String valor){
        
        List<Product> ListaProducto = new ArrayList();
        String sql = "SELECT * FROM products ORDER BY status_product";
        String search = "SELECT * FROM products where code_product LIKE '%" + valor + "%' OR description_product LIKE'%" + valor + "%'";        
        
        try {
            con = cn.getConexion();
            if(valor.equalsIgnoreCase("")){
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            }else{
                ps= con.prepareStatement(search);
                rs= ps.executeQuery();
                
            }
            
            while(rs.next()){
                Product prod = new Product();
                prod.setId_product(rs.getInt("id_product"));
                prod.setCode_product(rs.getString("code_product"));
                prod.setDescription_product(rs.getString("description_product"));
                prod.setPurchase_price(rs.getDouble("purchase_price"));
                prod.setSale_price(rs.getDouble("sale_price"));
                prod.setQuantity(rs.getInt("quantity"));
                prod.setStatus_product(rs.getString("status_product"));
                ListaProducto.add(prod);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return ListaProducto;
        
    
    }
    
    public boolean modify(Product prod){
        
        String sql = "UPDATE product SET code_product=?, description_product=?, purchase_price=?, sale_price=?, id_provider=?, id_category=? where id_product=?";
        try {
            con = cn.getConexion();
            ps= con.prepareStatement(sql);
            ps.setString(1, prod.getCode_product());
            ps.setString(2, prod.getDescription_product());
            ps.setDouble(3, prod.getPurchase_price());
            ps.setDouble(4, prod.getSale_price());
            ps.setInt(5, prod.getId_provider());
            ps.setInt(6, prod.getId_category());
            ps.setInt(7, prod.getId_product());
            ps.execute();
            return true;
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    
    }
    
    public boolean accion(String status_product, int id_product){
        String sql = "UPDATE product SET status_product=? where id_product=?";
        
        try {
          con = cn.getConexion();
          ps= con.prepareStatement(sql);
          ps.setString(1, status_product);
          ps.setInt(2, id_product);
          ps.execute();
          return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    
    }
    
}
