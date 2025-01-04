package com.restaraunt.entities;




import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;






@Entity
public class Restaraunt implements Comparable<Restaraunt>{
	@Id
	private int rid;
	private String name;
	private String location;
	private String  distance;
	private String cuisine;
	private String budget;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(budget, cuisine, distance, location, name, rid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaraunt other = (Restaraunt) obj;
		return Objects.equals(budget, other.budget) && Objects.equals(cuisine, other.cuisine)
				&& Objects.equals(distance, other.distance) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && rid == other.rid;
	}
	public Restaraunt(int rid, String name, String location, String distance, String cuisine, String budget) {
		super();
		this.rid = rid;
		this.name = name;
		this.location = location;
		this.distance = distance;
		this.cuisine = cuisine;
		this.budget = budget;
	}
	public Restaraunt() {
		super();
		
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String  getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return "Restaraunt [rid=" + rid + ", name=" + name + ", location=" + location + ", distance=" + distance
				+ ", cuisine=" + cuisine + ", budget=" + budget + "]";
	}
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.REFRESH)
    @JoinColumn(name = "fk_rid", referencedColumnName = "rid")
    @JsonBackReference
    @Override
    public int compareTo(Restaraunt o) {
        // TODO Auto-generated method stub
        return 0;
    }
	
	
	

}
