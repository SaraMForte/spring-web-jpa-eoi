package jpaeoi.gardening.infrastructure.persistence;

import jpaeoi.gardening.application.ProductRepository;
import jpaeoi.gardening.domain.Product;
import jpaeoi.gardening.infrastructure.persistence.model.ProductoJpa;
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
