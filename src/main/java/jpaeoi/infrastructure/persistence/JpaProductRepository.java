package jpaeoi.infrastructure.persistence;

import jpaeoi.application.ProductRepository;
import jpaeoi.domain.Product;
import jpaeoi.infrastructure.persistence.model.ProductoJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductRepository extends
        JpaRepository<ProductoJpa, String>,
        ProductRepository {

    @Override
    @Query("""
            SELECT
                codigo_producto AS "product_code",
                nombre AS "name",
                gama AS "product_line",
                dimensiones AS "dimensions",
                proveedor AS "supplier",
                descripcion AS "description",
                cantidad_en_stock AS "quantity_in_stock",
                precio_venta AS "sale_price",
                precio_proveedor AS "supplier_price"
            FROM producto
            WHERE
                activo = true
            """)
    List<Product> findAllProducts();

    @Override
    @Query("""
            SELECT
                codigo_producto AS "product_code",
                nombre AS "name",
                gama AS "product_line",
                dimensiones AS "dimensions",
                proveedor AS "supplier",
                descripcion AS "description",
                cantidad_en_stock AS "quantity_in_stock",
                precio_venta AS "sale_price",
                precio_proveedor AS "supplier_price"
            FROM producto
            WHERE
                codigo_producto = :id
            """)
    Product findProductById(@Param("id") String id);

    @Override
    @Modifying
    @Query("""
               INSERT INTO producto
                   (
                    codigo_producto,
                    nombre,
                    gama,
                    dimensiones,
                    proveedor,
                    descripcion,
                    cantidad_en_stock,
                    precio_venta,
                    precio_proveedor
                    )
               VALUES
                   (
                    :#{#product.productCode},
                    :#{#product.name},
                    :#{#product.productLine},
                    :#{#product.dimensions},
                    :#{#product.supplier},
                    :#{#product.description},
                    :#{#product.quantityInStock},
                    :#{#product.salePrice},
                    :#{#product.supplierPrice}
                    )
            """)
    void saveProduct(@Param("product") Product product);

    @Override
    @Modifying
    @Query("""
            UPDATE producto
            SET
                nombre = :#{#product.name},
                gama = :#{#product.productLine},
                dimensiones = :#{#product.dimensions},
                proveedor = :#{#product.supplier},
                descripcion = :#{#product.description},
                cantidad_en_stock = :#{#product.quantityInStock},
                precio_venta = :#{#product.salePrice},
                precio_proveedor = :#{#product.supplierPrice}
            WHERE
                codigo_producto = :#{#product.productCode}
            """)
    void updateProduct(Product product);

    @Override
    @Modifying
    @Query("""
            UPDATE producto
            SET
                activo = false
            WHERE
                codigo_producto = :id
            """)
    void deleteProduct(@Param("id") String id);
}
