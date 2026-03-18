package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
		
		try {
			FileUtils.copyFile(src, new File(path));
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return path;
	}
}
