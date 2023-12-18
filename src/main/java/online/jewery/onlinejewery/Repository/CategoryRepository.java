package online.jewery.onlinejewery.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import online.jewery.onlinejewery.Model.Category;



@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    
}
