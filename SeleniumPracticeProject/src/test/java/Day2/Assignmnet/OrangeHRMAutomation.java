package Day2.Assignmnet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMAutomation {
    public static void main(String[] args) {
    	
    	WebDriverManager.chromedriver().setup();

        // Launch the web browser
        WebDriver driver = new ChromeDriver();

        // Open the URL
        driver.get("https://opensource-demo.orangehrmlive.com/"); // URL for the OrangeHRM demo site

        // Enter username as Admin
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.clear();
        usernameField.sendKeys("Admin");

        // Enter password as admin123
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.clear();
        passwordField.sendKeys("admin123");

        // Click on login button
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        // Validate home page with title
        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";  // Adjust this as per the actual title after login
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title validation passed. Actual Title: " + actualTitle);
        } else {
            System.out.println("Title validation failed. Actual Title: " + actualTitle);
        }

        // Validate home page with URL
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";  // Adjust this as per the actual URL after login
        if (actualURL.equals(expectedURL)) {
            System.out.println("URL validation passed. Actual URL: " + actualURL);
        } else {
            System.out.println("URL validation failed. Actual URL: " + actualURL);
        }

        // Logout from the application
        WebElement welcomeMenu = driver.findElement(By.id("welcome"));
        welcomeMenu.click();
        try {
            Thread.sleep(2000); // Waiting for the logout option to be visible
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();

        // Close the browser
        driver.quit();
    }
}