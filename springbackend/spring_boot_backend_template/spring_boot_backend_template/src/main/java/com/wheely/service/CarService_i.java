package com.wheely.service;

import java.util.List;
import java.util.Optional;

import com.wheely.dto.CarDTO;
import com.wheely.pojos.Car;

public interface CarService_i {
	public Car addCar(CarDTO carDto);
	public List<Car> getAllCars();
	public Optional<Car> getCarById(Long id);
	public List<Car> getCarsByUserId(Long userId);
	 public Car updateCar(Long id, CarDTO carDto);
	 public void deleteCar(Long id);

}
