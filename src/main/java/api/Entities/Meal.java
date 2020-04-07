package api.Entities;

import java.util.UUID;

public class Meal {
    private UUID id;
    private String name;
    private double Price;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return Price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
