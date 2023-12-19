package online.jewery.onlinejewery.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import online.jewery.onlinejewery.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    
}
