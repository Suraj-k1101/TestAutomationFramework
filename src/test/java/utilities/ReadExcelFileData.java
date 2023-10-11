package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcelFileData {

	
	@DataProvider(name = "bvtdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException    //(Method m)- it will reflect the method you are calling
	{   
		String excelSheetName = m.getName(); //getName()- will do here from whichever class this utility will be call it will get the name of the method 
		//create object of File class:-
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testdata.xlsx");
		
		//create object of FileInputStream class:-
		FileInputStream fis = new FileInputStream(file);
		
		//now we need to read the Workbook:-
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		
		Row rowCells = sheetName.getRow(0);   //for column/cell count //this logic basically will capture the specific row
		int totalColumn = rowCells.getLastCellNum();
		System.out.println(totalColumn);
		
		
	//now we need to format the data
		//create object of DataFormatter:-
		DataFormatter df = new DataFormatter();
		
		String testData[][] = new String[totalRows][totalColumn];
		//now we need to read data:-
		for(int i=1;i<=totalRows;i++)    //this for loop will iterate through rows
		{
			
			for(int j=0;j<totalColumn;j++)        //this for loop will iterate through rows
			{
				
				testData[i-1][j] = df.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
				
			}
			
		}
		
		return testData;
	}

}
