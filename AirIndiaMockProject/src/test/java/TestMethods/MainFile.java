package TestMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MainFile 
{
	
	public static ChromeDriver driver;
	public static XSSFSheet sheet;
	public static TakesScreenshot webdriver;
	public static String Directory = System.getProperty("user.dir");
	public static org.apache.logging.log4j.Logger myLogger;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest data;
	public static boolean reportInitialized = false;
	
	public static void setupDriver() throws MalformedURLException 
	{
		System.setProperty("webdriver.chrome.driver", Directory+ "\\src\\test\\java\\Objects\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.airindia.in/");
	}
	
	public static void closeDriver() 
	{
		driver.quit();
	}
	
	public static void getSheet(int sheetno) throws IOException 
	{
		FileInputStream fis = new FileInputStream(Directory+"\\src\\test\\java\\Objects\\Air1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		sheet = book.getSheetAt(sheetno);	
	}
	public static String getActions(int row, int col) 
	{
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	
	public static void log4jInit(String className)
	{
		myLogger = LogManager.getLogger(className);
		DOMConfigurator.configure(Directory + "\\src\\main\\resources\\log4j2.xml");
	}
	
	private static void reportInit() 
	{
		reporter = new ExtentSparkReporter("reports\\result.html");
		reporter.config().setDocumentTitle("Air India Report");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	public static void createTestReport(String testName)
	{
		if(!reportInitialized)
		{
			reportInit();
			reportInitialized = true;
		}
		
		data = extent.createTest(testName).assignAuthor("Sneha Das").assignDevice("Windows 10");
	}
}

