package testCases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static WebDriver driver;

	@BeforeClass
	public static void openBrowser() {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
	}

	@Test
	public void valid_UserCredential() {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test
	public void invalid_UserCredential() {

		driver.findElement(By.id("txtUsername")).sendKeys("test");
		driver.findElement(By.id("txtPassword")).sendKeys("test123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@AfterClass
	public static void tearDown() {

		driver.quit();
	}

}
