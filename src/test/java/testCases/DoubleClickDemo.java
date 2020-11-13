package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application OrangeHRM
		String url = "http://demoqa.com/buttons";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		// Instantiate Action class
		Actions actions = new Actions(driver);

		WebElement btnElement = driver.findElement(By.id("doubleClickBtn"));

		actions.doubleClick(btnElement).perform();
		String doubleClickMessage = driver.findElement(By.id("doubleClickBtn")).getText();
		Assert.assertTrue(doubleClickMessage.contains("You have done a double click"));

		// Close Browser
		driver.quit();

	}
}
