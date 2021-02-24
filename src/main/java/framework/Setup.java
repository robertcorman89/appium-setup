package framework;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.BeforeClass;
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
	public DesiredCapabilities caps;

	@BeforeSuite
	public void setupCapabilities() {
		System.out.println("=========================CAPABILITIES============================");
		caps = Helper.setCapabilities(caps);
	}

	@BeforeMethod()
	public AppiumDriverLocalService startAppiumServer() {
		System.out.println("=========================APPIUM============================");
		if (!Helper.isServerRunning(Environment.PORT)) {
			appiumBuilder = new AppiumServiceBuilder();
			appiumBuilder.withAppiumJS(new File(Environment.APPIUM_JS_PATH));
			appiumBuilder.withIPAddress(Environment.IP);
			appiumBuilder.usingPort(Environment.PORT);
			appiumService = AppiumDriverLocalService.buildService(appiumBuilder);
			appiumService.start();
		}
		return appiumService;
	}

	@BeforeMethod(dependsOnMethods = "startAppiumServer")
	public void setup() throws IOException, InterruptedException {
		System.out.println("=========================SETUP============================");
		driver = new AndroidDriver<>(new URL(Environment.URL + ":" + Environment.PORT + "/wd/hub"), caps);
	}

	@AfterMethod
	public void tearDown() throws IOException {
		System.out.println("=========================TEARDOWN============================");
		driver.quit();
		appiumService.stop();
	}
}
