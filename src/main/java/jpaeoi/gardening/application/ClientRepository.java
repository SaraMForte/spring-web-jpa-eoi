package jpaeoi.gandening.application;

import jpaeoi.gandening.application.exception.DataOperationException;
import jpaeoi.gandening.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    void saveClient(Client client) throws DataOperationException;

    List<Client> findAllClients() throws DataOperationException;

    Optional<Client> findClientById(int id) throws DataOperationException;

    void updateClient(Client client) throws DataOperationException;

    void deleteClientById(int id) throws DataOperationException;
}
