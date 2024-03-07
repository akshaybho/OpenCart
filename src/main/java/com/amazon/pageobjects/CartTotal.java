package com.amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.actiondriver.Action;
import com.amazon.base.Base;

public class CartTotal extends Base {
	float totalCost = 0;
	Action a = new Action();
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")
	WebElement macAddtoCart;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")
	WebElement iPhoneAddtoCart;
	
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement alertText;
	
	@FindBy(xpath = "//a[@title=\"Shopping Cart\"]")
	WebElement shoppingCart;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/table/tbody/tr[4]/td[2]")
	WebElement TotalExpectedValue;
	
	public CartTotal() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickItems() throws InterruptedException {
		macAddtoCart.click();
		Thread.sleep(3000);
		String text1 = alertText.getText();
		System.out.println(text1);
		Thread.sleep(3000);
		iPhoneAddtoCart.click();
		String text2 = alertText.getText();
		System.out.println(text2);
	}
	
	public void shopCart() throws InterruptedException {
		shoppingCart.click();
		Thread.sleep(3000);
		
	}
	
	public void costofItems() throws InterruptedException {
		 
		for(int i=1; i<3; i++) {
			 
			String itemCost = getDriver().findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr["+i+"]/td[6]")).getText();
			Thread.sleep(3000);
			String monetaryValue = itemCost;
			String numericPart = monetaryValue.substring(1);
			float Itemvalue = Float.parseFloat(numericPart);
			System.out.println("Coste of item("+i+") " +Itemvalue);	
			totalCost = totalCost + Itemvalue;
			
		}System.out.println("Total cost = "+totalCost);
	}
	
	public void validate() {
		
		String expected = TotalExpectedValue.getText();
		String totalexp = expected.substring(1);
		float expectedTotal = Float.parseFloat(totalexp);
		if(totalCost == expectedTotal) {
			Assert.assertTrue(true);
			System.out.println("===PASS===");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("===FAIL===");
		}
		
		
	}
	
	
	
	

}
