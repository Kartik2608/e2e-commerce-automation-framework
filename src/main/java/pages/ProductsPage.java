package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class ProductsPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	//Locators
	@FindBy(className = "inventory_item")
	java.util.List<WebElement> products;
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement addToCartButton;
	
	@FindBy(className = "shopping_cart_badge")
	WebElement cartBadge;
	
	//Actions
	public int getProductCount() {
		return products.size();
	}
	
	public void addProductToCart() {
		elementUtils.click(addToCartButton);
	}
	
	public String getCartCount() {
		return cartBadge.getText();
	}
}
