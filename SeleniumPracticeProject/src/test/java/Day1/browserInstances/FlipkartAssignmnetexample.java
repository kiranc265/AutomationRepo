package Day1.browserInstances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class FlipkartAssignmnetexample {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		// Launch the web browser
		WebDriver driver = new ChromeDriver();

		// Open the URL 
		driver.get("https://www.flipkart.com");

		//  home page title
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";

		// Verify actual title with the expected title
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title verification passed. Actual Title: " + actualTitle);
		} else {
			System.out.println("Title verification failed. Actual Title: " + actualTitle);
		}

		// Print home page title 
		System.out.println("Home Page Title: " + actualTitle);

		String pageSource = driver.getPageSource();
		int pageSourceLength = pageSource.length();

		// Print Page Source length on the console
		System.out.println("Page Source Length: " + pageSourceLength);

		// Close the browser
		driver.quit();
	}
}
