package REST.Models;

import REST.Entities.Tag;

import java.util.ArrayList;
import java.util.UUID;

public class MealModel {

    private UUID MealId;
    private int Price;
    private String Name;
    private String Description;
    private ArrayList<Tag> Allergens;

    public MealModel(UUID mealId, int price, String name, String description, ArrayList<Tag> allergens) {
        MealId = mealId;
        Price = price;
        Name = name;
        Description = description;
        Allergens = allergens;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<Tag> getAllergens() {
        return Allergens;
    }

    public void setAllergens(ArrayList<Tag> allergens) {
        Allergens = allergens;
    }
}
