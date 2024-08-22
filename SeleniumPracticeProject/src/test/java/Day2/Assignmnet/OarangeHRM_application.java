package Day2.Assignmnet;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class OarangeHRM_application {
	    public static void main(String[] args) {
	        
	    	WebDriverManager.chromedriver().setup();
	    	
	        // Launch the web browser
	        WebDriver driver = new ChromeDriver();

	        // Open the URL
	        driver.get("https://opensource-demo.orangehrmlive.com/"); // URL for the OrangeHRM demo site

	        
	      /*  driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("Admin");
	        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("admin123");
	        driver.findElement(By.xpath("//button[@type = 'submit']")).submit();
			*/
	     // Enter username as Admin
	        WebElement usernameField = driver.findElement(By.name("username"));
	        usernameField.clear();
	        usernameField.sendKeys("Admin");

	        // Enter password as admin123
	        WebElement passwordField = driver.findElement(By.name("password"));
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
	        String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";  
	        if (actualURL.equals(expectedURL)) {
	            System.out.println("URL validation passed : " + actualURL);
	        } else {
	            System.out.println("URL validation failed : " + actualURL);
	        }

	        // Logout from the application
	        
		    
	        
	          
	        // Close the browser
	        driver.quit();
	    }
	}