package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactOrg;
	@FindBy(name="lastname")
	private WebElement ln;
	@FindBy(xpath="//input[@title='Save [Alt+S]']/ancestor::tbody/descendant::b[text()='Contact Image Information:']/ancestor::tr/following-sibling::tr/descendant::input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(id="jscal_field_support_start_date")
	private WebElement suppDate;
	@FindBy(name="support_end_date")
	private WebElement endDate;
	public WebElement getContactOrg() {
		return contactOrg;
	}
	public WebElement getLn() {
		return ln;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getSuppDate() {
		return suppDate;
	}
	public WebElement getEndDate() {
		return endDate;
	}
	public void contactsToApp(String lasnam)
	{
		ln.sendKeys(lasnam);
		savebtn.click();
	}
	public void contactsToApp(String lasnam,String stdate,String enddt)
	{
		ln.sendKeys(lasnam);
		suppDate.sendKeys(stdate);
		endDate.clear();
		endDate.sendKeys(enddt);
		savebtn.click();
	}
}
