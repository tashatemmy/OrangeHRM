package ui;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIM {
	protected WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")
	WebElement pim;
	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement addEmployeeButton;
	@FindBy(xpath = "//a[text() ='Employee List']")
	WebElement employeeList;
	@FindBy(name = "firstName")
	WebElement firstName;
	@FindBy(name = "middleName")
	WebElement middleName;
	@FindBy(name = "lastName")
	WebElement lastName;
	@FindBy(xpath ="//button[normalize-space()='Save']")
	WebElement save;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")
	WebElement loginCheckbox;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
	WebElement userName;
	@FindBy(css = "input[type='password']")
	WebElement password;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")
	WebElement confirmPassword;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
	WebElement eNameField;
	@FindBy(xpath = "//button[normalize-space() ='Search']")
	WebElement search;
	@FindBy(xpath = "//button[normalize-space() = 'Add']")
	WebElement add;
	@FindBy(xpath = "//a[text() ='OrangeHRM, Inc']")
	WebElement link;
	
	
	
	public PIM(WebDriver driver) {
	PageFactory.initElements(driver, this);
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	js = (JavascriptExecutor) driver;
	
	}
	
	
	
	public void addEmployee( String fname, String mname, String lname ) {
		wait.until(ExpectedConditions.visibilityOf(pim));
		pim.click();
		wait.until(ExpectedConditions.visibilityOf(addEmployeeButton));
		addEmployeeButton.click();
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(fname);
		wait.until(ExpectedConditions.attributeToBe(firstName, "value", fname));
		middleName.sendKeys(mname);
		lastName.sendKeys(lname);
		wait.until(ExpectedConditions.attributeToBe(lastName, "value", lname));
		loginCheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys("lolo");
		password.sendKeys("Lolo123456");
		confirmPassword.sendKeys("Lolo123456");
		wait.until(ExpectedConditions.attributeToBe(confirmPassword, "value", "Lolo123456"));
		js.executeScript("arguments[0].scrollIntoView(true);", save);
		save.click();		
		
	}
	
	public void searchEmployee(String name) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(pim));
		pim.click();
		wait.until(ExpectedConditions.visibilityOf(employeeList));
		employeeList.click();
		wait.until(ExpectedConditions.visibilityOf(eNameField));
		eNameField.sendKeys(name);
		wait.until(ExpectedConditions.attributeToBe(eNameField, "value", name));
		search.click();
		wait.until(ExpectedConditions.elementToBeClickable(add));
		js.executeScript("arguments[0].scrollIntoView(true);", link);
		wait.until(ExpectedConditions.elementToBeClickable(link));
		Thread.sleep(3000);
		
		
		
	}
	

}
