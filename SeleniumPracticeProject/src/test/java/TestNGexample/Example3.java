package TestNGexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import reusableComponent.GenericFunctions;
import reusableComponent.SeleniumUtility;

public class Example3 extends SeleniumUtility{

	@Test
	public void Login() {
		WebDriver driver=setUp("chrome", "https://www.amazon.in");
	
	
}
// 10: Close the browser
// driver.quit();

}
