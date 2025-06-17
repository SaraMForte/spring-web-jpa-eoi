package jpaeoi.gardening.infrastructure.persistence;

import jpaeoi.gardening.application.ClientRepository;
import jpaeoi.gardening.application.exception.DataOperationException;
import jpaeoi.gardening.domain.Client;
import jpaeoi.gardening.infrastructure.persistence.model.ClienteJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaClientRepository extends JpaRepository<ClienteJpa, Integer>, ClientRepository {

    @Override
    default List<Client> findAllClients() throws DataOperationException {
        return findAll().stream()
                .map(ClienteJpa::toDomain)
                .toList();
    }

    @Override
    default void saveClient(Client client) throws DataOperationException {
        save(ClienteJpa.fromDomain(client));
    }

    @Override
    default Optional<Client> findClientById(int id) throws DataOperationException {
        return findById(id).map(ClienteJpa::toDomain);
    }

    @Override
    default void updateClient(Client client) throws DataOperationException {
        save(ClienteJpa.fromDomain(client));
    }

    @Override
    default void deleteClientById(int id) throws DataOperationException {

    }
}
