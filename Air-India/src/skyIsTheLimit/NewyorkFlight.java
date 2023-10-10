package skyIsTheLimit;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewyorkFlight
{
//	public static ChromeDriver driver;
	public static RemoteWebDriver driver;
	public static XSSFSheet sheet;
	public static WebElement dropDown;
	public static Select s;

	
	public void verify(int date) throws IOException
	{
		driver = MainScript.setupDriver();
		
		fillInfo(date);
		check();
		
		MainScript.waitAndClose();
	}
	
	
	public void fillInfo(Integer date) throws IOException
	{
		sheet = MainScript.getSheet();
		int rowsCount = sheet.getPhysicalNumberOfRows();
		
		for(int i=1; i<rowsCount; i++)
		{
			
			String myAction = MainScript.getActions(i, 0);
			System.out.println(myAction);
			String locator1 = MainScript.getActions(i, 1);
			String locator2 = MainScript.getActions(i, 2);
			String data1 = MainScript.getActions(i, 5);
			String data11 = MainScript.getActions(i, 6);
			
			switch(myAction)
			{
				case "From":
					driver.findElement(By.id(locator1)).sendKeys(data1);
					driver.findElement(By.partialLinkText(data11)).click();
					break;

				case "To":
					driver.findElement(By.id(locator1)).sendKeys(data1);
					driver.findElement(By.partialLinkText(data11)).click();
					break;
					
				case "One way / Round trip":
					driver.findElement(By.id(locator2)).click();
					break;
					
				case "Departure Date":
					driver.findElement(By.id(locator1)).click();
					driver.findElement(By.linkText(date.toString())).click();
					break;
				
				case "Returning Date":
					driver.findElement(By.id(locator1)).click();
					driver.findElement(By.linkText(((Integer)(date+2)).toString())).click();
					break;
					
				case "Adults":
					dropDown = driver.findElement(By.id(locator1));
					dropDown.click();
					s = new Select(dropDown);
					s.selectByVisibleText(data1.charAt(0)+"");
					break;
					
				case "Children":
					dropDown = driver.findElement(By.id(locator1));
					dropDown.click();
					s = new Select(dropDown);
					s.selectByVisibleText(data1.charAt(0)+"");
					break;
					
				case "Infants":
					dropDown = driver.findElement(By.id(locator1));
					dropDown.click();
					s = new Select(dropDown);
					s.selectByVisibleText(data1.charAt(0)+"");
					break;
				
				case "Search":
					driver.findElement(By.id(locator1)).click();
					
			}
		}
		
	}
	
	public void check()
	{
		
	}

}
