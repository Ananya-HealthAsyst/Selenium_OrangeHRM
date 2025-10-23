//Excel_Listener                                                                                                                                                                                                              package com.reports;
 
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reports.ExcelReport;
import com.utilities.BaseTest;
 
public class ExcelListener implements ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExcelReport.logResult(result.getName(),
				"PASS",
				null,
				result.getEndMillis() - result.getStartMillis(),
				null);
	}
	//String screenshotpath=TestBase.captureScreenshot(result.getName());
	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath = BaseTest.captureScreenshot(result.getName());
		ExcelReport.logResult(result.getName(),
				"FAIL",
				result.getThrowable().getMessage(),
				result.getEndMillis() - result.getStartMillis(),
				screenshotPath
				);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		ExcelReport.logResult(result.getName(), "SKIPPED", result.getThrowable()!=null ? result.getThrowable().getMessage() : "Skipped",
				result.getEndMillis()-result.getStartMillis(), null);
 
		
	}
	@Override
	public void onFinish(ITestContext context) {
		ExcelReport.saveReport();
		System.out.println("Excel report generated: TESTNG_RESULTS.xlsx");
	}
	
	
}
 