package com.restaraunt.service;

import java.util.List;

import com.restaraunt.entities.Menu;
import com.restaraunt.entities.Orders;


public interface MenuService {

	public List<Menu> showMenu(String name);
	public Menu showMenuById(int mid);
	public void updateStocks(int oid);
	
	public void updateStocksOnDelete(int oid);
}
