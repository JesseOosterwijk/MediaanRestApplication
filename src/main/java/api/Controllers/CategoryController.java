package api.Controllers;

import api.Entities.Category;
import api.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/addcategory")
    public ResponseEntity AddNewCategory(@Valid @RequestBody Category category) {
        try {
            categoryService.AddCategory(category);
            return ResponseEntity.ok(category);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/deletecategory")
    public ResponseEntity DeleteCategory(@Valid @RequestBody Category category) {
        try {
            categoryService.DeleteCategory(category);
            return ResponseEntity.ok(category);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getcategories")
    public ResponseEntity GetAllCategories() {
        try {
            return new ResponseEntity(categoryService.GetAllCategories(), HttpStatus.OK);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
