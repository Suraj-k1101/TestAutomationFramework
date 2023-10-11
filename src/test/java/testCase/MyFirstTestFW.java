package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyFirstTestFW extends BaseTest {

@Test(dataProvider = "testdata")
public static void LoginTest(String username, String password) throws InterruptedException
{
	

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.findElement(By.xpath(loc.getProperty("sign_in_link"))).click();  //locators in properties file 
	driver.findElement(By.cssSelector(loc.getProperty("email_field"))).sendKeys(username);
	driver.findElement(By.cssSelector(loc.getProperty("next_button"))).click();
	
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(loc.getProperty("password_field"))).sendKeys(password);
	driver.findElement(By.cssSelector(loc.getProperty("login_next_button"))).click(); 
	
/*	driver.findElement(By.xpath(loc.getProperty("user_profile_button"))).click();
    driver.findElement(By.xpath(loc.getProperty("signout_button"))).click(); */
	
	//we are just using key here for locators in the xpath or css rather than directly hard coded original locators
    
}

   @DataProvider(name = "testdata")
   public Object[][] createData()
   {
	   
	   return new Object[][]
			   {
		         {"surajromankamble@gmail.com","suraj@kamble"},
		         {"surajromakamble@gmail.com","sk1234"},
		         {"surajromannkamble@gmail.com","suraj@ka"},
		         {"surajkamble@gmail.com","suraj@kamble"},
		         
		   
			   };  
			   
	   
   }

	
}
