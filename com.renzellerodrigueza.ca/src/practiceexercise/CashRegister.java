package practiceexercise;


public class CashRegister {

	private RetailItems item;
	private int quantityPurchase;
	
	public CashRegister(RetailItems item, int quantityPurchase)
	{
		//this.item = item;
		// create a copy of the pass parameter item
		this.item = new RetailItems(item);
		this.quantityPurchase = quantityPurchase;
	}
	
	public double getSubtotal()
	{
		return item.getPrice() * quantityPurchase;
	}
	
	
	//private ArrayList<RetailItems> items;

	//public ArrayList<RetailItems> getItems() {
	//	return items;
	//}

	//public void setItems(ArrayList<RetailItems> items) {
	//	this.items = items;
	//}
	
	//public void addItem(RetailItems item)
	//{
	//	this.items.add(item);
	//}
	
	public double roundTo2Decimal(double value)
	{
		return Math.round(value * 100) / 100.00;
	}
	public double getTax()
	{
		
		return roundTo2Decimal(this.getSubtotal() * 0.05);
	}
	
	public double getTotal()
	{
		
		return roundTo2Decimal(this.getSubtotal() + this.getTax());
	}
	
	public RetailItems getItem() 
	{
		// This technique will return a copy of the item and not the actual/orginal copy
		// to avoid of change in the actual item being retrieve
		return new RetailItems(item);
	}
	
	
}
