package Day3.sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusableComponent.GenericFunctions;

public class CssValidationWithPosition {

	public static void main(String[] args) {
		WebDriver driver = GenericFunctions.createInstanceOfRequiredBrowser("chrome");
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// after implicit wait, driver will get default time as define in implicit wait,
		// 0-30
		driver.get("https://online.actitime.com/uts/login.do");

		driver.findElement(By.id("loginButton")).click();// 0-30 sec

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String expectedErrorMsg = "Username or Password is invalid. Please try again.";

		wait.until(ExpectedConditions.textToBe(By.className("errormsg"), expectedErrorMsg));

		WebElement errosMsg = driver.findElement(By.className("errormsg"));
		String actualErrorMsg = errosMsg.getText();

		System.out.println("Error msg validation " + actualErrorMsg.equals(expectedErrorMsg));

		System.out.println("Error msg color code in RGBA format : " + errosMsg.getCssValue("color"));
		System.out.println("Error msg font family : " + errosMsg.getCssValue("font-family"));
		System.out.println("Error msg font-size : " + errosMsg.getCssValue("font-size"));

		Point errorMsgPoint = errosMsg.getLocation();
		int errorMsg_x = errorMsgPoint.getX();
		int errorMsg_y = errorMsgPoint.getY();
		System.out.println("Error msg x and y cords are: " + errorMsg_x + "," + errorMsg_y);
	}
}