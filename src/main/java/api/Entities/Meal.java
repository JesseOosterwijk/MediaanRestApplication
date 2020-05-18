package api.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Meal")
public class Meal {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotBlank
    @Column(name = "Name")
    private String name;

    @NotBlank
    @Column(name = "Price")
    private double price;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "meal_order",
            joinColumns = {@JoinColumn(name = "MealId")},
            inverseJoinColumns = {@JoinColumn(name = "OrderID")}
    )
    private Set<Order> Orders = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "recipe_tag",
            joinColumns = {@JoinColumn(name = "MealId")},
            inverseJoinColumns = {@JoinColumn(name = "TagId")}
    )

    private Set<Tag> Tags = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Set<Order> getOrders() {
        return Orders;
    }

    public Set<Tag> getTags() {
        return Tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOrders(Set<Order> orders) {
        Orders = orders;
    }
}
