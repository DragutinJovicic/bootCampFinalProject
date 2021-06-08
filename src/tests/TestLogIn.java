package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.HomePage;

public class TestLogIn {
	
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
		
		String actual = driver.getCurrentUrl();
		String expected = "https://johncage.humanity.com/app/dashboard/";
		
		Assert.assertEquals(actual, expected);
	}

}
