/**
 * 
 */
package com.test.PageObjectModel.ICJ.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author nawkumar
 *
 */

public class ExcelReader {
	 String path ="C:\\Users\\nawkumar\\workspace\\ICJ\\TestData\\Kiosk_locations_CA.xlsx";
	 String sheetName ="Drscholls Store     ";

	/*String path = "C:\\Users\\nawkumar\\workspace\\ICJ\\TestData\\kiosk_removal.xlsx";
	String sheetName = "Remove";*/
	Workbook workbook = null;
	public Cell cell = null;

	Sheet sheet = null;
	Row row = null;

	// @DataProvider(name ="StoreList")
	public Object[][] readExcel() throws Exception {
		File file = new File(path);
		FileInputStream ExcelFileInput = new FileInputStream(file);
		Object[][] excelObjectArray = null;

		workbook = new XSSFWorkbook(ExcelFileInput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		excelObjectArray = new Object[rowcount][colcount];
		String cellValue = "";
		int k = 0;
		for (int r = 1; r <= rowcount; r++, k++) {
			row = sheet.getRow(r);
			int l = 0;
			for (int c = 0; c < colcount; c++, l++) {
				if (row.getCell(c) != null) {
					cell = row.getCell(c);
					if (cell.getCellTypeEnum() == CellType.STRING) {
						cellValue = cell.getStringCellValue();
						excelObjectArray[k][l] = cellValue;

					} else if (cell.getCellTypeEnum() == CellType.NUMERIC
							|| cell.getCellTypeEnum() == CellType.FORMULA) {
						cellValue = String.valueOf(cell.getNumericCellValue());
						excelObjectArray[k][l] = cellValue;

					}
				} else {
					cellValue = "";
					excelObjectArray[k][l] = cellValue;
				}

			}
		}

		return excelObjectArray;
	}

	public void writeExcel(int r, int col, String status) throws IOException {
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(r);
		row.createCell(col).setCellValue(status);
		FileOutputStream fileOut = new FileOutputStream(src);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();

	}

}
