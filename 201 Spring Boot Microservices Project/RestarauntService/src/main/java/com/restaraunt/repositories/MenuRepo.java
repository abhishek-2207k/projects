package com.restaraunt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.restaraunt.entities.Menu;

public interface MenuRepo extends JpaRepository<Menu,Integer> {

	
	public List<Menu> findByRestnameEquals(String restname);

	public Menu findByMidEquals(int mid);
	
}
