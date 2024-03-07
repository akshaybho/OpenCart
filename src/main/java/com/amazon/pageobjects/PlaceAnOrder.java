package com.amazon.pageobjects;

import com.amazon.actiondriver.Action;
import com.amazon.base.Base;
import com.amazon.utility.Utility;
import org.apache.poi.xdgf.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;


public class PlaceAnOrder extends Base {

    Action a = new Action();

    Utility u = new Utility();



    @FindBy(xpath ="//a[text()=\"Desktops\"]")
    WebElement Desktops;

    @FindBy(xpath = "//a[text()='Mac (1)']")
    WebElement Mac;

    @FindBy(xpath ="//a[text()=\"Laptops & Notebooks (5)\"]")
    WebElement LaptopsAndNotebooks;

    @FindBy(xpath ="//*[@id=\"content\"]/div[4]/div[5]/div/div[2]/div[1]/h4/a")
    WebElement sonyLaptop;

    @FindBy(css ="button#button-cart")
    WebElement addToCart;

    @FindBy(css ="span#cart-total")
    WebElement itemsInCart;

    @FindBy(xpath ="//a/strong/i[@class='fa fa-shopping-cart']")
    WebElement viewCart;

    @FindBy(xpath ="//a[text()='Checkout']")
    WebElement checkOut;

    @FindBy(xpath ="//input[@value='guest']")
    WebElement guestCheckOut;

    @FindBy(xpath ="//*[@id='button-account']")
    WebElement GuestcontinueBtn;

    @FindBy(css ="input#input-payment-firstname")
    WebElement firstName;

    @FindBy(css ="input#input-payment-lastname")
    WebElement lastName;

    @FindBy(css ="input#input-payment-email")
    WebElement Email;

    @FindBy(css ="input#input-payment-telephone")
    WebElement telePhone;

    @FindBy(css ="input#input-payment-company")
    WebElement companyName;

    @FindBy(css ="input#input-payment-address-1")
    WebElement Address;

    @FindBy(css ="input#input-payment-city")
    WebElement cityName;

    @FindBy(css ="input#input-payment-postcode")
    WebElement postCode;

    @FindBy(css ="select#input-payment-country")
    WebElement countryDropDown;

    @FindBy(css ="select#input-payment-zone")
    WebElement stateDropDown;

    @FindBy(css ="input#button-guest")
    WebElement BillContinueBtn;

    @FindBy(css ="input#button-shipping-method")
    WebElement DeliverContinueBtn;

    @FindBy(xpath ="//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
    WebElement checkBox;

    @FindBy(xpath = "//*[@id='button-payment-method']")
    WebElement paymentContinueBtn;
    @FindBy(css="input#button-confirm")
    WebElement confirmOrderBtn;

    @FindBy(xpath ="//div/h1")
    WebElement orderText;

    @FindBy(css = "div.alert.alert-success.alert-dismissible")
    WebElement alertText;

    public PlaceAnOrder()
    {
        PageFactory.initElements(driver, this);
    }

    public void clickOnDesktop()
    {
        a.click(driver,Desktops);
    }

    public void clickOnMac()
    {

        a.click(driver, Mac);
    }

    public void clickonLaptopAndNotebook()
    {

        a.click(driver, LaptopsAndNotebooks);
    }

    public void clickOnSony()
    {

        a.click(driver, sonyLaptop);

    }

    public void clickonAddtoCart()
    {

        a.click(driver, addToCart);
    }

    public void getSuccessMessage()
    {
        String text = alertText.getText();
        System.out.println(text);
    }

    public void clickOnItemCart()
    {

        a.click(driver, itemsInCart);
    }

    public void clickOnViewCart()
    {

        a.click(driver, viewCart);
    }

   /* public void checkSelectedItem()
    {

        WebElement selectedItem = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/a"));
        String textSelectedItem = selectedItem.getText();
        System.out.println("Selected Item = "+textSelectedItem);
        String sony = sonyLaptop.getText();
        WebElement selectedItem = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/a"));
        String textSelectedItem = selectedItem.getText();
        if(textSelectedItem.equals(sony))
        {

            System.out.println("===PASS===");
        }
        else
        {
            System.out.println("===FAIL===");


        }
    }*/

    public void getThePageTitle()
    {

        System.out.println(a.getTitle(driver));
    }

    public void clickOnCheckOut()
    {

        a.click(driver, checkOut);
    }

    public void selectRadioButton()
    {
        a.click(driver, guestCheckOut);
    }

    public void clickOnGuestContinueButton()
    {
        a.click(driver, GuestcontinueBtn);
    }

    public void personalInfo() throws InterruptedException, IOException {
       String mail = u.generateEmail();
       firstName.sendKeys(p.getProperty("firstname"));
        Thread.sleep(2000);
       lastName.sendKeys(p.getProperty("lastname"));
        Thread.sleep(2000);
       Email.sendKeys(mail);
        Thread.sleep(2000);
       telePhone.sendKeys(p.getProperty("telephone"));
        Thread.sleep(2000);
       companyName.sendKeys(p.getProperty("company"));
        Thread.sleep(2000);
       Address.sendKeys(p.getProperty("address"));
        Thread.sleep(2000);
       cityName.sendKeys(p.getProperty("city"));
        Thread.sleep(2000);
       postCode.sendKeys(p.getProperty("pincode"));
        Thread.sleep(2000);

       countryDropDown.click();
        // Assuming you've already instantiated the WebDriver instance 'driver'

// Use Select class for dropdown handling
        Select countryDropdown = new Select(driver.findElement(By.xpath("//select[@name='country_id']")));

// Selecting by visible text "India"
        countryDropdown.selectByVisibleText("India");
        Thread.sleep(2000);

        stateDropDown.click();
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@name='zone_id']")));
        stateDropdown.selectByVisibleText("Maharashtra");


    }

    public void clickOnBillingContinueButton()
    {
        a.click(driver, BillContinueBtn);
    }

    public void clickOnDeliveryContinueButton()
    {
        a.click(driver, DeliverContinueBtn);
    }

    public void checkTermsAndConditions()
    {
        a.click(driver, checkBox);
    }

    public void clickOnPaymentContinueButton()
    {
        a.click(driver, paymentContinueBtn);
    }

    public void clickonConfirmOrder()
    {
        a.click(driver,confirmOrderBtn);

    }

    public void getFinalPageText(){
        String finalText = orderText.getText();
        System.out.println(finalText);
    }

}
