package api.api.Models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class MealModel {

    @NotNull(message = "please enter price")
    private int Price;

    @NotEmpty(message = "please enter name")
    private String Name;

    //@NotEmpty(message = "please enter description")
    private String Description;


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
}
