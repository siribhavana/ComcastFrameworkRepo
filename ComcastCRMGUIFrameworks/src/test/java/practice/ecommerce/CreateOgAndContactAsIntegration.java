package practice.ecommerce;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.cast.crm.generic.webdriverutility.JavaUtility;
import com.cast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOgAndContactAsIntegration 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriver driver;
		//Properties
		/*
		 * FileInputStream fis=new
		 * FileInputStream("./configAppData/commondata.properties"); Properties prop=new
		 * Properties(); prop.load(fis); String Url=prop.getProperty("url"); String
		 * Browser=prop.getProperty("browser"); String
		 * Username=prop.getProperty("username"); String
		 * Password=prop.getProperty("password"); String addr=prop.getProperty("Addr");
		 */
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		String Browser=flib.getDataFromPropertiesFile("browser");
		String Url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		String addr=flib.getDataFromPropertiesFile("Addr");
		int r=jlib.getRandomNum();
		
		 /* Random rand=new Random(); int r=rand.nextInt(1000);*/
		//Excel
		 /* FileInputStream fis1=new FileInputStream("./testData/testScriptdata1.xlsx");
		 * Workbook workbook=WorkbookFactory.create(fis1); Sheet
		 * sheet=workbook.getSheet("Org"); Row row=sheet.getRow(7); String
		 * orgname=row.getCell(2).toString()+r; String ln=row.getCell(1).toString()+r;
		 * String mobno=row.getCell(3).getStringCellValue(); workbook.close();*/
		ExcelUtility elib=new ExcelUtility();
		String orgname=elib.getDataFromExcel("Org", 7, 2).toString()+r;
		String ln=elib.getDataFromExcel("Org", 7, 1).toString()+r;
		String mobno=elib.getDataFromExcel("Org", 7, 3).toString();
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
		driver.get(Url);
		wlib.waitForPageToLoad(driver);
		 /* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 * driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username)
		 * ; driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(
		 * Password); driver.findElement(By.id("submitButton")).click();
		 * driver.findElement(By.linkText("Organizations")).click();
		 * driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(
		 * );*/
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		
		HomePage hp=new HomePage(driver);
		hp.getOrganizationlink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.createNewOrg();

		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.getPh().sendKeys(mobno);
		cnop.newAccount(orgname, addr);
		 /* driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname
		 * ); driver.findElement(By.id("phone")).sendKeys(mobno);
		 * driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(addr
		 * ); driver.findElement(By.
		 * xpath("//textarea[@name='description']/ancestor::tr[@style='height:25px']/following-sibling::tr/descendant::input[@title='Save [Alt+S]']"
		 * )).click();*/
		
		//verify the header
		OrganizationInfoPage oinfp=new OrganizationInfoPage(driver);
		String headerinfo=oinfp.getHeaderinfo().getText();
		//String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgname))
		{
			System.out.println(orgname+" is created==>PASS");
		}
		else
		{
			System.out.println(orgname+" is not created==>FAIL");
		}
		
		hp.getContactlink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getContactOrg().click();
		cp.contactsToApp(ln);
		
		/* driver.findElement(By.linkText("Contacts")).click();
		 * driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"
		 * )).click(); driver.findElement(By.name("lastname")).sendKeys(ln);
		 * driver.findElement(By.xpath(
		 * "//input[@name='account_name']/following-sibling::img")).click();*/
		
		//switch to child window
		/*  wlib.switchNewBrowserTab(driver, "module=Accounts&action");
			Set<String> cw=driver.getWindowHandles(); Iterator<String> it=cw.iterator();
		 * while(it.hasNext()) { String childWindowId=it.next();
		 * driver.switchTo().window(childWindowId); String
		 * childUrl=driver.getCurrentUrl();
		 * if(childUrl.contains("module=Accounts&action")) { break; } }*/
	
			 /* driver.findElement(By.name("search_text")).sendKeys(orgname);
			 * driver.findElement(By.name("search")).click();
			 * driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();//dynamic
			 * xpath*/
		//Switch to parent window
		/* wlib.switchNewBrowserTab(driver, "Contacts&action");
		 * Set<String> parentwind=driver.getWindowHandles(); Iterator<String>
		 * it1=parentwind.iterator(); while(it1.hasNext()) { String
		 * parentwindId=it1.next(); driver.switchTo().window(parentwindId); String
		 * parentUrl=driver.getCurrentUrl(); if(parentUrl.contains("Contacts&action")) {
		 * break; } }*/
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']/ancestor::tbody/descendant::b[text()='Contact Image Information:']/ancestor::tr/following-sibling::tr/descendant::input[@title='Save [Alt+S]']")).click();
		
		//verify header phone no info expected result
		headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(ln))
		{
			System.out.println(ln+" is created==>PASS");
		}
		else
		{
			System.out.println(ln+" is not created==>FAIL");
		}
		/* String
		 * orgtext=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		 * System.out.println(orgtext); if(orgtext.trim().equals(orgname)) {
		 * System.out.println(orgtext+" is same==>pass"); } else {
		 * System.out.println(orgtext+" is not same==>fail"); } */
		
		driver.quit();
	}
}
