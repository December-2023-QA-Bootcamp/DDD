package com.cms.gov.ddd.unit;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import dto.Student;
import util.ExcelUtil;

public class ExcelTest {

	@Test(enabled = false)
	public void testWorkbook() throws EncryptedDocumentException, IOException {
		InputStream iStream = getClass().getClassLoader().getResourceAsStream("Players.xlsx");

		// File file = new File("src/test/resources/Players.xlsx");

		// Workbook can take file as well
		Workbook book = WorkbookFactory.create(iStream);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
		System.out.println(cell.getStringCellValue()); // Last Name
	}

	//@Test
	@Test
	public void testList() throws EncryptedDocumentException, IOException {
		File file = new File("src/test/resources/Players.xlsx");

		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(1);

		// int totalPhysicalCells = row.getPhysicalNumberOfCells();
		int lastCellNum = row.getLastCellNum();

		List<Object> rowData = new ArrayList<Object>();

		for (int i = 0; i < lastCellNum; i++) {
			Cell cell = row.getCell(i);

			if (cell != null) {
				if (cell.getCellType() == CellType.NUMERIC) {
					rowData.add((int) cell.getNumericCellValue());
				} else {
					rowData.add(cell.getStringCellValue());
				}
			} else {
				rowData.add(cell);
			}
		}

		System.out.println(rowData);

	}
	
	@Test
	public void testMapData() throws EncryptedDocumentException, IOException {
		File file = new File("src/test/resources/Players.xlsx");

		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Sheet1");
		
		int totalRows = sheet.getLastRowNum();
		System.out.println("Total rows : " + totalRows);
		
		List<Map<String, Object>> listData = new ArrayList<Map<String,Object>>();
		
		for(int i = 1; i <= totalRows; i++) {
			Row row = sheet.getRow(i);
			Map<String, Object> rowMap = new LinkedHashMap<String, Object>();
			
			for(int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				
				if(cell != null) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					Object value = null;
					
					if(cell.getCellType() == CellType.NUMERIC) {
						value = (int) cell.getNumericCellValue();
					}else if(cell.getCellType() == CellType.STRING) {
						value = cell.getStringCellValue();
					}else if(cell.getCellType() == CellType.BOOLEAN) {
						value = cell.getBooleanCellValue();
					}
					
					rowMap.put(key, value);
				}
			}
			
			listData.add(rowMap);
		}
		
		listData.forEach(System.out::println);
		
		System.err.println(listData.get(0).get("Last Name"));
	}
	
	@Test
	public void unitTestExcelUtil() {
		ExcelUtil excelUtil = new ExcelUtil("Players.xlsx", "Sheet1");
		
		// Map Data
		//excelUtil.getData();
		
		// Student Data
		List<Student> list = excelUtil.getStudents();
		list.forEach(e -> System.out.println(e.getLastname()));
	}
	
	@Test
	public void studetnNullAllowed() {
		Student student = new Student("Fa", null, 2, "June", 2002);
		System.err.println(student.getDob_date());
	}
}
