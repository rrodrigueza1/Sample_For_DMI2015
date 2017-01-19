package practiceexercise;

public class RetailItems {
	private String description;
	private double price;
	private int unitsOnHand;
	
	public RetailItems(String desc, int onHand, double price)
	{
		description = desc;
		unitsOnHand = onHand;
		this.price = price;
	}
	
	public RetailItems(RetailItems item) 
	{
		description = item.getDescription();
		unitsOnHand = item.getUnitsOnHand();
		price = item.getPrice();
		
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getUnitsOnHand() {
		return unitsOnHand;
	}
		
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "RetailItems [description=" + description + ", price=" + price + ", unitsOnHand=" + unitsOnHand + "]";
	}
	
	
}
