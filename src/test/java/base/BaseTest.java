package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ScreenshotUtils;



public class BaseTest {
	
	protected WebDriver driver;
	ConfigReader config;
	Logger log = LogManager.getLogger(BaseTest.class);
	
	@BeforeMethod
	public void setup() {
		
		config = new ConfigReader();
		
		log.info("Initializing browser");
		
		driver = DriverFactory.initializeDriver(config.getBrowser());
		
		log.info("Opening URL: " + config.getUrl());
		
		driver.get(config.getUrl());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtils.captureScreenshot(driver, result.getName());
			ScreenshotUtils.attachScreenShot(driver);
			
			log.error("Test Failed: Screenshot attached to Allure report");
		}
		
		driver.quit();
	}

}
