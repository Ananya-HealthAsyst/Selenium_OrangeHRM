package com.utilities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	protected static WebDriver driver;
	
	
	  @BeforeMethod
	  public void setUp() {
		  //setup chrome browser
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

		  //to wait to load
		  
	  }

//  @AfterMethod
//  public void tearDown() {
//	  if(driver!=null) {
//		  driver.quit();
//	  }
//  }
  public WebDriver getDriver() {
		return driver;
  }
  public static String captureScreenshot(String testName) {
	    String screenshotPath = System.getProperty("user.dir") + "/testreport/" + testName + ".png";
	    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File destFile = new File(screenshotPath);
	    try {
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
	        return screenshotPath;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public static void alert() {
	    driver.switchTo().alert().accept();
	}


}
