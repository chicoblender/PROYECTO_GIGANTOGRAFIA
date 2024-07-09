package negocio;

import datos.ProductoDAO;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProductoControl {

    private final ProductoDAO DATOS;
    private Producto obj;
    private DefaultTableModel modeloTabla;

    public int registrosMostrados;

    public ProductoControl() {
        this.DATOS = new ProductoDAO();
        this.obj = new Producto();
        
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Producto> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID", "Nombre Producto", "Precio Unitario", "Stock", "Activo"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[5];
        this.registrosMostrados = 0;

        for (Producto item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getProductoID());
            registro[1] = item.getNombreProducto();
            registro[2] = Double.toString(item.getPrecioUnitario());
            registro[3] = Integer.toString(item.getStock());
            registro[4] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }
    public String insertar(String nombre, double precio, int stock) {
        if (DATOS.existe(nombre)) {
            return "El registro ya existe.";
        } else {
            obj.setNombreProducto(nombre);
            obj.setPrecioUnitario(precio);
            obj.setStock(stock);
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en la inserción.";
            }
        }
    }

    public String actualizar(int id, String nombre, double precio, int stock) {
        obj.setProductoID(id);
        obj.setNombreProducto(nombre);
        obj.setPrecioUnitario(precio);
        obj.setStock(stock);
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "Error en la actualización";
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
