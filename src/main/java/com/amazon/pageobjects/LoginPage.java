package com.amazon.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.amazon.actiondriver.Action;
import com.amazon.base.Base;

public class LoginPage extends Base {
	
	Action a = new Action();
	@FindBy(xpath = "//a//span[text()='My Account']")
	WebElement accountBtn;
	
	@FindBy(xpath = "//ul//a[text()=\"Login\"]")
	WebElement loginTab;
	
	@FindBy(id = "input-email")
	WebElement emailAddress;
	
	@FindBy(id = "input-password")
	WebElement passwordLogin;
	
	@FindBy(xpath = "//*[@value='Login']")
	WebElement submitBtn;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	WebElement alertMessage;
	
	@FindBy(css = "div#content h2")
	WebElement loginText;
	
	
	public LoginPage() {

		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnLoginTab() throws InterruptedException {
		accountBtn.click();
		Thread.sleep(3000);
		loginTab.click();
		Thread.sleep(3000);
	}
	
	
	public void loginInvalid(String email, String pwd) throws InterruptedException {
		emailAddress.sendKeys(email);
		Thread.sleep(3000);
		passwordLogin.sendKeys(pwd);
		Thread.sleep(3000);
		submitBtn.click();
		
		String text = alertMessage.getText();
		System.out.println(text);	
	}
	
	public void loginValid() throws InterruptedException, IOException {
		emailAddress.sendKeys(p.getProperty("username"));
		Thread.sleep(3000);
		String pwd = Base.decodeString(p.getProperty("password"));
		passwordLogin.sendKeys(pwd);		
		Thread.sleep(3000);
		submitBtn.click();
		Thread.sleep(3000);
		String text = loginText.toString();
		System.out.println(text);
		
	}
	

}
