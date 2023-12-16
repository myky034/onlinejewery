package online.jewery.onlinejewery.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import online.jewery.onlinejewery.Model.UserModel;

public interface UserRepo extends MongoRepository<UserModel, String> {
    // Optional<UserModel> findItemByName(String name);
}
