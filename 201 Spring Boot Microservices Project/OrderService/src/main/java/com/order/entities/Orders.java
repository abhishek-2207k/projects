	package com.order.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String status;
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(food, mid, oid, payment_method, price, quantity, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(food, other.food) && mid == other.mid && oid == other.oid
				&& Objects.equals(payment_method, other.payment_method) && price == other.price
				&& quantity == other.quantity && Objects.equals(status, other.status);
	}

	public Orders(int oid, String food, int quantity, int price,int mid, String payment_method, String status) {
		super();
		this.oid = oid;
		this.food = food;
		this.quantity = quantity;
		this.price = price;
		this.mid=mid;
		this.payment_method = payment_method;
		this.status=status;
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
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", mid=" + mid + ", food=" + food + ", quantity=" + quantity + ", price=" + price
				+ ", payment_method=" + payment_method + ", status=" + status + "]";
	}

	@Override
	public int compareTo(Orders o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
	

}
