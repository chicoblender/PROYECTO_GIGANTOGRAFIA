
package entidades;

import java.util.Objects;




public class Producto {
    private int productoID;
    private String nombreProducto;
    private double precioUnitario;
    private int stock;
    private boolean activo;

    public Producto() {
    }

    public Producto(int productoID, String nombreProducto, double precioUnitario, int stock, boolean activo) {
        this.productoID = productoID;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.activo = activo;
    }

    public Producto(int productoID, String nombreProducto) {
        this.productoID = productoID;
        this.nombreProducto = nombreProducto;
    }

    public Producto(int productoID, String nombreProducto, double precioUnitario) {
        this.productoID = productoID;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
    }
    

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Producto{" + "productoID=" + productoID + ", nombreProducto=" + nombreProducto + ", precioUnitario=" + precioUnitario + ", stock=" + stock + ", activo=" + activo + '}';
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.productoID;
        hash = 79 * hash + Objects.hashCode(this.nombreProducto);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.precioUnitario) ^ (Double.doubleToLongBits(this.precioUnitario) >>> 32));
        hash = 79 * hash + this.stock;
        hash = 79 * hash + (this.activo ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.productoID != other.productoID) {
            return false;
        }
        if (Double.doubleToLongBits(this.precioUnitario) != Double.doubleToLongBits(other.precioUnitario)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        return Objects.equals(this.nombreProducto, other.nombreProducto);
    }

   

   
}

