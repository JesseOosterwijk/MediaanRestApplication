package api.DAL;

import api.Entities.Meal;
import org.springframework.jdbc.core.JdbcTemplate;

public class MealRepository {

    private JdbcTemplate connection;

    public MealRepository(JdbcTemplate con) { this.connection = con; }

    public void addMeal(Meal meal) {
        String query = "INSERT INTO meal (Name, Price) VALUES (?,?)";
        connection.update(query, meal.getName(), meal.getPrice());
    }
}
