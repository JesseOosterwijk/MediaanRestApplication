package com.example.messagingstompwebsocket.models;

import java.util.Collection;

public class Order {

	public Integer table;
	public Collection<Meal> mealList;
	
	public Integer getTable() {
		return table;
	}
	public void setTable(Integer table) {
		this.table = table;
	}
	public Collection<Meal> getMealList() {
		return mealList;
	}
	public void setMealList(Collection<Meal> mealList) {
		this.mealList = mealList;
	}
	
}
