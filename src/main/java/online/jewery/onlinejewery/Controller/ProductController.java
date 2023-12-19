package online.jewery.onlinejewery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public String viewProduct(Model model) {
        return findPaginated(1, model);
    }

    @GetMapping("/homepage")
    public String viewProductUser(Model model) {
        model.addAttribute("listProducts", producutService.getAllProducts());
        return "homepage/index";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        List<Category> categories = this.categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "admin/new_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        // save product to db
        try {
            producutService.saveProduct(product);

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("error save product:: " + e);
        }
        return "redirect:/products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") String id) {
        // call delete product method
        this.producutService.deleteProductById(id);
        return "redirect:/products";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;
        Page<Product> page = producutService.findPaginated(pageNo, pageSize);
        List<Product> listProducts = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listProducts", listProducts);
        return "admin/products";
    }

}
