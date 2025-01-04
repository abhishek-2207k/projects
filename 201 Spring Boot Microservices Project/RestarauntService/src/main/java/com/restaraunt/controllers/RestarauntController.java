package com.restaraunt.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.restaraunt.entities.Restaraunt;
import com.restaraunt.exception.BudgetException;
import com.restaraunt.exception.CuisineNotFoundException;
import com.restaraunt.exception.DistanceException;
import com.restaraunt.exception.LocationNotFoundException;
import com.restaraunt.exception.RestarauntNotFoundException;
import com.restaraunt.repositories.RestarauntRepo;
import com.restaraunt.service.RestarauntServiceImpl;

import brave.sampler.Sampler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
public class RestarauntController 
{
    
    public static final String RESTARAUNT_SERVICE="RestarauntService";
    
    @Bean
    public  Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
	
	@Autowired
	public RestarauntRepo rr;
	@Autowired
	public RestarauntServiceImpl rsi;

	Logger logger = LoggerFactory.getLogger(RestarauntController.class);
	
	
	@GetMapping("/restaraunt/location/{location}")
	@CircuitBreaker(name =RESTARAUNT_SERVICE,fallbackMethod = "AlternateMethod1")
	public Restaraunt showRestarauntByLocation(@PathVariable("location")String location) throws LocationNotFoundException
	{
		if(location.equals("Gachibowli") || location.equals("Madhapur")) return rsi.showByLocation(location);
		else
		{
		    logger.error("restaraunt not found in location");
		    throw new LocationNotFoundException("Resataraunts are not found in this Location!!!,try finding Gachibowli or Madhapur");
		}
	}
	public Restaraunt AlternateMethod1(Exception e)
	{
	    return new Restaraunt(3, "SpicyFood", "Uppal", ">40", "Italian", "500");
	}
	
	@GetMapping("/restaraunt/distance/{distance}")
	@CircuitBreaker(name =RESTARAUNT_SERVICE,fallbackMethod = "AlternateMethod2")
	public Restaraunt showRestarauntByDistance(@PathVariable("distance")String distance) throws DistanceException
	{
		if(distance.equals("0-20") || distance.equals("20-40")) return rsi.showByDistance(distance);
		else 
		    {
		    logger.error("restaraunt not found between this distance range");
		    throw new DistanceException("Restaraunt is not found in this distance range!!!,try range of 0-20 or 20-40");
		    }
	}
	public Restaraunt AlternateMethod2(Exception e)
    {
        return new Restaraunt(3, "SpicyFood", "Uppal", ">40", "Italian", "500");
    }
	
	@GetMapping("/restaraunt/cuisine/{cuisine}")
	@CircuitBreaker(name =RESTARAUNT_SERVICE,fallbackMethod = "AlternateMethod3")
	public Restaraunt showRestarauntByCuisine(@PathVariable("cuisine")String cuisine) throws CuisineNotFoundException
	{
		
		if(cuisine.equals("Chinese") || cuisine.equals("Indian") ) return rsi.showByCuisine(cuisine);
		else 
		    {
		    logger.error("restaraunt with this cuisine not found");
		    throw new CuisineNotFoundException("This type of Cuisine not found in any restaraunt!!!,try Indian or Chinese");
		    }
		
	}
	public Restaraunt AlternateMethod3(Exception e)
    {
        return new Restaraunt(3, "SpicyFood", "Uppal", ">40", "Italian", "500");
    }
    
	
	@GetMapping("/restaraunt/budget/{budget}")
	@CircuitBreaker(name =RESTARAUNT_SERVICE,fallbackMethod = "AlternateMethod4")
	public Restaraunt showRestarauntByBudget(@PathVariable("budget")String budget) throws BudgetException
	{
	    if(budget.equals("100-300") || budget.equals("300-500")) return rsi.showByBudget(budget);
	    else
	    {
	        logger.error("restaraunt not found of this budget");
		 throw new BudgetException("Restaraunt with this budget is not found!!!");
	    }
	   
		
	}
	public Restaraunt AlternateMethod4(Exception e)
    {
        return new Restaraunt(3, "SpicyFood", "Uppal", ">40", "Italian", "500");
    }
    
	
	@GetMapping("/restaraunt/name/{name}")
	@CircuitBreaker(name =RESTARAUNT_SERVICE,fallbackMethod = "AlternateMethod5")
	public Restaraunt showRestarauntByName(@PathVariable("name")String name) throws RestarauntNotFoundException
	{
	    System.out.println(name);
		if(name.equals("IndianPride") || name.equals("XiJinPing"))
		{
		return rsi.showByName(name);
		}
		else 
		{
		    logger.error("restaraunt not found of this name");
		    throw new RestarauntNotFoundException("Restaraunt Not Found!!!,Try another name");
		}
		
	}
	public Restaraunt AlternateMethod5(Exception e)
    {
        return new Restaraunt(3, "SpicyFood", "Uppal", ">40", "Italian", "500");
    }
	
	
	

}
