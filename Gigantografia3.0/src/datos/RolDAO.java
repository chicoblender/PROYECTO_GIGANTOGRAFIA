package datos;

import basedatos.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Rol;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RolDAO implements CrudSimpleInterface<Rol>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public RolDAO() {
        CON=Conexion.getInstancia();
    }
    
    

    @Override
    public List<Rol> listar(String texto) {
     List<Rol> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT*FROM rol WHERE nombre LIKE ?");
            ps.setString(1, texto+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Rol(rs.getInt(1),rs.getString(2),rs.getBoolean(3)));
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
    
    public List<Rol> seleccionar() {
     List<Rol> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT id,nombre FROM rol order by nombre asc"); 
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Rol(rs.getInt(1),rs.getString(2)));
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
    public boolean insertar(Rol obj) {
        respuesta=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO rol(nombre,activo) VALUES(?,1)");
            ps.setString(1, obj.getNombre());
            if (ps.executeUpdate()>0) {
                respuesta=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean actualizar(Rol obj) {
respuesta=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE rol SET nombre=? WHERE id=?");
            ps.setString(1, obj.getNombre());
            ps.setInt(2, obj.getId());
            if (ps.executeUpdate()>0) {
                respuesta=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return respuesta;    }

    @Override
    public boolean desactivar(int id) {
        respuesta=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE rol SET activo=0 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0) {
                respuesta=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean activar(int id) {
        respuesta=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE rol SET activo=1 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0) {
                respuesta=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public int total() {
        int totalRegistros=0;
        try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) FROM rol");
            rs=ps.executeQuery();
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id)");
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
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        respuesta=false;
        try {
            ps=CON.conectar().prepareStatement("SELECT nombre FROM rol WHERE nombre=?");
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
