package com.wheely.service;

import java.util.List;

import com.wheely.dto.BookingRequestDTO;
import com.wheely.dto.BookingStatusUpdateDTO;
import com.wheely.pojos.Booking;

public interface BookingService_i {
	
	public List<Booking> getBookingsByUser(Long userId);
	public Booking getBookingById(Long bookingId);
	public Booking createBooking(BookingRequestDTO dto);
	public List<Booking> getBookingsByStatus(String status);
	public List<Booking> getBookingsByMechanic(Long mechanicId);
	public List<Booking> getBookingsByMechanicAndStatus(Long mechanicId, String status);
	public Booking updateJobStatus(Long bookingId, BookingStatusUpdateDTO statusUpdate);
	public Booking completeJob(Long bookingId, BookingStatusUpdateDTO statusUpdate);

}
