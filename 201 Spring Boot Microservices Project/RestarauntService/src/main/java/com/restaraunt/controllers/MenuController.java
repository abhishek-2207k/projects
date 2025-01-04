package com.restaraunt.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restaraunt.entities.Menu;
import com.restaraunt.exception.FoodItemNotFoundException;
import com.restaraunt.exception.MenuItemException;
import com.restaraunt.repositories.MenuRepo;
import com.restaraunt.repositories.RestarauntRepo;
import com.restaraunt.service.MenuServiceImpl;

import brave.sampler.Sampler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@Controller
public class MenuController {
	
    public static final String MENU_SERVICE="MenuService";
    
	@Autowired
	public MenuRepo mr;
	
	@Bean
    public  Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
	
	
	@Autowired
	public RestarauntRepo rr;
	@Autowired
	public MenuServiceImpl msi;
	Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	
	
	@ResponseBody
	@GetMapping("/restaraunt/name/{name}/menu")
	@CircuitBreaker(name =MENU_SERVICE,fallbackMethod = "AlternateMethod1")
	public List<Menu> showRestarauntMenuByName(@PathVariable("name")String name) throws MenuItemException
	{
	    
		if(name.equals("IndianPride") || name.equals("XiJinPing")) return msi.showMenu(name);
		else 
		{
		    logger.error("no restaraunt found");
		    throw new MenuItemException("Menu of this Restaraunt not found !!!,Please do crossheck the name of Restaraunt ");
		}
	}
	public List<Menu> AlternateMethod1(Exception e)
    {
        return mr.findAll();
    }
	
	@ResponseBody
	@GetMapping("/restaraunt/menuid/{mid}")
	@CircuitBreaker(name =MENU_SERVICE,fallbackMethod = "AlternateMethod2")
	public Menu showRestarauntById(@PathVariable("mid")int  mid) throws FoodItemNotFoundException
	{
		if(mid>=1 && mid<=6) return msi.showMenuById(mid); 
		else
		{
		    logger.error("no food item found");
		    throw new FoodItemNotFoundException("No Food is associated with this Menu Id!!!");
		}
	}
	public Menu AlternateMethod2(Exception e)
    {
        return new  Menu(7, "dosa", 50, "Only this item is available",20);
    }
	
	
	
	@ResponseBody
    @PutMapping("/orders/{oid}")
    public void updateStock(@PathVariable("oid")int  oid)
    { 
         msi.updateStocks(oid);
    }
	@ResponseBody
	@PutMapping("/orders/ondelete/{oid}")
	public void updateStockonDelete(@PathVariable("oid")int  oid)
	 {
	    msi.updateStocksOnDelete(oid);	        
	  }

}
