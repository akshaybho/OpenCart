package com.amazon.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	public static Properties p;
	
	/*Thread local can be considered as a scope of access like session scope or request scope.
	 *  In thread local, you can set any object and this object will be local and global to the specific thread which is accessing this object.
	 *   Java ThreadLocal class provides thread-local variables.
	 */
	public static WebDriver driver;
	
	
	public void readConfig() {
		
		try {
			p = new Properties();
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			FileInputStream inputdet = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Details.properties");
			p.load(input);
			p.load(inputdet);
			System.out.println("driver: "+driver);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	} 
	
	public static void launchApp() {
		Base b = new Base();
		b.readConfig();
		Action a = new Action();
		WebDriverManager.chromedriver().setup();
		
		
		String browserName = p.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			driver = new ChromeDriver();		
		}
		else if(browserName.contains("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.contains("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		a.pageLoadTimeOut(driver, 30);
		driver.get(p.getProperty("url"));
	}
	
	public static String decodeString(String password) throws IOException {
		p = new Properties();
		FileInputStream input = new FileInputStream(
				System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		p.load(input);
		password  = p.getProperty("password");
		byte []decodedString = Base64.decodeBase64(password);
		return (new String(decodedString));
	}

	
	
	

}

