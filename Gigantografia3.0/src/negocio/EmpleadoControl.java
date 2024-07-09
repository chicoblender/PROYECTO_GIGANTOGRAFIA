package negocio;

import datos.EmpleadoDAO;
import entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EmpleadoControl {

    private final EmpleadoDAO DATOS;
    private Empleado obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public EmpleadoControl() {
        this.DATOS = new EmpleadoDAO();
        this.obj = new Empleado();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Empleado> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID", "Nombre", "Cargo", "Salario", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[5];
        this.registrosMostrados = 0;

        for (Empleado item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getEmpleadoID());
            registro[1] = item.getNombreEmpleado();
            registro[2] = item.getCargo();
            registro[3] = Double.toString(item.getSalario());
            registro[4] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }

    public String insertar(String nombre, String cargo, double salario) {
        obj.setNombreEmpleado(nombre);
        obj.setCargo(cargo);
        obj.setSalario(salario);
        if (DATOS.existe(nombre)) {
            return "El registro ya existe.";
        } else {
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en la inserción.";
            }
        }
    }

    public String actualizar(int id, String nombre, String nombreAnt, String cargo, double salario) {
        if (nombre.equals(nombreAnt)) {
            obj.setEmpleadoID(id);
            obj.setNombreEmpleado(nombre);
            obj.setCargo(cargo);
            obj.setSalario(salario);
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización";
            }
        } else {
            if (DATOS.existe(nombre)) {
                return "El registro ya existe.";
            } else {
                obj.setEmpleadoID(id);
                obj.setNombreEmpleado(nombre);
                obj.setCargo(cargo);
                obj.setSalario(salario);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualización";
                }
            }
        }
    }

    public String desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro.";
        }
    }

    public String activar(int id) {
        if (DATOS.activar(id)) {
            return "OK";
        } else {
            return "No se puede activar el registro.";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }
}
