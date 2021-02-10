package framework;

import java.io.File;
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
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Setup {

	public static AppiumDriverLocalService appiumService;
	public static AppiumServiceBuilder appiumBuilder;
	protected AndroidDriver<WebElement> driver;

	@BeforeSuite()
	protected void startEmulator() throws IOException {
		Helper.runSystemFile(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
	}

	@BeforeMethod()
	protected AppiumDriverLocalService startAppiumServer() {
		String APPIUM_JS = "C:\\Users\\robertc\\AppData\\Roaming\\npm\\node_modules\\appium\\lib";

//		appiumService = AppiumDriverLocalService.buildDefaultService();
		if (!Helper.isServerRunning(Environment.port)) {
			appiumBuilder = new AppiumServiceBuilder();
			appiumBuilder.withAppiumJS(new File(APPIUM_JS));
			appiumBuilder.withIPAddress("127.0.0.1");
			appiumBuilder.usingPort(Environment.port);
			appiumService = AppiumDriverLocalService.buildService(appiumBuilder);
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
