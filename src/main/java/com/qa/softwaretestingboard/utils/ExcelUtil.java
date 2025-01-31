package com.qa.softwaretestingboard.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	//private static final String REGISTER_TEST_DATA_SHEET = ".src\\test\\resources\\testdata/registertestdata.xlsx";
		private static final String REGISTER_TEST_DATA_SHEET = "src/test/resources/testdata/registertestdata.xlsx";
		private static Workbook workBook;
		private static Sheet sheet;

		public static Object[][] getExcelTestData(String sheetName) throws InvalidFormatException {
			System.out.println("Reading data from sheet: " + sheetName);
			Object data[][] = null;

			try {
				// Open the Excel file
				FileInputStream ip = new FileInputStream(REGISTER_TEST_DATA_SHEET);
				workBook = WorkbookFactory.create(ip); 
				//method creates a Workbook object from the file input stream.
				//This method from Apache POI dynamically handles both older Excel formats (.xls) 
				//and newer formats (.xlsx). It creates a Workbook instance for us to work with."
				
				// Check if the workbook is loaded
				if (workBook == null) {
					throw new RuntimeException("Failed to load Excel workbook.");
				}

				// Check if the sheet is present
				sheet = workBook.getSheet(sheetName);
				if (sheet == null) {
					throw new RuntimeException("Sheet with name '" + sheetName + "' not found.");
				}

				// Initialize the data array
				
				//sheet.getLastRowNum() gives the total number of rows
				//sheet.getRow(0).getLastCellNum() gives the number of columns in the first row.
				data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				

				// Loop through rows and columns
				for (int i = 0; i < sheet.getLastRowNum(); i++) {
					for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
						data[i][j] = sheet.getRow(i + 1).getCell(j).toString(); 
						System.out.println("Reading: " + data[i][j]); // Debugging line to check data
					}
				}

			} catch (FileNotFoundException e) {
				System.out.println("File not found: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("IO Exception: " + e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("NullPointerException: " + e.getMessage());
			}

			if (data != null) {
				System.out.println("Data read successfully from Excel sheet.");
			} else {
				System.out.println("Failed to read data from Excel sheet.");
			}

			return data;
	
	
		}
	  
	  
}


