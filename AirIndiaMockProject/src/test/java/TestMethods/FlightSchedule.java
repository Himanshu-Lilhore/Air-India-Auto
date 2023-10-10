package TestMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;

import org.openqa.selenium.By;



public class FlightSchedule {

	
@Test
public void validate() throws MalformedURLException, InterruptedException {
	MainFile.setupDriver();
	MainFile.createTestReport("Flight Schedule");
	MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
	Integer date=27;
	Thread.sleep(3000);
	String url = MainFile.driver.findElements(By.xpath("//a[text()='Flight Schedule']")).get(0).getAttribute("href");
	MainFile.driver.get(url);
	
	MainFile.driver.findElements(By.xpath("//div//div//table//tbody//tr//td")).get(0).click();
	MainFile.driver.findElement(By.id("txtFromDate")).click();
	MainFile.driver.findElement(By.linkText(date.toString())).click();
	MainFile.driver.findElement(By.id("txtFromLocation")).sendKeys("Delhi");
	MainFile.driver.findElement(By.partialLinkText("Indira Gandhi International Airport")).click();
	MainFile.driver.findElement(By.id("txtToLocation")).sendKeys("Hyderabad");
	Thread.sleep(2000);
	MainFile.driver.findElement(By.partialLinkText("Rajiv Gandhi International Airport")).click();
	MainFile.driver.findElement(By.id("btnFlightTimeTable")).click();
	Thread.sleep(10000);
	
	String from = MainFile.driver.findElements(By.xpath("//div//div//h2//div//span//strong")).get(0).getText();
	String to = MainFile.driver.findElements(By.xpath("//div//div//h2//div//span//strong")).get(1).getText();
	
	String fromlower=from.toLowerCase();
	String tolower=to.toLowerCase();
	
	String del="delhi";
	String hyd="hyderabad";
	
	Assert.assertEquals(fromlower, del);
	Assert.assertEquals(tolower, hyd);
	
	MainFile.myLogger.info("Flight Schedule is verified successfuly");
	MainFile.closeDriver();
	MainFile.extent.flush();
	
	
	
	
	
	
	
}



}
