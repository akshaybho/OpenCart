package com.amazon.testcases;

import org.testng.annotations.*;

import com.amazon.base.Base;
import com.amazon.pageobjects.CartTotal;


public class CartTotalTest extends Base {
	
	CartTotal c;
	@BeforeMethod
	public void setUp() {

		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {

		getDriver().quit();
	}
	
	@Test
	public void orderItems() throws InterruptedException {

		c = new CartTotal();
		c.clickItems();
		c.shopCart();
		c.costofItems();
		c.validate();
	}

}
