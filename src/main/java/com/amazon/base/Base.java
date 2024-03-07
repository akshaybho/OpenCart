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
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	
	
	public static Properties p;
	
	/*Thread local can be considered as a scope of access like session scope or request scope.
	 *  In thread local, you can set any object and this object will be local and global to the specific thread which is accessing this object.
	 *   Java ThreadLocal class provides thread-local variables.
	 */
	//public static WebDriver driver;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	
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

		
		
		String browserName = p.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();

			driver.set(new ChromeDriver());
		}
		else if(browserName.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		else if(browserName.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		a.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(p.getProperty("url"));
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

