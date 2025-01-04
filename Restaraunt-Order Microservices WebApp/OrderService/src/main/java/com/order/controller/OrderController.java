package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.order.Exception.OrderNotFoundException;
import com.order.entities.Orders;
import com.order.repositories.OrderRepo;
import com.order.service.OrderServiceImpl;

import brave.sampler.Sampler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
public class OrderController {

	public static final String ORDER_SERVICE="OrderService";
	
	@Bean
    public  Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
	
	@Autowired
	public OrderServiceImpl osi;
	
	@Autowired
	public OrderRepo or;
	
	@PostMapping("/placeorder")
	@CircuitBreaker(name =ORDER_SERVICE,fallbackMethod = "AlternateMethod")
	public String createOrder( @RequestBody Orders orders)
	{
		osi.placeOrder(orders);
		return "Congratulations!!!, Order placed";
	}
	public String AlternateMethod(Exception e)
	{
	    return "Cant place order !!!This service is currently under maintenance";
	}
	
	@GetMapping("/orders")
	@CircuitBreaker(name =ORDER_SERVICE,fallbackMethod = "AlternateMethod1")
	public List<Orders> getAllOrders()
	{
		return osi.viewOrders();
	}
	public List<Orders> AlternateMethod1(Exception e)
	{
	    return or.findAll();
	}
	
	@PutMapping("/update")
	@CircuitBreaker(name =ORDER_SERVICE,fallbackMethod = "AlternateMethod2")
	public String UpdateOrders(@RequestBody Orders order) throws OrderNotFoundException
	{
		osi.editOrders(order);
		return "Order updated Sucessfully!!!";
	}
	public String AlternateMethod2(Exception e)
	{
	    return "Cant Update !!!This service is currently under maintenance";
	}

	@DeleteMapping("/delete/{oid}")
	@CircuitBreaker(name =ORDER_SERVICE,fallbackMethod = "AlternateMethod3")
	public String deleteOrder(@PathVariable("oid")int oid) throws OrderNotFoundException
	{
		
		osi.deleteOrder(oid);
		return "Order Deleted Sucessfully!!!";
	}
	public String AlternateMethod3(Exception e)
	{
	    return "Cant Delete !!!This service is currently under maintenance";
	}
	
	@GetMapping("/orders/oid/{oid}")
	public Object updateStock(@PathVariable("oid")int oid)
	{
		return or.findById(oid);
	}
	
	

}
