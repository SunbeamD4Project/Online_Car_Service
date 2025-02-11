package com.wheely.service;

import java.util.List;

import com.wheely.dto.ServiceDTO;
import com.wheely.pojos.Booking;
import com.wheely.pojos.Car;
import com.wheely.pojos.User;

public interface AdminService_i {
	public List<User> getAllUsers();
	public List<Booking> getAllBookings();
	public List<com.wheely.pojos.Service> getAllServices();
	public com.wheely.pojos.Service addService(ServiceDTO serviceDto) ;
	public List<Car> getAllCars(Long userId);
}
