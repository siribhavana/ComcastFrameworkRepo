package pac1;

import org.testng.annotations.Test;

public class ContactTest
{
	@Test
	public void createContactTest()
	{
		String URL=System.getProperty("url");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		String BROWSER=System.getProperty("browser");
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println(BROWSER);
		System.out.println("createContactTest");
	}
	
	@Test
	public void modifyContactTest()
	{
		System.out.println("modifyContactTest");
	}
	
}
