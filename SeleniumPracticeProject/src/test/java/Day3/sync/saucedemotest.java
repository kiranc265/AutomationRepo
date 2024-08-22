package Day3.sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class saucedemotest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// Launch the web browser
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://www.saucedemo.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// pick user name and password
		// WebElement username = driver.findElement(By.id("login_credentials"));

		// System.out.println("Login button name is: " + username.getText());
		// username.click();

		// WebElement Password = driver.findElement(By.className("login_password"));
		/// System.out.println("Login button name is: " + Password.getText());
		// Password.click();

		String username = "standard_user";
		String password = "secret_sauce";

		// Enter username as standard_user
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.clear();
		usernameField.sendKeys(username);
		System.out.println("Username input field visibility status? " + usernameField.isDisplayed());
		System.out.println("Username input field editable status? " + usernameField.isEnabled());
		String defaultValueOfUserNameInputField = usernameField.getAttribute("placeholder");
		System.out.println("User name input field value: " + defaultValueOfUserNameInputField);

		// Enter password as secret_sauce
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.clear();
		passwordField.sendKeys(password);
		System.out.println("Password input field visibility status? " + passwordField.isDisplayed());
		System.out.println("Password input field editable status? " + passwordField.isEnabled());
		String defaultValueOfpasswordInputField = passwordField.getAttribute("placeholder");
		System.out.println("Password input field value: " + defaultValueOfpasswordInputField);

		// Click on login button
		WebElement loginButton = driver.findElement(By.id("login-button"));
		System.out.println("loginBtn visibility status? " + loginButton.isDisplayed());
		System.out.println("loginBtn enable or not? " + loginButton.isEnabled());
		System.out.println("Login button name is: " + loginButton.getText());
		loginButton.click();

		// Validate home page with title
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs"; // Adjust this as per the actual title after login
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title validation passed : " + actualTitle);
		} else {
			System.out.println("Title validation failed : " + actualTitle);
		}

		// homepage
		WebElement homePage = driver.findElement(By.id("react-burger-menu-btn"));
		System.out.println("homePage visibility status? " + homePage.isDisplayed());
		System.out.println("homePage enable or not? " + homePage.isEnabled());
		System.out.println("homePage name is: " + homePage.getText());
		homePage.click();
		// Logout
		WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
		System.out.println("logoutButton visibility status? " + logoutButton.isDisplayed());
		System.out.println("logoutButton enable or not? " + logoutButton.isEnabled());
		System.out.println("logoutButton name is: " + logoutButton.getText());
		logoutButton.click();

	}
}
