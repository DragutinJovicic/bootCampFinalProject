package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Resources;
import objects.HomePage;

public class TestTopMenu {
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test (priority = 1)
	public void testMenuShiftPlan() {
		String email = "johncage433@test.com";
		String password = "thepasSword";
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.goToHomePage(driver);
		HomePage.acceptCookies(driver);
		HomePage.removeAnnouncement(driver);
		HomePage.inputCredentials(driver, email, password);
		
		HomePage.menuShiftPlanning(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = Resources.SHIFT_PLAN_URL;
		
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test (priority = 2)
	public void testMenuTimeClock() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.menuTimeClock(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = Resources.TIME_CLOCK_URL;
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 3)
	public void testMenuLeave() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.menuLeave(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = Resources.LEAVE_URL;
		
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 4)
	public void testMenuTraining() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.menuTraining(driver);
		driver.navigate().refresh();
		
		String actual = driver.getCurrentUrl();
		String expected = Resources.TRAINING_URL;
		
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 5)
	public void testMenuStaff() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.menuStaff(driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String actual = driver.getCurrentUrl();
		String expected = Resources.STAFF_URL;
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 6)
	public void testMenuAvailability() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.menuAvailability(driver);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String actual = driver.getCurrentUrl();
		String expected = Resources.AVAILABILITY_URL;
		
		Assert.assertTrue(actual.contains(expected), "Failed");
	
	}
	@Test (priority = 7)
	public void testMenuPayroll() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.menuPayroll(driver);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String actual = driver.getCurrentUrl();
		String expected = Resources.PAYROLL_URL;
		
		Assert.assertEquals(actual, expected);
		
	}
	@Test (priority = 8)
	public void testMenuReports() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.menuReports(driver);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String actual = driver.getCurrentUrl();
		String expected = Resources.REPORTS_URL;
		
		Assert.assertEquals(actual, expected);
		
	}

}
