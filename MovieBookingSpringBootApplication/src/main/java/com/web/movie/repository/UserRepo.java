package com.web.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.movie.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

	User findByName(String userName);

}
