package Day4.multipleElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusableComponent.GenericFunctions;

public class Example1 {

	public static void main(String[] args) {
		WebDriver driver = GenericFunctions.createInstanceOfRequiredBrowser("chrome");

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//identify number links present in page
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Link count: "+links.size());
		
		for(int i=0;i<links.size();i++) {
			WebElement element=links.get(i);
			String linkUrl=element.getAttribute("href");
			System.out.println("Link "+i+" "+linkUrl);
		}

	}

}
