package testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "http://demo.guru99.com/test/upload/";
		driver.get(url);

		driver.manage().window().maximize();

		WebElement uploadButton = driver.findElement(By.id("uploadfile_0"));

//		uploadButton.sendKeys("E:\\Formation_Selenium_Zied\\Projet\\firstProjectAutomation\\selenium_photo.jpg");

		File path = new File("src/test/resources/temp/selenium_photo.jpg");
		uploadButton.sendKeys(path.getAbsolutePath());

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();

		Thread.sleep(5000);
		
		String uploadMsg = driver.findElement(By.xpath("//*[@id=\"res\"]/center")).getText();
		Assert.assertTrue(uploadMsg.contains("successfully"));
		
		System.out.println("Message check");

	}

}
