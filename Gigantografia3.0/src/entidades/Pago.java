package entidades;

import java.sql.Date;

public class Pago {
    private int PagoID;
    private int VentaID;
    private double MontoPagado;
    private Date FechaPago;

    public Pago() {
    }

    public Pago(int pagoID, int ventaID, double montoPagado, Date fechaPago) {
        this.PagoID = pagoID;
        this.VentaID = ventaID;
        this.MontoPagado = montoPagado;
        this.FechaPago = fechaPago;
    }

    public int getPagoID() {
        return PagoID;
    }

    public void setPagoID(int pagoID) {
        this.PagoID = pagoID;
    }

    public int getVentaID() {
        return VentaID;
    }

    public void setVentaID(int ventaID) {
        this.VentaID = ventaID;
    }

    public double getMontoPagado() {
        return MontoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.MontoPagado = montoPagado;
    }

    public Date getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.FechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "Pago{" + "PagoID=" + PagoID + ", VentaID=" + VentaID + ", MontoPagado=" + MontoPagado + ", FechaPago=" + FechaPago + '}';
    }
}
