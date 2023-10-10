package TestMethods;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hyperlink {
	
@Test
public void verify() throws MalformedURLException {
	MainFile.setupDriver();
	MainFile.createTestReport("Hyperlink");
	MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
	
	ArrayList<String> names=new ArrayList<String>();
	names.add("About Air India");
	names.add("Citizen Charter");
	names.add("Conditions of Carriage");
	names.add("US DOT Regulations");
	names.add("Terms and Conditions");
	names.add("Disclaimer");
	names.add("Media Center");
	names.add("Forms and Downloads");
	names.add("Canada Regulations");
	names.add("Corporate Environment Policy");
	names.add("Vigilance");
	names.add("Contact Details");
	names.add("Air India Express");
	names.add("Statutory Information");
	names.add("GST");
	names.add("Sitemap");
	names.add("Careers");
	names.add("Travel Agents");
	names.add("FAQs");
	names.add("Carriage of Pets");
	
	WebElement element=MainFile.driver.findElement(By.className("container"));
	ArrayList<WebElement> wb = (ArrayList<WebElement>) element.findElements(By.xpath("//*[@class='foot_bg']/div/div[@class='row']/div/ul/li/a"));
	
	ArrayList<String> elements=new ArrayList<String>();
	
	
	for(WebElement one : wb)
	{
		String footer = one.getText();
		elements.add(footer);
	}
	

	
	Assert.assertEquals(names, elements);
	MainFile.myLogger.info("Hyperlinks are verified.");
	MainFile.closeDriver();
	MainFile.extent.flush();
	
	
}

}
