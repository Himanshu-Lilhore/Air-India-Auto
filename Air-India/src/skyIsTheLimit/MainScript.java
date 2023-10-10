package skyIsTheLimit;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainScript {
	public static ChromeDriver driver;
//	public static RemoteWebDriver driver;
	public static XSSFSheet sheet;

	@DataProvider(name = "dates")
	public int[][] myDates() {
		int[][] data = { { 20 }, { 21 }
//				{22},
//				{23},
//				{24}
		};
		return data;
	}

	
// TASK #1 - Delhi to Hyderabad
	@Test(dataProvider = "dates")
	public void task1(int[] date) throws IOException, MalformedURLException
	{
		System.out.println(date[0]);
		DelhiFlight del = new DelhiFlight();
		del.verify(date[0]);
	}

// TASK #2 - New York to Bangkok
	@Test(dataProvider = "dates")
	public void task2(int[] date) throws IOException, MalformedURLException
	{
		System.out.println(date[0]);
		NewyorkFlight nyc = new NewyorkFlight();
		nyc.verify(date[0]);
	}
	 

//  TASK #3 - Billing
	@Parameters({"fname", "lname", "email", "dob", "mob"})
	@Test
	public void task3(String fname, String lname, String email, String dob, String mob) throws IOException, InterruptedException, MalformedURLException
	{
		BillingCheck bc = new BillingCheck();
		bc.verify(fname, lname, email, dob, mob);
	}
	

//	TASK #4 - Ask Maharajah
	@Test
	public void task4() throws InterruptedException, MalformedURLException
	{
		AskMaharajah am = new AskMaharajah();
		am.verify();
	}
	
	
//	TASK #5 - Social Media
	@Test
	public void task5() throws InterruptedException, MalformedURLException
	{
		SocialMedia sm = new SocialMedia();
		sm.verify();
	}
	
	
//	TASK #6 - Verifying footer hyper-links
	@Test
	public void task6()
	{
		// what to do ??
	}
	
	
//	TASK #7 - Flight Schedule
	@Test
	public void task7() throws InterruptedException, MalformedURLException
	{
		FlightSchedule fs = new FlightSchedule();
		fs.verify();
	}
	
	
//	TASK #8 - Login
	@Test
	public void task8() throws MalformedURLException
	{
		Login lg = new Login();
		lg.verify();
	}
	
	
//	TASK #9 - Topics of interest
	@Test
	public void task9()
	{
		// !! requires phone no. verification to proceed
	}
	
	
	
//	TASK #10 - Adding email & phone
	@Test
	public void task10()
	{
		// !! requires phone no. verification to proceed
	}
	

//	public static ChromeDriver setupDriver() {
	
	public static ChromeDriver setupDriver() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hlilhore\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.airindia.in/");
		
		
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");
//		cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//		
//		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.143.207.15:4444"), cap);
//		driver.get("https://www.airindia.in/");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		
		
		return driver;
	}

	public static void waitAndClose() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

	public static XSSFSheet getSheet() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\hlilhore\\eclipse-workspace\\Air-India\\src\\dataCloud\\dataAndLocators.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		sheet = book.getSheetAt(0);
		return sheet;
	}

	public static String getActions(int row, int col) {
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
}
