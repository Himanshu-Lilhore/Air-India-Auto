package skyIsTheLimit;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FlightSchedule
{
//	public static ChromeDriver driver;
	public static RemoteWebDriver driver;
	
	@Test
	public void verify() throws InterruptedException, MalformedURLException
	{
		Integer date = 20;
		driver = MainScript.setupDriver();
		
		// Page 1 - Home page
		String url = driver.findElements(By.xpath("//a[text()='Flight Schedule']")).get(0).getAttribute("href");
		driver.get(url);
		
		// Page 2 - Filling flight info
		driver.findElements(By.xpath("//div//div//table//tbody//tr//td")).get(0).click();
		driver.findElement(By.id("txtFromDate")).click();
		driver.findElement(By.linkText(date.toString())).click();
		driver.findElement(By.id("txtFromLocation")).sendKeys("Delhi");
		driver.findElement(By.partialLinkText("Indira Gandhi International Airport")).click();
		driver.findElement(By.id("txtToLocation")).sendKeys("Hyderabad");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Rajiv Gandhi International Airport")).click();
		driver.findElement(By.id("btnFlightTimeTable")).click();
		
		// Manual captcha window
		Thread.sleep(10000);
		
		// Page 3 - Flight schedule (verifying)
		String from = driver.findElements(By.xpath("//div//div//h2//div//span//strong")).get(0).getText();
		String to = driver.findElements(By.xpath("//div//div//h2//div//span//strong")).get(1).getText();
		if(from.toLowerCase().equals("delhi") && to.toLowerCase().equals("hyderabad"))
			System.out.println("Flight details are matching.");
		
		MainScript.waitAndClose();
	}
}
