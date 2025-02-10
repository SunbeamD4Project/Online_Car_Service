package com.wheely.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wheely.pojos.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	  List<Car> findByUser_UserId(Long userId);
	
	

	
}