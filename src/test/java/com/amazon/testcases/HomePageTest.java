package com.amazon.testcases;




import org.testng.annotations.*;

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

		quitBrowser();
	}
	
	@Test
	public void HomeTest() throws InterruptedException {

		 h = new HomePage();
		 h.searchItem();
		 log.info("User clicks on search item");
		 h.verifyTitle();
		 log.info("Verifying the title");

		 
		 
		 
	}
	
	
	
}
