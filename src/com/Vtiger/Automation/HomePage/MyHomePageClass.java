package com.Vtiger.Automation.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.Automation.Utility.UtilityClass;

public class MyHomePageClass {

	@FindBy(linkText="Marketing")
	private WebElement we_Marketing;
	@FindBy(linkText="Leads")
	private WebElement we_Lead;
	@FindBy(linkText="Leads")
	private WebElement Lead_Link;
	@FindBy(linkText="About Us")
	private WebElement we; 
	
	public void goToLead() {
		
		UtilityClass.mouseHover(we_Marketing);
		UtilityClass.mouseHover(we_Lead);
		UtilityClass.ReturnUtilObj().fn_Click(Lead_Link);
	}
	
	public void verifyAboutUs()
	{
		UtilityClass.ReturnUtilObj().fn_Click(we);
	}
}
