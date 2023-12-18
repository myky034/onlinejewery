package online.jewery.onlinejewery.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class OnlinejeweryController {
    @RequestMapping("/homepage")
    public String home() {
        return "homepage/index.html";
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
