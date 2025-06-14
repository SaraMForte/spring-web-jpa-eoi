package jpaeoi.infrastructure.controller.model;

import jpaeoi.application.OrderService;
import jpaeoi.infrastructure.persistence.JpaOrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    public OrderService orderService(JpaOrderRepository jdbcOrderRepository) {
        return new OrderService(jdbcOrderRepository);
    }
}
