package com.order.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu implements Comparable<Menu>{
	@Id
	private int mid;
	private String restname;
	private String food;
	private int price;
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(food, mid, price, restname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return Objects.equals(food, other.food) && mid == other.mid && price == other.price
				&& Objects.equals(restname, other.restname);
	}

	public Menu(int mid, String food, int price, String restname) {
		super();
		this.mid = mid;
		this.food = food;
		this.price = price;
		this.restname = restname;
	}

	public Menu() {
		super();
		
	}

	public String getRestname() {
		return restname;
	}

	public void setRestname(String restname) {
		this.restname = restname;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", food=" + food + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Menu o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
