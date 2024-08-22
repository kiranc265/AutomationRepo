package Day3.sync;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class AmazonAutomation {
	public static void main(String[] args) {
		// Step 1: Launch browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Step 2: Open this URL - www.amazon.in
		driver.get("https://www.amazon.in");
		// Step 3: Maximize or set size of browser window
		driver.manage().window().maximize();
		// Step 4: Get the page title and print it
		String homePageTitle = driver.getTitle();
		System.out.println("Home Page Title: " + homePageTitle);
		// Menu links and their expected titles
		WebElement menuLink = driver.findElement(By.className("hm-icon"));
		menuLink.click();
		// Step 7: Navigate back to Home Page
		driver.navigate().back();
		// Step 8: Get Page title and verify it with expected value
		homePageTitle = driver.getTitle();
		System.out.println("Home Page Title after navigating back: " + homePageTitle);
		if (!homePageTitle.equals(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			System.out.println("Home page title does not match expected value");
		}
	}
	// 10: Close the browser
	// driver.quit();
}
