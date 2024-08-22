package TestNGexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusableComponent.SeleniumUtility;

public class Assignment extends SeleniumUtility {

	@BeforeTest
	public void openBrowser()  {
		
		WebDriver driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com");
		
	}
	
	@BeforeMethod
	public void loginAndNavigateToPimPage() {
		typeInput(driver.findElement(By.xpath("//input[@placeholder='Username']")),"Admin");
		typeInput(driver.findElement(By.xpath("//input[@placeholder='Password']")),"admin01");
		clickOnElement(driver.findElement(By.cssSelector("button[type='submit']")));
		
		
	}
	
	@Test(priority=1)
	public void createPim() {
		
	}
	
	@Test(priority=2, dependsOnMethods = "createPim")
	public void updatePim() {
		
	}
	
	@Test(priority=3, dependsOnMethods = "createPim")
	public void deletePim() {
		
	}
	
	
	@AfterMethod
	public void logout() {
		
	}
	@AfterTest
	public void closeBrowser() {
		
	}
}
