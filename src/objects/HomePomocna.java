package objects;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePomocna {

	
	public static void removeAnnouncement(WebDriver driver) {
		Actions actions = new Actions(driver);

		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(50, 50);

			actions.click().build().perform();

			robot.mouseMove(200, 70);

			actions.click().build().perform();
			actions.click().build().perform();
		} catch (AWTException e) {
			e.printStackTrace();
		}
}
}