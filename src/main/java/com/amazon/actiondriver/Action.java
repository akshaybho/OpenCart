package com.amazon.actiondriver;



import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.actioninterface.ActionInterface;
import com.amazon.base.Base;

import static java.time.Duration.*;

public class Action extends Base implements ActionInterface {
	
	

	public void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

    public boolean findElement(WebDriver driver, WebElement ele) {
    	boolean flag = false;
    	try {
    		ele.isDisplayed();
    		flag = true;
    	}
    	catch(Exception e) {
    		flag = false;
    	}
    	finally {
    		if(flag) {
    			System.out.println("Successfully found element at");
    		}
    		else {
    			System.out.println("Unable to locate element at");
    		}
    	}
    return flag;
    }

    public boolean isDisplayed(WebDriver driver, WebElement ele) {
    	boolean flag = false;
    	flag = findElement(driver, ele);
    	if(flag) {
    		flag = ele.isDisplayed();
    		if(flag) {
    			System.out.println("The element is Displayed");
    		}
    		else {
    			System.out.println("Not Displayed");
    		}
    	}
    return flag;
    }

    public boolean isSelected(WebDriver driver, WebElement ele) {
    	boolean flag = false;
    	flag = findElement(driver, ele);
    	if(flag) {
    		flag = ele.isSelected();
    		if(flag) {
    			System.out.println("The element is Selected");
    		}
    		else {
    			System.out.println("The element is not Selected");
    		}
    	}
    	else {
    		System.out.println("Not Selected");
    	}
    return flag;
    }

    public boolean isEnabled(WebDriver driver, WebElement ele) {
    	boolean flag = false;
    	flag = findElement(driver, ele);
    	if(flag) {
    		flag = ele.isEnabled();
    		if(flag) {
    			System.out.println("The element is Enabled");
    		}
    		else {
    			System.out.println("The element is not Enabled");
    		}
    	}
    	else {
    		System.out.println("Not Enabled");
    	}
    
    return flag;
    }

    public boolean type(WebElement ele, String text) {
    	boolean flag = false;
    	try {
    		flag = ele.isDisplayed();
    		ele.clear();
    		ele.sendKeys(text);
    		flag = true;
    	}
    	catch(Exception e) {
    		System.out.println("Location not found");
    		flag = false;
    	}finally {
    		if(flag) {
    			System.out.println("Successfully entered value");
    		}
    		else {
    			System.out.println("Unable to enter value");
    		}
    	}   
    return flag;
    }

    public boolean selectBySendkeys(String value, WebElement ele) {
    	boolean flag = false;
    	try {
    		ele.sendKeys(value);
    		flag = true;
    		return true;
    	}catch (Exception e) {
    		return false;
    	}finally {
    		if(flag) {
    			System.out.println("Select value from dropdown");
    		}
    		else {
    			System.out.println("Not able to select value from dropdown");
    		}
    	}
   
    }

    public boolean selectByIndex(WebElement ele, int index) {
    	boolean flag = false;
    	try {
    		Select s = new Select(ele);
    		s.selectByIndex(index);
    		flag = true;
    		return true;
    	}catch (Exception e) {
    		return false;
    	}finally {
    		if(flag) {
    			System.out.println("Option selected by index");
    		}
    		else {
    			System.out.println("Not able to select option by index");
    		}
    	}
   
    }

    public boolean selectByValue(WebElement ele, String value ) {
    	boolean flag = false;
    	try {
    		Select s = new Select(ele);
    		s.selectByValue(value);
    		flag = true;
    		return true;
    	}catch (Exception e) {
    		return false;
    	}finally {
    		if(flag) {
    			System.out.println("Option selected by value");
    		}
    		else {
    			System.out.println("Not able to select option by value");
    		}
    	}
   
    }

    public boolean selectByVisibleText(String visibletext, WebElement ele) {
    	boolean flag = false;
    	try {
    		Select s = new Select(ele);
    		s.selectByVisibleText(visibletext);
    		flag = true;
    		return true;
    	}catch (Exception e) {
    		return false;
    	}finally {
    		if(flag) {
    			System.out.println("Option selected by visibletext");
    		}
    		else {
    			System.out.println("Not able to select option by visibletext");
    		}
    	}
   
    }
    //We can use Actions class to perform mouse hovers, 
    //if we are are not able to perform due to any restrictions, we can use JavaScriptExecutor to perform the same action.

    public boolean mouseHoverByJavaScript(WebElement ele) {
    	boolean flag= false;
    	try {
    		WebElement mo = ele;
    		String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
    		JavascriptExecutor js = (JavascriptExecutor)driver;
    		js.executeScript(javaScript, ele);
    		flag = true;
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    	finally {
    		if(flag) {
    			System.out.println("MouseHver action is performed");
    		}
    		else {
    			System.out.println("MouseHover action is not performed");
    		}
    	}
    }  
   

    public boolean switchToFrameByIndex(WebDriver driver, int index) {
    	boolean flag = false;
    	try {
    		new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//iframe")));
    		driver.switchTo().frame(index);
    		flag = true;
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    	finally {
    		if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
    	}
    }

    public boolean switchToFrameByName(WebDriver driver, String name) {
    	boolean flag = false;
    	try {
    		new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//iframe")));
    		driver.switchTo().frame(name);
    		flag = true;
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    	finally {
    		if (flag) {
				System.out.println("Frame with index \"" + name + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + name + "\" is not selected");
			}
    	}
    }

    public boolean switchToFrameById(WebDriver driver, String idValue) {
    	boolean flag = false;
    	try {
    		new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//iframe")));
    		driver.switchTo().frame(idValue);
    		flag = true;
    		return true;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	finally {
    		if (flag) {
				System.out.println("Frame with index \"" + idValue + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + idValue + "\" is not selected");
			}
    	}
    }

    public boolean switchToDefaultFrame(WebDriver driver) {
    	boolean flag = false;
    	try {
    		driver.switchTo().defaultContent();
    		flag = true;
    		return true;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	finally {
    		if(flag) {
    			// SuccessReport("SelectFrame ","Frame with Name is selected");
    		}
    		else if(!flag) {
    			// failureReport("SelectFrame ","The Frame is not selected");
    		}
    	}
    }

    public boolean mouseHoverElement(WebDriver driver, WebElement ele) {
    	boolean flag = false;
    	try {
    		new Actions(driver).moveToElement(ele).perform();
    		flag = true;
    	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    	finally {
    		if(flag) {
    			System.out.println("MouseHover action is performed");
    		}
    		else {
    			System.out.println("MouseHover action is not performed");
    		}
    	
    	}
    
    return flag;
    }

    public boolean moveToElement(WebDriver driver, WebElement ele) {
    	boolean flag = false;
    	try {
    		new Actions(driver).moveToElement(ele).build().perform();
    		flag = true;
    		return true;
    	}
    	catch (Exception e){
    		return false;
    	}
    	finally {
    		/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
    	}
    }

    public boolean draggable(WebDriver driver,WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Exception e) {
		
			return false;
			
		} finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \""+source+"\"");			
			} else if(!flag) {
				System.out.println("Draggable action is not performed on \""+source+"\"");
			}
		}
    }

    public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
          boolean flag = false;
          try {
        	  new Actions(driver).dragAndDrop(source, target);
        	  flag = true;
        	  return true;
        	  }
          catch(Exception e) {
        	  return false;
          }
          finally {
        	  if(flag) {
        		  System.out.println("DragAndDrop Action is performed");
        	  }
        	  else if(!flag) {
        		  System.out.println("DragAndDrop Action is not performed");
        	  }
          }
    }

    public boolean slider(WebDriver driver,WebElement ele, int x, int y) {
	     boolean flag = false;
	    try {
		// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
		// .perform();
		new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
		Thread.sleep(5000);
		flag = true;
		return true;
	} catch (Exception e) {

		return false;
	} finally {
		if (flag) {
			System.out.println("Slider Action is performed");
		} else {
			System.out.println("Slider Action is not performed");
		}
	}
}

    public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Window is Navigated with title");				
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}

	public boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Focus navigated to the window with title");			
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}

	public int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}
	

	public int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}
	
	
	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * 
	 */

	public boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		org.openqa.selenium.Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");		
			} else{
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}

	public boolean launchUrl(WebDriver driver,String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \""+url+"\"");				
			} else {
				System.out.println("Failed to launch \""+url+"\"");
			}
		}
	}
	

	public boolean isAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}
	

	public String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	

	public String getCurrentURL(WebDriver driver)  {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}
	

	public boolean click1(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \""+locatorName+"\"");
			} else {
				System.out.println("Click Unable to click on \""+locatorName+"\"");
			}
		}

	}

	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
			FluentWait<WebDriver> webDriverFluentWait = new FluentWait<WebDriver>((WebDriver) driver);
			webDriverFluentWait.withTimeout(ofSeconds(20));
			webDriverFluentWait.pollingEvery(ofSeconds(2));
			webDriverFluentWait.ignoring(Exception.class);
			wait = webDriverFluentWait;
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}

	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}

	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "D:\\ak\\Amazon_1\\Screenshot" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}

	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

	public boolean rightclick(WebDriver driver,WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}

    public boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}
	

	public boolean mouseover(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean JSClick(WebDriver driver, WebElement ele) throws Exception {
		boolean flag = false;
    	try {
    		JavascriptExecutor js = (JavascriptExecutor)driver;
    		js.executeScript("arguments[0].click()", ele);
    		flag = true;
    	}
    	catch(Exception e) {
    		throw e;
    	}
    	finally {
    		if(flag) {
    			System.out.println("Click action is performed");
    		}
    		else {
    			System.out.println("Click action is not perfprmed");
    		}
    	}
    	return flag;
	}
	
	

}




