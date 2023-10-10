package skyIsTheLimit;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BillingCheck
{
	public static ChromeDriver driver;
//	public static RemoteWebDriver driver;
	public static XSSFSheet sheet;
	public static WebElement dropDown;
//	public static Select s;
	
//	@Test(groups= {"fetch"})
//	public void fetch()
//	{
//		
//	}
	
	@Parameters({"fname", "lname", "email", "dob", "mob"})
	@Test
	public void verify(String fname, String lname, String email, String dob, String mob) throws IOException, InterruptedException
	{
		int date = 20;
		DelhiFlight del = new DelhiFlight();
		DelhiFlight.driver = MainScript.setupDriver();
		
		DelhiFlight.billing = true;
		
		del.fillInfo(date);
		driver = DelhiFlight.driver;
		
		// Manual Captcha window
		Thread.sleep(10000);
		
		// selecting a flight
		driver.findElements(By.xpath("//button[@type='button']//span//div[text()='Economy']")).get(0).click();
		
		// selecting plan
		driver.findElement(By.xpath("//div[@class='carousel-container']//ul[@class='carousel']//li[contains(@class,'fare-card-list-item')]")).click();
		
		// clicking continue button
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		
		// clicking 'Keep Web Special Economy'
		driver.findElement(By.xpath("//button//span//span[text()='Keep Web Special Economy']")).click();
		
		// clicking 'Fill passengers details'
		driver.findElement(By.xpath("//span[text()='Fill passenger details']")).click();
		
		// Filling passenger details (using @Parameters)
		Thread.sleep(3000);
		driver.findElement(By.id("mat-select-value-5")).click();
		driver.findElement(By.xpath("//span[text()='Mr']")).click();
		driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(0).sendKeys(fname);
		driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(1).sendKeys(lname);
		driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(2).sendKeys(dob);
		driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(4).sendKeys(email);
		driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(5).sendKeys(email);
		driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(6).sendKeys("91");
		driver.findElements(By.xpath("//mat-form-field//div//div//div//input")).get(7).sendKeys(mob);
		driver.findElement(By.xpath("//span[contains(text(), 'I Agree To')]")).click();
		driver.findElement(By.xpath("//button//span//span[text()='Confirm']")).click();
		
		
		// Checkout
		System.out.println("ee");
		WebElement wb = driver.findElement(By.xpath("//span[contains(text(), 'Checkout')]"));
		System.out.println("ee0");
		System.out.println("web element : " + wb);
		System.out.println("driver : " + driver);
		wb.click();
		System.out.println("ee1");
		Thread.sleep(10000);
		
		
		
//		mainScript.waitAndClose();
	}
}
