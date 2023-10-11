package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadExcelFileData;

public class MySecondTestUsingExcelDataProvider extends BaseTest {
	
    @Test(dataProviderClass = ReadExcelFileData.class, dataProvider = "bvtdata")
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
		
	
	}
}
