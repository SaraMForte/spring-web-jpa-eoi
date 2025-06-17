package jpaeoi.gandening.infrastructure.config;

import jpaeoi.gandening.application.OrderService;
import jpaeoi.gandening.domain.Order;
import jpaeoi.shared.infrastructure.genericcontroller.GenericControllerConfig;
import jpaeoi.shared.infrastructure.genericcontroller.DtoMapper;
import jpaeoi.gandening.infrastructure.controller.model.PedidoDto;
import jpaeoi.gandening.infrastructure.controller.model.PedidoDtoMapper;
import jpaeoi.gandening.infrastructure.persistence.JpaOrderRepository;
import jpaeoi.shared.infrastructure.generictable.GenericTable;
import jpaeoi.shared.infrastructure.generictable.GenericTableFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class OrderConfiguration {

    @Bean
    public OrderService orderService(JpaOrderRepository jdbcOrderRepository) {
        return new OrderService(jdbcOrderRepository);
    }

    @Bean(name = "orderControllerConfig")
    public GenericControllerConfig<Order, PedidoDto> genericControllerConfig(OrderService orderService, PedidoDtoMapper pedidoDtoMapper) {
        return new GenericControllerConfig<Order, PedidoDto>() {
            @Override
            public List<Order> findDomainAll() {
                return orderService.findAll();
            }

            @Override
            public Optional<Order> findDomainById(String id) {
                return orderService.findById(Integer.parseInt(id));
            }

            @Override
            public void saveDomain(Order domain) {
                orderService.save(domain);
            }

            @Override
            public void updateDomain(Order domain) {
                orderService.update(domain);
            }

            @Override
            public void deleteDomainById(String id) {
                orderService.deleteById(Integer.parseInt(id));
            }

            @Override
            public DtoMapper<Order, PedidoDto> mapper() {
                return pedidoDtoMapper;
            }

            @Override
            public GenericTable getTable(List<PedidoDto> entities) {
                return GenericTableFactory.create(entities, PedidoDto.class);
            }
        };

    }
}
