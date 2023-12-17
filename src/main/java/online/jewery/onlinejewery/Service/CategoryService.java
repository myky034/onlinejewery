package online.jewery.onlinejewery.Service;

import java.util.List;


import online.jewery.onlinejewery.Model.Category;


public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(String id);
    //Category getCategoryById(String id);
    void saveCategory(Category category);
    void deleteCategoryById(String id);
}
