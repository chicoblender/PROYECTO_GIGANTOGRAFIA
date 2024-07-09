package datos;

import basedatos.Conexion;
import com.mysql.jdbc.Statement;
import datos.interfaces.CrudOrdenInterface;
import entidades.DetalleVenta;
import entidades.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentaDAO implements CrudOrdenInterface<Venta, DetalleVenta> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public VentaDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Venta> listar(String texto) {
        List<Venta> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT v.VentaID,v.usuario_id,concat(u.nombres,u.apellidos) as usuario_nombre,v.ClienteID,c.NombreCliente as cliente_nombre,v.ProductoID,p.NombreProducto as producto_nombre, v.num_comprobante, v.FechaVenta, v.situacion, v.total, v.Estado FROM Venta v INNER JOIN Cliente c ON v.ClienteID=c.ClienteID INNER JOIN usuario u ON v.usuario_id=u.id INNER JOIN Producto p ON v.ProductoID=p.ProductoID  WHERE v.num_comprobante LIKE ? ORDER BY v.VentaID desc");
            ps.setString(1, texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
             registros.add(new Venta(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10),rs.getDouble(11),rs.getString(12)));
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

    @Override
    public List<DetalleVenta> listarDetalle(int id) {
        List<DetalleVenta> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT d.servicio,d.Cantidad,d.PrecioUnitario  FROM DetalleVenta d WHERE d.VentaID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
            registros.add(new DetalleVenta(/*rs.getInt(1),*/rs.getString(1), rs.getInt(2), rs.getDouble(3)));
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

    @Override
    public boolean insertar(Venta obj) {
        respuesta = false;
        Connection conn = null;
        try {
            conn = CON.conectar();
            conn.setAutoCommit(false);
            String sqlInsertIngreso = "INSERT INTO Venta(ClienteID,usuario_id,ProductoID,FechaVenta,num_comprobante,situacion,total,Estado) VALUES (?,?,?,now(),?,?,?,?)";
            ps = conn.prepareStatement(sqlInsertIngreso, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, obj.getClienteId());
            ps.setInt(2, obj.getUsuarioId());
            ps.setInt(3, obj.getProductoId());
            ps.setString(4, obj.getNumComprobante());
            ps.setString(5, obj.getSituacion());
            ps.setDouble(6, obj.getTotal());
            ps.setString(7, "Aceptado");
            int filasAfectadas = ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            int idGenerado = 0;
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
            if (filasAfectadas == 1) {
                String sqlInsertDetalle = "INSERT INTO DetalleVenta (DetalleVentaID,servicio,Cantidad,PrecioUnitario) VALUES (?,?,?,?)";
                ps = conn.prepareStatement(sqlInsertDetalle);
                for (DetalleVenta item : obj.getDetalles()) {
                    ps.setInt(1, idGenerado);
                  //  ps.setInt(2,item.getVentaId());
                    ps.setString(2, item.getServicio());
                    ps.setInt(3, item.getCantidad());
                    ps.setDouble(4, item.getPrecioUnitario());
                    respuesta = ps.executeUpdate() > 0;
                }
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    @Override
    public boolean actualizar(Venta obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean anular(int id) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE Venta SET Estado='Anulado' WHERE VentaID=?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(VentaID) FROM Venta");
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRegistros = rs.getInt("COUNT(VentaID)");
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
            ps = CON.conectar().prepareStatement("SELECT VentaID FROM Venta WHERE num_comprobante=?");
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

    public String ultimoNumero() {
        String numComprobante = "";
        try {
            ps = CON.conectar().prepareStatement("SELECT num_comprobante FROM Venta order by num_comprobante desc limit 1");
            //ps = (CallableStatement) CON.conectar().prepareCall("{call spUltimoNumeroIngreso(?,?)}");
            rs = ps.executeQuery();

            while (rs.next()) {
                numComprobante = rs.getString("num_comprobante");
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
        return numComprobante;
    }

}
