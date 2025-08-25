package ui_tests;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	
	
	
	@BeforeMethod
	public void browserSetup() {
		String browser = System.getProperty("browser", "chrome");
		String url = "https://opensource-demo.orangehrmlive.com";
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
	        options.setAcceptInsecureCerts(true);
	        
	        driver = new ChromeDriver(options);
			
		}else if(browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			SafariOptions options = new SafariOptions();
			options.setAcceptInsecureCerts(true);
	        
	        driver = new SafariDriver(options);	
		}
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
