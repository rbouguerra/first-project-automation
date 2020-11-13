package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application OrangeHRM
		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		// Print a log in message to the screen
		System.out.println("Successfully opened the website OrangeHRM");

		// Send Username
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		// Wait 3 sec
		Thread.sleep(3000);

		// Send Password
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		// Click button Login with explicit wait
		WebElement btnLogin;
		btnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
		btnLogin.click();
		// driver.findElement(By.id("btnLogin")).click();

		String adminUser = driver.findElement(By.id("welcome")).getText();
		Assert.assertTrue(adminUser.contains("Welcome"));

		// Close Browser
		driver.quit();

	}

}