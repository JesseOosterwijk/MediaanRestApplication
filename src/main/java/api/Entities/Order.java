package api.Entities;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "session_id")
    private int SessionId;

    @Column(name = "order_time")
    private LocalTime orderTime;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderMeal> orderMeals = new HashSet<>();

/*
    public void addMeal(Meal meal) {
        Meals.add(meal);
        meal.getOrders().add(this);
    }
*/

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public Set<OrderMeal> getOrderMeals() {
        return orderMeals;
    }

    public void setOrderMeals(Set<OrderMeal> meals) {
        this.orderMeals = meals;
    }

    public long getId() {
        return id;
    }

    public long getSessionId() {
        return SessionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSessionId(int sessionId) {
        SessionId = sessionId;
    }
}
