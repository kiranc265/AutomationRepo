package TestNGexample;

import org.testng.annotations.Test;


public class Example2 {
	
@Test(priority=1)
	
public void testCaseOrangeHrm() {
	
System.out.println("Hello OrangeHrm");

	}
	
@Test
	
public void testCaseActitime() {
		
System.out.println("Hello Actitime");
		
tc1();
	
}
	
	
public void tc1() {
		
System.out.println("TC1");
	
}
}

/*
 * TestNG method should public, nonstatic  and return type as void
 * 
 
* TestNG file can have more then one @Test method in such cases it will be
 
* executed alphabetically
 * 
 
* Tests run count depends on 
@test method
 
*/