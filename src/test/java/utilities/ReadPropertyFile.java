package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
	//create an object of  FileReader class:-
		FileReader fr = new FileReader("C:\\Users\\ks\\eclipse-workspace\\TestAutomationFramework\\src\\test\\resources\\configFiles\\config.properties");
		//here we provide config.prperties file location in FileReader() Argument
		
	//create object of Properties class as well:-
		Properties p = new Properties();
		p.load(fr);
		
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("testurl"));
		
		

	}

}
