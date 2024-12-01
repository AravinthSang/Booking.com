package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	public int rowCount;
	
	
	public ExcelUtility(String filePath,String sheetName){
		try {
			file= new FileInputStream(filePath);
			workbook= new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			rowCount=sheet.getLastRowNum();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getColCount(String sheetName,int row){
		return sheet.getRow(row).getLastCellNum();
		
	}
	public String getCellFromExcel(int rowNo, int cellNo) {
		
		try {
			row=sheet.getRow(rowNo);
			if(row!=null) {
				cell=row.getCell(cellNo);
				file.close();
				if(cell!=null)
					
					return cell.toString();
			}
			return "";
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
			
		}
		
		
	}

}
