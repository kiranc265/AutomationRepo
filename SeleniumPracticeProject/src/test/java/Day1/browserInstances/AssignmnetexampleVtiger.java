package Day1.browserInstances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmnetexampleVtiger {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		// Launch browser
		WebDriver Driver = new ChromeDriver();

		// Open url- https://demo.vtiger.com/
		Driver.get("https://demo.vtiger.com/");

		// Title name and Title length
		String title = Driver.getTitle();
		int titleLength = title.length();

		System.out.println("Page Title: " + title);
		System.out.println("Title length: " + titleLength);

		// Get Page URL and verify if it is the correct page opened
		String url = Driver.getCurrentUrl();
		if (url.equals("https://demo.vtiger.com/")) {
			System.out.println("Correct URL opened: " + url);
		} else {
			System.out.println("Incorrect URL opened: " + url);
		}

		// Get Page Source (HTML Source code) and Page Source length
		String pageSource = Driver.getPageSource();
		int pageSourceLength = pageSource.length();

		// Print Page Source length on the Eclipse Console
		System.out.println("Page Source length: " + pageSourceLength);

		// Close the Browser
		Driver.close();
	}
}