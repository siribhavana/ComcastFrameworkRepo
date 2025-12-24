package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * Contains login page elements & business library like login()
 * @author Siri
 */
public class LoginPage { //Rule-1: Create a seperate java class
	//Rule-2: Object Creation
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement userpasswordEdt;
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	//Rule-3: Object Initialization
	//Rule-4: Object Encapsulation
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getUserpasswordEdt() {
		return userpasswordEdt;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Rule-5:provide Action
	public void loginToApp(String username,String password)
	{
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		userpasswordEdt.sendKeys(password);
		loginbtn.click();
	}
	
	/**
	 * login to application based on username,password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(String url,String username,String password)
	{
		driver.get(url);
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		usernameEdt.sendKeys(username);
		userpasswordEdt.sendKeys(password);
		loginbtn.click();
	}
}
