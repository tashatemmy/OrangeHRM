package ui_tests;

import org.testng.annotations.Test;
import ui.Login;

public class LoginTest extends Base{
	
	@Test
	public void validLogin() {
		Login log = new Login(driver);
		log.loginAdmin("Admin", "admin123");
	}

}
