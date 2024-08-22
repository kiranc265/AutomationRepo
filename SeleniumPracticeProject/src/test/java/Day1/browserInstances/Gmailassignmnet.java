package Day1.browserInstances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmailassignmnet {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.gmail.com");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Gmail";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title verify : " + actualTitle);
		} else {
			System.out.println("Title not verify : " + actualTitle);
		}

		System.out.println("Home Page Title: " + actualTitle);

		String pageSource = driver.getPageSource();
		int pageSourceLength = pageSource.length();

		System.out.println("Page Source Length: " + pageSourceLength);

		driver.quit();
	}
}