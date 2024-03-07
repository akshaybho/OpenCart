package com.amazon.testcases;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.pageobjects.RegistrationPage;

public class RegistrationPageTest extends Base {
      
	RegistrationPage r;
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void goToRegister() throws InterruptedException, IOException {
		r = new RegistrationPage();
		r.clickOnRegi();
		r.Info();
		r.enterPassword();
		r.verifyError();
	}
	
	
	
	
	
}
