package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands {

	public static void main(String[] args) {

		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application OrangeHRM
		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);

		// Resize current window to the set dimension
		driver.manage().window().maximize();

		// Send User name
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		// Verifier si le champ a pris le jeu de donnée ou non
		WebElement element = driver.findElement(By.id("txtUsername"));
		String attValue = element.getAttribute("id");
		System.out.println("The id attribut is: " + attValue);
		driver.findElement(By.id("txtUsername")).clear();
		// element.clear();

		// Send Password
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		WebElement element2 = driver.findElement(By.id("txtPassword"));
		Dimension dimensions = element2.getSize();
		System.out.println("Height: " + dimensions.height + " | " + "Width: " + dimensions.width);
		element2.clear();

		WebElement element3 = driver.findElement(By.id("txtPassword"));
		Point point = element3.getLocation();
		System.out.println("X cordinate: " + point.x + " Y cordinate: " + point.y);

		// Verify if element is displayed (element est affiché ou non) True or False
		WebElement element4 = driver.findElement(By.id("btnLogin"));
		boolean statut = element4.isDisplayed();
		System.out.println("Statut: " + statut);

		// type primitive : boolean
		// class wapper : Boolean : le classe rupper envelope les types de données
		// primitif ds un objet de cet classe

		// Verify element is enabled True or False
		WebElement element5 = driver.findElement(By.id("btnLogin"));
		boolean statut1 = element5.isEnabled();
		System.out.println("Statut1: " + statut1);

		// Verifiy element is existed True or False
		List<WebElement> element6 = driver.findElements(By.id("btnLogin"));
		if (element6.size() != 0) {
			System.out.println("The element exist");
		} else {
			System.out.println("The element not exist");
		}

		//driver.quit();

	}

}
