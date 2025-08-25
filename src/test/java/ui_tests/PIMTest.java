package ui_tests;

import org.testng.annotations.Test;
import ui.Login;
import ui.PIM;

public class PIMTest extends Base{
	
	@Test(groups = {"smoke", "regression", "positive"}, priority = 1)
	public void addEmployeeTest() {
		//login to orangeHRM
		Login lt = new Login(driver);
		lt.loginAdmin("Admin", "admin123");;
		
		//PIM module
		PIM pim = new PIM(driver);
		pim.addEmployee("Erica", "Jui", "Simpson");
	}
	
	
	@Test(groups = {"smoke", "regression", "positive"}, priority =2)
	public void employeeSearchTest() throws InterruptedException {
		//login to orangeHRM
		Login lt = new Login(driver);
		lt.loginAdmin("Admin", "admin123");
		
		PIM pim = new PIM(driver);
		pim.searchEmployee("John");
		
	}	

}
