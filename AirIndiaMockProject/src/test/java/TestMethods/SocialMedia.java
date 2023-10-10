package TestMethods;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SocialMedia {	
@Test	
public void verify() throws MalformedURLException {
	MainFile.createTestReport("Social Media");
	MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
	MainFile.setupDriver();
	MainFile.myLogger.info("Social Media icons are visible");
	String parentWindow =MainFile.driver.getWindowHandle();
	
	MainFile.driver.findElement(By.xpath("//a[contains(@href, 'instagram')]")).click();
	MainFile.driver.findElement(By.xpath("//a[contains(@href, 'twitter')]")).click();
	MainFile.driver.findElement(By.xpath("//a[contains(@href, 'facebook')]")).click();
//	MainFile.driver.findElement(By.xpath("//a[contains(@href, 'youtube')]")).click();
	
		
		Set<String> tabs = MainFile.driver.getWindowHandles();
		ArrayList<String> titles=new ArrayList<String>();
		for(String i :tabs)	
		{
			
			if(!parentWindow.equals(i))
			{
				MainFile.driver.switchTo().window(i);
				String webTitle=MainFile.driver.switchTo().window(i).getTitle();
				System.out.println(webTitle);
				
				titles.add(webTitle);
			}
		}
		for(String j: titles) {
			if(j.contains("Instagram"))
			{
				Assert.assertTrue(j.contains("Instagram photos and videos"));
				
			}
			
			else if(j.contains("Twitter"))
			{
				Assert.assertTrue(j.contains("Air India (@airindiain) / Twitter"));
				
			}
			
			else if(j.contains("Facebook"))
			{
				Assert.assertTrue(j.contains("Air India | Facebook"));
				
			}
			
			
//			else if(j.contains("YouTube"))
//			{
//				Assert.assertTrue(j.contains(""));
//				
//			}
		}
		
		
		
		
//		if(webTitle.contains("Instagram")) {
//			Assert.assertEquals("Air India (@airindia.in) � Instagram photos and videos" , webTitle);
//			MainFile.driver.close();
//		}
//		
		MainFile.myLogger.info("All the social media icons are validated.");
		MainFile.extent.flush();
		
	}
	
}


