package com.Vtiger.Automation.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.Automation.Login.LoginClass;

public class UtilityClass {

	public static WebDriver driver = null;
	private static UtilityClass utilobj = null;
	
	
	
	public static UtilityClass ReturnUtilObj()
	{
		if(utilobj==null)
		{
			utilobj = new UtilityClass();
			return utilobj;
		}
		return utilobj;
	}
	
	
	private UtilityClass()
	{
		
	}
	
	public void fn_Input(WebElement we, String Val) {
		
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				we.sendKeys(Val);
			}
		}
	}
	public void fn_Click(WebElement we) {
		
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				we.click();
			}
		}
	}
	
	public static void fn_SelectByIndex(WebElement we, int index) {
		
		Select selobj = new Select(we);
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				selobj.selectByIndex(index);
			}
		}
	}
	public static void fn_SelectByVisibleText(WebElement we, String Val) {
		
		Select selobj = new Select(we);
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				selobj.selectByVisibleText(Val);
			}
		}
	}
	public static void fn_SelectByValue(WebElement we, String Val) {
		
		Select selobj = new Select(we);
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				selobj.selectByValue(Val);
			}
		}
	}
	public static void launchBrowser(String BrowserName) {
		
		if(BrowserName.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(BrowserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		if(BrowserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}
	public static LoginClass navigateURL(String URL) {
		if(null != driver) {
		driver.get(URL);
		LoginClass LoginObject  = PageFactory.initElements(UtilityClass.driver, LoginClass.class);
		return LoginObject;
		}
		return null;
	}
	public static void deleteCookies() {
		
		if(null != driver) {
		driver.manage().deleteAllCookies();
		}
	}
	
	public static void mouseHover(WebElement we) {

		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				Actions actionobj = new Actions(driver);
				actionobj.moveToElement(we).build().perform(); 
			}
		}
	}
	public static void dragAndDrop(WebElement weSource, WebElement weTarget) {

		if(weSource.isDisplayed()) {
			if(weSource.isEnabled()) {
				Actions actionobj = new Actions(driver);
				actionobj.dragAndDrop(weSource, weTarget).build().perform();
			}
		}
	}
	
	public static WebElement createWebElement(String LocatorName, String LocatorValue) {
		
		if(LocatorName.equalsIgnoreCase("name")) {
			WebElement we = driver.findElement(By.name(LocatorValue));
			return we;
		}else if(LocatorName.equalsIgnoreCase("id")) {
			WebElement we = driver.findElement(By.id(LocatorValue));
			return we;
		}else if(LocatorName.equalsIgnoreCase("xpath")) {
			WebElement we = driver.findElement(By.xpath(LocatorValue));
			return we;
		}else if(LocatorName.equalsIgnoreCase("linkText")) {
			WebElement we = driver.findElement(By.linkText(LocatorValue));
			return we;
		}
		return null;
	}
	
	public static void readPropertyFile()
	{
		
	}
	
	public static void switchBrowser()
	{
		
	}
	
}
