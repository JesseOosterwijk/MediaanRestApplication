package api.Service;

import api.DAL.MealRepository;
import api.Entities.Meal;
import api.Models.MealModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) { this.mealRepository = mealRepository;
    }

    public void addMeal(Meal meal) {
        try {
            mealRepository.save(meal);
        } catch(Exception e) {
            throw e;
        }
    }

    public List<MealModel> GetAllMeals() {
        try {
            List<Meal> meals = mealRepository.findAll();
            List<MealModel> mealModels = new ArrayList<>();
            for (int i = 0; i < meals.size(); i++) {
                Meal m = meals.get(i);
                MealModel mm = new MealModel(m.getId(), m.getPrice(), m.getName());
                mealModels.add(mm);
            }
            return mealModels;
        } catch(Exception e) {
            throw e;
        }
    }
}
