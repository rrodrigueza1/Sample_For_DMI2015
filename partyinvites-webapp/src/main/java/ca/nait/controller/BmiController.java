package ca.nait.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.omnifaces.util.Messages;

@Named // allows you to access an instance of this class using JSF-EL (Expression Language)
@RequestScoped // create an instance of this class for one HTTP request
public class BmiController {
	
	@NotNull(message="Please enter a weight.")
	private Double weight; //getter and setter
	
	@NotNull(message="Please enter a height.")
	private Double height; // getter and setter
	
	

	
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
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
		
		//FacesContext facesContext = FacesContext.getCurrentInstance();
		// Send message to FaceMessage
		//FacesMessage facesMessage = new FacesMessage(message);
		// Set severity
		//facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		// set FaceContext with the created faceMessage
		//facesContext.addMessage(null, facesMessage);
		// Using omnifaces
		if( bmiValue < 18.5)
		{
			String message = String.format("Your BMI is %.1f. You are underweight", bmiValue);
			Messages.addFlashGlobalWarn(message);
		}
		else if (bmiValue >= 18.5 && bmiValue <= 24.99)
		{
			String message = String.format("Your BMI is %.1f. You are at optimal weight", bmiValue);
			Messages.addFlashGlobalInfo(message);
		}
		else if (bmiValue >= 25 && bmiValue < 30)
		{
			String message = String.format("Your BMI is %.1f. You are overweight", bmiValue);
			Messages.addFlashGlobalError(message);
		}
		else
		{
			String message = String.format("Your BMI is %.1f. You are on health trouble", bmiValue);
			Messages.addFlashGlobalFatal(message);
		}
	}
	
	@Override
	public String toString() {
		return "BmiConroller [weight=" + weight + ", height=" + height + "]";
	}
}
