package jpaeoi.infrastructure.persistence.model;

import jakarta.persistence.*;
import jpaeoi.domain.Employee;

import java.util.List;

@Entity
@Table(name = "empleado")
public class EmpleadoJpa {

    @Id
    @Column(name = "codigo_empleado", nullable = false)
    private Integer codigoEmpleado;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido1", nullable = false, length = 50)
    private String apellido1;

    @Column(name = "apellido2", length = 50)
    private String apellido2;

    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @JoinColumn(name = "codigo_jefe")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmpleadoJpa jefe;


    @Column(name = "puesto", length = 50)
    private String puesto;

    @OneToMany(mappedBy = "empleadoRepVentas", fetch = FetchType.LAZY)
    private List<ClienteJpa> clientes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_oficina")
    private OficinaJpa oficina;

    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmpleadoJpa getJefe() {
        return jefe;
    }

    public void setJefe(EmpleadoJpa jefe) {
        this.jefe = jefe;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public List<ClienteJpa> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteJpa> clientes) {
        this.clientes = clientes;
    }

    public OficinaJpa getOficina() {
        return oficina;
    }

    public void setOficina(OficinaJpa oficina) {
        this.oficina = oficina;
    }

    public Employee toDomain() {
        Employee employee = new Employee();
        employee.setEmployeeCode(codigoEmpleado);
        employee.setFirstName(nombre);
        employee.setLastName1(apellido1);
        employee.setLastName2(apellido2);
        employee.setExtension(extension);
        employee.setEmail(email);
        employee.setManager(jefe != null ? jefe.toDomain() : null);
        employee.setJobTitle(puesto);
        return employee;
    }

    public static EmpleadoJpa fromDomain(Employee employee) {
        EmpleadoJpa empleadoJpa = new EmpleadoJpa();

        empleadoJpa.setCodigoEmpleado(employee.employeeCode());
        empleadoJpa.setNombre(employee.firstName());
        empleadoJpa.setApellido1(employee.lastName1());
        empleadoJpa.setApellido2(employee.lastName2());
        empleadoJpa.setExtension(employee.extension());
        empleadoJpa.setEmail(employee.email());
        empleadoJpa.setPuesto(employee.jobTitle());
        empleadoJpa.setJefe(employee.manager() != null ? fromDomain(employee.manager()) : null);
        empleadoJpa.setOficina(OficinaJpa.fromDomain(employee.office()));

        return empleadoJpa;
    }

}
