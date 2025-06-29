package jpaeoi.gardening.infrastructure.persistence;

import jpaeoi.gardening.application.OrderRepository;
import jpaeoi.gardening.application.exception.DataOperationException;
import jpaeoi.gardening.domain.Order;
import jpaeoi.gardening.infrastructure.persistence.model.PedidoJpa;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaOrderRepository extends ListCrudRepository<PedidoJpa, Integer>, OrderRepository {

    @Override
    default void saveOrder(Order order) throws DataOperationException {
        save(PedidoJpa.fromDomain(order));
    }

    @Override
    default List<Order> findAllOrders() throws DataOperationException {
        return findAll().stream()
                .sorted(Comparator.comparing(PedidoJpa::getCodigoPedido))
                .map(PedidoJpa::toDomain)
                .toList();
    }

    @Override
    default Optional<Order> findOrderById(int id) throws DataOperationException {
        return findById(id).map(PedidoJpa::toDomain);
    }

    @Override
    default void updateOrder(Order order) throws DataOperationException {
        save(PedidoJpa.fromDomain(order));
    }

    @Override
    default void deleteOrderById(int id) throws DataOperationException {

    }
}
