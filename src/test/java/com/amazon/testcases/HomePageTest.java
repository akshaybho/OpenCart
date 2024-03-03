package com.amazon.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.pageobjects.HomePage;

public class HomePageTest extends Base {
	HomePage h;
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void searchItem() throws InterruptedException {
		 h = new HomePage();
		 h.searchItem();
	}
	
	@Test
	public void verifyTitle() {
		String actual = "Your Store";
		Assert.assertEquals(actual, h.getTitle());
		
	}

}
