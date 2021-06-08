package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.HomePage;

public class TestExcelAddEmployee {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void addEmployeesNG() {
		String email = "johncage433@test.com";
		String password = "thepasSword";
		List list = new ArrayList();

		File f = new File("data.xlsx");
		InputStream in;
		try {
			in = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			Sheet sheet = wb.getSheetAt(0);

			for (int i = 0; i < 5; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < 3; j++) {
					Cell c0 = row.getCell(j);
					list.add(c0);
				}
			}
			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		HomePage.goToHomePage(driver);
		HomePage.acceptCookies(driver);
		HomePage.removeAnnouncement(driver);
		HomePage.inputCredentials(driver, email, password);
		HomePage.menuStaff(driver);

		HomePage.addEmployeesNG(driver, list);

		SoftAssert sa = new SoftAssert();

		for (int i = 0; i <= list.size() && i % 3 == 0 || i == 0; i++) {
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
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String actual = driver.getPageSource();
			String expected = list.get(i).toString() + " " + list.get(i + 1).toString();

			sa.assertTrue(actual.contains(expected));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.navigate().refresh();
		}
		sa.assertAll();
	}
}
