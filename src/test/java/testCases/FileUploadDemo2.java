package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadDemo2 {

	public WebDriver driver;
	public WebDriverWait wait;
	private static String filePath = "E:\\Formation_Selenium_Zied\\selenium_photo.jpg";

	@BeforeMethod
	public void setup() { 

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
	} 

	@Test
	public void robotTest() throws InterruptedException {

		// Click ImageUpload
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.fileinput-button")));
		driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();
		uploadFileWithRobot(filePath);
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	// File upload with robot class
	public void uploadFileWithRobot(String imagePath) {

		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(stringSelection, null);

		Robot robot = null;
		try {

			robot = new Robot();
		} catch (AWTException e) {

			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}

