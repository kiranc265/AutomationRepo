package TestNGexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusableComponent.SeleniumUtility;

public class ActitimeLogin extends SeleniumUtility{

	@Test
	public void testActitimeLogin() {
		WebDriver driver=setUp("chrome", "https://online.actitime.com/uts/login.do");
		typeInput(driver.findElement(By.id("username")),"admin01");
		typeInput(driver.findElement(By.name("pwd")),"admin01");
		clickOnElement(driver.findElement(By.id("loginButton")));
		
		String expectedTitle="actiTIME - Enter Time-Track";
		String actualTitle=getCurrentTitleOfApplication();
		System.out.println("Home page validation status? "+actualTitle.equals(expectedTitle));		
	}
	@Test
	public void testActitimeLogin2() {
		WebDriver driver=setUp("chrome", "https://online.actitime.com/uts/login.do");
		
		typeInput(driver.findElement(By.id("username")),"admin01");
		typeInput(driver.findElement(By.name("pwd")),"admin01");
		clickOnElement(driver.findElement(By.id("loginButton")));
		
		String expectedTitle="actiTIME - Enter Time-Track";
		String actualTitle=getCurrentTitleOfApplication();
		//System.out.println("Home page validation status? "+actualTitle.equals(expectedTitle));
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void testActitimeLogin3() {
		WebDriver driver=setUp("chrome", "https://online.actitime.com/uts/login.do");
		
		typeInput(driver.findElement(By.id("username")),"admin01");
		typeInput(driver.findElement(By.name("pwd")),"admin01");
		clickOnElement(driver.findElement(By.id("loginButton")));
		
		String expectedTitle="actiTIME - Enter Time-Track";
		String actualTitle=getCurrentTitleOfApplication();
		//System.out.println("Home page validation status? "+actualTitle.equals(expectedTitle));
		Assert.assertEquals(actualTitle, expectedTitle,"Either login failed or home page tile got changed");
	}
	
	@Test
	public void testActitimeLogin4() {
		WebDriver driver=setUp("chrome", "https://online.actitime.com/uts/login.do");
		
		WebElement checkbox=driver.findElement(By.id("keepLoggedInCheckBox"));
		boolean statusBeforeSelection=isCheckBoxSelected(checkbox);
		Assert.assertFalse(statusBeforeSelection);
		
		clickOnElement(checkbox);
		boolean statusAfterSelection=isCheckBoxSelected(checkbox);
		Assert.assertTrue(statusAfterSelection);
		
	}
	@Test
	public void testActitimeLogin5() {
		WebDriver driver=setUp("chrome", "https://online.actitime.com/uts/login.do");
		
		WebElement checkbox=driver.findElement(By.id("keepLoggedInCheckBox"));
		
		boolean statusBeforeSelection=isCheckBoxSelected(checkbox);
		Assert.assertTrue(statusBeforeSelection);
		
	}
}
/*
 * Validation: should be done using Assert class
 * 
 * 		Assert.assertEquals(arg1, arg2);
 * 		Assert.assertEquals(arg1, arg2, msg);
 * 
 * 		Assert.assertTrue(condition);
 * 		Assert.assertTrue(condition,msg);
 * 
 * 		Assert.assertFalse(condition);
 * 		Assert.assertFalse(condition,msg);
 */
