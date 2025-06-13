package jpaeoi.infrastructure.persistence;

import jpaeoi.application.ProductLineRepository;
import jpaeoi.domain.ProductLine;
import jpaeoi.infrastructure.persistence.model.GamaProductoJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaProductLineRepository extends JpaRepository<GamaProductoJpa, String>, ProductLineRepository {

    @Override
    @Modifying
    @Query("""
            UPDATE gama_producto
            SET
                activo = false
            WHERE
                gama = :id
            """)
    void deleteProductLine(@Param("id") String id);

    @Override
    default void updateProductLine(ProductLine productLine) {
        save(GamaProductoJpa.fromDomain(productLine));
    }

    @Override
    @Modifying
    @Query("""
            INSERT INTO gama_producto
                (
                gama,
                descripcion_texto,
                descripcion_html,
                imagen
                 )
            VALUES
                (
                 :#{#productLine.line},
                 :#{#productLine.textDescription},
                 :#{#productLine.htmlDescription},
                 :#{#productLine.image}
                  )
            """)
    void saveProductLine(ProductLine productLine);

    @Override
    default Optional<ProductLine> findProductLinetById(String id) {
        return findById(id).map(GamaProductoJpa::toDomain);
    }

    @Override
    default List<ProductLine> findAllProductLines() {
        return findAll().stream()
                .filter(GamaProductoJpa::activo)
                .sorted(Comparator.comparing(GamaProductoJpa::gama))
                .map(GamaProductoJpa::toDomain)
                .toList();
    }
}
