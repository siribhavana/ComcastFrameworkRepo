package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage
{
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(className="dvHeaderText")
	private WebElement headerinfo;
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgname;
	@FindBy(id="dtlview_Phone")
	private WebElement phone;
	@FindBy(id="dtlview_Industry")
	private WebElement industry;
	@FindBy(id="dtlview_Type")
	private WebElement type;
	public WebElement getHeaderinfo() {
		return headerinfo;
	}
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getOrgname() {
		return orgname;
	}
	public WebElement getIndustry() {
		return industry;
	}
	public WebElement getType() {
		return type;
	}
}
