package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginButton;
	
	//Actions
	public void enterUsername(String user) {
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void loginToApplication(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
	}
}
