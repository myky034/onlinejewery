package online.jewery.onlinejewery.Service;

import java.util.List;

import online.jewery.onlinejewery.Model.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    void saveProduct(Product product);
    void deleteProductById(String id);
}
