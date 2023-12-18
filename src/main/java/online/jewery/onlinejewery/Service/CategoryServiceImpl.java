package online.jewery.onlinejewery.Service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.jewery.onlinejewery.Model.Category;
import online.jewery.onlinejewery.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public void saveCategory(Category category) {
        this.categoryRepository.save(category);
    }
    @Override
    public void deleteCategoryById(String id) {
        this.categoryRepository.deleteById(id);
    }
    @Override
    public Category getCategoryById(String id) {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = null;
        if(optional.isPresent()) {
            category = optional.get();
        }else {
            throw new RuntimeErrorException(null, "Category not found for id :: " + id);
        }
        return category;
    }
}
