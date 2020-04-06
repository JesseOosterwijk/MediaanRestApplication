package api.Service;

import api.Entities.Meal;
import api.DAL.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class MealService {
    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) { this.mealRepository = mealRepository;
    }

    public Optional<ArrayList<Meal>> getAllMeals(UUID id) {
        return mealRepository.findAllMeals(id);
    }
}
