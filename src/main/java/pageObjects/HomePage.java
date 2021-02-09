package pageObjects;

import org.openqa.selenium.WebElement;

import framework.Initializer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends Initializer {

	public HomePage(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Preference']")
	public WebElement preferences;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Accessibility']")
	public WebElement accesibility;

	public Preferences clickPreferencesOption() {
		preferences.click();
		return new Preferences(driver);
	}
	
	public Preferences clickAccesabilityOption() {
		accesibility.click();
		return new Preferences(driver);
	}
}
