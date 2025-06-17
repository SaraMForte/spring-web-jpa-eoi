package jpaeoi.gandening.application;


import jpaeoi.gandening.application.exception.DataDeleteException;
import jpaeoi.gandening.domain.Order;

import java.util.List;

public class ClientDeleteUseCase {

    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;

    public ClientDeleteUseCase(ClientRepository clientRepository, OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
    }

    public void deleteClient(int id) throws DataDeleteException {
        List<Order> orders = orderRepository.findAllOrders()
                .stream()
                .filter(order -> id == order.client().clientCode())
                .toList();

        if (!orders.isEmpty()) {
            throw new DataDeleteException("Client has orders and cannot be deleted");
        } else {
            clientRepository.deleteClientById(id);
        }
    }
}