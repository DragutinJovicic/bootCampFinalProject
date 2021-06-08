package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Resources;
import objects.HomePage;
import objects.Settings;

public class TestSettings {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void testSettings() {
		String email = "johncage433@test.com";
		String password = "thepasSword";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.goToHomePage(driver);
		HomePage.acceptCookies(driver);
		HomePage.removeAnnouncement(driver);
		HomePage.inputCredentials(driver, email, password);

		String language = "serbian";

		Settings.clickSettingsIcon(driver);
		Settings.selectLanguage(driver, language);
		Settings.uncheckNotifications(driver);

		Select select = new Select(driver.findElement(By.xpath(Resources.SELECT_LNG_XPATH)));

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(select.getFirstSelectedOption().getText(), "Serbian (machine)");
		sa.assertFalse(driver.findElement(By.id("pref_pref_email")).isSelected());
		sa.assertFalse(driver.findElement(By.id("pref_pref_sms")).isSelected());
		sa.assertFalse(driver.findElement(By.id("pref_pref_mobile_push")).isSelected());
		
		sa.assertAll();	
	}

}
