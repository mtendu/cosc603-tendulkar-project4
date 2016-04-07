/**
 * 
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author Madhura Tendulkar
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendingMachineTest {
	private static VendingMachine vendingMachine = null;
	private static  VendingMachineItem vendingMachineItem1 = null;
	private static VendingMachineItem vendingMachineItem2 = null;
	private static VendingMachineItem vendingMachineItem3 = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		vendingMachine = new VendingMachine();
		vendingMachineItem1 = new VendingMachineItem("Chips", 1.5);
		vendingMachineItem2 = new VendingMachineItem("Ice cream", 1.5);
		vendingMachineItem3 = new VendingMachineItem("Coffee", 3.5);		
	}

	
	/**
	 * Test the method addItem() with correct input.
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test
	public void testCase01AddItem() {
		
		vendingMachine.addItem(vendingMachineItem1, "A");
		assertTrue((Arrays.asList(vendingMachine.itemArray[0]).contains(vendingMachineItem1)));
		
		vendingMachine.addItem(vendingMachineItem2, "B");
		assertTrue((Arrays.asList(vendingMachine.itemArray[1]).contains(vendingMachineItem2)));
	
		vendingMachine.addItem(vendingMachineItem3, "C");
		assertTrue((Arrays.asList(vendingMachine.itemArray[2]).contains(vendingMachineItem3)));

	}
	
	/**
	 * Test the method addItem() for the case to add item in already occupied slot.
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test
	public void testCase02AddItemOccupied(){
		vendingMachine.addItem(vendingMachineItem3, "C");
		assertTrue((Arrays.asList(vendingMachine.itemArray[2]).contains(vendingMachineItem3)));
	}
	
	/**
	 * Test the method addItem() for the invalid slot code.
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test
	public void testCase03AddItemInvalidCode(){
		vendingMachine.addItem(vendingMachineItem3, "E");
		assertTrue((Arrays.asList(vendingMachine.itemArray[3]).contains(vendingMachineItem3)));
	}	
	/** 
	 * Test the method removeItem() with good input.
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */	
	@Test
	public void testCase04RemoveItem() {
		VendingMachineItem vItem = vendingMachine.removeItem("A");
		assertEquals("Chips",vItem.getName());
	}
	
	/** 
	 * Test the method removeItem() in an empty slot
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */
	@Test
	public void testCase05RemoveEmptySlot(){
		assertEquals("Chips", vendingMachine.removeItem("D").getName());
	}
	
	/** 
	 * Test the method removeItem() for the case to remove the item with invalid code
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */	
	@Test
	public void testCase06RemoveItemInvalidCode() {
		assertSame(vendingMachineItem1,vendingMachine.removeItem("M"));
	}
	
	
	/**
	 * Test the method insertMoney with amount >= 0
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#insertMoney(double)}.
	 */
	@Test
	public void testCase07InsertMoney() {
		vendingMachine.insertMoney(0);
		assertEquals(0, vendingMachine.getBalance(), 0.0);
		vendingMachine.insertMoney(2);
		assertEquals(2, vendingMachine.getBalance(), 0.0);
		
	}
	
	/**
	 * Test the method insertMoney with amount < 0
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#insertMoney(double)}.
	 */
	@Test
	public void testCase08InsertMoneyInvalidAmount() {
		vendingMachine.insertMoney(-1);
		assertEquals(-1, vendingMachine.getBalance(), 0.0);
	}
	
	/**
	 * Test the method makePurchase with good input.
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#testMakePurchase()}.
	 */
	@Test
	public void testCase09MakePurchase(){
		assertTrue(vendingMachine.makePurchase("B"));
	}
	/**
	 * Test the method makePurchase with insufficient balance
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#testMakePurchase()}.
	 */
	@Test
	public void testCase10MakePurchaseInsufficientBalance() {
		assertTrue(vendingMachine.makePurchase("C"));
		
	}
	
	/**
	 * Test the method makePurchase for code of empty slot
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#testMakePurchase()}.
	 */
	@Test
	public void testCase11MakePurchaseEmptySlot() {
		
		assertTrue(vendingMachine.makePurchase("D"));
		
	}
	
	
	/**
	 * Test the method getBalance 
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#testGetBalance()}.
	 */
	@Test
	public void testCase12GetBalance(){
		assertEquals(0.5, vendingMachine.getBalance(),0.0);
	}
	
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}.
	 */
	@Test
	public void testCase13ReturnChange() {
		assertEquals(0.5, vendingMachine.returnChange(),0.0);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown(){
		vendingMachine = null;
		vendingMachineItem1 = null;
		vendingMachineItem2 = null;
		vendingMachineItem3 = null;
	}
	
}