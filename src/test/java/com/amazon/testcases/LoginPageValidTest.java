package com.amazon.testcases;

import java.io.IOException;


import org.testng.annotations.*;

import com.amazon.actiondriver.Action;
import com.amazon.base.Base;
import com.amazon.pageobjects.LoginPage;


public class LoginPageValidTest extends Base {
	
	LoginPage l;
	Action a = new Action();


	@BeforeMethod
	public void setUp() {

		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {

		getDriver().quit();
	}
	
	@Test
	public void validCredentials() throws InterruptedException, IOException {

		l = new LoginPage();
		l.clickOnLoginTab();
		l.loginValid();


	}

}
