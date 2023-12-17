package online.jewery.onlinejewery.Service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.jewery.onlinejewery.Model.Product;
import online.jewery.onlinejewery.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if(optional.isPresent()) {
            product = optional.get();
        }else {
            throw new RuntimeErrorException(null, "Product not found for id :: " + id);
        }
        return product;
    }
    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }
    @Override
    public void deleteProductById(String id) {
        this.productRepository.deleteById(id);
    }
}
