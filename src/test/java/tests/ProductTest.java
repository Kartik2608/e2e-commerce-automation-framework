package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class ProductTest extends BaseTest{
	
	@Test
	public void addToCartTest() {
		
		ConfigReader config = new ConfigReader();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(config.getUsername(), config.getPassword());
		
		ProductsPage productsPage = new ProductsPage(driver);
		
		// Validate Products loaded
		Assert.assertTrue(productsPage.getProductCount() > 0);
		
		// Add product to cart
		productsPage.addProductToCart();
		
		//Validate cart updated
		Assert.assertEquals(productsPage.getCartCount(), "1");
	}

}
