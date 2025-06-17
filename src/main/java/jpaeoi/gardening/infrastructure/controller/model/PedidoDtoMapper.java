package jpaeoi.gardening.infrastructure.controller.model;

import jpaeoi.gardening.application.ClientService;
import jpaeoi.gardening.domain.Order;
import jpaeoi.shared.infrastructure.genericcontroller.DtoMapper;
import org.springframework.stereotype.Component;

@Component
public class PedidoDtoMapper implements DtoMapper<Order, PedidoDto> {

    ClientService clientService;

    public PedidoDtoMapper(ClientService clientService) {
        this.clientService = clientService;
    }

    public Order toDomain(PedidoDto pedidoDto) {
        if (pedidoDto == null) {
            return emptyDomain();
        }

        Order domain = new Order();
        domain.setOrderCode(pedidoDto.getCodigoPedido());
        domain.setOrderDate(pedidoDto.getFechaPedido());
        domain.setExpectedDate(pedidoDto.getFechaEsperada());
        domain.setDeliveryDate(pedidoDto.getFechaEntrega());
        domain.setStatus(pedidoDto.getEstado());
        domain.setComment(pedidoDto.getComentarios());
        domain.setClient(
                clientService
                        .findById(pedidoDto.getCodigoCliente())
                        .orElseThrow()
        );
        return domain;
    }

    public PedidoDto fromDomain(Order order) {
        if (order == null) {
            return emptyDto();
        }

        PedidoDto dto = new PedidoDto();
        dto.setCodigoPedido(order.orderCode());
        dto.setFechaPedido(order.orderDate());
        dto.setFechaEsperada(order.expectedDate());
        dto.setFechaEntrega(order.deliveryDate());
        dto.setEstado(order.status());
        dto.setComentarios(order.comment());
        dto.setCodigoCliente(order.client().clientCode());
        return dto;
    }

    @Override
    public Order emptyDomain() {
        return new Order();
    }

    @Override
    public PedidoDto emptyDto() {
        return new PedidoDto();
    }
}
