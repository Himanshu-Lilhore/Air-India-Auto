package TestMethods;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FlyingReturns {

@Test	
public void login() throws MalformedURLException {
	MainFile.createTestReport("Flying Returns");
	MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
	

	MainFile.setupDriver();
	
	MainFile.myLogger.info("Login Module is working");
	MainFile.driver.findElement(By.partialLinkText("Login")).click();
	

	
	ArrayList<String> tabs=new ArrayList<String>(MainFile.driver.getWindowHandles());
	
	
		MainFile.driver.switchTo().window(tabs.get(1));
		
		MainFile.driver.findElement(By.id("signInName")).sendKeys("snehadas@deloitte.com");
		MainFile.driver.findElement(By.id("password")).sendKeys("Myflight@123");
		MainFile.driver.findElement(By.id("next")).click();
		
		MainFile.driver.findElement(By.linkText("Your Profile")).click();
		
		MainFile.driver.findElements(By.xpath("//span[@class='mat-checkbox-label']")).get(1).click();
		MainFile.driver.findElements(By.xpath("//span[@class='mat-checkbox-label']")).get(2).click();
		
		MainFile.myLogger.info("Login is done!");
		MainFile.closeDriver();
		MainFile.extent.flush();
		
		
	
	
	
}

}
