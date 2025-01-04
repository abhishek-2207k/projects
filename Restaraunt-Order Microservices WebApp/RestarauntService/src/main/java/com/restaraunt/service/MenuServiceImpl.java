package com.restaraunt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.restaraunt.entities.Menu;
import com.restaraunt.entities.Orders;
import com.restaraunt.repositories.MenuRepo;
import com.restaraunt.repositories.RestarauntRepo;
@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	public RestarauntRepo rr;
	

    @Autowired
    RestTemplate restTemplate;
	
	@Autowired
	public MenuRepo mr;

	
	@Override
	public List<Menu> showMenu(String name) {
		return (List<Menu>) mr.findByRestnameEquals(name);
	}
	
	@Override
	public Menu showMenuById(int mid) {
		return  mr.findByMidEquals(mid);
	}
	
	public void updateStocks(int oid)
	{ 
	    Orders order = restTemplate.getForObject("http://ORDERSERVICE/orders/oid/"+oid, Orders.class);
	    Menu m=mr.findByMidEquals(order.getMid());
	    m.setStock(m.getStock()-order.getQuantity());
	    mr.save(m);
	}
    @Override
    public void updateStocksOnDelete(int oid) {
        Orders order = restTemplate.getForObject("http://ORDERSERVICE/orders/oid/"+oid, Orders.class);
        Menu m=mr.findByMidEquals(order.getMid());
        m.setStock(m.getStock()+order.getQuantity());
        mr.save(m); 
    }

	
	
}
