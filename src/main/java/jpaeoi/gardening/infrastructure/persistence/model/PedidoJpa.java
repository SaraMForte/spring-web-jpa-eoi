package jpaeoi.gandening.infrastructure.persistence.model;

import jakarta.persistence.*;
import jpaeoi.gandening.domain.Order;

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

    @JoinColumn(name = "codigo_cliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteJpa cliente;

    @Column(name = "activo")
    private boolean activo;

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEsperada() {
        return fechaEsperada;
    }

    public void setFechaEsperada(LocalDate fechaEsperada) {
        this.fechaEsperada = fechaEsperada;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public ClienteJpa getCliente() {
        return cliente;
    }

    public void setCliente(ClienteJpa cliente) {
        this.cliente = cliente;
    }

    public boolean isActivo() {
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
        pedidoJDBC.setCliente(ClienteJpa.fromDomain(order.client()));
        return pedidoJDBC;
    }

    public Order toDomain() {
        Order domain = new Order();
        domain.setOrderCode(codigoPedido);
        domain.setOrderDate(fechaPedido);
        domain.setExpectedDate(fechaEsperada);
        domain.setDeliveryDate(fechaEntrega);
        domain.setStatus(estado);
        domain.setComment(comentarios);
        domain.setClient(cliente.toDomain());
        return domain;
    }
}
