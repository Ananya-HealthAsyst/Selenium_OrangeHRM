package com.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginDDT {
	public FileInputStream fileInputStream;
	public FileOutputStream fileOutputStream;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	WebDriver driver;
	String path=".\\testData\\testdata.xlsx";
	//String pageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	
	
	
  @Test(dataProvider = "loginData")
  public void loginDDT(String userName, String passWord) {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passWord);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
//	  String currentURL=driver.getCurrentUrl();
//	  System.out.println(currentURL);
//	  if(currentURL.contentEquals(pageURL)) {
//		  System.out.println("Successful");
//  }
	  System.out.println(userName);
	  System.out.println(passWord);
  }

  @DataProvider(name = "loginData")
  String[][] getData() throws IOException {
	  fileInputStream = new FileInputStream(path);
	  workbook = new XSSFWorkbook(fileInputStream);
	  
	  sheet=workbook.getSheet("Sheet1");
	  int rowCount = sheet.getLastRowNum();
	  int colCount = sheet.getRow(0).getLastCellNum();
	  String loginData[][] = new String[rowCount][colCount];
	  for(int i=1;i<=rowCount;i++) {
		 for(int j=0;j<colCount;j++) { 
			 row = sheet.getRow(i);
			 cell=row.getCell(j);
			 DataFormatter formatter= new DataFormatter();
			 String cellData=formatter.formatCellValue(cell);
			 loginData[i-1][j]=cellData;
			 System.out.println(loginData[i-1][j]);
					 
			 
		 }
	  }
	  return loginData;
  }

}
