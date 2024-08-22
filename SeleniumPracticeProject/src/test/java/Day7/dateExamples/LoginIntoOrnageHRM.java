package Day7.dateExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reusableComponent.SeleniumUtility;
public class LoginIntoOrnageHRM  {

	public static void main(String[] args) {
		
		SeleniumUtility ref=new SeleniumUtility();
		
		WebDriver driver=ref.setUp("chrome", "https://demowebshop.tricentis.com/login");
		
		//Identify email input field & perform required action i.e type email id
		//driver.findElement(By.id("Email")).sendKeys("tester01@vomoto.com");
		
		ref.typeInput(driver.findElement(By.id("Email")), "tester01@vomoto.com");
		
		//identify password input field & perform required action i.e type password
		//driver.findElement(By.name("Password")).sendKeys("Abc@12345");
		
		ref.typeInput(driver.findElement(By.name("Password")), "Abc@12345");
		
		//identify login button & perform required action i.e click
		//driver.findElement(By.className("login-button")).click();
		
		ref.clickOnElement(driver.findElement(By.className("login-button")));
		
		String expectedUrlContent="login";
		String currenUrl=ref.getCurrentUrlOfApplication();
		System.out.println("Home page validation status: "+(!currenUrl.contains(expectedUrlContent)));
	}
}
/*
open chrome browser
enter application url as https://demowebshop.tricentis.com/login
enter emailid as tester01@vomoto.com
enter password as Abc@12345
click on login button
validation home page
*/