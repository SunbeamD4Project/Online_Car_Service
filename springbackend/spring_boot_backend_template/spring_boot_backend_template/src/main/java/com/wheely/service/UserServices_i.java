package com.wheely.service;


import com.wheely.dto.UserUpdateDTO;
import com.wheely.pojos.User;

public interface UserServices_i {

	 public User authenticateUser(String email, String password);
	    public User registerUser(User newUser);
	    public String removeUser(Long id);
	    public String updateUserDetails(UserUpdateDTO userUpdateDTO, Long id);
		public User getUserById(Long id);
}
