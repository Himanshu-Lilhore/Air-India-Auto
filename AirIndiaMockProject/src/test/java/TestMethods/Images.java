package TestMethods;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Images {
	
@Test
public void imageVerify() throws MalformedURLException {
	MainFile.setupDriver();
	MainFile.createTestReport("Carousel Images");
	MainFile.log4jInit(MethodHandles.lookup().lookupClass().toString());
	List<WebElement> images =MainFile.driver.findElements(By.xpath("//div[@class=\"slider-section\"]/div/div/div/div[@class=\"owl-item active\"] "
			+ "| //div[@class=\"slider-section\"]/div/div/div/div[@class=\"owl-item\"]"));
	
	ArrayList<String> imgNames = new ArrayList<String>();
	
	for(WebElement img : images)
	{
		WebElement insideElement = img.findElement(By.xpath("./div"));
		String style = insideElement.getAttribute("style");
		String imgName = (style.split("/",0))[3];
		imgName = imgName.substring(0, imgName.length()-3);
		imgNames.add(imgName);

		
	}
	for(String s: imgNames) {
		System.out.println(s);
	}
	ArrayList<String> caraousel= new ArrayList<String>();
	

	caraousel.add("Banner_1_1_Hero_Banner_Latest_1440x480_12122022.jpg");
	caraousel.add("Banner_1_1_Excess_Baggage_Latest1440x480.jpg");
	caraousel.add("Banner_1_1_Get_Upfront_1440x480.jpg");
	caraousel.add("Banner_1_1_Preferred_Seats_1440x480pixel.jpg");
	
	if(CollectionUtils.containsAny(imgNames, caraousel)) {
		System.out.println("Images are verified");
	}
	else {
		System.out.println("Images are not verified");
	}
	MainFile.myLogger.info("Images in the carousel are validated.");
	MainFile.closeDriver();
	MainFile.extent.flush();
	
}
	

}
