package api.Controllers;

import api.Entities.Category;
import api.Entities.Meal;
import api.Models.MealModel;
import api.Service.CategoryService;
import api.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MealController {
    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping(value = "/overview", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity SendAllMealsToIPad(@Valid @RequestBody MealModel mealModel) {
        return ResponseEntity.ok(mealModel);
    }

    @PostMapping(value = "/addmeal")
    public ResponseEntity addMeal(@Valid @RequestBody MealModel mealModel) {
        try {
            Meal newMeal = new Meal();
            newMeal.setName(mealModel.getName());
            newMeal.setPrice(mealModel.getPrice());
            mealService.AddMeal(newMeal);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getmealsbycategory/{id}")
    public Optional<Set<Meal>> GetMealsByCategory(@Valid @PathVariable int id) {
        try {
            return mealService.GetAllMealsByCategory(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }


}
