package ca.nait.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named // allows you to access an instance of this class using JSF-EL (Expression Language)
@RequestScoped // create an instance of this class for one HTTP request
public class BmiController {
	
	private double weight; //getter and setter
	private double height; // getter and setter
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	
	private double calculateBMI(double weight, double height)
	{
		return 703.0 * weight / Math.pow(height, 2);
	}
	
	public void submitForm()
	{
		double bmiValue = this.calculateBMI(this.weight, this.height);
		// Send info message to FacesContext
		String message = String.format("Your BMI is %.1f", bmiValue);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		// Send message to FaceMessage
		FacesMessage facesMessage = new FacesMessage(message);
		// Set severity
		facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		// set FaceContext with the created faceMessage
		facesContext.addMessage(null, facesMessage);
	}
	
	@Override
	public String toString() {
		return "BmiConroller [weight=" + weight + ", height=" + height + "]";
	}
}
