package entidades;

import java.sql.Date;
import java.util.List;

public class Venta {
    private int ventaId;
    private int usuarioId;
    private String usuarioNombre; //por el inner join
    private int clienteId;
    private String clienteNombre; //por el inner join
    private int productoId;
    private String nombreProducto; 
    private String numComprobante;
    private Date fechaVenta;
    private String situacion;
    private double total;
    private String estado;
    private List<DetalleVenta> detalles;

    public Venta() {
    }

    public Venta(int ventaId, int usuarioId, String usuarioNombre, int clienteId, String clienteNombre, int productoId, String nombreProducto, String numComprobante, Date fechaVenta, String situacion, double total, String estado, List<DetalleVenta> detalles) {
        this.ventaId = ventaId;
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.numComprobante = numComprobante;
        this.fechaVenta = fechaVenta;
        this.situacion = situacion;
        this.total = total;
        this.estado = estado;
        this.detalles = detalles;
    }

    public Venta(int ventaId, int usuarioId, String usuarioNombre, int clienteId, String clienteNombre, int productoId, String nombreProducto, String numComprobante, Date fechaVenta, String situacion, double total, String estado) {
        this.ventaId = ventaId;
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.numComprobante = numComprobante;
        this.fechaVenta = fechaVenta;
        this.situacion = situacion;
        this.total = total;
        this.estado = estado;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

  
    
}
