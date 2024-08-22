package Day3.sync;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtigertest1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// Launch the web browser
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");

		// Enter username as Admin
		WebElement usernameField = driver.findElement(By.id("username"));
		System.out.println("Username input field visibility status? " + usernameField.isDisplayed());
		System.out.println("Username input field editable status? " + usernameField.isEnabled());
		String defaultValueOfUserNameInputField = usernameField.getAttribute("placeholder");
		System.out.println("User name input field value: " + defaultValueOfUserNameInputField);
		usernameField.clear();
		usernameField.sendKeys("Admin");

		// Enter password as admin
		WebElement passwordField = driver.findElement(By.id("password"));

		System.out.println("Password input field visibility status? " + passwordField.isDisplayed());
		System.out.println("Password input field editable status? " + passwordField.isEnabled());
		String defaultValueOfpasswordInputField = passwordField.getAttribute("placeholder");
		System.out.println("Password input field value: " + defaultValueOfpasswordInputField);
		passwordField.clear();
		passwordField.sendKeys("admin");

		// Click on login button
		WebElement loginButton = driver.findElement(By.className("buttonBlue"));

		System.out.println("loginBtn visibility status? " + loginButton.isDisplayed());
		System.out.println("loginBtn enable or not? " + loginButton.isEnabled());
		System.out.println("Login button name is: " + loginButton.getText());
		loginButton.click();

		// home page
		WebElement homePage = driver.findElement(By.className("fa-user"));
		System.out.println("homePage visibility status? " + homePage.isDisplayed());
		System.out.println("homePage enable or not? " + homePage.isEnabled());
		System.out.println("homePage name is: " + homePage.getText());
		homePage.click();

		// signout

		WebElement logoutButton = driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT"));
		System.out.println("logoutButton visibility status? " + logoutButton.isDisplayed());
		System.out.println("logoutButton enable or not? " + logoutButton.isEnabled());
		System.out.println("logoutButton name is: " + logoutButton.getText());
		logoutButton.click();

	}
}
