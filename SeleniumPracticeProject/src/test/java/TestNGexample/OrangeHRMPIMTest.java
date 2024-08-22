package TestNGexample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMPIMTest {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        // Set up the WebDriver (ChromeDriver)
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @BeforeMethod
    public void loginAndNavigateToPIM() {
        // Login to the OrangeHRM system
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

        // Navigate to PIM module
        driver.findElement(By.xpath("//b[text()='PIM']")).click();
    }

    @Test(priority = 1)
    public void createPIM() {
        // Click on Add Employee
        driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
        
        // Fill in the employee details
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        
        // Verify employee was created
        WebElement employeeName = driver.findElement(By.xpath("//h1[text()='John Doe']"));
        Assert.assertTrue(employeeName.getText().contains("John Doe"), "Employee creation failed!");
    }

    @Test(priority = 2)
    public void updatePIM() {
        // Search for the employee by name
        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        
        // Click on the employee name to edit
        driver.findElement(By.xpath("//a[text()='John Doe']")).click();
        
        // Update the employee's middle name
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        driver.findElement(By.xpath("//input[@id='personal_txtEmpMiddleName']")).sendKeys("Michael");
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        
        // Verify the update was successful
        WebElement middleName = driver.findElement(By.xpath("//input[@id='personal_txtEmpMiddleName']"));
        Assert.assertEquals(middleName.getAttribute("value"), "Michael", "Employee update failed!");
    }

    @Test(priority = 3)
    public void deletePIM() {
        // Search for the employee by name
        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("John Michael Doe");
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        
        // Select the employee checkbox and delete
        driver.findElement(By.xpath("//input[@name='chkSelectRow[]']")).click();
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
        
        // Verify the employee was deleted
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("John Michael Doe");
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        
        WebElement noRecordsFound = driver.findElement(By.xpath("//td[text()='No Records Found']"));
        Assert.assertTrue(noRecordsFound.isDisplayed(), "Employee deletion failed!");
    }

    @AfterMethod
    public void logout() {
        
        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
    }

    @AfterTest
    public void closeBrowser() {
        
        driver.quit();
    }
}