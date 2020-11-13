package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application
		String url = "http://demoqa.com/droppable/";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		Actions actions = new Actions(driver);
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		actions.dragAndDrop(from, to).perform();

		// Verify text was Dropped
		String textTo = to.getText();

		if (textTo.equals("Dropped!")) {
			System.out.println("pass : source is dropped to target as expected ");
		} else {
			System.out.println("pass : source couldn't be dropped to target as expected ");
		}
	}
}