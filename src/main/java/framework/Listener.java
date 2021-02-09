package framework;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.ITestListener;
import org.testng.ITestResult;
import framework.utils.Helper;
import io.appium.java_client.android.AndroidDriver;

public class Listener implements ITestListener {
	@SuppressWarnings("unchecked")
	@Override
	public void onTestFailure(ITestResult result) {
		AndroidDriver<WebElement> driver;
		try {
			driver = (AndroidDriver<WebElement>) result.getTestClass().getRealClass().getSuperclass()
					.getDeclaredField("driver").get(result.getInstance());
			Helper.getScreenshot(driver, result.getName());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
