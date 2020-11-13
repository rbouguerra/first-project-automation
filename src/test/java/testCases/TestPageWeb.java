package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPageWeb {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://cfspart.fr/LoginAccess?opwYXJ0LmltcG90cy5nb3V2LmZyL21vbnByb2ZpbC13ZWJhcHAvbW9uQ29tcHRl";
		driver.get(url);

		driver.manage().window().maximize();

		driver.findElement(By.id("spi_tmp")).sendKeys("30373888475");

		// Click button Continuer with explicit wait
		WebElement btnContinuer;
		btnContinuer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAction")));
		btnContinuer.click();

		driver.findElement(By.id("pwd_tmp")).sendKeys("blabla1457@");

		// Click button Connexion with explicit wait
		WebElement bntConnexion;
		bntConnexion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAction")));
		bntConnexion.click();

		driver.findElement(By.id("id_zoneclick_0")).click();

		// Button of deconnexion
		/*
		 * driver.findElement(By.id("accederdeconnexion")).click(); // Wait 3 sec
		 * Thread.sleep(3000); driver.findElement(By.id("confirmdeconnexion")).click();
		 */
		//driver.close();
		// driver.quit();

		// il faut ajouter Thread.sleep entre le click de deconnexion et le button
		// confirmer

	}

}
