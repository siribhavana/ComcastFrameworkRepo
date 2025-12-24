package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement accname;
	@FindBy(name="ship_street")
	private WebElement shipaddr;
	@FindBy(xpath="//b[text()='Organization Information']/ancestor::tr/preceding-sibling::tr/descendant::input[contains(@value,'Save')]")
	private WebElement savebtn;
	@FindBy(name="industry")
	private WebElement indust;
	@FindBy(id="phone")
	private WebElement ph;
	@FindBy(name="accounttype")
	private WebElement type;
	public WebElement getShipaddr() {
		return shipaddr;
	}
	public WebElement getAccname() {
		return accname;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getIndust() {
		return indust;
	}
	public WebElement getPh() {
		return ph;
	}
	public WebElement getType() {
		return type;
	}
	public void newAccount(String accname1,String shipaddress)
	{
		driver.manage().window().maximize();
		accname.sendKeys(accname1);	
		shipaddr.sendKeys(shipaddress);
		savebtn.click();
	}
	public void newAccount(String accname1,String shipaddress,String ind)
	{
		driver.manage().window().maximize();
		accname.sendKeys(accname1);	
		shipaddr.sendKeys(shipaddress);
		Select sel=new Select(indust);
		sel.selectByVisibleText(ind);
		savebtn.click();
	}
	public void newAccount(String accname1,String shipaddress,String ind,String acctype) {
		driver.manage().window().maximize();
		accname.sendKeys(accname1);	
		shipaddr.sendKeys(shipaddress);
		Select sel=new Select(indust);
		sel.selectByVisibleText(ind);
		Select sel1=new Select(type);
		sel1.selectByVisibleText(acctype);
		savebtn.click();
	}
}
