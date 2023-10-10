package TestMethods;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewYorkFlight {
	public static WebElement dropdown;
	public static Select s;
	
	@DataProvider(name = "dates")
	public int[][] myDates() 
	{
		int[][] data = { { 10 }, { 11 },
				{12},
				{13},
				{14}
		};
		return data;
	}
	
	@Test(dataProvider = "dates")
	public void doVerify(int[] dates) throws IOException, InterruptedException 
	{
		MainFile.createTestReport("NewYork Flight");
		MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
		MainFile.setupDriver();
		MainFile.myLogger.info("Searching flight from NewYork To Bangkok");
	
		fillInfo(dates[0]);
		
		MainFile.closeDriver();
		MainFile.extent.flush();
	}
	
	public static void fillInfo(Integer date) throws IOException, InterruptedException 
	{
		MainFile.getSheet(2);
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
					
				case "returndate":
					MainFile.driver.findElement(By.id(locators)).click();
					MainFile.driver.findElement(By.linkText(((Integer)(date+2)).toString())).click();
					break;
					
				case "adult":
					dropdown = MainFile.driver.findElement(By.id(locators));
					dropdown.click();
					s = new Select(dropdown);
					s.selectByVisibleText(data11.charAt(0)+"");
					break;
					
				case "children":
					dropdown = MainFile.driver.findElement(By.id(locators));
					dropdown.click();
					s = new Select(dropdown);
					s.selectByVisibleText(data11.charAt(0)+"");
					break;
					
				case "infant":
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
		MainFile.myLogger.info("NewYork to Bangkok flight is getting searched.");
	}
	
}
		



