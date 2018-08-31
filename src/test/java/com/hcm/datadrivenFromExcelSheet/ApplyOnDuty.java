package com.hcm.datadrivenFromExcelSheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;

public class ApplyOnDuty extends base2{
	
	
	@Test(dataProvider="login")
	public void ApplyOnDutyForm(String id,String pd,String location) throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//*[@id='employeecode']"))).click().pause(1000).sendKeys(id).build().perform();
		
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		act.moveToElement(pwd).click().pause(1000).sendKeys(pwd,pd).build().perform();
		
		driver.findElement(By.xpath("//*[@id='loginid']/h4")).click();
		driver.get("http://192.168.2.140:8282/thcm/ondutyform");
		Thread.sleep(2000);
	
		// click on apply to on duty button
		driver.findElement(By.xpath("//*[@id='tableid']/div[2]/div[1]/div/button")).click();
		/*WebElement vElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tableid']/div[2]/div[1]/div/button")));
		act.moveToElement(vElement).click();*/
		Reporter.log("Successfully clicked on ApplyOnDuty/OnTour button ",true);
		Thread.sleep(3000);
		//Select value from application type
		WebElement applicationtype = driver.findElement(By.xpath("//*[@id='ddlApplicationType']"));
		Select select = new Select(applicationtype);
		select.selectByValue("On-Duty form");
		Reporter.log("Selected Value from dropdown : "+select.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		//Select value from on duty type dropdown
		WebElement onDutyType = driver.findElement(By.id("ddlLeaveType"));
		Select select1 = new Select(onDutyType);
		select1.selectByIndex(0);
		Reporter.log(select1.getFirstSelectedOption().getText(),true);
		Thread.sleep(3000);
		//Enter From Date
		driver.findElement(By.id("fromdateid")).click();
		driver.findElement(By.linkText("24")).click();
		Reporter.log("From Date : "+driver.findElement(By.id("fromdateid")).getText(),true);
		Thread.sleep(3000);
		//Enter from date
		driver.findElement(By.id("todateid")).click();
		driver.findElement(By.linkText("24")).click();
		Reporter.log("Todate is : "+driver.findElement(By.id("todateid")).getText(),true);
		Thread.sleep(3000);
		//enter from date from date picker
		driver.findElement(By.xpath("//*[@id='fromtimeid']")).click();
		
		driver.findElement(By.xpath("//*[@id='fromtimeid']")).clear();
		driver.findElement(By.xpath("//*[@id='fromtimeid']")).sendKeys("11:30 AM");
		Reporter.log("Fro Time is : "+driver.findElement(By.xpath("//*[@id='fromtimeid']")).getText(),true);
		Thread.sleep(3000);
		//enter to date from date picker
		
		driver.findElement(By.xpath("//*[@id='totimeid']")).click();
		driver.findElement(By.xpath("//*[@id='totimeid']")).clear();
		driver.findElement(By.xpath("//*[@id='totimeid']")).sendKeys("01:30 PM");
		Reporter.log("To date is : "+driver.findElement(By.xpath("//*[@id='fromtimeid']")).getText(),true);
		Thread.sleep(3000);
		driver.findElement(By.name("worklocation")).click();
		driver.findElement(By.name("worklocation")).sendKeys(location);
		Reporter.log("Location is : "+driver.findElement(By.name("worklocation")).getText(),true);
		Thread.sleep(3000);
		driver.findElement(By.id("imprestcashid")).click();
		driver.findElement(By.id("imprestcashid")).sendKeys("500");
		Reporter.log("Cash is : "+driver.findElement(By.id("imprestcashid")).getText(),true);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='descriptionid']")).click();
		driver.findElement(By.xpath("//*[@id='descriptionid']")).sendKeys("Good");
		Reporter.log("Description is : ",true);
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//*[@id='btnsave']")).isEnabled()){
			driver.findElement(By.xpath("//*[@id='btnsave']")).click();
		}
		else{
			Reporter.log("save button is not enabled");
		}
		Thread.sleep(3000);
		
	}
 @DataProvider
 public Object[][] login() throws JXLException, IOException{
	 Object[][] data = getExcelData();
	return data;
	 
 }
private Object[][] getExcelData() throws JXLException, IOException {
	FileInputStream inputStream = new FileInputStream("D:\\Project_leodeaz\\HCM\\HCM_lvdata.xls");
	 Workbook book = Workbook.getWorkbook(inputStream);
	 Sheet sheet = book.getSheet("data");
	 String[][] arexceldada = new String[sheet.getRows()][sheet.getColumns()];
		for (int i = 0; i < sheet.getRows(); i++) 
		{
			for (int j = 0; j < sheet.getColumns(); j++) 
			{
				arexceldada[i][j]=sheet.getCell(j, i).getContents();
			}
		}
	return arexceldada;
}
}
