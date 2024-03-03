package com.amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.actiondriver.Action;
import com.amazon.base.Base;
import com.amazon.pageobjects.LoginPage;

public class LoginPageTest extends Base {

	LoginPage l;
	Action a = new Action();
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "credentials")
	public void goToLogin(String username, String password) throws InterruptedException {
		l = new LoginPage();
		l.clickOnLoginTab();
		l.loginInvalid(username, password);
	}
	
	@DataProvider(name = "credentials")
	public Object[][] dataset() {
		return new Object[][] {
			{"akshay","1234"},
			{"abc","345"}
		};
	}
	
	
	
	
}
