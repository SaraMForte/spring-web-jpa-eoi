package jpaeoi.application;

import jpaeoi.application.exception.DataOperationException;
import jpaeoi.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    void saveOrder(Order order) throws DataOperationException;

    List<Order> findAllOrders() throws DataOperationException;

    Optional<Order> findOrderById(int id) throws DataOperationException;

    void updateOrder(Order order) throws DataOperationException;

    void deleteOrderById(int id) throws DataOperationException;
}
