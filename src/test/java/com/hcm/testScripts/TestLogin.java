package com.hcm.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hcm.pages.Loginpage;
import com.hcm.testbase.TestBase;

public class TestLogin extends TestBase{
	
	@Test(description="login to the appliaction")
	public void loginToAppliaction() throws InterruptedException{
		Loginpage login = PageFactory.initElements(driver, Loginpage.class);
		login.enterEmployIdInTextboxCode("1000");
		login.enterPasswordInTextbox("leo@123");
		login.clickToSingnInButton();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		Reporter.log("Dashboard is displayed"+title);
		Assert.assertEquals(title, "HCM");
	}
	
	

}
