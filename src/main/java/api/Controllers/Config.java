package api.Controllers;

import api.DAL.MealRepository;
import api.DAL.OrderRepository;
import api.Entities.Meal;
import api.Service.MealService;
import api.Service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Config {

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("dbi398785");
        dataSource.setPassword("123");
        dataSource.setUrl("jdbc:mysql://studmysql01.fhict.local:3306/dbi398785");
        return dataSource;
    }

    @Bean
    public MealRepository mealRepository(JdbcTemplate con) {
        return new MealRepository(con);
    }

    @Bean
    public OrderRepository orderRepository(JdbcTemplate con) {
        return new OrderRepository(con);
    }

    @Bean
    public MealService mealService(MealRepository meal) {
        return new MealService(meal);
    }

    @Bean
    public OrderService orderService(OrderRepository order) {
        return new OrderService(order);
    }
}
