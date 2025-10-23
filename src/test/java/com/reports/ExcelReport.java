                                                                                                                                                                                                             package com.reports;
 
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReport {
	private static Workbook workbook=new XSSFWorkbook();
	private static Sheet sheet=workbook.createSheet("Test Results");
	private static int rowCount = 0;
	
	//create header row once
	static {
		Row header=sheet.createRow(rowCount++);
		header.createCell(0).setCellValue("Test Name");
		header.createCell(1).setCellValue("Status");
		header.createCell(2).setCellValue("Error Message");
		header.createCell(3).setCellValue("Execution Time");
		header.createCell(4).setCellValue("ScreenShotFile");
		
	}
	public static void saveReport() {
		try(FileOutputStream outStream=new FileOutputStream(".//testReport//TestNG_results.xlsx")){
			workbook.write(outStream);
			workbook.close();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	public static void logResult(String testName, String status, String errorMsg, long duration, String screenshotPath) {
		Row row = sheet.createRow(rowCount++);
		row.createCell(0).setCellValue(testName);
		row.createCell(1).setCellValue(status);
		row.createCell(2).setCellValue(errorMsg != null ? errorMsg: "No Error");
		row.createCell(3).setCellValue(duration +"ms");
		row.createCell(4).setCellValue(screenshotPath);
		
		//add full path hyperlink
		if(screenshotPath != null) {
			Cell cell = row.createCell(4);
			cell.setCellValue(screenshotPath);
		}
	}
}
 