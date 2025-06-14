package jpaeoi.infrastructure.controller.model;

import jpaeoi.application.ProductLineService;
import jpaeoi.infrastructure.persistence.JpaProductLineRepository;
import jpaeoi.infrastructure.persistence.JpaProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductLineConfiguration {

    @Bean
    public ProductLineService productLineService(
            JpaProductLineRepository jdbcProductLineRepository,
            JpaProductRepository jdbcProductRepository
    ) {
        return new ProductLineService(jdbcProductLineRepository, jdbcProductRepository);
    }
}
