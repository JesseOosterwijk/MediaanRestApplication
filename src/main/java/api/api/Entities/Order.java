package api.api.Entities;

import api.Entities.Meal;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sessions")
    private long SessionId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "meal_order",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "meal_id")}
    )
    private Set<Meal> Meals = new HashSet<>();

    public void addMeal(Meal meal) {
        Meals.add(meal);
        meal.getOrders().add(this);
    }

    public Set<Meal> getMeals() {
        return Meals;
    }

    public long getId() {
        return id;
    }

    public long getSessionId() {
        return SessionId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSessionId(long sessionId) {
        SessionId = sessionId;
    }
}
