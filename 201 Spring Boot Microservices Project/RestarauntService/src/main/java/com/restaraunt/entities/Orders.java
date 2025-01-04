package com.restaraunt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.restaraunt.entities.Orders;

@Entity
public class Orders implements Comparable<Orders> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int oid;
	private int mid;
	private String food;
	private int quantity;
	private int price;
	private String payment_method;
	
	
	
	public Orders(int oid, String food, int quantity, int price,int mid, String payment_method) {
		super();
		this.oid = oid;
		this.food = food;
		this.quantity = quantity;
		this.price = price;
		this.mid=mid;
		this.payment_method = payment_method;
	}
	
	public Orders() {
		super();
		
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", food=" + food + ", quantity=" + quantity + ", price=" + price
				+ ", payment_method=" + payment_method + "]";
	}

    @Override
    public int compareTo(Orders o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.REFRESH)
    private List<Menu> menu;
	
	

}
