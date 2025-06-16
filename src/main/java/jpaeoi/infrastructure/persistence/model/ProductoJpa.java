package jpaeoi.infrastructure.persistence.model;

import jakarta.persistence.*;
import jpaeoi.domain.Product;

@Entity
@Table(name = "producto")
public class ProductoJpa {

    @Id
    private String codigoProducto;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gama", nullable = false)
    private GamaProductoJpa gama;

    private String dimensiones;

    private String proveedor;

    private String descripcion;

    private int cantidadEnStock;

    private float precioVenta;

    private float precioProveedor;

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GamaProductoJpa getGama() {
        return gama;
    }

    public void setGama(GamaProductoJpa gama) {
        this.gama = gama;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(float precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public Product toDomain() {
        Product product = new Product();
        product.setProductCode(codigoProducto);
        product.setName(nombre);
        product.setProductLine(gama.toDomain());
        product.setDimensions(dimensiones);
        product.setSupplier(proveedor);
        product.setDescription(descripcion);
        product.setQuantityInStock(cantidadEnStock);
        product.setSalePrice(precioVenta);
        product.setSupplierPrice(precioProveedor);
        return product;
    }
}
