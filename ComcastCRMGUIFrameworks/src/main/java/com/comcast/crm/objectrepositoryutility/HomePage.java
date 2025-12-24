package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage { //Rule-1 Create a seperate java class
	//Rule-2 Object Creation
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	@FindBy(linkText="More")
	private WebElement morelink;
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	@FindBy(name="search_text")
	private WebElement searchtxt;
	@FindBy(name="search")
	private WebElement searchbtn;
	@FindBy(linkText="Sign Out")
	private WebElement signoutbtn;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	public WebElement getOrganizationlink() {
		return organizationlink;
	}
	public WebElement getContactlink() {
		return contactlink;
	}
	public WebElement getMorelink() {
		return morelink;
	}
	public WebElement getCampaignlink() {
		return campaignlink;
	}
	public WebElement getSearchtxt() {
		return searchtxt;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getAdminimg() {
		return adminimg;
	}
	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	public void navigateToCampaignPage()
	{
		Actions action=new Actions(driver);
		action.moveToElement(morelink).perform();
		campaignlink.click();
	}
	public void Logout()
	{
		Actions action=new Actions(driver);
		action.moveToElement(adminimg).perform();
		signoutbtn.click();
	}
}
