package framework.wrappers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;

public class Actions {

	AndroidDriver<WebElement> driver;
	WebDriverWait waitDriver;

	public Actions(AndroidDriver<WebElement> driver, WebDriverWait waitDriver) {
		this.driver = driver;
		this.waitDriver = waitDriver;
	}

	public void click(WebElement element) {
		waitDriver.until(ExpectedConditions.visibilityOfAllElements(element));
		element.click();
	}
}
