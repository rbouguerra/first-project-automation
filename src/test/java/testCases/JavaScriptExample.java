package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class JavaScriptExample {

	public static void main(String[] args) {

	    System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
/*
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("window-size=1024,768");
	    
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    WebDriver driver = new ChromeDriver(capabilities);
*/
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("http://google.com/");
	    driver.manage().window().maximize();

	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor) driver).executeScript("alert('Bonjour tout le monde');");
	    }

	}

}
