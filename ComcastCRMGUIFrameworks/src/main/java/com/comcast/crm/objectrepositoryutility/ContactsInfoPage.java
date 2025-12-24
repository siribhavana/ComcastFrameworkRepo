package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
    WebDriver driver;

    public ContactsInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dtlview_Last Name")
    private WebElement headername;
    @FindBy(xpath="//td[text()='Support Start Date']/following-sibling::td")
    private WebElement stdate;

    @FindBy(xpath="//td[text()='Support End Date']/following-sibling::td")
    private WebElement enddate;

	/*
	 * @FindBy(id = "dtlview_Support Start Date") private WebElement stdate;
	 * 
	 * @FindBy(id = "dtlview_Support End Date") private WebElement enddate;
	 */

    // Business methods (return actual values instead of WebElement)
    public String getHeaderName() {
        return headername.getText();
    }

    public String getSupportStartDate() {
        return stdate.getText().trim();
    }

    public String getSupportEndDate() {
        return enddate.getText().trim();
    }
}