package comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basemainClass.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
/**
 * @author Siri
 */
public class CreateContactWithname extends BaseClass {
	@Test(groups="smokeTest")
	public void contactTest() throws Exception {
		//Read test Script data from Excel File
		String ln = elib.getDataFromExcel("Org", 1, 2) + jlib.getRandomNum();
		//Navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();
		//Click on Create Contact Module
		ContactsPage cp = new ContactsPage(driver);
		cp.getContactOrg().click();
		//Enter all the details & create new Contact
		cp.contactsToApp(ln);
		//Verify header phone Number info Expected Result 
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String lastname = cip.getHeaderName();
		/*
		 * if (lastname.equals(ln)) { System.out.println(lastname + " is same"); } else
		 * { System.out.println(lastname + " is not same"); }
		 */
		Assert.assertEquals(lastname, ln);
		System.out.println(lastname + " is same");
	}
	
	@Test(groups="regressionTest")
	public void createContWithSuppDateTest() throws Exception
	{
		String addr = flib.getDataFromPropertiesFile("Addr");
		int r = jlib.getRandomNum();
		String ln = elib.getDataFromExcel("Org", 1, 2) + r;
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getContactOrg().click();
		wlib.mousemoveOnElement(driver, driver.findElement(By.name("support_end_date")));
		
		String startdate = jlib.getSystemDateYYYYMMDD();
		String enddate = jlib.getRequireddateYYYYMMDD(30);
		cp.contactsToApp(ln, startdate, enddate);
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String suppdate = cip.getSupportStartDate();
		String suppenddate = cip.getSupportEndDate();
		/*
		 * if (suppdate.equals(startdate)) { System.out.println(startdate + " is same");
		 * } else { System.out.println(startdate + " is not same"); }
		 */
		SoftAssert ass=new SoftAssert();
		ass.assertEquals(suppdate, startdate);
		System.out.println(startdate+" is same");
		ass.assertEquals(suppenddate, enddate);
		System.out.println(enddate+" is same");
		ass.assertAll();
		/*
		 * if (suppenddate.equals(enddate)) { System.out.println(enddate + " is same");
		 * } else { System.out.println(enddate + " is not same"); }
		 */
	}
	@Test(groups="regressionTest")
	public void createOrgAndContactTest() throws Exception
	{
		int r=jlib.getRandomNum();
		String orgname=elib.getDataFromExcel("Org", 7, 2).toString()+r;
		String ln=elib.getDataFromExcel("Org", 7, 1).toString()+r;
		String mobno=elib.getDataFromExcel("Org", 7, 3).toString();
		String addr=flib.getDataFromPropertiesFile("Addr");
		HomePage hp=new HomePage(driver);
		hp.getOrganizationlink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.createNewOrg();
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.getPh().sendKeys(mobno);
		cnop.newAccount(orgname, addr);
		OrganizationInfoPage oinfp=new OrganizationInfoPage(driver);
		String headerinfo=oinfp.getHeaderinfo().getText();
		boolean flag;
		 if(headerinfo.contains(orgname)) {
			 flag=true;
		   } else {
		   flag=false; }
		Assert.assertTrue(flag);
		System.out.println(orgname+" is created==>PASS");
		
		hp.getContactlink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getContactOrg().click();
		cp.contactsToApp(ln);
		headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean flag1;
		if(headerinfo.contains(ln))
		{
			flag1=true;
		}
		else
		{
			flag1=false;
		}
		Assert.assertTrue(flag1);
		System.out.println(ln+" is created==>PASS");
	}
}
