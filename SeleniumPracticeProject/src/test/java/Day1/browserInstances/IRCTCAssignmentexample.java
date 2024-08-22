package Day1.browserInstances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCAssignmentexample {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		// Launch the web browser
		WebDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://www.irctc.com");

		// home page title
		String actualTitle = driver.getTitle();
		String expectedTitle = "IRCTC Next Generation eTicketing System"; // Update this with the expected title

		// Verify actual title with the expected title
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title verification passed. Actual Title: " + actualTitle);
		} else {
			System.out.println("Title verification failed. Actual Title: " + actualTitle);
		}

		// Print home page title
		System.out.println("Home Page Title: " + actualTitle);

		String PageSource = driver.getPageSource();
		int pageSourceLength = PageSource.length();
		System.out.println("PageSource Length; " + pageSourceLength);

		// Close the browser
		driver.quit();
	}
}
