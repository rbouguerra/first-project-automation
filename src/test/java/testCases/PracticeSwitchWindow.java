package testCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSwitchWindow {

	public static void main(String[] args) {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application
		String url = "https://demoqa.com/browser-windows";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		// Print a log in message to the screen
		System.out.println("Successfully opened the website");

		// Store and print the name of the first window
		String handle = driver.getWindowHandle();
		System.out.println("First window " + handle);

		driver.findElement(By.id("messageWindowButton")).click();

		// Store and print the name of all the windows open
		Set handles = driver.getWindowHandles();
		System.out.println("All window open " + handles);

		// Pass window handle to other window
		for (String handle1 : driver.getWindowHandles()) {
			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}

		//driver.quit();
	}

}
