package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.Resources;

public class Settings {

	public static void clickSettingsIcon(WebDriver driver) {
		WebElement settings = driver.findElement(By.xpath(Resources.SETTINGS_XPATH));
		settings.click();
	}

	public static void selectLanguage(WebDriver driver, String language) {
		WebElement settings = driver.findElement(By.xpath(Resources.SELECT_LNG_XPATH));
		settings.sendKeys(language);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void uncheckNotifications(WebDriver driver) {
		WebElement check1 = driver.findElement(By.id("pref_pref_email"));
		check1.click();
		WebElement check2 = driver.findElement(By.id("pref_pref_sms"));
		check2.click();
		WebElement check3 = driver.findElement(By.id("pref_pref_mobile_push"));
		check3.click();

		WebElement saveSettings = driver.findElement(By.id("act_primary"));
		saveSettings.click();

		driver.navigate().refresh();
	}

	public static void uploadPicture(WebDriver driver) {

		WebElement fileUpload = driver.findElement(By.id("fileupload"));
		fileUpload.sendKeys("C:\\Users\\dragu\\eclipse-final-project\\bootcampFinalProject\\goat.jpg");
		WebElement saveSettings = driver.findElement(By.id("act_primary"));
		saveSettings.click();
	}

}
