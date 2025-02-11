package com.wheely.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class UserLoginRequestDTO {
	@NotBlank(message = "Email must be not null n not blank!!!!")
	@Email(message = "Invalid email format")
	private String email;
	@NotBlank
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
