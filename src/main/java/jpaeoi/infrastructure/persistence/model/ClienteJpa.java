package jpaeoi.infrastructure.persistence.model;

import jakarta.persistence.*;
import jpaeoi.domain.Client;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
public class ClienteJpa {

    @Id
    @Column(name = "codigo_cliente", nullable = false)
    private Integer codigoCliente;

    @Column(name = "nombre_cliente", nullable = false, length = 50)
    private String nombreCliente;

    @ColumnDefault("NULL")
    @Column(name = "nombre_contacto", length = 30)
    private String nombreContacto;

    @ColumnDefault("NULL")
    @Column(name = "apellido_contacto", length = 30)
    private String apellidoContacto;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "fax", nullable = false, length = 15)
    private String fax;

    @Column(name = "linea_direccion1", nullable = false, length = 50)
    private String lineaDireccion1;

    @ColumnDefault("NULL")
    @Column(name = "linea_direccion2", length = 50)
    private String lineaDireccion2;

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @ColumnDefault("NULL")
    @Column(name = "region", length = 50)
    private String region;

    @ColumnDefault("NULL")
    @Column(name = "pais", length = 50)
    private String pais;

    @ColumnDefault("NULL")
    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_empleado_rep_ventas")
    private EmpleadoJpa codigoEmpleadoRepVentas;

    @ColumnDefault("NULL")
    @Column(name = "limite_credito", precision = 15, scale = 2)
    private BigDecimal limiteCredito;

    @ColumnDefault("true")
    @Column(name = "activo")
    private Boolean activo;

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public EmpleadoJpa getCodigoEmpleadoRepVentas() {
        return codigoEmpleadoRepVentas;
    }

    public void setCodigoEmpleadoRepVentas(EmpleadoJpa codigoEmpleadoRepVentas) {
        this.codigoEmpleadoRepVentas = codigoEmpleadoRepVentas;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLineaDireccion2() {
        return lineaDireccion2;
    }

    public void setLineaDireccion2(String lineaDireccion2) {
        this.lineaDireccion2 = lineaDireccion2;
    }

    public String getLineaDireccion1() {
        return lineaDireccion1;
    }

    public void setLineaDireccion1(String lineaDireccion1) {
        this.lineaDireccion1 = lineaDireccion1;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getId() {
        return codigoCliente;
    }

    public void setId(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Client toDomain() {
        Client client = new Client();
        client.setClientCode(codigoCliente);
        client.setFirstName(nombreCliente);
        client.setContactName(nombreContacto);
        client.setContactLastName(apellidoContacto);
        client.setContactPhone(telefono);
        client.setFax(fax);
        client.setAddressLine1(lineaDireccion1);
        client.setAddressLine2(lineaDireccion2);
        client.setCity(ciudad);
        client.setRegion(region);
        client.setCountry(pais);
        client.setPostalCode(codigoPostal);
        client.setEmployeeSalesRepresentativeCode(codigoEmpleadoRepVentas.getId());
        client.setCreditLimit(limiteCredito.doubleValue());
        return client;
    }
}
