package Day3.sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusableComponent.GenericFunctions;

public class BrowserValidation {

	public static void main(String[] args) {
		WebDriver driver = GenericFunctions.createInstanceOfRequiredBrowser("chrome");
		// maximize browser window
		driver.manage().window().maximize();
		// to set browser window with desired size
		driver.manage().window().setSize(new Dimension(500, 700));
		// minimize browser window
		driver.manage().window().minimize();
		// maximize browser window
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// after implicit wait, driver will get default time as define in implicit wait,
		// 0-30
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.className("orangehrm-login-forgot")).click();
		// once you move to next screen and want to come back to previous screen use
		// this
		driver.navigate().back();

		// if you are navigated back to previous screen and want to goto next screen
		// again
		driver.navigate().forward();

		// to reload use
		driver.navigate().refresh();

		// to move to another URL
		driver.navigate().to("https://www.google.com");
	}
}
