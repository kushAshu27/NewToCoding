package com.Vtiger.Automation.TestScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.Automation.HomePage.MyHomePageClass;
import com.Vtiger.Automation.Login.LoginClass;
import com.Vtiger.Automation.Practise.Practise;
import com.Vtiger.Automation.Utility.TestDataUtil;
import com.Vtiger.Automation.Utility.UtilityClass;

public class TestScenarios {
	
	
	public static void main(String[] args) throws Exception {
		
		TS_001_VerifyValidLogin();
		//new TestScenarios().TS_003_CreateAndVerifyNewLead();
		
	}
	
	public static void TS_001_VerifyValidLogin() throws Exception {
		
		String TCID = "TC001";
		TestDataUtil.getTestCaseData("TestData\\TestData.xlsx", TCID);
		UtilityClass.launchBrowser("ch");
		UtilityClass.navigateURL("http://localhost:8888/index.php");
		LoginClass LoginObject  = PageFactory.initElements(UtilityClass.driver, LoginClass.class);
		MyHomePageClass homeobj = LoginObject.doLogin();
		homeobj.verifyAboutUs();
		WebDriver dd = Practise.switchbrowser();
		dd.findElement(By.name("close")).click();
	}
	
	public void TS_002_VerifyInValidLogin() {
		
		
	}
	
	public void TS_003_CreateAndVerifyNewLead() {
		
		String TCID = "TC003";
		UtilityClass.launchBrowser("ch");
		LoginClass LoginObject = UtilityClass.navigateURL("http://localhost:8888/index.php");
		MyHomePageClass homeobj = LoginObject.doLogin();
		homeobj.goToLead();
		
	}

	public void TS_004_VerifyAboutUsDetails() {
		
		String TCID = "TC003";
		UtilityClass.launchBrowser("ch");
		LoginClass LoginObject = UtilityClass.navigateURL("http://localhost:8888/index.php");
		MyHomePageClass homeobj = LoginObject.doLogin();
		homeobj.goToLead();
		
		
	}
}
