package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightclickDemo {

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

		WebElement btnElement = driver.findElement(By.id("rightClickBtn"));
		actions.contextClick(btnElement).perform();

		String rightClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
		Assert.assertTrue(rightClickMessage.contains("right"));
		System.out.println("This message contains : " + rightClickMessage);

		// Close Browser
		// driver.quit();

	}
}
