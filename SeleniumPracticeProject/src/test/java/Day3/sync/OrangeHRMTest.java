package Day3.sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest {

	public static void main(String[] args) {
		// Set up ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// Navigate to the OrangeHRM login page
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// Username

		WebElement userNameInputField = driver.findElement(By.name("username"));
		System.out.println("Username input field visibility status? " + userNameInputField.isDisplayed());
		System.out.println("Username input field editable status? " + userNameInputField.isEnabled());
		String defaultValueOfUserNameInputField = userNameInputField.getAttribute("placeholder");
		System.out.println("User name input field value: " + defaultValueOfUserNameInputField);
		userNameInputField.clear();
		userNameInputField.sendKeys("Admin");

		// Password

		WebElement passwordInputField = driver.findElement(By.name("password"));

		System.out.println("Password input field visibility status? " + passwordInputField.isDisplayed());
		System.out.println("Password input field editable status? " + passwordInputField.isEnabled());
		String defaultValueOfpasswordInputField = passwordInputField.getAttribute("placeholder");
		System.out.println("Password input field value: " + defaultValueOfpasswordInputField);
		passwordInputField.clear();
		passwordInputField.sendKeys("admin123");

		// Loginbtn
		WebElement loginBtn = driver.findElement(By.className("orangehrm-login-button"));
		
		System.out.println("loginBtn visibility status? " + loginBtn.isDisplayed());
		System.out.println("loginBtn enable or not? " + loginBtn.isEnabled());
		System.out.println("Login button name is: " + loginBtn.getText());
		loginBtn.click();
		
		// Homepage

		WebElement Homepage = driver.findElement(By.className(" oxd-icon "));
		System.out.println("Homepage visibility status? " + Homepage.isDisplayed());
		System.out.println("Homepage enable or not? " + Homepage.isEnabled());
		Homepage.click();
		
		
		// dropdownicon
		
		WebElement dropdownIcon = driver.findElement(By.className("oxd-userdropdown-icon"));
		System.out.println("dropdownIcon visibility status? " + dropdownIcon.isDisplayed());
		System.out.println("dropdownIcon enable or not? " + dropdownIcon.isEnabled());
		System.out.println("dropdownIcon name is: " + dropdownIcon.getText());
		dropdownIcon.click();
		
		// Logoutbtn
		WebElement logoutButton = driver.findElement(By.className("oxd-userdropdown-link"));
		System.out.println("logoutButton visibility status? " + logoutButton.isDisplayed());
		System.out.println("logoutButton enable or not? " + logoutButton.isEnabled());
		System.out.println("logoutButton name is: " + logoutButton.getText());
		logoutButton.click();
		

	
	}
}