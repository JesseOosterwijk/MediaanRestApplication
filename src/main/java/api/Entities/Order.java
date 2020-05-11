package api.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "SessionId")
    private long SessionId;

    @ManyToMany(mappedBy = "Orders", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
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
