package jpaeoi.infrastructure.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jpaeoi.domain.Order;

import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class PedidoJpa {

    @Id
    @Column(name = "codigo_pedido")
    private int codigoPedido;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "fecha_esperada")
    private LocalDate fechaEsperada;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "estado")
    private String estado;

    @Column(name = "comentarios")
    private String comentarios;

    @Column(name = "codigo_cliente")
    private int codigoCliente;

    @Column(name = "activo")
    private boolean activo;

    public int codigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public LocalDate fechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate fechaEsperada() {
        return fechaEsperada;
    }

    public void setFechaEsperada(LocalDate fechaEsperada) {
        this.fechaEsperada = fechaEsperada;
    }

    public LocalDate fechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String estado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String comentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int codigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public boolean activo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public static PedidoJpa fromDomain(Order order) {
        PedidoJpa pedidoJDBC = new PedidoJpa();
        pedidoJDBC.setCodigoPedido(order.orderCode());
        pedidoJDBC.setFechaPedido(order.orderDate());
        pedidoJDBC.setFechaEsperada(order.expectedDate());
        pedidoJDBC.setFechaEntrega(order.deliveryDate());
        pedidoJDBC.setEstado(order.status());
        pedidoJDBC.setComentarios(order.comment());
        pedidoJDBC.setCodigoCliente(order.clientCode());
        return pedidoJDBC;
    }

    public Order toDomain() {
        Order domain = new Order();
        domain.setOrderCode(codigoPedido());
        domain.setOrderDate(fechaPedido());
        domain.setExpectedDate(fechaEsperada());
        domain.setDeliveryDate(fechaEntrega());
        domain.setStatus(estado());
        domain.setComment(comentarios());
        domain.setClientCode(codigoCliente());
        return domain;
    }
}
