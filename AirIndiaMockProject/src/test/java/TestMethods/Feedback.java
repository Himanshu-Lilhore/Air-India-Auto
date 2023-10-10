package TestMethods;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

@Test
public class Feedback {
	
	public void doVerify() throws IOException, InterruptedException 
	{
		MainFile.createTestReport("Checking Feedback functionality");
		
		MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
		MainFile.setupDriver();
		
		MainFile.driver.findElement(By.id("QSIFeedbackButton-btn")).click();
		
		MainFile.driver.switchTo().frame("QSIFeedbackButton-survey-iframe");
		String text=MainFile.driver.findElement(By.xpath("//div[@class='QuestionText BorderColor']")).getText();
		Assert.assertEquals("How would you rate the Air India Website experience?", text);
		
		String text2=MainFile.driver.findElement(By.id("QID1-5-label")).getText();
		Assert.assertEquals("Very good", text2);
		
		String text1=MainFile.driver.findElement(By.id("QID1-4-label")).getText();
		Assert.assertEquals("Good", text1);
		
		
		String text3=MainFile.driver.findElement(By.id("QID1-3-label")).getText();
		Assert.assertEquals("Average", text3);
		
		String text4=MainFile.driver.findElement(By.id("QID1-2-label")).getText();
		Assert.assertEquals("Poor", text4);
		
		String text5=MainFile.driver.findElement(By.id("QID1-1-label")).getText();
		Assert.assertEquals("Very poor", text5);
		
		File SrcFile=((TakesScreenshot)MainFile.driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SrcFile, new File(MainFile.Directory + "\\src\\main\\Screenshot\\Feedback.jpg"));
		
		MainFile.myLogger.info("Feedback button is working and the texts are shown");
		
		MainFile.driver.close();
		MainFile.extent.flush();
	
}
}

