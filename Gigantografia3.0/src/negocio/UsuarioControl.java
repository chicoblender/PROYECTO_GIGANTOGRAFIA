package negocio;

import clases.Variables;
import datos.UsuarioDAO;
import datos.RolDAO;
import entidades.Usuario;
import entidades.Rol;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;

public class UsuarioControl {

    private final UsuarioDAO DATOS;
    private final RolDAO DATOSROL;
    private Usuario obj;
    private DefaultTableModel modeloTabla;

    public int registrosMostrados;

    public UsuarioControl() {
        this.DATOS = new UsuarioDAO();
        this.DATOSROL=new RolDAO();
        this.obj = new Usuario();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Usuario> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID","Rol ID","Rol","Nombres", "Apellidos","CI","Email","Clave","Fecha Nac.","Foto","Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[11];
        this.registrosMostrados = 0;

        for (Usuario item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getRolId());
            registro[2] = item.getRolNombre();
            registro[3] = item.getNombres();
            registro[4] = item.getApellidos();
            registro[5] = item.getCi();
            registro[6] = item.getEmail();
            registro[7] = item.getClave();
            registro[8] = String.valueOf(item.getFechaNacimiento());
            registro[9] = item.getFoto();
            registro[10] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }
    
    public DefaultComboBoxModel seleccionar(){
        DefaultComboBoxModel items=new DefaultComboBoxModel();
        List<Rol> lista=new ArrayList();
        lista=DATOSROL.seleccionar();
        for(Rol item:lista) {
            items.addElement(new Rol(item.getId(),item.getNombre()));
        }
        return items;
    }
    
    public DefaultTableModel listar(String texto,String campo) {
        List<Usuario> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto,campo));
        String[] titulos = {"ID","Rol ID","Rol","Nombres", "Apellidos","CI","Email","Clave","Fecha Nac.","Foto","Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[11];
        this.registrosMostrados = 0;

        for (Usuario item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getRolId());
            registro[2] = item.getRolNombre();
            registro[3] = item.getNombres();
            registro[4] = item.getApellidos();
            registro[5] = item.getCi();
            registro[6] = item.getEmail();
            registro[7] = item.getClave();
            registro[8] = String.valueOf(item.getFechaNacimiento());
            registro[9] = item.getFoto();
            registro[10] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }

    public String insertar(int rolId,String nombres,String apellidos,String ci,String email,String clave,Date fechaNacimiento,String foto) {
        if (DATOS.existe(email)) {
            return "El registro ya existe.";
        } else {
            obj.setRolId(rolId);
            obj.setNombres(nombres);
            obj.setApellidos(apellidos);
            obj.setCi(ci);
            obj.setEmail(email);
            obj.setClave(this.encriptar(clave));
            obj.setFechaNacimiento(fechaNacimiento);
            obj.setFoto(foto);
            
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en la insercion.";
            }
        }
    }
    
    public String login(String email,String clave){
        String resp="0";
        Usuario usu=this.DATOS.login(email, this.encriptar(clave));
        if (usu!=null) {
            if (usu.isActivo()) {
                Variables.usuarioId=usu.getId();
                Variables.rolId=usu.getRolId();
                Variables.rolNombre=usu.getRolNombre();
                Variables.usuarioNombre=usu.getNombres();
                Variables.usuarioApellido=usu.getApellidos();
                Variables.usuarioCi=usu.getCi();
                Variables.usuarioEmail=usu.getEmail();
                resp="1"; 
            }else{
              resp="2";  
            }
            }
        return resp;
    }
    
    private static String encriptar(String valor){
        MessageDigest md;
        try {
            md=MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        byte[] hash=md.digest(valor.getBytes());
        StringBuilder sb=new StringBuilder();
        for(byte b:hash){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    public String actualizar(int id,int rolId,String nombres,String apellidos,String ci,String email,String emailAnt,String clave,Date fechaNacimiento,String foto) {
        if (email.equalsIgnoreCase(emailAnt)) {
            obj.setId(id);
            obj.setRolId(rolId);
            obj.setNombres(nombres);
            obj.setApellidos(apellidos);
            obj.setCi(ci);
            obj.setEmail(email);
            String encriptado;
            if (clave.length()==64) {
                encriptado=clave;
            }else{
                encriptado=this.encriptar(clave);
            }
            obj.setClave(encriptado);
            obj.setFechaNacimiento(fechaNacimiento);
            obj.setFoto(foto);
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualizacion";
            }
        } else {
            if (DATOS.existe(email)) {
                return "El registro ya existe.";
            } else {
                obj.setId(id);
                obj.setRolId(rolId);
                obj.setNombres(nombres);
                obj.setApellidos(apellidos);
                obj.setCi(ci);
                obj.setEmail(email);
                String encriptado;
                if (clave.length() == 64) {
                    encriptado = clave;
                } else {
                    encriptado = this.encriptar(clave);
                }
                obj.setClave(encriptado);
                obj.setFechaNacimiento(fechaNacimiento);
                obj.setFoto(foto);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualizacion";
                }
            }
        }
    }
     
      public String desactivar(int id){
        if(DATOS.desactivar(id)){
            return "OK";
        }else{
            return "No se puede desactivar el registro.";
        }
    }
    
    public String activar(int id){
        if(DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar el registro.";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
    
    public String generaNombreImagen(String nombre,String numDocumento){
        String nombreImagen=nombre.replaceAll("\\s","").trim()+numDocumento.trim();
        return nombreImagen;
    }
    
}
