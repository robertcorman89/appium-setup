package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import framework.Initializer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Preferences extends Initializer {

	public Preferences(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement preferenceDependencies;

	@AndroidFindBy(id = "android:id/checkbox")
	public WebElement wiFiCheckbox;

	@AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	public WebElement wiFiSettingsOption;

	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement wiFiSettingsInput;

	@AndroidFindBy(className = "android.widget.Button")
	private List<WebElement> wifiSettingsPopUpButtons;

	public void clickCancelButton() {
		wifiSettingsPopUpButtons.get(0).click();
	}

	public void clickOkButton() {
		wifiSettingsPopUpButtons.get(1).click();
	}
}
