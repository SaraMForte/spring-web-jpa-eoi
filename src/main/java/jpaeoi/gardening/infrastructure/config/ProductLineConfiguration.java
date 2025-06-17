package jpaeoi.gardening.infrastructure.config;

import jpaeoi.gardening.application.ProductLineService;
import jpaeoi.gardening.infrastructure.persistence.JpaProductLineRepository;
import jpaeoi.gardening.infrastructure.persistence.JpaProductRepository;
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
