package test;

import utils.ExcelUtils;

public class ExcelTest {

	public static void main(String[] args) {
		String projectPath= System.getProperty("user.dir");
		ExcelUtils excel= new ExcelUtils(projectPath+"/src/main/resources/BookImene.xlsx","sheet1");
		
		excel.getRowCount();
		excel.getCellData(2, 0);
		excel.getCellDataNumber(2, 1);

}
}
