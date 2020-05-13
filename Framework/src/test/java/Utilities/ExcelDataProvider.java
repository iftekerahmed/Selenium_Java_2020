package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider()   {
//		//File srs = new File("./TestData/Data.xlsx");
//		File srs = new File("C:\\Users\\Ifte\\Desktop\\practiseExcel.xlsx");
//		FileInputStream fis = new FileInputStream(srs);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
			File srs = new File("C:\\Users\\Ifte\\Desktop\\practiseExcel.xlsx");
		
		FileInputStream fil;
		try {
			fil = new FileInputStream(srs);
			XSSFWorkbook wb = new XSSFWorkbook(fil);
			
		} catch (Exception e) {
		System.out.println(e.getMessage());		}
		

	}

	public String getStringData(int sheetIndex, int row, int columns) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(columns).getStringCellValue();
	}

	public String getStringData(String sheetName, int row, int columns) {
		return wb.getSheet(sheetName).getRow(row).getCell(columns).getStringCellValue();
	}

	public double getNumericData(String sheetName, int row, int columns) {
		return wb.getSheet(sheetName).getRow(row).getCell(columns).getNumericCellValue();

	}
}
