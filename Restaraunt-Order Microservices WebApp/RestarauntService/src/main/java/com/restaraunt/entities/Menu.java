package com.restaraunt.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Menu implements Comparable<Menu>{
	
    @Id
	private int mid;
	private String restname;
	private String food;
	private int price;
	private int stock;
	

	@Override
    public int hashCode() {
        return Objects.hash(food, mid, price, restname, stock);
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
                && Objects.equals(restname, other.restname) && stock == other.stock;
    }

    public Menu(int mid, String food, int price, String restname,int stock) {
		super();
		this.mid = mid;
		this.food = food;
		this.price = price;
		this.restname = restname;
		this.stock =stock;
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



    public int getStock() {
        return stock;
    }



    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Menu [mid=" + mid + ", restname=" + restname + ", food=" + food + ", price=" + price + ", stock="
                + stock + "]";
    }

    @Override
    public int compareTo(Menu o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.REFRESH)
    private List<Orders> orders;

	
	
	
	

}
