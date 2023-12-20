package online.jewery.onlinejewery.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OnlinejeweryController {
    @RequestMapping("/login")
    public String login() {
        return "admin/login.html";
    }

    @RequestMapping("/register")
    public String register() {
        return "admin/register";
    }

    @RequestMapping("/products")
    public String products() {
        return "homepage/products.html";
    }

    @RequestMapping("/admin")
    public String index() {
        return "admin/index";
    }

}
