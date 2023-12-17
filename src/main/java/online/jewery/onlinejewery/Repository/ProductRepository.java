package online.jewery.onlinejewery.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import online.jewery.onlinejewery.Model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
    
}
