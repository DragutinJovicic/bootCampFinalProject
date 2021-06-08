package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.Resources;

public class ProfileSettings {

	public static void clickProfileSettingsIcon(WebDriver driver) {
		WebElement profileSettingsMenu = driver.findElement(By.id("wrap_us_menu"));
		profileSettingsMenu.click();
		WebElement profileSettings = driver.findElement(By.xpath(Resources.PROFILE_SETTINGS_XPATH));
		profileSettings.click();
	}
	public static void addId(WebDriver driver, String id) {
		WebElement idBox = driver.findElement(By.id("eid"));
		idBox.click();
		idBox.sendKeys(id);
	}
	public static void changeEmployeeType(WebDriver driver, String type) {
		WebElement employeeTypeBox = driver.findElement(By.name("employee_type"));
		employeeTypeBox.click();
		employeeTypeBox.sendKeys(type);
		
	}
	public static void saveUpdate(WebDriver driver) {
		WebElement saveUpdate = driver.findElement(By.name("update"));
		saveUpdate.click();
		driver.navigate().refresh();
	}

}
