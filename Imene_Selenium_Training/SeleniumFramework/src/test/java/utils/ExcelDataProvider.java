package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	@Test(dataProvider="test1Data")
	public void test1(String students, double grade) {
		System.out.print(students+" | "+grade);


	}

	@DataProvider(name="test1Data")
	public void getData() {
		String excelPath = "C:\\Users\\mabde\\Imene_Selenium_Training\\SeleniumFramework\\src\\main\\resources\\BookImene.xlsx";
		testData(excelPath,"sheet1");		
	}

	public void testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();



		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				if (j==0) {
					String cellData = excel.getCellData(i, j);
					System.out.print(cellData+" | ");	
				}
				else {
					double cellData = excel.getCellDataNumber(i, j);
					System.out.println(cellData+" | ");	


				}

			}

		}


	}
}
