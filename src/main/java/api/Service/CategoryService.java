package api.Service;

import api.DAL.CategoryRepository;
import api.Entities.Category;
import api.Entities.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void AddCategory(Category category) {
        try {
            categoryRepository.save(category);
        } catch(Exception e) {
            throw e;
        }
    }

    public List<Category> GetAllCategories() {
        try {
            return categoryRepository.findAll();
        } catch(Exception e) {
            throw e;
        }
    }

    public void DeleteCategory(Category category) {
        try {
            categoryRepository.delete(category);
        } catch(Exception e) {
            throw e;
        }
    }
}
