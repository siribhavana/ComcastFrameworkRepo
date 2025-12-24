package com.cast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility
{
	public void waitForPageToLoad(WebDriver driver)
	{
		//Implict wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		//Explict wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchNewBrowserTab(WebDriver driver,String partialUrl)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			driver.switchTo().window(windowID);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl))
			{
				break;
			}
		}
	}
	public void switchTabonTitle(WebDriver driver,String partialTitle)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String WindowID=it.next();
			driver.switchTo().window(WindowID);
			String actTitle=driver.getTitle();
			if(actTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	//Select class
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/*
	 * public void select(WebElement element,String text) { Select sel=new
	 * Select(element); sel.selectByValue(text); }
	 */
	
	public void select(WebElement element, String text) {
	    Select sel = new Select(element);
	    sel.selectByVisibleText(text);
	}

	public void selectByValue(WebElement element, String value) {
	    Select sel = new Select(element);
	    sel.selectByValue(value);
	}
	
	//Actions
	public void mousemoveOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void mouseDoubleClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
}
