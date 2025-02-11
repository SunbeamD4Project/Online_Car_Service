package com.wheely.service;

import java.util.List;

import com.stripe.model.Address;

public interface AddressService_i {
	public Address saveAddress(Long userId, Address address);
	public List<com.wheely.pojos.Address> getAddressesByUserId(Long userId);
}
