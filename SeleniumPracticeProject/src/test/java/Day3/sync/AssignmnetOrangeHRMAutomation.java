package Day3.sync;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmnetOrangeHRMAutomation {
	public static void main(String[] args) {
		// Set up the WebDriver (assuming you have the ChromeDriver installed and in
		// PATH)
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Step 2: Enter application URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Step 3: Click on login button without entering credentials
		WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
		loginButton.click();
		// Step 4: Validate error message color and error message below the username
		// input field
		WebElement errorMessage = driver.findElement(By.className("oxd-alert-content-text"));
		String errorColor = errorMessage.getCssValue("color");
		String expectedColor = "rgba(235, 9, 16, 1)"; // Adjust this based on actual error message color
		// Validate error message below the username input field
		String errorMessageText = errorMessage.getText();
		System.out.println("Error message text: " + errorMessageText);
		// Step 5: Get the username and password from UI (assuming default values)
		WebElement usernameField = driver.findElement(By.name("username"));
		WebElement passwordField = driver.findElement(By.name("password"));
		String defaultUsername = usernameField.getAttribute("placeholder");
		String defaultPassword = passwordField.getAttribute("placeholder");
		System.out.println("Default Username: " + defaultUsername);
		System.out.println("Default Password: " + defaultPassword);
		// Step 6: Enter username and password into input fields
		usernameField.sendKeys("Admin");
		passwordField.sendKeys("admin123");
		// Step 7: Click on login button
		loginButton.click();
		// Close the browser
		driver.quit();

	}
}
