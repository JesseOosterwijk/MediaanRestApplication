package api.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value = { "Orders" })
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

    @NotBlank
    @Column(name = "Description")
    private String description;

    @NotBlank
    @Column(name = "file_path")
    private String image;

    @JsonIgnore
    @ManyToMany(mappedBy = "Meals", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Order> Orders = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "recipe_tag",
            joinColumns = {@JoinColumn(name = "meal_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> Tags = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        return Orders;
    }

    @JsonIgnore
    public Set<Tag> getTags() {
        return Tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonIgnore
    public void setOrders(Set<Order> orders) {
        Orders = orders;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public String getDescription() {
        return description;
    }

    @JsonIgnore
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public void setTags(Set<Tag> tags) {
        Tags = tags;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String filepath) {
        this.image = filepath;
    }

    @JsonIgnore
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
