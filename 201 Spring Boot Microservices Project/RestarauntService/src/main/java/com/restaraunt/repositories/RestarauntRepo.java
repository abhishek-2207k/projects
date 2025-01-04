package com.restaraunt.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.restaraunt.entities.Restaraunt;

@Repository
public interface RestarauntRepo extends JpaRepository<Restaraunt,Integer> {

	
	
	public Restaraunt findBylocation(String location);
	
	
	public Restaraunt findByDistance(String distance);
	
	public Restaraunt findByBudget(String budget);
	
	
	public Restaraunt findByCuisine(String cuisine);
	
	
	public Restaraunt findByName(String name);
	
	
	
	
}