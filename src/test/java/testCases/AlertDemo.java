package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application
		String url = "https://demoqa.com/alerts";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		// Click Alert
		driver.findElement(By.id("alertButton")).click();

		// Accept Alert

		driver.switchTo().alert().accept();

		String title = driver.getTitle();

		System.out.println("The title of page is: " + title);

		// Close Browser
		driver.quit();

	}
}
