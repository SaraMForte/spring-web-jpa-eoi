package jpaeoi.gardening.infrastructure.persistence;

import jpaeoi.gardening.application.ProductLineRepository;
import jpaeoi.gardening.domain.ProductLine;
import jpaeoi.gardening.infrastructure.persistence.model.GamaProductoJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaProductLineRepository extends JpaRepository<GamaProductoJpa, String>, ProductLineRepository {
    @Override
    default List<ProductLine> findAllProductLines() {
        return null;
    }

    @Override
    default Optional<ProductLine> findProductLinetById(String id) {
        return null;
    }

    @Override
    default void saveProductLine(ProductLine productLine) {

    }

    @Override
    default void updateProductLine(ProductLine productLine) {

    }

    @Override
    default void deleteProductLine(String id) {

    }
}
