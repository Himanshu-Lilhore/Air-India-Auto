package skyIsTheLimit;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SocialMedia
{
//	public static ChromeDriver driver;
	public static RemoteWebDriver driver;
	
	@Test
	public void verify() throws InterruptedException, MalformedURLException
	{
		driver = MainScript.setupDriver();
		
		driver.findElement(By.xpath("//a[contains(@href, 'instagram')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'twitter')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'facebook')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'youtube')]")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		
		for(String i : tabs)
		{
			printTitle(i);
		}
		
		MainScript.waitAndClose();
	}
	

	public void printTitle(String st) throws InterruptedException
	{
		driver.switchTo().window(st);
		Thread.sleep(500);
		
		String title = driver.getTitle();
		
		if(!title.equals("Air India"))
			System.out.println(title);
	}
}
