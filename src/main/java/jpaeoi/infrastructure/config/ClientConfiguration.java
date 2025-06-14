package jpaeoi.infrastructure.config;

import jpaeoi.application.ClientService;
import jpaeoi.infrastructure.persistence.JpaClientRepository;
import jpaeoi.infrastructure.persistence.JpaOrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public ClientService clientService(
            JpaClientRepository jdbcClientRepository,
            JpaOrderRepository jdbcOrderRepository
    ) {
        return new ClientService(jdbcClientRepository, jdbcOrderRepository);
    }
}
