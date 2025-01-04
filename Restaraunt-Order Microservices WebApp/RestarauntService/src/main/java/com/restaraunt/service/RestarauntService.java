package com.restaraunt.service;

import com.restaraunt.entities.Restaraunt;

public interface RestarauntService {

	public Restaraunt showByLocation(String location);
	public Restaraunt showByName(String name);
	public Restaraunt showByBudget(String budget);
	public Restaraunt showByCuisine(String cuisine);
	public Restaraunt showByDistance(String distance);
}
