package datos;

import basedatos.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Cliente;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO implements CrudSimpleInterface<Cliente> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public ClienteDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Cliente> listar(String texto) {
        List<Cliente> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM Cliente WHERE NombreCliente LIKE ?");
            ps.setString(1, texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Cliente(
                        rs.getInt("ClienteID"),
                        rs.getString("NombreCliente"),
                        rs.getString("Telefono"),
                        rs.getString("Direccion"),
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
    
    
     public List<Cliente> listar(String texto,String campo) {
     List<Cliente> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT c.ClienteID,c.NombreCliente,c.Telefono,c.Direccion,c.Activo FROM Cliente c WHERE "+campo+" LIKE ? ORDER BY c.ClienteID DESC");
           // ps.setString(1, campo);
            ps.setString(1, texto+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5)));
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
        return registros;
    }

    
    

    @Override
    public boolean insertar(Cliente obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO Cliente (NombreCliente, Telefono, Direccion, Activo) VALUES (?, ?, ?, 1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTelefono());
            ps.setString(3, obj.getDireccion());
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
    public boolean actualizar(Cliente obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE Cliente SET NombreCliente = ?, Telefono = ?, Direccion = ? WHERE ClienteID = ?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTelefono());
            ps.setString(3, obj.getDireccion());
            ps.setInt(4, obj.getId());
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
            ps = CON.conectar().prepareStatement("UPDATE Cliente SET Activo = 0 WHERE ClienteID = ?");
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
            ps = CON.conectar().prepareStatement("UPDATE Cliente SET Activo = 1 WHERE ClienteID = ?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(ClienteID) FROM Cliente");
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRegistros = rs.getInt("COUNT(ClienteID)");
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
            ps = CON.conectar().prepareStatement("SELECT NombreCliente FROM Cliente WHERE NombreCliente = ?");
           ps.setString(1, texto);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                respuesta=true;
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
        return respuesta;
    }
}
