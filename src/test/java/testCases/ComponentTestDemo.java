package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ComponentTestDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://laboconnect.com/public/home";
		driver.get(url);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("j_idt20")).click();
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/label[1]")).click();

		driver.findElement(By.id("form:idDecLastname:idITxtLastname")).sendKeys("Bouguerra");
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[3]/div[1]/div[1]/input[1]")).sendKeys("Ridha");
		
		Select selectBoxDay = new Select(driver.findElement(By.xpath("//select[@id='form:birthday:day']")));
		selectBoxDay.selectByValue("7");
		
		Thread.sleep(2000);
		
		Select selectBoxMonth = new Select(driver.findElement(By.xpath("//select[@id='form:birthday:month']")));
		//selectBoxMonth.selectByValue("4");
		selectBoxMonth.selectByVisibleText("Avril");
		
		Thread.sleep(2000);
		
		Select selectBoxYears = new Select(driver.findElement(By.xpath("//select[@id='form:birthday:year']")));
		selectBoxYears.selectByValue("1983");

		System.out.println("The date of birthday is selected");

	}

}
