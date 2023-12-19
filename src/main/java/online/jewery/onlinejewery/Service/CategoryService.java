package online.jewery.onlinejewery.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import online.jewery.onlinejewery.Model.Category;



public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(String id);
    
    void saveCategory(Category category);
    
    void deleteCategoryById(String id);

    Page<Category> findPaginated(int pageNo, int pageSize);
}
