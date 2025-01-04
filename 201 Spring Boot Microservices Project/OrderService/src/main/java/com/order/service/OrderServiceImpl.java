package com.order.service;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.Exception.OrderNotFoundException;
import com.order.entities.Menu;
import com.order.entities.Orders;
import com.order.repositories.OrderRepo;


@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	public OrderRepo or;

	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Override
	public void placeOrder(Orders orders) {
		int mid=orders.getMid();

		
		Menu menu = restTemplate.getForObject("http://RESTARAUNTSERVICE/restaraunt/menuid/"+mid, Menu.class);
		
		int price=menu.getPrice()*orders.getQuantity();
		orders.setFood(menu.getFood());
		orders.setPrice(price);
		orders.setStatus("Done!!!");
		System.out.println(orders.getStatus());
		or.save(orders);
		
		int oid=orders.getOid();
		 restTemplate.put("http://RESTARAUNTSERVICE/orders/"+oid, Menu.class);
		
	}

	@Override
	public List<Orders> viewOrders() {
		
		return or.findAll();
	}

	@Override
	public void editOrders(Orders order) throws OrderNotFoundException{
		
		List<Orders> orders=or.findAll();
		int flag=0;
		
		for(Orders o:orders)
		{ 
			if(order.getOid()==o.getOid())
			{
				Menu menu = restTemplate.getForObject("http://RESTARAUNTSERVICE/restaraunt/menuid/"+order.getMid(), Menu.class);
				order.setOid(order.getOid());
				order.setMid(menu.getMid());
				order.setFood(menu.getFood());
				order.setPayment_method(order.getPayment_method());
				order.setQuantity(order.getQuantity());
				order.setPrice(menu.getPrice()*order.getQuantity());
				or.save(order);
				flag=1;
			}
		}
		if(flag==0)
		{
			logger.error("Order with this id not found");
			throw new OrderNotFoundException("Order with this id not found!!! ");
		}
	
	}

	@Override
	public void deleteOrder(int oid) throws OrderNotFoundException {
		List<Orders> orders=or.findAll();
		int flag=0;
		for(Orders o:orders)
		{
			if(o.getOid()==oid)
			{
				restTemplate.put("http://RESTARAUNTSERVICE/orders/ondelete/"+oid, Menu.class);
				or.deleteById(oid);
				flag=1;
			}
			
		}
		
		if(flag==0) 
		{
			logger.error("Order with this id not found");
			throw new OrderNotFoundException("Order of this id is not found");
			}
		
		 
		
	}
	
	

	
	
	
}
