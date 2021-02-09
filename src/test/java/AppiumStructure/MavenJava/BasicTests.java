package AppiumStructure.MavenJava;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.Setup;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class BasicTests extends Setup {

	@Test(groups = "Smoke")
	public void addWifiSettingPreference() {
		String wifiName = "New Wi-fi";
		HomePage homePage = new HomePage(driver);
		Preferences preferencesPage = homePage.clickPreferencesOption();
		preferencesPage.preferenceDependencies.click();
		preferencesPage.wiFiCheckbox.click();
		preferencesPage.wiFiSettingsOption.click();
		preferencesPage.wiFiSettingsInput.sendKeys(wifiName);
		preferencesPage.clickOkButton();
		Assert.assertTrue(preferencesPage.wiFiSettingsOption.isDisplayed());
	}

	@Test(groups = "Regression", priority = 1)
	public void openPreferencePage() throws MalformedURLException, InterruptedException {
		HomePage homePage = new HomePage(driver);
		Preferences preferencesPage = homePage.clickPreferencesOption();
		Assert.assertTrue(preferencesPage.preferenceDependencies.isDisplayed());
	}
}
