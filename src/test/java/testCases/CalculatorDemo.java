package testCases;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorDemo {

	public static void main(String[] args) {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application OrangeHRM
		String url = "https://juliemr.github.io/protractor-demo/";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("2");

		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("4");

		driver.findElement(By.id("gobutton")).click();

		WebElement result = driver.findElement(By.tagName("h2"));
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		Pattern pattern = Pattern.compile("\\d+");
		
		wait.until(ExpectedConditions.textMatches(By.tagName("h2"), pattern));

		System.out.println("The result is: " + result.getText());

	}

}
