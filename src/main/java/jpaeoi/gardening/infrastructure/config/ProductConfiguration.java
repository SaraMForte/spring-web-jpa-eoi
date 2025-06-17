package jpaeoi.gandening.infrastructure.config;

import jpaeoi.gandening.application.ProductService;
import jpaeoi.gandening.infrastructure.persistence.JpaProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public ProductService productService(JpaProductRepository jdbcProductRepository) {
        return new ProductService(jdbcProductRepository);
    }
}
