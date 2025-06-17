package jpaeoi.gardening.infrastructure.config;

import jpaeoi.gardening.application.ClientService;
import jpaeoi.gardening.domain.Client;
import jpaeoi.shared.infrastructure.genericcontroller.GenericControllerConfig;
import jpaeoi.gardening.infrastructure.controller.model.ClienteDto;
import jpaeoi.gardening.infrastructure.controller.model.ClienteDtoMapper;
import jpaeoi.shared.infrastructure.genericcontroller.DtoMapper;
import jpaeoi.gardening.infrastructure.persistence.JpaClientRepository;
import jpaeoi.gardening.infrastructure.persistence.JpaOrderRepository;
import jpaeoi.shared.infrastructure.generictable.GenericTable;
import jpaeoi.shared.infrastructure.generictable.GenericTableFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class ClientConfiguration {

    @Bean
    public ClientService clientService(
            JpaClientRepository jdbcClientRepository,
            JpaOrderRepository jdbcOrderRepository
    ) {
        return new ClientService(jdbcClientRepository, jdbcOrderRepository);
    }

    @Bean(name = "clientControllerConfig")
    public GenericControllerConfig<Client, ClienteDto> genericControllerConfig(ClientService clientService, ClienteDtoMapper mapper) {
        return new GenericControllerConfig<Client, ClienteDto>() {

            @Override
            public List<Client> findDomainAll() {
                return clientService.findAll();
            }

            @Override
            public Optional<Client> findDomainById(String id) {
                return clientService.findById(Integer.parseInt(id));
            }

            @Override
            public void saveDomain(Client domain) {
                clientService.save(domain);
            }

            @Override
            public void updateDomain(Client domain) {
                clientService.update(domain);
            }

            @Override
            public void deleteDomainById(String id) {
                clientService.deleteById(Integer.parseInt(id));
            }

            @Override
            public DtoMapper<Client, ClienteDto> mapper() {
                return mapper;
            }

            @Override
            public GenericTable getTable(List<ClienteDto> entities) {
                return GenericTableFactory.create(entities, ClienteDto.class);
            }
        };
    }
}
