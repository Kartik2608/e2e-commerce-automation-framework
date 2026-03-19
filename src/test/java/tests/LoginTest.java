package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider = "loginData", dataProviderClass = TestData.class)
//	public void validLoginTest() {
		public void loginTest(String username, String password) {
//		ConfigReader config = new ConfigReader();
		
		LoginPage loginPage = new LoginPage(driver);
		
//		loginPage.loginToApplication(config.getUsername(), config.getPassword());
		loginPage.loginToApplication(username, password);
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory"));
	}

}
