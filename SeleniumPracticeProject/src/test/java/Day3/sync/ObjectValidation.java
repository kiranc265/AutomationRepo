package Day3.sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import reusableComponent.GenericFunctions;

public class ObjectValidation {

	public static void main(String[] args) {
		// WebDriver driver=GenericFunctions.createInstanceOfRequiredBrowser("chrome");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// after implicit wait, driver will get default time as define in implicit wait,
		// 0-30
		driver.get("https://online.actitime.com/uts/login.do");

		WebElement userNameInputField = driver.findElement(By.id("username"));
		System.out.println("Username input field visibility status? " + userNameInputField.isDisplayed());
		System.out.println("Username input field editable status? " + userNameInputField.isEnabled());
		String defaultValueOfUserNameInputField = userNameInputField.getAttribute("placeholder");
		System.out.println("User name input field value: " + defaultValueOfUserNameInputField);

		WebElement keepMeLoggedInCheckBox = driver.findElement(By.id("keepLoggedInCheckBox"));
		System.out.println("keepMeLoggedInCheckBox visibility status: " + keepMeLoggedInCheckBox.isDisplayed());
		System.out.println("keepMeLoggedInCheckBox selectable status: " + keepMeLoggedInCheckBox.isEnabled());
		System.out.println("keepMeLoggedInCheckBox default selection status: " + keepMeLoggedInCheckBox.isSelected());
		keepMeLoggedInCheckBox.click();
		System.out.println("after selection, keepMeLoggedInCheckBox status: " + keepMeLoggedInCheckBox.isSelected());

		WebElement loginBtn = driver.findElement(By.id("loginButton"));
		System.out.println("loginBtn visibility status? " + userNameInputField.isDisplayed());
		System.out.println("loginBtn enable or not? " + userNameInputField.isEnabled());
		System.out.println("Login button name is: " + loginBtn.getText());
	}
}
/**
 * 
 * username display or not editable or not default value/placeholder
 * 
 * Checkbox: display or not clickable/functional or not by default select or not
 * select and check now its selected or not
 * 
 * Button: display or not clickable/functional or not button name button color
 * 
 * error: clickable/functional or not color text
 * 
 * Position:
 */