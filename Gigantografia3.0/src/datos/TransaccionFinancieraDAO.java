package datos;

import basedatos.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.TransaccionFinanciera;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TransaccionFinancieraDAO implements CrudSimpleInterface<TransaccionFinanciera> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public TransaccionFinancieraDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<TransaccionFinanciera> listar(String texto) {
        List<TransaccionFinanciera> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM TransaccionFinanciera WHERE Descripcion LIKE ?");
            ps.setString(1, texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new TransaccionFinanciera(rs.getInt("TransaccionID"), rs.getString("TipoTransaccion"), rs.getString("Descripcion"), rs.getDouble("Monto"), rs.getDate("FechaTransaccion"), rs.getInt("VentaID"), rs.getInt("PagoID")));
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
    public boolean insertar(TransaccionFinanciera obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO TransaccionFinanciera(TipoTransaccion, Descripcion, Monto, FechaTransaccion, VentaID, PagoID) VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getTipoTransaccion());
            ps.setString(2, obj.getDescripcion());
            ps.setDouble(3, obj.getMonto());
            ps.setDate(4, obj.getFechaTransaccion());
            ps.setInt(5, obj.getVentaID());
            ps.setInt(6, obj.getPagoID());
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
    public boolean actualizar(TransaccionFinanciera obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE TransaccionFinanciera SET TipoTransaccion = ?, Descripcion = ?, Monto = ?, FechaTransaccion = ?, VentaID = ?, PagoID = ? WHERE TransaccionID = ?");
            ps.setString(1, obj.getTipoTransaccion());
            ps.setString(2, obj.getDescripcion());
            ps.setDouble(3, obj.getMonto());
            ps.setDate(4, obj.getFechaTransaccion());
            ps.setInt(5, obj.getVentaID());
            ps.setInt(6, obj.getPagoID());
            ps.setInt(7, obj.getTransaccionID());
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
            ps = CON.conectar().prepareStatement("UPDATE TransaccionFinanciera SET Activo = 0 WHERE TransaccionID = ?");
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
            ps = CON.conectar().prepareStatement("UPDATE TransaccionFinanciera SET Activo = 1 WHERE TransaccionID = ?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(TransaccionID) FROM TransaccionFinanciera");
            rs = ps.executeQuery();
            if (rs.next()) {
                totalRegistros = rs.getInt(1);
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
            ps = CON.conectar().prepareStatement("SELECT TransaccionID FROM TransaccionFinanciera WHERE TransaccionID = ?");
            ps.setInt(1, Integer.parseInt(texto));
            rs = ps.executeQuery();
            if (rs.next()) {
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
