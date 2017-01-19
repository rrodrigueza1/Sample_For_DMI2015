package ca.nait.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class GuestResponse {

	@NotBlank(message="Please enter your name")
	private String name;
	
	@NotBlank(message="Please enter your email address")
	@Email(message="Please enter a valid email address")
	private String email;
	
	@NotBlank(message="Please enter your address")
	private String address;
	
	@NotNull(message="Please select whether you'll atend or not")
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
