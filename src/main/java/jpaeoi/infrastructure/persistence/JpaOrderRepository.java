package jpaeoi.infrastructure.persistence;

import jakarta.transaction.Transactional;
import jpaeoi.application.OrderRepository;
import jpaeoi.application.exception.DataOperationException;
import jpaeoi.domain.Order;
import jpaeoi.infrastructure.persistence.model.PedidoJpa;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaOrderRepository extends ListCrudRepository<PedidoJpa, Integer>, OrderRepository {

    @Override
    @Modifying
    @Query("""
            UPDATE pedido
            SET
                activo = false
            WHERE
                codigo_pedido = :id
            """)
    void deleteOrderById(@Param("id") int id) throws DataOperationException;

    @Override
    default void updateOrder(Order order) throws DataOperationException {
        save(PedidoJpa.fromDomain(order));
    }

    @Override
    default Optional<Order> findOrderById(int id) throws DataOperationException {
        return findById(id).map(PedidoJpa::toDomain);
    }

    @Override
    @Transactional
    default List<Order> findAllOrders() throws DataOperationException {
        return findAll().stream()
                .filter(PedidoJpa::activo)
                .sorted(Comparator.comparingInt(PedidoJpa::codigoPedido))
                .map(PedidoJpa::toDomain)
                .toList();
    }

    @Override
    @Modifying
    @Query("""
            INSERT INTO pedido
                (
                 codigo_pedido,
                 fecha_pedido,
                 fecha_esperada,
                 fecha_entrega,
                 estado,
                 comentarios,
                 codigo_cliente
                 )
            VALUES
                (
                 :#{#order.orderCode},
                 :#{#order.orderDate},
                 :#{#order.expectedDate},
                 :#{#order.deliveryDate},
                 :#{#order.status},
                 :#{#order.comment},
                 :#{#order.clientCode}
                  )
            """)
    void saveOrder(Order order) throws DataOperationException;
}
