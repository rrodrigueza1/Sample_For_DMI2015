package practiceexercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class RetailItemsTest {

	@Test
	public void testAllMethods() {
		RetailItems item = new RetailItems("Gears of War 4(Xbox One)" ,30 ,79.99);
		assertEquals("Gears of War 4(Xbox One)", item.getDescription());
		assertEquals(30, item.getUnitsOnHand());
		assertEquals(79.99, item.getPrice(), 0);
	}



}
