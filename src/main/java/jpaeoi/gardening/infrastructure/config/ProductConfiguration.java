package jpaeoi.gardening.infrastructure.config;

import jpaeoi.gardening.application.ProductService;
import jpaeoi.gardening.infrastructure.persistence.JpaProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public ProductService productService(JpaProductRepository jdbcProductRepository) {
        return new ProductService(jdbcProductRepository);
    }
}
