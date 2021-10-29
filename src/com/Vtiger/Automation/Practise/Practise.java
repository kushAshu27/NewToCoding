package com.Vtiger.Automation.Practise;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.Automation.HomePage.MyHomePageClass;
import com.Vtiger.Automation.Login.LoginClass;
import com.Vtiger.Automation.Marketing.LeadClass;
import com.Vtiger.Automation.TestScenarios.TestScenarios;
import com.Vtiger.Automation.Utility.TestDataUtil;
import com.Vtiger.Automation.Utility.UtilityClass;

public class Practise {
	
	public static WebDriver driverchild = null;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String TCID = "TC003";
		TestDataUtil.getTestCaseData("TestData\\TestData.xlsx", TCID);
		UtilityClass.launchBrowser("ch");
		LoginClass LoginObject = UtilityClass.navigateURL("http://localhost:8888/index.php");
		MyHomePageClass homeobj = LoginObject.doLogin();
		System.out.println("done till here");
		homeobj.verifyAboutUs();
		switchbrowser();
	}
	
	public static WebDriver switchbrowser()
	{
		ChromeDriver driver1 = new ChromeDriver();
		Set<String> handval = driver1.getWindowHandles();
		for(String handleValue : handval)
		{
			driverchild = driver1.switchTo().window(handleValue);
			String title = driverchild.getTitle();
			if(title.equalsIgnoreCase("vtiger CRM 5 - Free, Commercial grade Open Source CRM"))
			{
				return driverchild;
			}
		}
		return driver1;
	}

}
