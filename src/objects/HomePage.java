package objects;


import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.Resources;

public class HomePage {

	public static void goToHomePage(WebDriver driver) {
		driver.get(Resources.HOME_URL);
		driver.manage().window().maximize();
	}

	public static void aboutUs(WebDriver driver) {

		WebElement aboutUsMenu = driver.findElement(By.xpath(Resources.ABOUT_US_MENU_XPATH));
		aboutUsMenu.click();
		WebElement aboutUs = driver.findElement(By.xpath(Resources.ABOUT_US_XPATH));
		aboutUs.click();
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./Screenshots/aboutUsScreen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void acceptCookies(WebDriver driver) {

		WebElement accept = driver.findElement(By.xpath(Resources.ACCEPT_COOKIES_XPATH));
		accept.click();
	}

	public static void removeAnnouncement(WebDriver driver) {

		WebElement removeAnnounc = driver.findElement(By.xpath(Resources.QUIT_ANNOUNCEMENT_XPATH));
		removeAnnounc.click();
	}

	public static void quitBot(WebDriver driver) {
		WebElement quitBot = driver.findElement(By.xpath(Resources.QUIT_BOT_XPATH));
		quitBot.click();
	}

	public static void inputCredentials(WebDriver driver, String email, String password) {
		WebElement logIn = driver.findElement(By.xpath(Resources.LOGIN_XPATH));
		logIn.click();
		WebElement emailBox = driver.findElement(By.id("email"));
		emailBox.click();
		emailBox.sendKeys(email);
		WebElement passBox = driver.findElement(By.id("password"));
		passBox.click();
		passBox.sendKeys(password);
		WebElement logInBtn = driver.findElement(By.name("login"));
		logInBtn.click();
	}

	public static void menuShiftPlanning(WebDriver driver) {
		WebElement shiftPlanning = driver.findElement(By.xpath(Resources.SHIFT_PLAN_XPATH));
		shiftPlanning.click();
	}
	public static void menuTimeClock(WebDriver driver) {
		WebElement timeClock = driver.findElement(By.xpath(Resources.TIME_CLOCK_XPATH));
		timeClock.click();
	}
	public static void menuLeave(WebDriver driver) {
		WebElement leave = driver.findElement(By.xpath(Resources.LEAVE_XPATH));
		leave.click();
	}
	public static void menuTraining(WebDriver driver) {
		WebElement training = driver.findElement(By.xpath(Resources.TRAINING_XPATH));
		training.click();
	}
	public static void menuStaff(WebDriver driver) {
		WebElement staff = driver.findElement(By.xpath(Resources.STAFF_XPATH));
		staff.click();
	}
	public static void menuAvailability(WebDriver driver) {
		WebElement available = driver.findElement(By.xpath(Resources.AVAILABILITY_XPATH));
		available.click();
	}
	public static void menuPayroll(WebDriver driver) {
		WebElement payroll = driver.findElement(By.xpath(Resources.PAYROLL_XPATH));
		payroll.click();
	}
	public static void menuReports(WebDriver driver) {
		WebElement reports = driver.findElement(By.xpath(Resources.REPORTS_XPATH));
		reports.click();
	}
	
	public static void addEmployees(WebDriver driver, String firstName, String lastName, String emailEmployee) {
		WebElement addEmpBtn = driver.findElement(By.id("act_primary"));
		addEmpBtn.click();
		WebElement firstName1 = driver.findElement(By.id("_asf1"));
		firstName1.click();
		firstName1.sendKeys(firstName);
		WebElement lastName1 = driver.findElement(By.id("_asl1"));
		lastName1.click();
		lastName1.sendKeys(lastName);
		WebElement emailEmployee1 = driver.findElement(By.id("_ase1"));
		emailEmployee1.click();
		emailEmployee1.sendKeys(emailEmployee);
		WebElement saveEmployee = driver.findElement(By.id("_as_save_multiple"));
		saveEmployee.click();
		
	}
	
	public static void filterEmployee(WebDriver driver, String name) {
		WebElement search = driver.findElement(By.id("EmployeeStaffFilter"));
		search.click();
		search.clear();
		search.sendKeys(name);
	}
	
	public static void changeEmpName(WebDriver driver,String oldName, String newName) {
		WebElement search = driver.findElement(By.id("EmployeeStaffFilter"));
		search.click();
		search.sendKeys(oldName);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement employeeList1 = driver.findElement(By.xpath(Resources.LIST_EMPLOYEE1_XPATH));
		employeeList1.click();
		WebElement editDetails = driver.findElement(By.xpath(Resources.EDIT_DETAILS_XPATH));
		editDetails.click();
		WebElement nameBox = driver.findElement(By.id("first_name"));
		nameBox.click();
		nameBox.clear();
		nameBox.sendKeys(newName);
		WebElement saveChanges = driver.findElement(By.name("update"));
		saveChanges.click();
	}
	public static void addEmployeesNG(WebDriver driver, List<?> employees) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement addEmpBtn = driver.findElement(By.id("act_primary"));
		addEmpBtn.click();
		///
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement firstName1 = driver.findElement(By.id("_asf1"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		firstName1.click();
		firstName1.sendKeys(employees.get(0).toString());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement lastName1 = driver.findElement(By.id("_asl1"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lastName1.click();
		lastName1.sendKeys(employees.get(1).toString());
		
		WebElement emailEmployee1 = driver.findElement(By.id("_ase1"));
		emailEmployee1.click();
		emailEmployee1.sendKeys(employees.get(2).toString());
		
		///
		WebElement firstName2 = driver.findElement(By.id("_asf2"));
		firstName2.click();
		firstName2.sendKeys(employees.get(3).toString());
		
		WebElement lastName2 = driver.findElement(By.id("_asl2"));
		lastName2.click();
		lastName2.sendKeys(employees.get(4).toString());
		
		WebElement emailEmployee2 = driver.findElement(By.id("_ase2"));
		emailEmployee2.click();
		emailEmployee2.sendKeys(employees.get(5).toString());
		
		///
		WebElement firstName3 = driver.findElement(By.id("_asf3"));
		firstName3.click();
		firstName3.sendKeys(employees.get(6).toString());
		
		WebElement lastName3 = driver.findElement(By.id("_asl3"));
		lastName3.click();
		lastName3.sendKeys(employees.get(7).toString());
		
		WebElement emailEmployee3 = driver.findElement(By.id("_ase3"));
		emailEmployee3.click();
		emailEmployee3.sendKeys(employees.get(8).toString());
		
		///
		WebElement firstName4 = driver.findElement(By.id("_asf4"));
		firstName4.click();
		firstName4.sendKeys(employees.get(9).toString());
		
		WebElement lastName4 = driver.findElement(By.id("_asl4"));
		lastName4.click();
		lastName4.sendKeys(employees.get(10).toString());
		
		WebElement emailEmployee4 = driver.findElement(By.id("_ase4"));
		emailEmployee4.click();
		emailEmployee4.sendKeys(employees.get(11).toString());
		
		///
		WebElement firstName5 = driver.findElement(By.id("_asf5"));
		firstName5.click();
		firstName5.sendKeys(employees.get(12).toString());
		
		WebElement lastName5 = driver.findElement(By.id("_asl5"));
		lastName5.click();
		lastName5.sendKeys(employees.get(13).toString());
		
		WebElement emailEmployee5 = driver.findElement(By.id("_ase5"));
		emailEmployee5.click();
		emailEmployee5.sendKeys(employees.get(14).toString());
		
		
		WebElement saveEmployee = driver.findElement(By.id("_as_save_multiple"));
		saveEmployee.click();
		
	}
	

}
