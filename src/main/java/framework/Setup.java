package framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import framework.data.Environment;
import framework.utils.Helper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Setup {

	public static AppiumDriverLocalService appiumService;
	protected AndroidDriver<WebElement> driver;

	@BeforeSuite()
	protected void startEmulator() throws IOException {
		Helper.runSystemFile(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
	}

	@BeforeMethod()
	protected AppiumDriverLocalService startAppiumServer() {
		appiumService = AppiumDriverLocalService.buildDefaultService();
		if (!Helper.isServerRunning(Environment.port)) {
			appiumService.start();
		}
		return appiumService;
	}

	@BeforeMethod(dependsOnMethods = { "startAppiumServer" })
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = Helper.setCapabilities();
		driver = new AndroidDriver<>(new URL(Environment.URL + ":" + Environment.port + "/wd/hub"), caps);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		appiumService.stop();
	}
}
