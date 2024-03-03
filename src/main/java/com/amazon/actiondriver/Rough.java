package com.amazon.actiondriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googinhydmabk-21&ref=pd_sl_7lvdlypdab_e&adgrpid=58666170373&hvpone=&hvptwo=&hvadid=678717150657&hvpos=&hvnetw=g&hvrand=10445659581428667736&hvqmt=e&hvdev=m&hvdvcmdl=&hvlocint=&hvlocphy=9062114&hvtargid=kwd-10573980&hydadcr=28228_2379650&gclid=CjwKCAiA4smsBhAEEiwAO6DEja71ogsbnbyay2BMaZmwaYuMJS0_gg9vEarpWiPe00ytdaqW9xgVHRoCfssQAvD_BwE");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[text()=\"Account & Lists\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("bhogale.akshay11@gmail.com");
		driver.findElement(By.cssSelector(".a-button-input")).click();
		driver.findElement(By.cssSelector("#ap_password")).sendKeys("Aksh@115");
		driver.findElement(By.cssSelector("#signInSubmit")).click();
		
		WebElement header = driver.findElement(By.cssSelector("header#navbar-main"));
		WebElement searchBar = header.findElement(By.cssSelector("#twotabsearchtextbox"));
		//WebElement item1 = driver.findElement(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
		//WebElement item2 = driver.findElement(By.cssSelector("span.a-size-base-plus.a-color-base.a-text-normal"));
		//WebElement buyNow = driver.findElement(By.cssSelector("input#buy-now-button"));
		
		
			searchBar.sendKeys("iphone");
			searchBar.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			WebElement item1 = driver.findElement(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
			item1.click();
			Thread.sleep(3000);
			String parent = driver.getWindowHandle();
			
			Set <String> windows = driver.getWindowHandles();
			Iterator <String> itr = windows.iterator();
			while(itr.hasNext()) {
				String child = itr.next();
				if(!parent.equals(child)) {
					driver.switchTo().window(child);
				}
			}
			WebElement buyNow = driver.findElement(By.cssSelector("input#buy-now-button"));
			buyNow.click();	
			Thread.sleep(3000);
			driver.switchTo().window(parent);
				Thread.sleep(3000);
			  
				driver.navigate().back();
				searchBar.sendKeys("fastrack watch");
				searchBar.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement item2 = driver.findElement(By.cssSelector("span.a-size-base-plus.a-color-base.a-text-normal"));
				item2.click();
				Thread.sleep(3000);
				
				String child = driver.getWindowHandle();
				
				Set <String> windowsList = driver.getWindowHandles();
				 itr = windowsList.iterator();
				while(itr.hasNext()){
					String grandchild = itr.next();
					if(!child.equals(grandchild)) {
						driver.switchTo().window(grandchild);
					}
				}
				buyNow.click();
			
			
		
		
	}
	

}
