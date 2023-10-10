package skyIsTheLimit;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Login
{
//	public static ChromeDriver driver;
	public static RemoteWebDriver driver;
	
	@Test
	public void verify() throws MalformedURLException
	{
		driver = MainScript.setupDriver();
		
		driver.findElement(By.partialLinkText("Login")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		for(String i : tabs)
		{
			driver.switchTo().window(i);
		}
		
		driver.findElement(By.id("signInName")).sendKeys("himanshu.other.email@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Air.India4test");
		driver.findElement(By.id("next")).click();
		
		MainScript.waitAndClose();
	}

}
