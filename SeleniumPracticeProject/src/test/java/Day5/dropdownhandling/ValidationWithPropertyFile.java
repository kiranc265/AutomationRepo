package Day5.dropdownhandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusableComponent.GenericFunctions;

public class ValidationWithPropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData\\AppData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		WebDriver driver=GenericFunctions.createInstanceOfRequiredBrowser("chrome");
		//after implicit wait, driver will get default time as define in implicit wait, 0-30
		driver.get(prop.getProperty("appUrl"));
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));//0-30 sec		
		driver.findElement(By.name("pwd")).sendKeys(prop.getProperty("password"));//0-30 sec		
		driver.findElement(By.id("loginButton")).click();//0-30 sec
		String expectedTitle=prop.getProperty("expectedTitle");
		
		//explicit wait- WebDriverWait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));	
		//wait for title to be changed
		wait.until(ExpectedConditions.titleIs(expectedTitle));		
		
		String actualTitle=driver.getTitle();//we need explicit wait to wait for certain condition/element
		System.out.println("Actutal Title: "+actualTitle);
		boolean status=actualTitle.equals(expectedTitle);
		System.out.println("Is login validation successful? "+status);
		
		//wait till login button is clickable with in given time
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		driver.findElement(By.id("logoutLink")).click();
	}
}
/*
login in actitime and validate login is successful or not

validate with title:
	expected: actiTIME - Enter Time-Track

*/