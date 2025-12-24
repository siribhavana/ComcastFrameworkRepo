package comcast.crm.orgtest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.basemainClass.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class CreateOrganizationTestData extends BaseClass
{
	@Test(groups="smokeTest")
	public void createOrg()throws Exception {
		
		UtilityClassObject.getTest().log(Status.INFO, "Pass Address from properties file");
		String addr=flib.getDataFromPropertiesFile("Addr");
		int r1=jlib.getRandomNum();
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgname=elib.getDataFromExcel("Org", 1, 2)+r1;
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hp=new HomePage(driver);
		hp.getOrganizationlink().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.createNewOrg();
		UtilityClassObject.getTest().log(Status.INFO, "create a new Org");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.newAccount(orgname, addr);
		UtilityClassObject.getTest().log(Status.INFO, orgname+"====>create a new Org");
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
	}
	
	@Test(groups="regressionTest")
	public void createOrgWithPhno() throws Exception
	{
		UtilityClassObject.getTest().log(Status.INFO, "Read the Address from excel");
		String addr=flib.getDataFromPropertiesFile("Addr");
		UtilityClassObject.getTest().log(Status.INFO, "read orgname data from excel");
		String orgname=elib.getDataFromExcel("Org", 7, 2).toString()+jlib.getRandomNum();
		UtilityClassObject.getTest().log(Status.INFO,"read mobno data from excel");
		String mobno=elib.getDataFromExcel("Org", 7, 3).toString();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
		HomePage hp=new HomePage(driver);
		hp.getOrganizationlink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to new Org page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.createNewOrg();
		UtilityClassObject.getTest().log(Status.INFO, orgname+" ===> page is created");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.getPh().sendKeys(mobno);
		cnop.newAccount(orgname, addr);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to OrgInfoPage");
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String ph=oip.getPhone().getText();
		if(ph.equals(mobno))
		{
			System.out.println(ph+" is matched===>PASS");
		}
		else
		{
			System.out.println(ph+" is not matched==>FAIL");
		}
	}
	@Test(groups="regressionTest")
	public void selIndustryDropDown() throws Exception
	{
		UtilityClassObject.getTest().log(Status.INFO, "read the address from properties file");
		String addr=flib.getDataFromPropertiesFile("Addr");
		//Random
		int r=jlib.getRandomNum();
		UtilityClassObject.getTest().log(Status.INFO, "read the Org name from excel");
		String orgname=elib.getDataFromExcel("Org", 4, 2).toString()+r;
		UtilityClassObject.getTest().log(Status.INFO,"read the industry from excel");
		String industry1=elib.getDataFromExcel("Org", 4, 4).toString();
		UtilityClassObject.getTest().log(Status.INFO, "read type from excel");
		String type1=elib.getDataFromExcel("Org", 4, 5).toString();
		HomePage hp=new HomePage(driver);
		hp.getOrganizationlink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.createNewOrg();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to new Org page");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.newAccount(orgname, addr, industry1,type1);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to OrgInfoPage");
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String indropdwn=oip.getIndustry().getText();
		if(indropdwn.equals(industry1))
		{
			Thread.sleep(2000);
			System.out.println(industry1+" name is verified===>PASS");
		}
		else
		{
			System.out.println(industry1+" name is not verified==>FAIL");
		}
		String typedropdwn=oip.getType().getText();
		if(typedropdwn.equals(type1))
		{
			System.out.println(type1+" is verified==>pass");
		}
		else
		{
			System.out.println(type1+" is not verified==>fail");
		}
	}
	/*//It's working seperate class
	 * @Test public void deleteOrgTest() throws Exception { String
	 * addr=flib.getDataFromPropertiesFile("Addr"); int r1=jlib.getRandomNum();
	 * String orgname=elib.getDataFromExcel("Org", 10, 2)+r1; HomePage hp=new
	 * HomePage(driver); hp.getOrganizationlink().click();
	 * 
	 * OrganizationsPage op=new OrganizationsPage(driver); op.createNewOrg();
	 * 
	 * CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
	 * cnop.newAccount(orgname, addr);
	 * 
	 * OrganizationInfoPage oinfp=new OrganizationInfoPage(driver); String
	 * headinfo=oinfp.getHeaderinfo().getText(); if(headinfo.contains(orgname)) {
	 * System.out.println(orgname+" is created==>PASS"); } else {
	 * System.out.println(orgname+" is not created==>FAIL"); } String
	 * orgtext=oinfp.getOrgname().getText(); if(orgtext.equals(orgname)) {
	 * System.out.println(orgtext+" is same==>pass"); } else {
	 * System.out.println(orgtext+" is not same==>fail"); }
	 * 
	 * //go back to Organizations Page hp.getOrganizationlink().click();
	 * 
	 * //search for organization op.getSearchEdt().sendKeys(orgname);
	 * wlib.select(op.getSearchDD(),"Organization Name"); op.getSearchBtn().click();
	 * 
	 * //As dynamic so we should take only findElement()
	 * driver.findElement(By.xpath("//a[text()='"+orgname+
	 * "']/ancestor::tr//a[text()='del']")).click(); }
	 */}
