package ca.nait.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ca.nait.domain.GuestResponse;
import helper.Gmail;

// mark this class as a JSF CDI-managed bean class
//@Named("cheeseBurger") // This technique is use if you want to customize the name of the object name of this class
@Named // allows you to access an instance of this class using JSF-EL (Expression Language)
@RequestScoped	// create an instance for on HTTP request and destroy it after the HTTP response is sent
				// other scopes @ViewedScop = keep instance until HTTP request for another page
				//@SessionScoped = allows instance to be shared across multiple pages for one client
				//@ApplicaionScoped = one instance is shared with ALL clients (global data)
public class RsvpFormController {
	
	private GuestResponse guestResponse = new GuestResponse(); // getter and setters
	
	// an "action" method returns a String to the next page
	// an "actionListener" does not return a value and navigation stays on the same page
	public String submitForm() 
	{
		Gmail mailer = new Gmail("renzellerodrigueza01@gmail.com","Akinto13");
		
		String mailMessage = "";
		if(guestResponse.getWillAttend())
		{
			mailMessage = "It's great that you're coming to my party.";
		}
		else
		{
			mailMessage="FU";
		}
		
		try 
		{
			mailer.sendmail("renzellerodrigueza01@gmail.com", 
					guestResponse.getEmail(), "Party Invitation", mailMessage);
		} 
		catch (Exception e) 
		{
			System.out.println("Cannot Send Email");
			
		}
		return "/thanks?faces-redirect=true";
	}

	public GuestResponse getGuestResponse() {
		return guestResponse;
	}

	public void setGuestResponse(GuestResponse guestResponse) {
		this.guestResponse = guestResponse;
	}
	

}
