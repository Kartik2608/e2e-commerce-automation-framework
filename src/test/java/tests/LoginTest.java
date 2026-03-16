package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest{
	
	@Test
	public void validLoginTest() {
		
		ConfigReader config = new ConfigReader();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(config.getUsername(), config.getPassword());
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory"));
	}

}
