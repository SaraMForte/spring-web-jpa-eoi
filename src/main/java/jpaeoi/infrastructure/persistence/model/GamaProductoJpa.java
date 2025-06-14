package jpaeoi.infrastructure.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jpaeoi.domain.ProductLine;

@Entity
@Table(name = "gama_producto")
public class GamaProductoJpa {

    @Id
    @Column(name = "gama")
    private String gama;

    @Column(name = "descripcion_texto")
    private String descripcionTexto;

    @Column(name = "descripcion_html")
    private String descripcionHtml;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "activo")
    private boolean activo;

    public String gama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String descripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String descripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String imagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean activo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ProductLine toDomain() {
        ProductLine productLine = new ProductLine();
        productLine.setLine(gama);
        productLine.setTextDescription(descripcionTexto);
        productLine.setHtmlDescription(descripcionHtml);
        productLine.setImage(imagen);
        return productLine;
    }

    public static GamaProductoJpa fromDomain(ProductLine productLine) {
        GamaProductoJpa gamaProductoJDBC = new GamaProductoJpa();
        gamaProductoJDBC.setGama(productLine.line());
        gamaProductoJDBC.setDescripcionTexto(productLine.textDescription());
        gamaProductoJDBC.setDescripcionHtml(productLine.htmlDescription());
        gamaProductoJDBC.setImagen(productLine.image());
        return gamaProductoJDBC;
    }
}
