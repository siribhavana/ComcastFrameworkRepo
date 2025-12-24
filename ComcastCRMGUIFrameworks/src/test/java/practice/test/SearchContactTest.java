package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basemainClass.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for contact module
 * @author Siri 
 */
public class SearchContactTest extends BaseClass
{
	/**
	 * Scenario: login()==> navigateContact==>createContact()==verify
	 */
	@Test
	public void searchContTest()
	{
		/* Step 1: login to app */
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("url","username", "password");
	}
}
