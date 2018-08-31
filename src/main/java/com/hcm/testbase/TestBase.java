package com.hcm.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	
	public static WebDriver driver = null;
	public String url = "http://192.168.2.140:8282/thcm/";
	
	public static WebDriver getbrowser(){
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace_Pankaj\\HCM\\src\\main\\java\\com\\hcm\\browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("Browser open successfully");
		return driver;
	}
	
	public void initialUtils(){
		driver.manage().window().maximize();
		Reporter.log("Browser maximize successfully");
		
	}
	
	public void implicitWait(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void openApplication(){
		getbrowser();
		initialUtils();
		driver.get(url);
		implicitWait();
		Reporter.log("Application open successfully");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		Reporter.log("Application closed successfully");
	}
	

}
