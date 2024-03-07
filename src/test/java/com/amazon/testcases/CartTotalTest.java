package com.amazon.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.pageobjects.CartTotal;

public class CartTotalTest extends Base {
	
	CartTotal c;
	@BeforeTest
	public void setUp() {

		launchApp();
	}
	
	@AfterTest
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
