package online.jewery.onlinejewery.Service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.jewery.onlinejewery.Model.User;
import online.jewery.onlinejewery.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }
    @Override
    public void deleteUserById(String id) {
        this.userRepository.deleteById(id);
    }
    @Override
    public User getUserById(String id) {
        Optional<User> optional = userRepository.findById(id);
        User User = null;
        if(optional.isPresent()) {
            User = optional.get();
        }else {
            throw new RuntimeErrorException(null, "User not found for id :: " + id);
        }
        return User;
    }
}
