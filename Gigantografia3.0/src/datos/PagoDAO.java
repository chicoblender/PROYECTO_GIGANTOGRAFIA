package datos;

import basedatos.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Pago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PagoDAO implements CrudSimpleInterface<Pago> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public PagoDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Pago> listar(String texto) {
        List<Pago> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM pago WHERE VentaID LIKE ?");
            ps.setString(1, texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Pago(rs.getInt("PagoID"), rs.getInt("VentaID"), rs.getDouble("MontoPagado"), rs.getDate("FechaPago")));
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
    public boolean insertar(Pago obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO pago(VentaID, MontoPagado, FechaPago) VALUES(?, ?, ?)");
            ps.setInt(1, obj.getVentaID());
            ps.setDouble(2, obj.getMontoPagado());
            ps.setDate(3, obj.getFechaPago());
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
    public boolean actualizar(Pago obj) {
        // No se implementa la actualización de pagos
        return false;
    }

    @Override
    public boolean desactivar(int id) {
        // No se implementa la desactivación de pagos
        return false;
    }

    @Override
    public boolean activar(int id) {
        // No se implementa la activación de pagos
        return false;
    }

    @Override
    public int total() {
        // No se implementa el total de pagos
        return 0;
    }

    @Override
    public boolean existe(String texto) {
        // No se implementa la verificación de existencia de pagos
        return false;
    }
}
