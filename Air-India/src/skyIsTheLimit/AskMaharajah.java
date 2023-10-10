package skyIsTheLimit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AskMaharajah
{
//	public static ChromeDriver driver;
	public static RemoteWebDriver driver;
	
	@Test
	public void verify() throws InterruptedException, MalformedURLException
	{
		driver = MainScript.setupDriver();
		
		driver.findElement(By.xpath("//span[contains(text(), 'Ask Maharajah')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Covid Info')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'End Chat')]")).click();
		Thread.sleep(3000);
		
		String thankYou = driver.findElements(By.xpath("//div//ul//li//div//c-chat-message//c-text-view")).get(5).getText();
		String title = driver.getTitle();
		
		if(thankYou.equals("Thanks for Contacting us. Goodbye! Have a great Day.")
				&& title.equals("Air India"))
			System.out.println("Ask Maharajah functionality is working perfectly fine !!");
		else
			System.out.println("Something is not right !!");

		
		MainScript.waitAndClose();
	}
}
