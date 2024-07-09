package entidades;

public class DetalleVenta {
    private int detalleVenta;
    private int ventaId;
    private String servicio;
    private int cantidad;
    private double precioUnitario; 

    public DetalleVenta() {
    }

    public DetalleVenta(int detalleVenta, int ventaId, String servicio, int cantidad, double precioUnitario) {
        this.detalleVenta = detalleVenta;
        this.ventaId = ventaId;
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public DetalleVenta(String servicio, int cantidad, double precioUnitario) {
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

   /* public DetalleVenta(int ventaId, String servicio, int cantidad, double precioUnitario) {
        this.ventaId = ventaId;
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    */

    public int getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(int detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "detalleVenta=" + detalleVenta + ", ventaId=" + ventaId + ", servicio=" + servicio + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }
    
    

    
}

