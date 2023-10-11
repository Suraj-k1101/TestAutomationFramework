package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName)
	{   try {
		
		wb = new XSSFWorkbook(excelPath);
		sheet = wb.getSheet(sheetName);
	}catch(Exception e) {
		e.printStackTrace();
		
	}
		
	}

	public static void main(String[] args) {

		getRowCount();
		getCellStringData(1,0);
		getCellNumericData(1,1);
		
		

	}

	public static void getRowCount() {
		try {

			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows : " + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

	public static void getCellStringData(int rowNum, int colNum) {
		try {
			
			String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);
		} catch (Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			}

		}
		

		public static void getCellNumericData(int rowNum, int colNum) {
			try {
				
				double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				System.out.println(cellData);
			} catch (Exception exp) {

				System.out.println(exp.getMessage());
				System.out.println(exp.getCause());
				exp.printStackTrace();

			}

	}

}
