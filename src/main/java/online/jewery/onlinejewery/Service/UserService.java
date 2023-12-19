package online.jewery.onlinejewery.Service;

import java.util.List;

import online.jewery.onlinejewery.Model.User;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(String id);
    
    void saveUser(User user);
    
    void deleteUserById(String id);
}
