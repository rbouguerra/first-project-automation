package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverCseAltran {
	
	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver2.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application
		String url = "https://www.csealtranidf.com/com/login?back_url=%2Fcom%2Fhomepage";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();
		
		driver.findElement(By.id("authentication_login")).sendKeys("ridha.bouguerra@altran.com");
		
		driver.findElement(By.id("authentication_password")).sendKeys("test1234A+");
		
		driver.findElement(By.xpath("/html/body/div[3]/div/form/div/div/div[4]/div/button")).click();
		
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/button/span")).click();
		
//		WebElement element = driver.findElement(By.xpath("//*[@id=\"pwb-navbar-connexion\"]/div/div[1]/button"));
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", element);
		
		Actions actions = new Actions(driver);
		WebElement mouseHover = driver.findElement(By.xpath("//*[@id=\"header-account\"]/i"));
		actions.moveToElement(mouseHover).perform();

//		WebElement mouseHoverSignOut = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[1]/ul/li[11]/a"));
//		actions.moveToElement(mouseHoverSignOut).perform();
//		
//		mouseHoverSignOut.click();
		
		// email: formationselenium@gmail.com
		// mot de passe: F4selenium@8
		
		//driver.close();

	}

}
