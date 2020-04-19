package com.example.messagingstompwebsocket.models;

import java.util.Collection;

public class OrderModel {

	public Integer tableNr;
	public Collection<Meal> mealList;
	
	public Integer getTableNr() {
		return tableNr;
	}
	public void setTableNr(Integer tableNr) {
		this.tableNr = tableNr;
	}
	public Collection<Meal> getMealList() {
		return mealList;
	}
	public void setMealList(Collection<Meal> mealList) {
		this.mealList = mealList;
	}
	
	
}
