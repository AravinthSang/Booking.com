package utilities;

import org.testng.annotations.DataProvider;


public class DataProviders {

	// Method read and returns the credentials from the excel
	@DataProvider(name="credentials")
	public String[][] getCredentialsFromExcel() {
		
		String filePath="./testData/TestData_AccRegistraton_booking.com.xlsx";
		String sheetName="Sheet1";
		ExcelUtility excel = new ExcelUtility(filePath, sheetName);
		String[][]data=new String[excel.rowCount-1][excel.getColCount(sheetName, 0)];
		
		for (int i = 1; i < excel.rowCount; i++) {
			for(int j=0;j<excel.getColCount(sheetName, i);j++) {
				data[i-1][j]=excel.getCellFromExcel(i, j);
			}
		}
		return data;
	}
}
