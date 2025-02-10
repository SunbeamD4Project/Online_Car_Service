package com.wheely.service;

import java.util.List;

import com.wheely.pojos.Address;

public interface AddressService_i {
	public Address saveAddress(Long userId, Address address);
	 public List<Address> getAddressesByUserId(Long userId);
}
