package TestMethods;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Billing {
	public static WebElement dropdown;
	public static Select s;
	
	@DataProvider(name = "dates")
	public int[][] myDates() 
	{
		int[][] data = { { 13 }, 
//				{ 21 },
//		
////				{22},
////				{23},
////				{24}
		};
		return data;
	}
	
	
	@Test(dataProvider = "dates")
	public void doVerify(int[] dates) throws IOException, InterruptedException 
	{
		MainFile.createTestReport("Ask Maharajah");
		MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
		MainFile.setupDriver();
	
		fillsData(dates[0]);
		MainFile.closeDriver();
		MainFile.extent.flush();
		
		
	}
	
	
	public static void fillsData(Integer date) throws IOException, InterruptedException 
	{
		MainFile.getSheet(1);
		int rows= MainFile.sheet.getPhysicalNumberOfRows();
		
		for(int i=1;i<rows;i++) 
		{
			String myAction=MainFile.getActions(i, 0);
			String locators=MainFile.getActions(i, 1);
			String data11=MainFile.getActions(i, 2);
			String data1=MainFile.getActions(i, 3);
			
			switch(myAction)
			{
				case "from":
					MainFile.driver.findElement(By.id(locators)).sendKeys(data11);
					MainFile.driver.findElement(By.partialLinkText(data1)).click();
					break;
					
				case "to":
					MainFile.driver.findElement(By.id(locators)).sendKeys(data11);
					MainFile.driver.findElement(By.partialLinkText(data1)).click();
					break;
				
				case "oneway":
					MainFile.driver.findElement(By.id(locators)).click();
					break;
					
				case "departuredate":
					MainFile.driver.findElement(By.id(locators)).click();
     				MainFile.driver.findElement(By.linkText(date.toString())).click();
     
					break;
					
				case "adult":
					dropdown = MainFile.driver.findElement(By.id(locators));
					dropdown.click();
					s = new Select(dropdown);
					s.selectByVisibleText(data11.charAt(0)+"");
					break;
							
				case "search":
					MainFile.driver.findElement(By.id(locators)).click();
					break;
			}
			
		}
		
		Thread.sleep(10000);
		
		// selecting a flight
		MainFile.driver.findElements(By.xpath("//button[@type='button']//span//div[text()='Economy']")).get(0).click();
				
		// selecting plan
		MainFile.driver.findElement(By.xpath("//div[@class='carousel-container']//ul[@class='carousel']//li[contains(@class,'fare-card-list-item')]")).click();
		
		MainFile.driver.findElement(By.xpath("//span[text()='Continue']")).click();
		
		// clicking 'Keep Web Special Economy'
		MainFile.driver.findElement(By.xpath("//button//span//span[text()='Keep Web Special Economy']")).click();
		
		// clicking 'Fill passengers details'
		MainFile.driver.findElement(By.xpath("//span[text()='Fill passenger details']")).click();
		
		Thread.sleep(3000);
		MainFile.driver.findElement(By.id("mat-select-value-5")).click();
		MainFile.driver.findElement(By.xpath("//span[text()='Mr']")).click();
		MainFile.driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(0).sendKeys("Riya");
		MainFile.driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(1).sendKeys("singh");
		MainFile.driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(2).sendKeys("14/02/2002");
		MainFile.driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(4).sendKeys("sriya@gmail.com");
		MainFile.driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(5).sendKeys("sriya@gmail.com");
		MainFile.driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(6).sendKeys("91");
		MainFile.driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(7).sendKeys("78906767");
		MainFile.driver.findElement(By.xpath("//span[contains(text(), 'I Agree To')]")).click();
		MainFile.driver.findElement(By.xpath("//button//span//span[text()='Confirm']")).click();
		Thread.sleep(12000);
		File SrcFile=((TakesScreenshot)MainFile.driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SrcFile, new File(MainFile.Directory + "\\src\\main\\Screenshot\\Billing.jpg"));
		
		MainFile.myLogger.info("Billing information is added successfully");
	}
}
			
				


