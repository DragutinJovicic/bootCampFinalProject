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

public class TestAddEmployee {

private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testAddEmployee() {
		String email = "johncage433@test.com";
		String password = "thepasSword";
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		HomePage.goToHomePage(driver);
		HomePage.acceptCookies(driver);
		HomePage.removeAnnouncement(driver);
		HomePage.inputCredentials(driver, email, password);
		HomePage.menuStaff(driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String firstName = Resources.firstNameEmp1;
		String lastName = Resources.lastNameEmp1;
		String emailEmployee = Resources.emailEmp1;
		
		HomePage.addEmployees(driver, firstName, lastName, emailEmployee);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement staff = driver.findElement(By.xpath(Resources.EMP1_XPATH));
		String name = staff.getText();
		String expected = firstName + " " + lastName;
		
		Assert.assertTrue(name.contains(expected), "Failed");                 
		
	}
}
