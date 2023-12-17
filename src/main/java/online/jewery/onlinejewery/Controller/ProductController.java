package online.jewery.onlinejewery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import online.jewery.onlinejewery.Model.Category;
import online.jewery.onlinejewery.Model.Product;
import online.jewery.onlinejewery.Service.CategoryService;
import online.jewery.onlinejewery.Service.ProductService;


@Controller
public class ProductController {
    @Autowired
    private ProductService producutService;
    @Autowired 
    private CategoryService categoryService;

    @GetMapping("/products")
    public String viewProduct(Model  model) {
        model.addAttribute("listProducts", producutService.getAllProducts());
        return "admin/products";
    }
    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        List<Category> categories = this.categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute( "product",product);
        return "admin/new_product";
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        //save product to db
        try {
            producutService.saveProduct(product);
            
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("error save product:: " + e);
        }
        return "redirect:/products";
    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") String id) {
        //call delete product method
        this.producutService.deleteProductById(id);
        return "redirect:/products";
    }
}
