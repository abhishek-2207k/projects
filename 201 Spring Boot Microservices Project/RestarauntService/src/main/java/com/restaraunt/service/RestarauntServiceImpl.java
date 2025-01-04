package com.restaraunt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaraunt.entities.Restaraunt;
import com.restaraunt.repositories.RestarauntRepo;


@Service
public class RestarauntServiceImpl implements RestarauntService {
	@Autowired
	public RestarauntRepo rr;
	
	@Override
	public Restaraunt showByLocation(String location) {
	 
		return rr.findBylocation(location);
	}

	@Override
	public Restaraunt showByName(String name) {
	
		return rr.findByName(name);
	}

	@Override
	public Restaraunt showByBudget(String budget) {
		
		return rr.findByBudget(budget);
	}

	@Override
	public Restaraunt showByCuisine(String cuisine) {
		
		return rr.findByCuisine(cuisine);
	}

	@Override
	public Restaraunt showByDistance(String distance) {
		
		return rr.findByDistance(distance);
	}

}
