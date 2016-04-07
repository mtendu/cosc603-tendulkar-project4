/**
 * 
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Madhura Tendulkar
 *
 */
public class VendingMachineItemTest {
	
	private static VendingMachineItem vendingMachineItem = null;
	private static VendingMachineItem vendingMachineItem1 = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		
		vendingMachineItem = new VendingMachineItem("Ice cream", 2.5);
		vendingMachineItem1 = new VendingMachineItem("Coke", -2);
	}

	
	/**
	 * Test the constructor of VendingMachineItem
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test
	public void testVendingMachineItem() {
		
			assertTrue((vendingMachineItem instanceof VendingMachineItem));
		
	}
	/**
	 * Test the the price of VendingMachineItem less than zero
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getPrice()}..
	 */
	@Test 
	public void testVendingMachineItem1() {
		
		assertEquals(-2, vendingMachineItem1.getPrice(),0.0);
	
}
	
	/**
	 * Test the method getName
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("Ice cream", vendingMachineItem.getName());
	}

	/**
	 * Test the method getPrice
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getPrice()}.
	 */
	
	@Test
	public void testGetPrice() {
		assertEquals(2.5, vendingMachineItem.getPrice(),0.0);
	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		
		vendingMachineItem = null;
		vendingMachineItem = null;
		vendingMachineItem1 = null;
	
	}


}
