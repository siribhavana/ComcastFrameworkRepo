package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basemainClass.BaseClass;
//@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass
{
	/*
	 * @Test public void createInvoiceTest() {
	 * System.out.println("execute createInvoiceTest"); String
	 * expectedTitle=driver.getTitle();
	 * System.out.println(expectedTitle+"**************");
	 * Assert.assertEquals(expectedTitle, "Home");; System.out.println("step-1");
	 * System.out.println("step-2"); System.out.println("step-3");
	 * System.out.println("step-4"); }
	 * 
	 * @Test public void createInvoiceWithContactTest() {
	 * System.out.println("execute createInvoiceWithContactTest");
	 * System.out.println("step-1"); System.out.println("step-2");
	 * System.out.println("step-3"); System.out.println("step-4"); }
	 */
	@Test(retryAnalyzer=com.comcast.crm.listenerUtility.RetryAnalyzerTest.class)
	public void activateSim()
	{
		System.out.println("execute createInvoiceTest");
		//Assert.assertEquals("Login", "Login"); //1 time only execute as test is pass
		Assert.assertEquals("", "Login"); //5 times as limitCount=5 as test case is fail
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
