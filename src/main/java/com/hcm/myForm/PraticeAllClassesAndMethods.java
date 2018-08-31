package com.hcm.myForm;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PraticeAllClassesAndMethods {
	WebDriver driver;
	public void handleDropdowns(){
	//dropdowns
	WebElement element = driver.findElement(By.xpath(""));
	Select select = new Select(element);
	select.selectByIndex(0);
	select.selectByValue("a");
	select.selectByVisibleText("Pankaj");
	
	//deSelect
	select.deselectByIndex(0);
	select.deselectByValue("a");
	select.deselectByVisibleText("b");
	
	 Set<String> set = driver.getWindowHandles();
	 
	
	}
	

}
