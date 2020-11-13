package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEvent2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://demoqa.com/text-box";
		driver.get(url);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement userName = driver.findElement(By.id("userName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement currentAdress = driver.findElement(By.id("currentAddress"));
		WebElement permanentAdress = driver.findElement(By.id("permanentAddress"));

		Actions actions = new Actions(driver);

		actions.sendKeys(userName, "Usager DGFIP").perform();
		actions.sendKeys(email, "usager@impot.gouv.fr").perform();
		actions.sendKeys(currentAdress, "4 Avenue Montaigne, Noisy-le-Grand").perform();

		actions.keyDown(currentAdress, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(permanentAdress, Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		WebElement submit = driver.findElement(By.id("submit"));
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", submit);

		System.out.println("The execution of the Submit button is done");

	}

}
