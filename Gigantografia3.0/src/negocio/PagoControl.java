package negocio;

import datos.PagoDAO;
import entidades.Pago;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PagoControl {

    private final PagoDAO DATOS;
    private Pago obj;
    private DefaultTableModel modeloTabla;

    public int registrosMostrados;

    public PagoControl() {
        this.DATOS = new PagoDAO();
        this.obj = new Pago();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Pago> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID", "VentaID", "Monto Pagado", "Fecha Pago"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[4];
        this.registrosMostrados = 0;

        for (Pago item : lista) {
            registro[0] = Integer.toString(item.getPagoID());
            registro[1] = Integer.toString(item.getVentaID());
            registro[2] = Double.toString(item.getMontoPagado());
            registro[3] = item.getFechaPago().toString();
            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }

    public String insertar(int ventaID, double montoPagado, java.sql.Date fechaPago) {
        obj.setVentaID(ventaID);
        obj.setMontoPagado(montoPagado);
        obj.setFechaPago(fechaPago);
        if (DATOS.insertar(obj)) {
            return "OK";
        } else {
            return "Error en la inserción.";
        }
    }
}
