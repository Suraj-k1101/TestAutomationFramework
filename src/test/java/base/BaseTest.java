package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;        //Reference of the driver or WebDriver reference
	public static Properties p = new Properties();  //create a object of Properties class for( config.prperties file)
	public static Properties loc = new Properties(); //create a object of Properties class for( locators.prperties file)
	public static FileReader fr;
	public static FileReader fr1;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		if(driver==null)
		{  // System.out.println("The Path is:- "+ System.getProperty("user.dir"));  //use this for path and do not hard code filePath in The FRAMEWORK
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
			//for reading the ( config.properties file)
			
			fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\locators.properties");
			//for reading the ( locators.properties file)
			
			p.load(fr);   //here we loading config.prperties file
			
			loc.load(fr1); ////here we loading locators.prperties file
				
		}
		
		if(p.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
			driver.get(p.getProperty("testurl"));  //instead of hard coding url we writing [p.getProperty("testurl")] which is present in properties file
				
		}
		else if(p.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(p.getProperty("testurl"));  
				
		}
		else if(p.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(p.getProperty("testurl"));  
			
		}
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		System.out.println("Teardown Successfull");
		
	}
	
}
