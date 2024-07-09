package datos;

import basedatos.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpleadoDAO implements CrudSimpleInterface<Empleado> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public EmpleadoDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Empleado> listar(String texto) {
        List<Empleado> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT EmpleadoID, NombreEmpleado, Cargo, Salario, Activo FROM Empleado WHERE NombreEmpleado LIKE ? ORDER BY EmpleadoID DESC");
            ps.setString(1, texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Empleado(
                        rs.getInt("EmpleadoID"),
                        rs.getString("NombreEmpleado"),
                        rs.getString("Cargo"),
                        rs.getDouble("Salario"),
                        rs.getBoolean("Activo")));
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
    public boolean insertar(Empleado obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO Empleado(NombreEmpleado, Cargo, Salario, Activo) VALUES(?,?,?,1)");
            ps.setString(1, obj.getNombreEmpleado());
            ps.setString(2, obj.getCargo());
            ps.setDouble(3, obj.getSalario());
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
    public boolean actualizar(Empleado obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE Empleado SET NombreEmpleado=?, Cargo=?, Salario=? WHERE EmpleadoID=?");
            ps.setString(1, obj.getNombreEmpleado());
            ps.setString(2, obj.getCargo());
            ps.setDouble(3, obj.getSalario());
            ps.setInt(4, obj.getEmpleadoID());
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
            ps = CON.conectar().prepareStatement("UPDATE Empleado SET Activo=0 WHERE EmpleadoID=?");
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
            ps = CON.conectar().prepareStatement("UPDATE Empleado SET Activo=1 WHERE EmpleadoID=?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(EmpleadoID) FROM Empleado");
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRegistros = rs.getInt("COUNT(EmpleadoID)");
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
            ps = CON.conectar().prepareStatement("SELECT NombreEmpleado FROM Empleado WHERE NombreEmpleado=?");
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
