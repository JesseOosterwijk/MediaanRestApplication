package api.Service;

import api.DAL.MealRepository;
import api.Entities.Category;
import api.Entities.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class MealService {
    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void AddMeal(Meal meal) {
        try {
            mealRepository.save(meal);
        } catch(Exception e) {
            throw e;
        }
    }

    public void GetAllMeals() {
        try {
            mealRepository.findAll();
        } catch(Exception e) {
            throw e;
        }
    }

    public Optional<Set<Meal>> GetAllMealsByCategory(Category category) {
        try {
            return mealRepository.findAllByCategory(category);
        } catch (Exception e) {
            throw e;
        }
    }
}
