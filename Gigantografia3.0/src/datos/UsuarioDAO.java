package datos;

import basedatos.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Usuario;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO implements CrudSimpleInterface<Usuario>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public UsuarioDAO() {
        CON=Conexion.getInstancia();
    }
    
    

    @Override
    public List<Usuario> listar(String texto) {
     List<Usuario> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT u.id,u.rol_id,r.nombre as rol_nombre,u.nombres,u.apellidos,u.ci,u.email,u.clave,u.fechanacimiento,u.foto,u.activo FROM usuario u inner join rol r on u.rol_id=r.id WHERE u.nombres LIKE ? ORDER BY u.id DESC");
            ps.setString(1, texto+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Usuario(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDate(9),rs.getString(10),rs.getBoolean(11)));
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
    
    public List<Usuario> listar(String texto,String campo) {
     List<Usuario> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT u.id,u.rol_id,r.nombre as rol_nombre,u.nombres,u.apellidos,u.ci,u.email,u.clave,u.fechanacimiento,u.foto,u.activo FROM usuario u inner join rol r on u.rol_id=r.id WHERE "+campo+" LIKE ? ORDER BY u.id DESC");
           
            ps.setString(1, texto+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Usuario(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDate(9),rs.getString(10),rs.getBoolean(11)));
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
    
    public Usuario login(String email,String clave) {
     Usuario usu=null;
        try {
            ps=CON.conectar().prepareStatement("SELECT u.id,u.rol_id,r.nombre as rol_nombre,u.nombres,u.apellidos,u.ci,u.email,u.activo FROM usuario u inner join rol r on u.rol_id=r.id WHERE u.email=? and u.clave=?");
           
            ps.setString(1, email);
            ps.setString(2, clave);
            rs=ps.executeQuery();
            if(rs.first()){
               usu= new Usuario(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getBoolean(8));
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
        return usu;
    }

    @Override
    public boolean insertar(Usuario obj) {
        respuesta=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO usuario(rol_id,nombres,apellidos,ci,email,clave,fechanacimiento,foto,activo) VALUES(?,?,?,?,?,?,?,?,1)");
            ps.setInt(1, obj.getRolId());
            ps.setString(2, obj.getNombres());
            ps.setString(3, obj.getApellidos());
            ps.setString(4, obj.getCi());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getClave());
            ps.setDate(7, obj.getFechaNacimiento());
            ps.setString(8, obj.getFoto());
            
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
    public boolean actualizar(Usuario obj) {
respuesta=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE usuario SET rol_id=?,nombres=?,apellidos=?,ci=?,email=?,clave=?,fechanacimiento=?,foto=? WHERE id=?");
           ps.setInt(1, obj.getRolId());
            ps.setString(2, obj.getNombres());
            ps.setString(3, obj.getApellidos());
            ps.setString(4, obj.getCi());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getClave());
            ps.setDate(7, obj.getFechaNacimiento());
            ps.setString(8, obj.getFoto());
            ps.setInt(9, obj.getId());
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
            ps=CON.conectar().prepareStatement("UPDATE usuario SET activo=0 WHERE id=?");
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
            ps=CON.conectar().prepareStatement("UPDATE usuario SET activo=1 WHERE id=?");
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
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) FROM usuario");
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
            ps=CON.conectar().prepareStatement("SELECT email FROM usuario WHERE email=?");
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
