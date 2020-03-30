package REST.Service;

import REST.Entities.Meal;
import REST.Repositories.MealRepository;
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
