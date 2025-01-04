package com.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entities.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer>{

}
