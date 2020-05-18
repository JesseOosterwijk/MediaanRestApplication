package api.api.Controllers;

import api.Entities.Meal;
import api.Models.MealModel;
import api.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MealController {
    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/overview", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity SendAllMealsToIPad(@Valid @RequestBody MealModel mealModel) {
        return ResponseEntity.ok(mealModel);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/addmeal")
    public ResponseEntity addMeal(@Valid @RequestBody MealModel mealModel) {
        try {
            Meal newMeal = new Meal();
            newMeal.setName(mealModel.getName());
            newMeal.setPrice(mealModel.getPrice());
            mealService.addMeal(newMeal);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
