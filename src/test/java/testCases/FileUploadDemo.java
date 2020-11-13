package testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FileUploadDemo {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application
		String url = "http://demo.guru99.com/test/upload/";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		// Print a log in message to the screen
		System.out.println("Successfully opened the website");

		WebElement uploadButton = driver.findElement(By.id("uploadfile_0"));

		// First Method upload file
		// uploadButton.sendKeys("E:\\Formation_Selenium_Zied\\selenium_photo.jpg");

		// Second Method upload file
		File path = new File("src/test/resources/temp/selenium_photo.jpg");
		uploadButton.sendKeys(path.getAbsolutePath());

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();

		Thread.sleep(2000);
		// Verify upload
		String upLoadMsg = driver.findElement(By.xpath("//*[@id=\"res\"]/center")).getText();
		Assert.assertTrue(upLoadMsg.contains("successfully"));

		// driver.quit(); 
	}
}
