package api.DAL;

import api.Entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MealRepository extends JpaRepository<Meal, UUID> {
    Optional<Meal> findMealByName(String name);
    Optional<ArrayList<Meal>> findAllMeals(UUID id);
}
