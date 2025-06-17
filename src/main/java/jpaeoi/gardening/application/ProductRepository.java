package jpaeoi.gardening.application;

import jpaeoi.gardening.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAllProducts();

    Product findProductById(String id);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(String id);
}
