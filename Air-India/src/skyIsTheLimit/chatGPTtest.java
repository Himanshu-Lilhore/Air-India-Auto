package skyIsTheLimit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class chatGPTtest {
    public static void main(String[] args) throws InterruptedException {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hlilhore\\Desktop\\Selenium\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Air India flight search page
        driver.get("https://www.airindia.in");

        // Select the "Round Trip" radio button
        WebElement roundTripButton = driver.findElement(By.id("RoundTrip"));
        roundTripButton.click();

        // Fill in the departure and arrival cities with random values
        WebElement departureCity = driver.findElement(By.id("FromSector_show"));
        departureCity.sendKeys("Delhi");

        WebElement arrivalCity = driver.findElement(By.id("Editbox13_show"));
        arrivalCity.sendKeys("Mumbai");

        // Fill in the departure date with a random value
        WebElement departureDate = driver.findElement(By.id("txtDepartureDate"));
        departureDate.sendKeys("08/08/2023");

        // Fill in the return date with a random value
        WebElement returnDate = driver.findElement(By.id("txtReturnDate"));
        returnDate.sendKeys("10/08/2023");

        // Submit the form
        WebElement submitButton = driver.findElement(By.id("Btn_Avail"));
        submitButton.click();

        // Close the browser
        driver.quit();
    }
}

