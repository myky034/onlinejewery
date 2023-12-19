package online.jewery.onlinejewery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import online.jewery.onlinejewery.Model.Category;
import online.jewery.onlinejewery.Model.Product;
import online.jewery.onlinejewery.Service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // displat list of category
    @GetMapping("/category")
    public String viewListCategory(Model model) {
        model.addAttribute("listCategories", categoryService.getAllCategories());
        return "admin/category";
    }

    @GetMapping("/showNewCategoryForm")
    public String showNewCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/new_category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") Category category) {
        // save category to db
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@ModelAttribute(value = "id") String id, Model model) {
        // get category from the service
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "admin/update_category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable(value = "id") String id) {
        // call delete category method
        this.categoryService.deleteCategoryById(id);
        return "redirect:/category";
    }

    @GetMapping("/category/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;
        Page<Category> page = categoryService.findPaginated(pageNo, pageSize);
        List<Category> listCategories = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listCategories", listCategories);
        return "admin/category";
    }

}
