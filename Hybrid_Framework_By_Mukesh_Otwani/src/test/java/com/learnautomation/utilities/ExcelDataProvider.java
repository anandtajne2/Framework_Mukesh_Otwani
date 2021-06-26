package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook workbook;

	public ExcelDataProvider() {
		File file = new File(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			System.out.println("unable to read excel file" + e.getMessage());
		}
	}

	public String getStringData(int sheetIndex, int row, int column) {
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringData(String sheetName, int row, int column) {
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public double getNumericData(String sheetName, int row, int column) {
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}