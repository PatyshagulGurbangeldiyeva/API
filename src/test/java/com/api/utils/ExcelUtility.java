package com.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static Workbook book;
	private static Sheet sheet;

	private static void openExcel(String filePath) {
		try {
			FileInputStream fileIS = new FileInputStream(filePath);
			book = new XSSFWorkbook(fileIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	private static int colsCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}

	private static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	// return a 2d object array of data
	public static Object[][] excelIntoArray(String filePath, String sheetName) {
		openExcel(filePath);
		loadSheet(sheetName);

		int rows = rowCount();
		int cols = colsCount(0);

		Object[][] data = new Object[rows - 1][cols];

		// iterating rows
		for (int i = 1; i < rows; i++) {
			// iterating cols
			for (int j = 0; j < cols; j++) {
				//storing values into 2D array 
				data[i - 1][j] = cellData(i, j);
			}
		}

		return data;
	}

	//HW Create a method that will return a List of Maps

	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName){
		openExcel(filePath);
		loadSheet(sheetName);
		
		List <Map<String,String>> list=new ArrayList<>();
		Map<String,String>excelMap=new LinkedHashMap<>();
		for (int r=1;r<rowCount(); r++) {
			excelMap=new LinkedHashMap<>();
			
			for (int c=0; c<colsCount(r);c++) {
				excelMap.put(cellData(0, c), cellData(r,c));
				
			}
			list.add(excelMap);
		}
		return list;
	}
	
}
