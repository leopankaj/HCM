package com.hcm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Loginpage {
	
	WebDriver driver;
	@FindBy(name = "employeecode")
	WebElement employId;
	
	@FindBy(name = "Password")
	WebElement password;
	
	@FindBy(id = "loginid")
	WebElement singIn;
	
	public Loginpage(WebDriver driver){
		this.driver =driver;
		
	}
	
	public void enterEmployIdInTextboxCode(String employcode){
		employId.sendKeys(employcode);
		Reporter.log("Enter employeeId successfully");

	}
	
	public void enterPasswordInTextbox(String password1){
		password.sendKeys(password1);
		Reporter.log("Enter password successfully");
	}
	public void clickToSingnInButton(){
		singIn.click();
		Reporter.log("click button successfully");
		
	}
	
	

}
