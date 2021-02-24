package framework.utils;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import framework.data.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Helper {
	public static boolean isServerRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static DesiredCapabilities setCapabilities(DesiredCapabilities caps) {
		File appDirectory = new File("src/main/java/resources");
		File appLocation = new File(appDirectory, Capabilities.APP_NAME);
		caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.APP, appLocation.getAbsolutePath());
		caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, Capabilities.APP_ACTIVITY);
		caps.setCapability(AndroidMobileCapabilityType.AVD, Capabilities.EMULATOR_NAME);
		caps.setCapability(AndroidMobileCapabilityType.AVD_READY_TIMEOUT, 30000);
		return caps;
	}

	public static void runSystemFile(String filePath) throws IOException {
		Runtime.getRuntime().exec(filePath);
	}

	public static void getScreenshot(AndroidDriver<WebElement> driver, String fileName) throws IOException {
		File fileSource = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileSource,
				new File(System.getProperty("user.dir") + "\\output\\screenshots\\" + fileName + ".png"));
	}
}
