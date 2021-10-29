package com.Vtiger.Automation.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.Automation.HomePage.MyHomePageClass;
import com.Vtiger.Automation.Utility.TestDataUtil;
import com.Vtiger.Automation.Utility.UtilityClass;

public class LoginClass {

	@FindBy(name="user_name")
	private WebElement UserName;
	@FindBy(name="user_password")
	private WebElement UserPassword;
	@FindBy(name="Login")
	private WebElement ContinueBt;
	@FindBy(name="login_theme")
	private WebElement color_DR;
	@FindBy(name="login_language")
	private WebElement Language_DR;
	
	public MyHomePageClass doLogin() {
		
	//	WebElement UserName = UtilityClass.createWebElement("name", "admin");
		UtilityClass.ReturnUtilObj().fn_Input(UserName, TestDataUtil.TDMap.get("User_Login_UserName_ED"));
		UtilityClass.ReturnUtilObj().fn_Input(UserPassword, TestDataUtil.TDMap.get("User_Login_Password_ED"));
		UtilityClass.fn_SelectByValue(color_DR, "bluelagoon");
		UtilityClass.fn_SelectByValue(Language_DR, "en_us");
		UtilityClass.ReturnUtilObj().fn_Click(ContinueBt);
		MyHomePageClass homeobj = PageFactory.initElements(UtilityClass.driver, MyHomePageClass.class);
		return homeobj;
	}
}
