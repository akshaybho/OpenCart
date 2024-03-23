package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.base.Base;


public class HomePage extends Base {
	
	@FindBy(xpath = "//input[@type=\"text\"]")
	WebElement searchBar;
	
	public HomePage() {

		PageFactory.initElements(getDriver(), this);
	}
	
	public void searchItem() throws InterruptedException {
		searchBar.sendKeys("mobile");
		Thread.sleep(3000);
	}
	
	public void verifyTitle() {
		 
		 
		String expected = "Your Store";
		Assert.assertEquals(expected, getDriver().getTitle());
		
		
		
	}


}
