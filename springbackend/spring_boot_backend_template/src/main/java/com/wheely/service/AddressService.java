package com.wheely.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wheely.dao.AddressRepository;
import com.wheely.dao.BookingRepository;
import com.wheely.dao.UserRepository;
import com.wheely.exception.ResourceNotFoundException;
import com.wheely.pojos.Address;
import com.wheely.pojos.Booking;
import com.wheely.pojos.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressService implements AddressService_i{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

  //  @Autowired
 //   private BookingRepository bookingRepository;

    public Address saveAddress(Long userId, Address address) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));

        address.setUser(user);


        return addressRepository.save(address);
    }



 // Get all addresses by user ID
    public List<Address> getAddressesByUserId(Long userId) {
        return addressRepository.findByUser_UserId(userId);
    }



	@Override
	public com.stripe.model.Address saveAddress(Long userId, com.stripe.model.Address address) {
		// TODO Auto-generated method stub
		return null;
	}

}
