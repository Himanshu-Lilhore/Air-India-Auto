package TestMethods;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AdditionalDetails {
	@Test
	public void verify() throws InterruptedException, IOException 
	{
		MainFile.createTestReport("Additional details");
		MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
		
		MainFile.setupDriver();
		additional();
		MainFile.closeDriver();
		MainFile.extent.flush();
	}

	
public void additional() throws InterruptedException, IOException {
	
	MainFile.driver.findElement(By.partialLinkText("Login")).click();
	MainFile.myLogger.info("Login button is clicked");
	ArrayList<String> tabs=new ArrayList<String>(MainFile.driver.getWindowHandles());
	MainFile.driver.switchTo().window(tabs.get(1));
	
	
		MainFile.driver.switchTo().window(tabs.get(1));
		
		MainFile.getSheet(3);
		int rows= MainFile.sheet.getPhysicalNumberOfRows();
		
			for(int i=1;i<rows;i++)
			{
				String myAction=MainFile.getActions(i, 0);
				String data1=MainFile.getActions(i, 1);
	//			System.out.println(data1);
	//			String data1=MainFile.getActions(i, 2);
	//			String data2=MainFile.getActions(i, 3);
	//			String data3=MainFile.getActions(rows, i)
	//			System.out.println(data);
				
				
				//String data1=MainFile.getActions(i, 2);
	//			int n=data1.length()-1;
	//			char c=data1.charAt(n);
	//			String data11=data1.substring(0,n);
				switch(myAction) {
				case "email":
					MainFile.driver.findElement(By.id("signInName")).sendKeys(data1);
					break;
				
				case "password":
					MainFile.driver.findElement(By.id("password")).sendKeys(data1);
					MainFile.driver.findElement(By.id("next")).click();
					MainFile.driver.findElement(By.linkText("Your Profile")).click();
					break;
				
				case "addemail":
					MainFile.driver.findElements(By.xpath("//form/div/div/div/div/button/span")).get(0).click();
					MainFile.driver.findElements(By.xpath("//input[@type='email']")).get(1).sendKeys(data1);
					break;
				
				case "addphone":
					data1 = data1.substring(4, 14);
					MainFile.driver.findElement(By.xpath("//button/span[contains(text(), 'Add another phone number')]")).click();
					MainFile.driver.findElements(By.xpath("//input[@type='tel']")).get(1).sendKeys(data1);		
					MainFile.driver.findElements(By.xpath("//input[@placeholder='Enter your country calling code']")).get(1).sendKeys("+91");
					MainFile.driver.findElement(By.xpath("//span/span[text() =\"+91 (India)\"]")).click();
				    MainFile.driver.findElement(By.xpath("//button[@class='mat-focus-indicator py-1 px-5 mat-raised-button mat-button-base mat-primary']")).click();
					break;
				}
			}
		MainFile.myLogger.info("Login is done sucessfully");
		
	}
}

		
		
		

				
	



