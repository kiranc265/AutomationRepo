package Day2.Assignmnet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo_application {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// Launch the web browser
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://www.saucedemo.com");

		// Enter username as standard_user
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.clear();
		usernameField.sendKeys("standard_user");

		// Enter password as secret_sauce
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.clear();
		passwordField.sendKeys("secret_sauce");

		// Click on login button
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// Validate home page with title and URL
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs"; // Adjust this as per the actual title after login
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title validation passed : " + actualTitle);
		} else {
			System.out.println("Title validation failed : " + actualTitle);
		}

		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html"; // Adjust this as per the actual URL after
																			// login
		if (actualURL.equals(expectedURL)) {
			System.out.println("URL validation passed. Actual URL: " + actualURL);
		} else {
			System.out.println("URL validation failed. Actual URL: " + actualURL);
		}

		// Logout from the application
		WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));

		menuButton.click();

		WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
		logoutButton.click();

		// Close the browser
		driver.quit();

	}
}
