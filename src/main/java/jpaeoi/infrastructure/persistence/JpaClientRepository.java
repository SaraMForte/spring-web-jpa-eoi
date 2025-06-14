package jpaeoi.infrastructure.persistence;

import jpaeoi.application.ClientRepository;
import jpaeoi.application.exception.DataOperationException;
import jpaeoi.domain.Client;
import jpaeoi.infrastructure.persistence.model.ClienteJpa;
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
    }

    @Override
    default Optional<Client> findClientById(int id) throws DataOperationException {
        return Optional.empty();
    }

    @Override
    default void updateClient(Client client) throws DataOperationException {

    }

    @Override
    default void deleteClientById(int id) throws DataOperationException {

    }
}
