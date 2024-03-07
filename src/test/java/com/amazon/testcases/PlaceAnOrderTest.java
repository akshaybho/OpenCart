package com.amazon.testcases;

import com.amazon.actiondriver.Action;
import com.amazon.base.Base;
import com.amazon.pageobjects.PlaceAnOrder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PlaceAnOrderTest extends Base {

    PlaceAnOrder p;
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
    public void orderAnItem() throws InterruptedException, IOException {
        p = new PlaceAnOrder();
        p.clickOnDesktop();
        Thread.sleep(2000);
        p.clickOnMac();
        Thread.sleep(2000);
        p.clickonLaptopAndNotebook();
        Thread.sleep(2000);
        p.clickOnSony();
        Thread.sleep(2000);
        p.clickonAddtoCart();
        Thread.sleep(2000);
        p.getSuccessMessage();
        Thread.sleep(2000);
        p.clickOnItemCart();
        Thread.sleep(2000);
        p.clickOnViewCart();
        Thread.sleep(2000);
        //p.getThePageTitle();
        //Thread.sleep(2000);
        p.getThePageTitle();
        Thread.sleep(2000);
        p.clickOnCheckOut();
        Thread.sleep(2000);
        p.selectRadioButton();
        Thread.sleep(2000);
        p.clickOnGuestContinueButton();
        Thread.sleep(2000);
        p.personalInfo();
        Thread.sleep(2000);
        p.clickOnBillingContinueButton();
        Thread.sleep(2000);
        p.clickOnDeliveryContinueButton();
        Thread.sleep(2000);
        p.checkTermsAndConditions();
        Thread.sleep(2000);
        p.clickOnPaymentContinueButton();
        Thread.sleep(2000);
        p.clickonConfirmOrder();
        Thread.sleep(2000);
        p.getFinalPageText();
    }

}
