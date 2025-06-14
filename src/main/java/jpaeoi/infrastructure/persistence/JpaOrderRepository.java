package jpaeoi.infrastructure.persistence;

import jpaeoi.application.OrderRepository;
import jpaeoi.application.exception.DataOperationException;
import jpaeoi.domain.Order;
import jpaeoi.infrastructure.persistence.model.PedidoJpa;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaOrderRepository extends ListCrudRepository<PedidoJpa, Integer>, OrderRepository {

    @Override
    default void saveOrder(Order order) throws DataOperationException {

    }

    @Override
    default List<Order> findAllOrders() throws DataOperationException {
        return null;
    }

    @Override
    default Optional<Order> findOrderById(int id) throws DataOperationException {
        return null;
    }

    @Override
    default void updateOrder(Order order) throws DataOperationException {

    }

    @Override
    default void deleteOrderById(int id) throws DataOperationException {

    }
}
