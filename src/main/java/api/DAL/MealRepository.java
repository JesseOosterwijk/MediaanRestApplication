package api.DAL;

import api.Entities.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MealRepository {
    private final JdbcTemplate con;

    public MealRepository(JdbcTemplate con) { this.con = con; }

    public void addMeal(Meal meal) {
        String query = "INSERT INTO meal (Name, Price) VALUES (?,?)";
        con.update(query, meal.getName(), meal.getPrice());
    }
}
