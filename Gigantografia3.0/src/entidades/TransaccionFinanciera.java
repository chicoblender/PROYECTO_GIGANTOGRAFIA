package entidades;
import java.sql.Date;

import java.sql.Date;

public class TransaccionFinanciera {
    private int transaccionID;
    private String tipoTransaccion;
    private String descripcion;
    private double monto;
    private Date fechaTransaccion;
    private int ventaID;
    private int pagoID;

    public TransaccionFinanciera() {
    }

    public TransaccionFinanciera(int transaccionID, String tipoTransaccion, String descripcion, double monto, Date fechaTransaccion, int ventaID, int pagoID) {
        this.transaccionID = transaccionID;
        this.tipoTransaccion = tipoTransaccion;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fechaTransaccion = fechaTransaccion;
        this.ventaID = ventaID;
        this.pagoID = pagoID;
    }

    public int getTransaccionID() {
        return transaccionID;
    }

    public void setTransaccionID(int transaccionID) {
        this.transaccionID = transaccionID;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public int getPagoID() {
        return pagoID;
    }

    public void setPagoID(int pagoID) {
        this.pagoID = pagoID;
    }

    @Override
    public String toString() {
        return "TransaccionFinanciera{" +
                "transaccionID=" + transaccionID +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", monto=" + monto +
                ", fechaTransaccion=" + fechaTransaccion +
                ", ventaID=" + ventaID +
                ", pagoID=" + pagoID +
                '}';
    }
}
