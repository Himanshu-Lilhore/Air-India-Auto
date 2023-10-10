package TestMethods;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class DelhiSearchFlight {
	public static WebElement dropdown;
	public static Select s;
	
	@DataProvider(name = "dates")
	public int[][] myDates() 
	{
		int[][] data = { { 13 },
//				{ 14 },
//				{15},
//				{16},
//				{17}
		};
		return data;
	}
	
	
	@Test(dataProvider = "dates")
	public void doVerify(int[] dates) throws IOException, InterruptedException 
	{
		MainFile.createTestReport("Delhi Search Flight");
		MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
		MainFile.setupDriver();
		MainFile.myLogger.info("Searching flight from Delhi to Hyderabad");
		fillData(dates[0]);
		
		MainFile.closeDriver();
		MainFile.extent.flush();
	}
	
	
	public static void fillData(Integer date) throws IOException, InterruptedException 
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
		Thread.sleep(10000);
		String from=MainFile.driver.findElement(By.xpath("//div/div[@class=\"departure-city\"]")).getText();
		String to= MainFile.driver.findElement(By.xpath("//div/div[@class=\"destination-city\"]")).getText();
		String fromlower=from.toLowerCase();
		String tolower=to.toLowerCase();
		String del="delhi";
		String hyd="hyderabad";
		Assert.assertEquals(fromlower, del);
		Assert.assertEquals(tolower, hyd);
		
		String day=MainFile.driver.findElement(By.xpath("//div[@class=\"refx-display-5 depart-date refx-body-1\" and text()=\"Mon, 13 Mar\"]")).getText();
		String datecompare="Mon, 13 Mar";
		Assert.assertEquals(day, datecompare);
		
		MainFile.myLogger.info("Delhi flight is getting searched");
		File SrcFile=((TakesScreenshot)MainFile.driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SrcFile, new File(MainFile.Directory + "\\src\\main\\Screenshot\\SearchFlight.jpg"));
	}	
		
}
