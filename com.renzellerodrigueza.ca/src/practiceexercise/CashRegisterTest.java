package practiceexercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class CashRegisterTest {

	@Test
	public void testAllMethods() {
		RetailItems item = new RetailItems("Gears of War 4(Xbox One)" ,30 ,79.99);
		CashRegister cashreg = new CashRegister(item, 10);
		item.setPrice(49.99);
		
		// still retrieve the 79.99 value. set price does not mater since a copy of the current
		// data is the one being use from the declaration of the RetailItems 
		// item and not the updated one
		
		assertEquals(799.90, cashreg.getSubtotal(), 0);
		assertEquals(40.00, cashreg.getTax(), 0.0);
		assertEquals(839.90, cashreg.getTotal(), 0.0);
		
	}

}
