package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
	
	WebDriver driver;
	WaitUtils waitUtils;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		waitUtils = new WaitUtils(driver);
	}
	
	public void type(WebElement element, String text) {
		waitUtils.waitForElementVisible(element);
		element.clear();
		element.sendKeys(text);
	}
	
	public void click(WebElement element) {
		waitUtils.waitForElementVisible(element);
		element.click();
	}
}
