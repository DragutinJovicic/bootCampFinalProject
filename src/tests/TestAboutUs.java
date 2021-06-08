package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Resources;
import objects.HomePage;

public class TestAboutUs {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testAboutUs () {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.goToHomePage(driver);
		HomePage.acceptCookies(driver);
		HomePage.removeAnnouncement(driver);
		//HomePage.quitBot(driver);
		HomePage.aboutUs(driver);
		
		
		String actual = driver.getCurrentUrl();
		String expected = Resources.ABOUT_US_URL;
		
		Assert.assertEquals(actual, expected);
	}

}
