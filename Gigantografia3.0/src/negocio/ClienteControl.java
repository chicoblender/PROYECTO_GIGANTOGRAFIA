package negocio;

import datos.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClienteControl {

    private final ClienteDAO DATOS;
    private Cliente obj;
    private DefaultTableModel modeloTabla;

    public int registrosMostrados;

    public ClienteControl() {
        this.DATOS = new ClienteDAO();
        this.obj = new Cliente();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Cliente> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID", "Nombre", "Teléfono", "Dirección", "Activo"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[5];
        this.registrosMostrados = 0;

        for (Cliente item : lista) {
            estado = item.isActivo() ? "Activo" : "Inactivo";
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getTelefono();
            registro[3] = item.getDireccion();
            registro[4] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }
    
     public DefaultTableModel listar(String texto,String campo) {
        List<Cliente> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto,campo));
        String[] titulos = {"ID", "Nombre", "Teléfono", "Dirección", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[5];
        this.registrosMostrados = 0;

        for (Cliente item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getTelefono();
            registro[3] = item.getDireccion();
            registro[4] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }

    public String insertar(String nombre, String telefono, String direccion) {
        obj.setNombre(nombre);
        obj.setTelefono(telefono);
        obj.setDireccion(direccion);
        obj.setActivo(true); // Por defecto, un nuevo cliente está activo

        if (DATOS.insertar(obj)) {
            return "Cliente registrado exitosamente.";
        } else {
            return "Error al intentar registrar el cliente.";
        }
    }

    public String actualizar(int id, String nombre,String nombreAnt, String telefono, String direccion) {
       if (nombre.equals(nombreAnt)) {
            obj.setId(id);
        obj.setNombre(nombre);
        obj.setTelefono(telefono);
        obj.setDireccion(direccion);

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
                obj.setNombre(nombre);
                obj.setTelefono(telefono);
                obj.setDireccion(direccion);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualizacion";
                }
            }
        }
    }

    public String desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "Cliente desactivado exitosamente.";
        } else {
            return "Error al intentar desactivar el cliente.";
        }
    }

    public String activar(int id) {
        if (DATOS.activar(id)) {
            return "Cliente activado exitosamente.";
        } else {
            return "Error al intentar activar el cliente.";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }
}
