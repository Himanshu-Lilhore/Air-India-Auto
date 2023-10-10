package TestMethods;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.google.common.io.Files;

@Test
public class AskMaharajah {
	
	public void verify() throws InterruptedException, IOException {
		MainFile.createTestReport("Ask Maharajah");
		
		System.out.println(AskMaharajah.class.getName());           //
		MainFile.log4jInit(AskMaharajah.class.getName());
		
		MainFile.setupDriver();
		
		MainFile.driver.findElement(By.xpath("//span[contains(text(), 'Ask Maharajah')]")).click();
		MainFile.driver.findElement(By.xpath("//button[contains(text(), 'Covid Info')]")).click();
		MainFile.driver.findElement(By.xpath("//button[contains(text(), 'End Chat')]")).click();
		Thread.sleep(3000);
		
		String thankYou =MainFile.driver.findElements(By.xpath("//div//ul//li//div//c-chat-message//c-text-view")).get(5).getText();
		String title = MainFile.driver.getTitle();
		
		if(thankYou.equals("Thanks for Contacting us. Goodbye! Have a great Day.")
				&& title.equals("Air India"))
			System.out.println("Ask Maharajah functionality is working perfectly fine !!");
		else
			System.out.println("Something is not right !!");
		
		MainFile.myLogger.info("Ask Maharajah functionality is working properly");
		
		MainFile.myLogger.info("Ask Maharajah is responding successfully");
		File SrcFile=((TakesScreenshot)MainFile.driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SrcFile, new File(MainFile.Directory + "\\src\\main\\Screenshot\\AskMaharajah.jpg"));
		
		
		MainFile.closeDriver();
		MainFile.extent.flush();
	}
		
		
		
	}


