package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Resources;
import objects.HomePage;

public class TestChangeName {

private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void testChangeEmpName() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String email = "johncage433@test.com";
		String password = "thepasSword";
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		HomePage.goToHomePage(driver);
		HomePage.acceptCookies(driver);
		HomePage.removeAnnouncement(driver);
		HomePage.inputCredentials(driver, email, password);
		
		HomePage.menuStaff(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String newName = "Nenad";
		String oldName = Resources.firstNameEmp1;
		HomePage.changeEmpName(driver,oldName, newName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		HomePage.menuStaff(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		HomePage.filterEmployee(driver, newName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement employee = driver.findElement(By.xpath(Resources.LIST_EMPLOYEE1_XPATH));
		String actual = employee.getText();
		String expected = newName + " " + Resources.lastNameEmp1;
		
		Assert.assertEquals(actual, expected);
		
		
	}
}
