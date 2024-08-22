package Day2.Assignmnet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerapplicationLogIn {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// Launch the web browser
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");

		// Enter username as Admin
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.clear();
		usernameField.sendKeys("Admin");

		// Enter password as admin
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.clear();
		passwordField.sendKeys("admin");

		// Click on login button
		WebElement loginButton = driver.findElement(By.className("buttonBlue"));
		loginButton.click();

		// Validate home page with title
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard"; // Adjust this as per the actual title after login
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title validation passed : " + actualTitle);
		} else {
			System.out.println("Title validation failed  : " + actualTitle);
		}

		// Validate home page with URL
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://demo.vtiger.com/vtigercrm/index.php";

		if (actualURL.equals(expectedURL)) {
			System.out.println("URL validation passed : " + actualURL);
		} else {
			System.out.println("URL validation failed : " + actualURL);
		}

		// Logout from the application
		WebElement userMenu = driver.findElement(By.xpath("//span[@class='fa fa-power-off']"));
		userMenu.click();
		WebElement logoutButton = driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT"));
		logoutButton.click();

		// Close the browser
		driver.quit();

	}
}
