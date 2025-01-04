package com.web.movie.entities;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class User implements Comparable<User> {
	@Override
	public int hashCode() {
		return Objects.hash(cinema, id, name, password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cinema, other.cinema) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "fk_id", referencedColumnName = "id")
	@JsonBackReference
	private List<Cinema> cinema;


	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
