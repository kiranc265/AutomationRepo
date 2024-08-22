package Day2.ObjectIdentification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import reusableComponent.GenericFunctions;

public class LoginDemoWebShop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = GenericFunctions.createInstanceOfRequiredBrowser("chrome");

		driver.get("https://demowebshop.tricentis.com/login");

		// Identify email input field & perform required action i.e type email id
		driver.findElement(By.id("Email")).sendKeys("tester01@vomoto.com");

		// identify password input field & perform required action i.e type password
		driver.findElement(By.name("Password")).sendKeys("Abc@12345");

		// identify login button & perform required action i.e click
		driver.findElement(By.className("login-button")).click();

		String expectedUrlContent = "login";
		String currenUrl = driver.getCurrentUrl();
		System.out.println("Home page validation status: " + (!currenUrl.contains(expectedUrlContent)));

	}
}