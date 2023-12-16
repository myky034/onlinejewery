package online.jewery.onlinejewery.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OnlinejeweryController {
    @RequestMapping("/admin/index")
    public String index() {
        return "admin/index.html";
    }

    @RequestMapping("/admin/product")
    public String product() {
        return "admin/product.html";
    }
}
