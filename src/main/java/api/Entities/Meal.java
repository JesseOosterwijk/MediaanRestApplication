package api.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Meal")
public class Meal {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Price")
    private double price;

    @NotNull
    @Column(name = "Description")
    private String description;

    @ManyToMany(mappedBy = "Meals", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Order> Orders = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "recipe_tag",
            joinColumns = {@JoinColumn(name = "meal_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )

    private Set<Tag> Tags = new HashSet<>();

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(Set<Tag> tags) {
        Tags = tags;
    }
}
