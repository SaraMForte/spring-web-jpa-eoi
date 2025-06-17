package jpaeoi.gandening.infrastructure.persistence.model;

import jakarta.persistence.*;
import jpaeoi.gandening.domain.Office;

import java.util.List;

@Entity
@Table(name = "oficina")
public class OficinaJpa {
    @Id
    @Column(name = "codigo_oficina", nullable = false, length = 10)
    private String codigoOficina;

    @Column(name = "ciudad", nullable = false, length = 30)
    private String ciudad;

    @Column(name = "pais", nullable = false, length = 50)
    private String pais;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "linea_direccion1", nullable = false, length = 50)
    private String lineaDireccion1;

    @Column(name = "linea_direccion2", length = 50)
    private String lineaDireccion2;

    @OneToMany
    private List<EmpleadoJpa> empleados;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public static OficinaJpa fromDomain(Office office) {
        if (office == null) return null;
        OficinaJpa oficinaJpa = new OficinaJpa();

        oficinaJpa.setCodigoOficina(office.officeCode());
        oficinaJpa.setCiudad(office.city());
        oficinaJpa.setPais(office.country());
        oficinaJpa.setRegion(office.region());
        oficinaJpa.setCodigoPostal(office.postalCode());
        oficinaJpa.setTelefono(office.phone());
        oficinaJpa.setLineaDireccion1(office.addressLine1());
        oficinaJpa.setLineaDireccion2(office.addressLine2());

        return oficinaJpa;
    }
}