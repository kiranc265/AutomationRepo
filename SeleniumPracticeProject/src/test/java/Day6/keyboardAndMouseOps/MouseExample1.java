package Day6.keyboardAndMouseOps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import reusableComponent.GenericFunctions;

public class MouseExample1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=GenericFunctions.createInstanceOfRequiredBrowser("chrome");
		
		driver.get("https://online.actitime.com/uts/login.do");
		//create an instance of actions class and pass driver instance to its constructor
		Actions action=new Actions(driver);
		
		//type user name
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("admin01");
		//using double click to select value available in username input field
		action.moveToElement(username).doubleClick().build().perform();
		//copy the value present in username input field
		username.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		
														
		//type password and press enter button
		driver.findElement(By.name("pwd")).sendKeys(Keys.chord(Keys.CONTROL,"v"),
													Keys.ENTER);
	}
}
