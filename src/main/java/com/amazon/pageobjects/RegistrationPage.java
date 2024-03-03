package com.amazon.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;

public class RegistrationPage extends Base {
	
	@FindBy(xpath = "//a//span[text()='My Account']")
	WebElement accountBtn;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerBtn;
	
	@FindBy(id = "input-firstname")
	WebElement firstName;
	
	@FindBy(id = "input-lastname")
	WebElement lastName;
	
	@FindBy(id = "input-email")
	WebElement eMail;
	
	@FindBy(id = "input-telephone")
	WebElement telePhone;
	
	@FindBy(id = "input-password")
	WebElement password;
	
	@FindBy(id = "input-confirm")
	WebElement passwordConfirm;
	
	@FindBy(css = ".btn.btn-primary")
	WebElement continueBtn;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	WebElement alertText;
	
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement checkBox;
	
	@FindBy(css = "div#content h1")
	WebElement registerText;
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRegi() throws InterruptedException {
		accountBtn.click();
		Thread.sleep(3000);
		registerBtn.click();
	}
	
	public void Info() throws InterruptedException {
		firstName.sendKeys("Akshay");
		Thread.sleep(3000);
		lastName.sendKeys("Bhogale");
		Thread.sleep(3000);
		eMail.sendKeys("abc@gmail.com");
		Thread.sleep(3000);
	    telePhone.sendKeys("1234");
	    Thread.sleep(3000);
	    }
	
	public void enterPassword() throws IOException, InterruptedException {
		String pwd = Base.decodeString(p.getProperty("password"));
		password.sendKeys(pwd);
		Thread.sleep(3000);
		passwordConfirm.sendKeys("Aksh@115");
		continueBtn.click();
		Thread.sleep(3000);
	}
	
	public void verifyError() throws InterruptedException {
		
		String text = alertText.getText();
		System.out.println(text);
	}
	
	public void checkTheBox() throws InterruptedException {
		checkBox.click();
		Thread.sleep(3000);
	}
	
	public void textMessage() {
		String data = registerText.getText();
		System.out.println(data);
	}

	

}
