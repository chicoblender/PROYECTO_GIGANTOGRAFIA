package negocio;

import datos.TransaccionFinancieraDAO;
import entidades.TransaccionFinanciera;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TransaccionFinancieraControl {

    private final TransaccionFinancieraDAO DATOS;
    private TransaccionFinanciera obj;
    private DefaultTableModel modeloTabla;

    public int registrosMostrados;

    public TransaccionFinancieraControl() {
        this.DATOS = new TransaccionFinancieraDAO();
        this.obj = new TransaccionFinanciera();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<TransaccionFinanciera> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID", "Tipo Transacción", "Descripción", "Monto", "Fecha Transacción", "Venta ID", "Pago ID"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[7];
        this.registrosMostrados = 0;

        for (TransaccionFinanciera item : lista) {
            registro[0] = Integer.toString(item.getTransaccionID());
            registro[1] = item.getTipoTransaccion();
            registro[2] = item.getDescripcion();
            registro[3] = Double.toString(item.getMonto());
            registro[4] = item.getFechaTransaccion().toString();
            registro[5] = Integer.toString(item.getVentaID());
            registro[6] = Integer.toString(item.getPagoID());
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }

    public String insertar(String tipoTransaccion, String descripcion, double monto, Date fechaTransaccion, int ventaID, int pagoID) {
        obj.setTipoTransaccion(tipoTransaccion);
        obj.setDescripcion(descripcion);
        obj.setMonto(monto);
        obj.setFechaTransaccion(fechaTransaccion);
        obj.setVentaID(ventaID);
        obj.setPagoID(pagoID);
        
        if (DATOS.insertar(obj)) {
            return "OK";
        } else {
            return "Error en la inserción.";
        }
    }

    public String actualizar(int transaccionID, String tipoTransaccion, String descripcion, double monto, Date fechaTransaccion, int ventaID, int pagoID) {
        obj.setTransaccionID(transaccionID);
        obj.setTipoTransaccion(tipoTransaccion);
        obj.setDescripcion(descripcion);
        obj.setMonto(monto);
        obj.setFechaTransaccion(fechaTransaccion);
        obj.setVentaID(ventaID);
        obj.setPagoID(pagoID);
        
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "Error en la actualización";
        }
    }

    public String desactivar(int transaccionID) {
        if (DATOS.desactivar(transaccionID)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro.";
        }
    }

    public String activar(int transaccionID) {
        if (DATOS.activar(transaccionID)) {
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
