package negocio;

import datos.RolDAO;
import entidades.Rol; 
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RolControl {

    private final RolDAO DATOS;
    private Rol obj;
    private DefaultTableModel modeloTabla;

    public int registrosMostrados;

    public RolControl() {
        this.DATOS = new RolDAO();
        this.obj = new Rol();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Rol> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID", "Nombre Rol", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[3];
        this.registrosMostrados = 0;

        for (Rol item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }

    public String insertar(String nombre) {
        if (DATOS.existe(nombre)) {
            return "El registro ya existe.";
        } else {
            obj.setNombre(nombre);
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en la insercion.";
            }
        }
    }

    public String actualizar(int id, String nombre, String nombreAnt) {
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualizacion";
            }
        } else {
            if (DATOS.existe(nombre)) {
                return "El registro ya existe.";
            } else {
                obj.setId(id);
                obj.setNombre(nombre);
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
}
