package api.Service;

import api.Entities.Meal;
import api.DAL.MealRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MealService {
    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public ArrayList<Meal> getAllMeals() {
        return new ArrayList<Meal>();
    }
}
