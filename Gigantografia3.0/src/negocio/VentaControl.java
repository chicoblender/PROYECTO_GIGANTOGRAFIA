package negocio;

import clases.Variables;
import datos.VentaDAO;
import datos.ProductoDAO;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Venta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class VentaControl {

    private final VentaDAO DATOS;
    private final ProductoDAO DATOSPRODUCTO;
    private Venta obj;
    private DefaultTableModel modeloTabla;

    public int registrosMostrados;

    public VentaControl() {
        this.DATOS = new VentaDAO();
        this.DATOSPRODUCTO = new ProductoDAO();
        this.obj = new Venta();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Venta> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID", "Usuario ID", "Usuario", "Cliente ID", "Cliente","Producto ID","Producto", "Numero Comprobante", "Fecha", "Situacion", "Total", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[12];
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        this.registrosMostrados = 0;

        for (Venta item : lista) {          
            registro[0] = Integer.toString(item.getVentaId());
            registro[1] = Integer.toString(item.getUsuarioId());
            registro[2] = item.getUsuarioNombre();
            registro[3] = Integer.toString(item.getClienteId());
            registro[4] = item.getClienteNombre();
            registro[5] = Integer.toString(item.getProductoId());
            registro[6] = item.getNombreProducto();
            registro[7] = item.getNumComprobante();
            registro[8] = sdf.format(item.getFechaVenta());
            registro[9] = item.getSituacion();
            registro[10] = Double.toString(item.getTotal());
            registro[11] = item.getEstado();
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }
    
    public DefaultComboBoxModel seleccionar() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Producto> lista = new ArrayList();
        lista = DATOSPRODUCTO.seleccionar();
        for (Producto item : lista) {
            items.addElement(new Producto(item.getProductoID(), item.getNombreProducto(),item.getPrecioUnitario()));
        }
        return items;
    }
    
    public DefaultTableModel listarDetalle(int id) {
        List<DetalleVenta> lista = new ArrayList();
        lista.addAll(DATOS.listarDetalle(id));
        String[] titulos = {"SERVICIO","CANTIDAD", "PRECIO UNITARIO"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[4];
        
        for (DetalleVenta item : lista) {          
            registro[0] = item.getServicio();
            registro[1] = Integer.toString(item.getCantidad());
            registro[2] = Double.toString(item.getPrecioUnitario());
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String insertar(int clienteId,int productoId,String numComprobante, String situacion, double total, DefaultTableModel modeloDetalle) {
        if (DATOS.existe(numComprobante)) {
            return "El registro ya existe.";
        } else {
            obj.setClienteId(clienteId);
            obj.setProductoId(productoId);
            obj.setUsuarioId(Variables.usuarioId);
            obj.setNumComprobante(numComprobante);
            obj.setSituacion(situacion);
            obj.setTotal(total);
            
            List<DetalleVenta> detalles=new ArrayList();
            //int ventaId;
            String servicio;
            int cantidad;
            double precio;
            
            for(int i=0;i<modeloDetalle.getRowCount();i++){

                //ventaId=Integer.parseInt(String.valueOf(modeloDetalle.getValueAt(i, 0)));
                servicio=String.valueOf(modeloDetalle.getValueAt(i, 0));
                cantidad=Integer.parseInt(String.valueOf(modeloDetalle.getValueAt(i, 1)));
                precio=Double.parseDouble(String.valueOf(modeloDetalle.getValueAt(i, 2)));
                detalles.add(new DetalleVenta(/*ventaId,*/servicio,cantidad,precio));
            }
            obj.setDetalles(detalles);
            
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en la insercion.";
            }
        }
    }

    public String anular(int id) {
        if (DATOS.anular(id)) {
            return "OK";
        } else {
            return "No se puede anular el registro.";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }
    
    public String ultimoNumero(){
        return this.DATOS.ultimoNumero();
    }

}
