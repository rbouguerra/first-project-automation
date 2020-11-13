package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckBoxAndRadioBox {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch the application OrangeHRM
		String url = "https://demoqa.com/automation-practice-form";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		// Print a log in message to the screen
		System.out.println("Successfully opened the website OrangeHRM");

		// Radio Button
		Select radio = new Select(driver.findElement(By.xpath("//*[@id=\"gender-radio-2\"]")));
		radio.selectByValue("Male");

		// CheckBox
		WebElement hobbiesSport = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
		hobbiesSport.click();

		// Scroll Down
		for (int second = 0 ;; second++) {
			if (second >= 60) {
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)", "");
		}

		// Refresh
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		// Back
		driver.navigate().back();
		Thread.sleep(2000);
		
		// Forward
		driver.navigate().forward();
	}

}
