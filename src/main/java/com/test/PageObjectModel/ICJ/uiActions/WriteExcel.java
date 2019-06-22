package com.test.PageObjectModel.ICJ.uiActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {

	
		
		
	  	public static void main(String args[]) throws EncryptedDocumentException, InvalidFormatException, IOException 
		{
	  		String path = "C:\\Users\\nawkumar\\workspace\\ICJ\\TestData\\kiosk_removal.xlsx";
		    String sheetName ="Remove";
		    XSSFWorkbook workbook = null;
		    //Cell cell = null;
		    XSSFSheet sheet=null;
		  	Row row =null;
			
		  	
		  	    File src=new File(path);
				FileInputStream fis=new FileInputStream(src);
				workbook =new XSSFWorkbook(fis);
				sheet=workbook.getSheet(sheetName);
				row=sheet.getRow(1);
				row.createCell(7).setCellValue("Pass");
				FileOutputStream fileOut = new FileOutputStream(src);
				workbook.write(fileOut);
				fileOut.close();
				workbook.close();
		
			
		}
	

}
