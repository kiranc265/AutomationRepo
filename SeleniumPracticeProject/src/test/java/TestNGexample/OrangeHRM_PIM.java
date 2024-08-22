package TestNGexample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import reusableComponent.SeleniumUtility;

public class OrangeHRM_PIM extends SeleniumUtility {

	public void OpenChrome() {

		// Set up the WebDriver (ChromeDriver)

	
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// Login to the OrangeHRM system

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		driver.findElement(By.id("btnLogin")).click();
	}

	@Test(priority = 1)
	public void testPIM_Creation() {
		// PIM module

		driver.findElement(By.className("oxd-main-menu-item active")).click();

		// Click Add Employee

		driver.findElement(By.className("oxd-topbar-body-nav-tab-item")).click();

		// Employee details

		driver.findElement(By.id("firstName")).sendKeys("QA");

		driver.findElement(By.id("lastName")).sendKeys("Tester");

//using double click to select value available in username input field
		WebElement employeeid = driver.findElement(By.className("oxd-input--active"));
		action.moveToElement(employeeid).doubleClick().build().perform();
		employeeid.sendKeys("10351");

		driver.findElement(By.className("oxd-button")).click();

		// search employee

		WebElement employeeName = driver.findElement(By.className("employee-image"));

		Assert.assertTrue(employeeName.getText().contains("QA Tester"));
	}

	@Test(priority = 2)

	public void testPIM_Update() {

		// updateEmployee
		driver.findElement(By.xpath(" //a[@class='oxd-main-menu-item active']")).click();

		driver.findElement(By.xpath("//a[text()='Employee List']")).click();

		// Search for the employee id

		driver.findElement(By.xpath(" //label[text()='Employee Id']"));

		//action.moveToElement(employeeid).doubleClick().build().perform();
		//action.moveToElement(employeeid).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
		//employeeid.sendKeys("10351");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Click on the employee name to edit

		driver.findElement(By.xpath("//a[text()='QA Tester']")).click();

		// Update the employee details

		driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("Automation");

		driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]")).click();

		// Verify employee was updated

		WebElement middleName = driver.findElement(By.xpath("//input[@placeholder='Middle Name']"));

		Assert.assertEquals(middleName.getAttribute("value"), "Automation");

	}

	@Test(priority = 3)

	public void testPIM_Delete() {

		// Navigate to Employee List

		driver.findElement(By.xpath(" //a[@class='oxd-main-menu-item active']")).click();

		driver.findElement(By.xpath("//a[text()='Employee List']")).click();

		// Search for the employee id

		driver.findElement(By.xpath(" //label[text()='Employee Id']"));

		//action.moveToElement(employeeid).doubleClick().build().perform();
		//employeeid.sendKeys("10351");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Select the employee checkbox and delete

		driver.findElement(By.xpath("//input[@name='chkSelectRow[]']")).click();

		driver.findElement(By.xpath("//input[@id='btnDelete']")).click();

		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();

		// Verify employee was deleted

		driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("John Michael Doe");

		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

		WebElement noRecordsFound = driver.findElement(By.xpath("//td[text()='No Records Found']"));

		Assert.assertTrue(noRecordsFound.isDisplayed());
	}

}

/*
 * Validation: should be done using Assert class
 * 
 * Assert.assertEquals(arg1, arg2); Assert.assertEquals(arg1, arg2, msg);
 * 
 * Assert.assertTrue(condition); Assert.assertTrue(condition,msg);
 * 
 * Assert.assertFalse(condition); Assert.assertFalse(condition,msg);
 */
