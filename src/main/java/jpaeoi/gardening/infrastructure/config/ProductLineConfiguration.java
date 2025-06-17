package jpaeoi.gandening.infrastructure.config;

import jpaeoi.gandening.application.ProductLineService;
import jpaeoi.gandening.infrastructure.persistence.JpaProductLineRepository;
import jpaeoi.gandening.infrastructure.persistence.JpaProductRepository;
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
