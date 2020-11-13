package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEvent {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application
		String url = "https://demoqa.com/text-box";
		driver.get(url);

		driver.manage().window().maximize();

		// Find web elements
		WebElement userName = driver.findElement(By.id("userName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

		// Instantiate class action
		Actions actions = new Actions(driver);
		actions.sendKeys(userName, "test").perform();
		actions.sendKeys(userEmail, "test1@test.com").perform();
		actions.sendKeys(currentAddress, "test222 la garenne colombes 92250").perform();

		// Copy current address
		actions.keyDown(currentAddress, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(permanentAddress, Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		// JavaScript executer click button submit
		WebElement submit = driver.findElement(By.id("submit"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", submit);

		System.out.println("The execution of the Submit button is done");
	}
}