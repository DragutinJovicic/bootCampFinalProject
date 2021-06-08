package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.HomePage;
import objects.ProfileSettings;

public class TestProfileSettings {
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testLogIn() {
		
		String email = "johncage433@test.com";
		String password = "thepasSword";
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.goToHomePage(driver);
		HomePage.acceptCookies(driver);
		HomePage.removeAnnouncement(driver);
		HomePage.inputCredentials(driver, email, password);
		
		ProfileSettings.clickProfileSettingsIcon(driver);
		String id = "123456";
		ProfileSettings.addId(driver, id);
		String type = "full";
		ProfileSettings.changeEmployeeType(driver, type);
		ProfileSettings.saveUpdate(driver);
	}

}
