package api.DAL;

import api.Entities.Category;
import api.Entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
    Optional<Set<Meal>> findAllByCategoryId(int id);
}
