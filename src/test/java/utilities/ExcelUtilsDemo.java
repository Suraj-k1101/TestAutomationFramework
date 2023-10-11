package utilities;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		ExcelUtils eu = new ExcelUtils(projectPath+"\\src\\test\\resources\\testData\\exceldata.xlsx", "sheet1");
        
		eu.getRowCount();
		eu.getCellStringData(1, 0);
		eu.getCellNumericData(1, 1);
	}

}
