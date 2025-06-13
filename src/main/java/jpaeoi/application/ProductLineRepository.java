package jpaeoi.application;

import jpaeoi.domain.ProductLine;

import java.util.List;
import java.util.Optional;

public interface ProductLineRepository {

    List<ProductLine> findAllProductLines();

    Optional<ProductLine> findProductLinetById(String id);

    void saveProductLine(ProductLine productLine);

    void updateProductLine(ProductLine productLine);

    void deleteProductLine(String id);
}
