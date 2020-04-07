package api.DAL;

import api.Entities.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class OrderRepository {

    private JdbcTemplate con;

    public OrderRepository(JdbcTemplate con) { this.con = con; }

    public void saveOrder(Order order) {
        String query = "INSERT INTO 'Order' ([sessionId]) Values (?)";

        con.update(query, order.getSessionId());
    }

    public void linkMealsToOrder(Order order) {

    }
}
