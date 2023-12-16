package online.jewery.onlinejewery.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import online.jewery.onlinejewery.Model.UserComponent;
import online.jewery.onlinejewery.Model.UserModel;
import online.jewery.onlinejewery.Repository.UserRepo;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    UserComponent userComponent;

    // Save method is predefine method in Mongo Repository
    // with this method we will save user in our database
    @PostMapping("/addUser")
    public UserModel addUser(@RequestBody UserModel user) {
        System.out.println(user);
        return userRepo.save(user);
    }

    // findAll method is predefine method in Mongo Repository
    // with this method we will all user that is save in our database
    @GetMapping("/getAllUser")
    public List<UserModel> getAllUser() {
        return userRepo.findAll();
    }
}
