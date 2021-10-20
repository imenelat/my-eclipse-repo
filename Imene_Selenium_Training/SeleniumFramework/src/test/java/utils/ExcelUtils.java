package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception exp) {
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();

		}
	}
	//get row count
	public static int getRowCount() {
		int rowCount=0;
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows"+rowCount);
		return rowCount;
	}

	//get column count
	public static int getColCount() {
		int colCount=0;
		 colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No of columns:"+colCount);
		return colCount;
	} 


	//get cell data string
	public static String getCellData(int rownum, int colnum) {
		String cellData = null;
		cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		//System.out.println(cellData);
		return cellData;

	}

	//get cell data number

	public static double getCellDataNumber(int rownum, int colnum) {

		double cellData = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		//System.out.println(cellData);
		return cellData;
	}
}