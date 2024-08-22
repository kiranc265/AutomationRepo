package Day1.browserInstances;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
	public class AssignmnetexampleFacebook {	
	    public static void main(String[] args) {
	    	 WebDriverManager.chromedriver().setup();
	        // Launch the web browser
	        WebDriver driver = new ChromeDriver();
	        // Open the URL 
	        driver.get("https://www.facebook.com");
	        //  home page title
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Facebook - log in or sign up";  
	        // Verify actual title  with the expected title
	        if (actualTitle.equals(expectedTitle)) {
	            System.out.println("Title verification passed. Actual Title: " + actualTitle);
	        } else {
	            System.out.println("Title verification failed. Actual Title: " + actualTitle);
	        }
	        // Print home page title on the console
	        System.out.println("Home Page Title: " + actualTitle);
	        // Close the browser
	        driver.close();
	    }
}