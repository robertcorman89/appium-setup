package AppiumStructure.MavenJava;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.Setup;
import pageObjects.HomePage;

public class BasicTests extends Setup {

	@Test(groups = "Smoke")
	public void addWifiSettingPreference() {
		System.out.println("Merge");
		HomePage homePage = new HomePage(driver);
		homePage.openProject.click();
		Assert.assertTrue(true);
	}

	@Test(groups = "Smoke")
	public void addWifiSettingPreference0() {
		System.out.println("Merge");
		HomePage homePage = new HomePage(driver);
		homePage.openProject.click();
		Assert.assertTrue(false);
	}
	@Test(groups = "Smoke")
	public void addWifiSettingPreference1() {
		System.out.println("Merge");
		HomePage homePage = new HomePage(driver);
		homePage.openProject.click();
		Assert.assertTrue(true);
	}
	@Test(groups = "Smoke")
	public void addWifiSettingPreference2() {
		System.out.println("Merge");
		HomePage homePage = new HomePage(driver);
		homePage.openProject.click();
		Assert.assertTrue(true);
	}
//	@Test(groups = "Regression", priority = 1)
	public void openPreferencePage() throws MalformedURLException, InterruptedException {
	}
}
