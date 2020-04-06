package api.Models;

import api.Entities.Meal;

import java.util.ArrayList;

public class OrderModel {


    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    private ArrayList<Meal> mealList;
}
