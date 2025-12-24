package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.basemainClass.BaseClass;

public class ListenerImpClass implements ITestListener,ISuiteListener
{
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println("Report Configuration");
		//Step-1: Spark report Config
		//it will print report whether pass or fail if fail the screenshot other wise report
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
				
		//Step-2: add Env information & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-90");
	}
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report BackUP");
		report.flush();
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("==== ====>"+result.getMethod().getMethodName()+">------START------");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test); //we created to print log or low level data to be visible on report page
		test.log(Status.INFO, result.getMethod().getMethodName()+"====> STARTED <====");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==== ====>"+result.getMethod().getMethodName()+">-----END-----");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====> COMPLETED <====");
	}
	@Override
	public void onTestFailure(ITestResult result)  {
		String testName=result.getMethod().getMethodName();
		//System.out.println(testName);
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String srcfile = ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ","_").replace(":","_");
		test.addScreenCaptureFromBase64String(srcfile,testName+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"====> FAILED <====");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	@Override
	public void onStart(ITestContext context)
	{
		
	}
	@Override
	public void onFinish(ITestContext context)
	{
		
	}
}
