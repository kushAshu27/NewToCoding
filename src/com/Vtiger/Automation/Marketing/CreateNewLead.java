package com.Vtiger.Automation.Marketing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.Automation.Utility.UtilityClass;

public class CreateNewLead {
	
	@FindBy(name="salutationtype")
	private WebElement  title;
	@FindBy(name="firstname")
	private WebElement First_Name;
	@FindBy(name="lastname")
	private WebElement Last_Name; 
	@FindBy(name="company")
	private WebElement Comapny;
	@FindBy(xpath="//input[@title='Save [Alt+S]' ]")
	private WebElement Save_Button;

	
	public void createNewLead() {
		
		UtilityClass.fn_SelectByVisibleText(title, "Mr.");
		UtilityClass.ReturnUtilObj().fn_Input(First_Name, "Kush");
		UtilityClass.ReturnUtilObj().fn_Input(Last_Name, "Singh");
		UtilityClass.ReturnUtilObj().fn_Input(Comapny, "TCS");
		UtilityClass.ReturnUtilObj().fn_Click(Save_Button);
	}
}
