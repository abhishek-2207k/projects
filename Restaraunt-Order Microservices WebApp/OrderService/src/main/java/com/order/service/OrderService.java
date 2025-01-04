package com.order.service;

import java.util.List;

import com.order.Exception.OrderNotFoundException;
import com.order.entities.Orders;

public interface OrderService {
	public void placeOrder(Orders order);
	public List<Orders> viewOrders();
	public void editOrders(Orders order) throws OrderNotFoundException;
	public void deleteOrder(int oid) throws OrderNotFoundException;
}
