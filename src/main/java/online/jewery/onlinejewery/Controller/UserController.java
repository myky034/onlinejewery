package online.jewery.onlinejewery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import online.jewery.onlinejewery.Model.User;
import online.jewery.onlinejewery.Service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
     @GetMapping("/users")
    public String viewListUser(Model  model) {
        model.addAttribute("listUser", userService.getAllUsers());
        return "admin/users";
    }
    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/new_user";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        //save user to db
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/showFormUserForUpdate/{id}")
    public String showFormUserForUpdate(@ModelAttribute(value = "id") String id, Model model) {
        //get user from the service
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/update_user";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") String id) {
        //call delete user method
        this.userService.deleteUserById(id);
        return "redirect:/users";
    }
}
