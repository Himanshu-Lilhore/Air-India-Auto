package TestMethods;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.HashSet;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



class TataLogo {

		@Test
		public void verify() throws IOException, InterruptedException
		{
			MainFile.createTestReport("Tata Logo");
			MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
			MainFile.setupDriver();
			
			login();
			
			MainFile.closeDriver();
			MainFile.extent.flush();
		}
		
		
		

	public void fillInfo(Integer date) throws IOException{
		MainFile.getSheet(date);
		int rowsCount = MainFile.sheet.getPhysicalNumberOfRows();
	}
			

	public void login() throws IOException, InterruptedException {
//		MainFile.sheet = MainFile.getSheet(0);
//		String locator1 = MainFile.getActions(1,1);
//		String locator2 = MainFile.getActions(1,2);
//		String locator3 = MainFile.getActions(1,3);
//		String data1=MainFile.getActions(2, 3);
		
//		driver.findElement(By.xpath(locator1)).click();
//		driver.findElement(By.id(locator2)).sendKeys(data1);
//		driver.findElement(By.id(locator3)).click();
		
		 String parentWindow =MainFile.driver.getWindowHandle();
		MainFile.driver.findElements(By.xpath("//img[contains(@src,'assets/images/tata-logo-reverse.svg')]")).get(1).click();
		
		
//		String tab= driver.getWindowHandle();
		HashSet<String> tab1=new HashSet<String>(MainFile.driver.getWindowHandles());
		
		String childWindow = "";
		
		for(String i :tab1)	
		{
			if(!parentWindow.equals(i))
			{
				childWindow = i;
				break;
			}
		}
		
		MainFile.driver.switchTo().window(childWindow);
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) MainFile.driver;
		
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        
        MainFile.driver.switchTo().frame(0);
        MainFile.driver.findElement(By.xpath("//input[@placeholder=\"Enter your email ID to subscribe\"]")).sendKeys("abcd@gmail.com");
		
		
        MainFile.driver.findElement(By.id("HtmlPage_htmlPage.button")).click();
        MainFile.myLogger.info("TataLogo is working and emailid is getting entered successfully");
        
	}

}
