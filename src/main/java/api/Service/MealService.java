package api.Service;

import api.DAL.MealRepository;
import api.Entities.Meal;

public class MealService {
    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) { this.mealRepository = mealRepository;
    }

    public void addMeal(Meal meal) {
        try {
            mealRepository.addMeal(meal);
        } catch(Exception e) {
            throw e;
        }
    }
}
