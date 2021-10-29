package com.Vtiger.Automation.Marketing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.Automation.Utility.UtilityClass;

public class LeadClass {
	@FindBy(xpath="//img[@title='Maak Lead...']")
	private WebElement CreateLead_Button;

	
	public void sendMail() {
		
		
	}
	
	public void massEdit() {
		
		
	}
	
	public void sendMsg() {
		
		
	}
	
	public void clickCreateLeadButton() {
		
		UtilityClass.ReturnUtilObj().fn_Click(CreateLead_Button);
	}
}
