package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipDemo {

	public static void main(String[] args) {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application OrangeHRM
		String url = "https://demoqa.com/tool-tips/";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		// Print a log in message to the screen
		System.out.println("Successfully opened the website");

		// ToolTip
		WebElement text = driver.findElement(By.id("toolTipButton"));
		String toolTipText = text.getText();
		if (toolTipText.equalsIgnoreCase("Hover me to see")) {
			System.out.println("Pass: ToolTip matching expected value");
		} else {
			System.out.println("Fail: ToolTip not matching expected value");
		}

		// PlaceHolder
		WebElement placeHolder = driver.findElement(By.id("toolTipTextField"));
		String textPlaceHolder = placeHolder.getAttribute("placeholder");
		System.out.println("The placHolder is: " + textPlaceHolder);
	}

}
