package com.comcast.crm.basemainClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cast.crm.generic.databaseutility.DatabaseUtility;
import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.cast.crm.generic.webdriverutility.JavaUtility;
import com.cast.crm.generic.webdriverutility.UtilityClassObject;
import com.cast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass 
{
	public DatabaseUtility dlib=new DatabaseUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver; //static cannot participate in parallel execution so extra variable is created
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("-----Connect to DB,Report config-----");
		dlib.getDbconnection();
	}
	//@Parameters("BROWSER") //Only work in suite_parallel_cross or distributes
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	//public void configBC(String browser) throws Exception ->For Parameterization only we have to use this
	public void configBC() throws Exception
	{
		System.out.println("-----Launch the Browser-----");
		//String Browser=browser;
		String Browser=flib.getDataFromPropertiesFile("browser");
		if(Browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(Browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws Exception
	{
		System.out.println("------Login-----");
		LoginPage lp=new LoginPage(driver);
		String Url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		String addr=flib.getDataFromPropertiesFile("Addr");
		lp.loginToApp(Url, Username, Password);
	}
	@AfterMethod(groups={"smokeTest","regressionTest"})
		public void configAM()
		{
			System.out.println("-----Logout-----");
			HomePage hp=new HomePage(driver);
			hp.Logout();
		}
		@AfterClass(groups={"smokeTest","regressionTest"})
		public void configAC()
		{
			System.out.println("-----Close the browser-----");
			driver.quit();
		}
	
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS() throws Exception
	{
		System.out.println("-----Close DB,Report BackUp-----");
		dlib.closeDbconnection();
	}
}
