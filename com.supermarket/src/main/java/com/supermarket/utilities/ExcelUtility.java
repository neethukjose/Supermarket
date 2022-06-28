package com.supermarket.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	XSSFSheet sheet;
	XSSFWorkbook workbook;
	XSSFRow row;
	XSSFCell cell;

	public void setExcelFile(String workBookName, String sheetName) {
		try {

			String path = System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\" + workBookName
					+ ".xlsx";
			File src = new File(path);
			FileInputStream fi = new FileInputStream(src);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCellData(int rowNum, int columnNum) {
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		switch (cell.getCellType()) {
		case STRING: {
			String x;
			x = cell.getStringCellValue();
			return x;
		}
		case NUMERIC: {
			long d = (long) cell.getNumericCellValue();
			return String.valueOf(d);
		}

		default:
			return null;

		}
	}

	public Object[][] getMultidimentionaldata(int row, int column) {
		Object data[][] = new Object[row-1][column];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < column; j++) {
				data[i-1][j] = getCellData(i, j);
			}
		}

		return data;
	}
	
	

	public List<String> getDatainList() {
		List<String> list = new ArrayList<String>();
		//System.out.println("column num"+row.getLastCellNum());
		for (int i = 0; i < 14; i++) {
			list.add(getCellData(0, i));
		}
		return list;
	}
}
