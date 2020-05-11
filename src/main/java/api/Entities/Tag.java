package api.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tag")
public class Tag {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "Name")
    private String name;

    @ManyToMany(mappedBy = "Tags")
    private Set<Meal> Meals = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Meal> getMeals() {
        return Meals;
    }

    public void addMeal(Meal meal) {
        Meals.add(meal);
        meal.getTags().add(this);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
