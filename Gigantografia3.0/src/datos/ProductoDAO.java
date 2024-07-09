package datos;

import basedatos.Conexion;
import com.mysql.jdbc.CallableStatement;
import datos.interfaces.CrudSimpleInterface;
import entidades.Producto;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductoDAO implements CrudSimpleInterface<Producto> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public ProductoDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Producto> listar(String texto) {
        List<Producto> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT ProductoID, NombreProducto, PrecioUnitario, Stock, Activo FROM Producto WHERE NombreProducto LIKE ?");
            ps.setString(1, texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Producto(
                        rs.getInt("ProductoID"),
                        rs.getString("NombreProducto"),
                        rs.getDouble("PrecioUnitario"),
                        rs.getInt("Stock"),
                        rs.getBoolean("Activo")
                ));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }
    
    public List<Producto> listar() {
        List<Producto> registroNombre = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT ProductoID, NombreProducto,PrecioUnitario WHERE NombreProducto LIKE ?");
         //   ps.setString(1, texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registroNombre.add(new Producto(
                        rs.getInt("ProductoID"),
                        rs.getString("NombreProducto"),
                        rs.getDouble("PrecioUnitario")
                ));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registroNombre;
    }
       
   public List<Producto> seleccionar() {
        List<Producto> registroNombre=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT ProductoID,NombreProducto,PrecioUnitario FROM Producto order by NombreProducto asc");
           // ps=(CallableStatement)CON.conectar().prepareCall("SELECT ProductoID,NombreProducto FROM Producto order by NombreProducto asc");
            rs=ps.executeQuery();
            while(rs.next()){
               registroNombre.add(new Producto(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registroNombre;
    }

    @Override
    public boolean insertar(Producto obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO Producto (NombreProducto, PrecioUnitario, Stock, Activo) VALUES (?, ?, ?, 1)");
            ps.setString(1, obj.getNombreProducto());
            ps.setDouble(2, obj.getPrecioUnitario());
            ps.setInt(3, obj.getStock());
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean actualizar(Producto obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE Producto SET NombreProducto=?, PrecioUnitario=?, Stock=? WHERE ProductoID=?");
            ps.setString(1, obj.getNombreProducto());
            ps.setDouble(2, obj.getPrecioUnitario());
            ps.setInt(3, obj.getStock());
            ps.setInt(4, obj.getProductoID());
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean desactivar(int id) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE Producto SET Activo=0 WHERE ProductoID=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean activar(int id) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE Producto SET Activo=1 WHERE ProductoID=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public int total() {
        int totalRegistros = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(ProductoID) FROM Producto");
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRegistros = rs.getInt("COUNT(ProductoID)");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("SELECT NombreProducto FROM Producto WHERE NombreProducto=?");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0) {
                respuesta = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return respuesta;
    }
}
