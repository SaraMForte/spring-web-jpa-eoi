package jpaeoi.infrastructure.config;

import jpaeoi.application.ProductService;
import jpaeoi.infrastructure.persistence.JpaProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public ProductService productService(JpaProductRepository jdbcProductRepository) {
        return new ProductService(jdbcProductRepository);
    }
}
