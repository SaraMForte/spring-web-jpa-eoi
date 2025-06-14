package jpaeoi.infrastructure.persistence;

import jpaeoi.application.ProductRepository;
import jpaeoi.domain.Product;
import jpaeoi.infrastructure.persistence.model.ProductoJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductoJpa, String>, ProductRepository {

    @Override
    default List<Product> findAllProducts() {
        return null;
    }

    @Override
    default Product findProductById(String id) {
        return null;
    }

    @Override
    default void saveProduct(Product product) {

    }

    @Override
    default void updateProduct(Product product) {

    }

    @Override
    default void deleteProduct(String id) {

    }
}
