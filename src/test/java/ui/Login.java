package ui;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	protected WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameField;
	@FindBy(name = "password")
	WebElement passwordField;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement login;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}
	
	
	
	public void loginAdmin(String username, String password ) {
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		login.click();
		
	}

}
