package ca.nait.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

// known as a problem domain class
public class GuestResponse {

	@NotBlank(message="Please enter your name")
	private String name;
	
	@NotBlank(message="Please enter your email address")
	@Email(message="Please enter a valid email address")
	private String email;
	
	@NotBlank(message="Please enter your address")
	//@Pattern(regexp="^[2-9]\\d{2}-\\d{3}-\\{4}$", message="Please enter a valid phone number")
	private String phone;
	
	@NotNull(message="Please select whether you'll attend or not")
	private Boolean willAttend;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getWillAttend() {
		return willAttend;
	}
	public void setWillAttend(Boolean willAttend) {
		this.willAttend = willAttend;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
