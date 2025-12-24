package practice.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.cast.crm.generic.webdriverutility.JavaUtility;
import com.cast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest 
{
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		//Get common data from properties file
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String Browser=flib.getDataFromPropertiesFile("browser");
		String Url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		String addr=flib.getDataFromPropertiesFile("Addr");
		
		//Random
		int r1=jlib.getRandomNum();
		
		//Get Excel file
		
		String orgname=elib.getDataFromExcel("Org", 10, 2)+r1;
		
		if(Browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.get(Url);
		wlib.waitForPageToLoad(driver);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		
		HomePage hp=new HomePage(driver);
		hp.getOrganizationlink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.createNewOrg();
		
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.newAccount(orgname, addr);
		
		OrganizationInfoPage oinfp=new OrganizationInfoPage(driver);
		String headinfo=oinfp.getHeaderinfo().getText();
		if(headinfo.contains(orgname)) 
		{
			System.out.println(orgname+" is created==>PASS"); 
		}
		else
		{
			System.out.println(orgname+" is not created==>FAIL");
		}
		String orgtext=oinfp.getOrgname().getText();
		if(orgtext.equals(orgname))
		{
			System.out.println(orgtext+" is same==>pass");
		}
		else
		{
			System.out.println(orgtext+" is not same==>fail");
		}
		
		//go back to Organizations Page
		hp.getOrganizationlink().click();
		
		//search for organization
		op.getSearchEdt().sendKeys(orgname);
		wlib.select(op.getSearchDD(),"Organization Name");
		op.getSearchBtn().click();
		
		//As dynamic so we should take only findElement()
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/ancestor::tr//a[text()='del']")).click();
		
		driver.quit();	
	}
}
