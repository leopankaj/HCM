package com.hcm.myForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hcm.testbase.TestBase;

public class Permission extends TestBase {
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/nav/ul/li[3]/a/div[1]/img")
	WebElement myFormsModule;
	
	@FindBy(tagName = "a")
	WebElement permission;
	
	@FindBy(name="checkIN_length")
	WebElement showdropdown;
	
	public void Permission(WebDriver driver){
		this.driver= driver;
	
	}
	public void clickToMyFormsImageModule(){
		String imageAttribute = myFormsModule.getAttribute("src");
	}
	public void clickToPermissionLink(){
		permission.click();
	}
	public void selectdShowDropdown(){
		
	}

}
